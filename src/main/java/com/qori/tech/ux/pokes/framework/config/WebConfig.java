package com.qori.tech.ux.pokes.framework.config;

import com.qori.tech.ux.pokes.framework.header.config.HeaderModelConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebFluxConfigurer {

  private final HeaderModelConfig headerModelArgumentResolver;

  @Override
  public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
    configurer.addCustomResolver(headerModelArgumentResolver);
  }
}