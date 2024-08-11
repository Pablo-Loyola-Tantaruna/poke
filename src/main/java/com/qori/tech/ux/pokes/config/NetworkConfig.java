package com.qori.tech.ux.pokes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactivefeign.ReactiveFeign;
import reactivefeign.webclient.WebReactiveFeign;

@Configuration
public class NetworkConfig {
  @Bean
  public ReactiveFeign.Builder<?> reactiveFeignBuilder() {
    return WebReactiveFeign.builder();
  }
}
