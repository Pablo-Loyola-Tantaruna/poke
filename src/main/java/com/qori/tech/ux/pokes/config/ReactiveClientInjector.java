package com.qori.tech.ux.pokes.config;

import com.qori.tech.ux.pokes.config.factory.ReactiveClientFactory;
import com.qori.tech.ux.pokes.framework.config.api.ReactiveAutoInject;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
@RequiredArgsConstructor
public class ReactiveClientInjector implements BeanPostProcessor {
  private final ReactiveClientFactory reactiveClientFactory;

  @Override
  public Object postProcessBeforeInitialization(Object bean, @NotNull String beanName) {
      Field[] fields = bean.getClass().getDeclaredFields();

      for (Field field : fields) {
        if (field.isAnnotationPresent(ReactiveAutoInject.class)) {
          ReactiveAutoInject annotation = field.getAnnotation(ReactiveAutoInject.class);
          Class<?> clientClass = annotation.clientClass();
          String apiName = annotation.apiName();
          Object client = reactiveClientFactory.createClient(clientClass, apiName);
          field.setAccessible(true);
          ReflectionUtils.setField(field, bean, client);
        }
      }
      return bean;
  }
}
