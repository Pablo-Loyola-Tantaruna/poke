package com.qori.tech.ux.pokes.config.factory;

import static com.qori.tech.ux.pokes.util.Utils.isNull;

import com.qori.tech.ux.pokes.config.ApplicationProperties;
import com.qori.tech.ux.pokes.model.util.ApiConfigProperties;
import com.qori.tech.ux.pokes.model.util.ServiceGroupProperties;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactivefeign.webclient.WebReactiveFeign;

/**
 * <p> This class is use like a factory for create a client.</p>
 * <p> The function of this class is to be used like a factory for create a client.</p>
 * <p><b>Class</b>: ReactiveClientFactory</p>
 * <p><b>Package</b>: com.qori.tech.ux.pokes.config.factory</p>
 * <p><b>Project</b>: Create-Account</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: QoriTech Solutions Company</p>
 * <p><b>Creation Date</b>: 2024-06-15</p>
 * <p><b>Copyright</b>: QoriTech Solutions (QTS)</p>
 * <p>@author Pablo Sergio Loyola Tantaruna (ZLT)</p>
 * <div>
 *     <u>Developed by</u>:
 *     <ul>
 *         <li>Pablo Sergio Loyola Tantaruna</li>
 *     </ul>
 * </div>
 * <div>
 *     <u>Reviewed by</u>:
 *     <ul>
 *         <li>Pablo Sergio Loyola Tantaruna</li>
 *     </ul>
 * </div>
 * <p><b>Version</b>: 1.0.0</p>
 */
@Component
@RequiredArgsConstructor
public class ReactiveClientFactory {

  private final ApplicationProperties applicationProperties;

  /**
   * <p> This method is used to create a client.</p>
   * <p> The function of this method is to be used to create a client.</p>
   *
   * @param clientClass The class of the client.
   * @param apiName The name of the api.
   * @return The client.
   */
  public <T> T createClient(Class<T> clientClass, String apiName) {
    System.out.println("ReactiveClientFactory.Api {}" + apiName);
    System.out.println("ReactiveClientFactory.createClient {}"
            + applicationProperties.getCross().size());
    System.out.println("ReactiveClientFactory.createClient {}"
            + applicationProperties.getCross().isEmpty());
    Map<String, String> apiConfig = applicationProperties.getCross().get(apiName);
    if (isNull(apiConfig)) {
      throw new IllegalArgumentException("API config not found");
    }
    String baseUrl = apiConfig.get("baseUrl");
    System.out.println("ReactiveClientFactory.createClient {}" + baseUrl);
    return WebReactiveFeign.<T>builder()
            .target(clientClass, baseUrl);
  }

}
