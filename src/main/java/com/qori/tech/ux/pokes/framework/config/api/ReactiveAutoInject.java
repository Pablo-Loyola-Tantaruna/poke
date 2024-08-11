package com.qori.tech.ux.pokes.framework.config.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReactiveAutoInject {
  Class<?> clientClass();
  String apiName();
}
