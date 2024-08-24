package com.qori.tech.ux.pokes.framework.header.config;

import com.qori.tech.ux.pokes.framework.header.manager.RequestHeaderModel;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.util.List;

@Component
@Slf4j
public class HeaderModelConfig implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(RequestHeaderModel.class);
  }

  @NotNull
  @Override
  public Mono<Object> resolveArgument(MethodParameter parameter, @NotNull BindingContext bindingContext,
                                      @NotNull ServerWebExchange exchange) {
    RequestHeaderModel headerModel = parameter.getParameterAnnotation(RequestHeaderModel.class);
    Class<?> paramType = headerModel.value();
    Object headerObject;
    try {
      headerObject = paramType.getDeclaredConstructor().newInstance();
      List<String> headerNames = exchange.getRequest().getHeaders().keySet().stream().toList();
      for (String headerName : headerNames) {
        try {
          Field field = paramType.getDeclaredField(headerName);
          field.setAccessible(true);
          field.set(headerObject, exchange.getRequest().getHeaders().getFirst(headerName));
        } catch (NoSuchFieldException ex) {
          log.error("Field {} not found in class {}", ex.getStackTrace(), paramType.getName());
        }
      }
    } catch (Exception e) {
      log.error("Error creating instance of class {}, and error is {}", paramType.getName(), e.getStackTrace());
      return Mono.error(e);
    }
    return Mono.just(headerObject);
  }
}