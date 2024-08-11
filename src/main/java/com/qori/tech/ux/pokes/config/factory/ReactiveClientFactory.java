package com.qori.tech.ux.pokes.config.factory;

import com.qori.tech.ux.pokes.config.ApplicationProperties;
import com.qori.tech.ux.pokes.model.util.ApiConfigProperties;
import com.qori.tech.ux.pokes.model.util.ServiceGroupProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactivefeign.webclient.WebReactiveFeign;

import static com.qori.tech.ux.pokes.util.Utils.isNull;

@Component
@RequiredArgsConstructor
public class ReactiveClientFactory {

  private final ApplicationProperties applicationProperties;

  public <T> T createClient(Class<T> clientClass, String apiName) {
    ServiceGroupProperties serviceGroup = applicationProperties.getCrossApis().get(apiName);
    if (isNull(serviceGroup)) {
      throw new IllegalArgumentException("Service group not found");
    }
    ApiConfigProperties apiConfig = serviceGroup.getApis().get("");
    if (isNull(apiConfig)) {
      throw new IllegalArgumentException("Api config not found");
    }

    return WebReactiveFeign.<T>builder()
            .target(clientClass, apiConfig.getBaseUrl());
  }

}
