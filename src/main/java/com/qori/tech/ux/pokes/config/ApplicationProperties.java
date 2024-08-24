package com.qori.tech.ux.pokes.config;

import com.qori.tech.ux.pokes.model.util.ServiceGroupProperties;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <p> This class is used to configure the properties of the application.</p>
 * <p> The function of this class is to be used to configure the properties of the application.</p>
 * <p><b>Class</b>: ApplicationProperties</p>
 * <p><b>Package</b>: com.qori.tech.ux.pokes.config</p>
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

@Configuration
@Component
@ConfigurationProperties(prefix = "application.http-client.qori")
@Getter
@Setter
public class ApplicationProperties {

  private Map<String, Map<String, String>> cross = new HashMap<>();
}