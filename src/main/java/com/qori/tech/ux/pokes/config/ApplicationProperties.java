package com.qori.tech.ux.pokes.config;

import com.qori.tech.ux.pokes.model.util.ServiceGroupProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "application.http-client.qori")
@Getter
@Setter
public class ApplicationProperties {

  @Value("${application.http-client.qori.cross}")
  private Map<String, ServiceGroupProperties> crossApis;

}