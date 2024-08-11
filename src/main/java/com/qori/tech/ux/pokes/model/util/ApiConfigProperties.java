package com.qori.tech.ux.pokes.model.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiConfigProperties {
  private String baseUrl;
  private int connectTimeout;
  private int readTimeout;
  private int writeTimeout;
  private ComponentProperties component;
}
