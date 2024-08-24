package com.qori.tech.ux.pokes.framework.header.config;

import com.qori.tech.ux.pokes.framework.header.RequestHeaderResolve;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * <p> This class is responsible for configuring the headers of the HTTP requests.</p>
 * <p><b>Class</b>: HeaderConfig</p>
 * <p><b>Package</b>: com.qoritech.logic.accounts.framework.header.config</p>
 * <p><b>Project</b>: Create-Account</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: QoriTech Solutions Company</p>
 * <p><b>Creation Date</b>: 2024-05-15</p>
 * <p><b>Copyright</b>: QoriTech Solutions (QTS)</p>
 * <p>@author Pablo Sergio Loyola Tantaruna (ZLT)</p>
 * <div>
 *   <u>Developed by</u>:
 *   <ul>
 *     <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <div>
 *   <u>Reviewed by</u>:
 *   <ul>
 *     <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <p><b>Version</b>: 1.0.0</p>
 */
@Configuration
public class HeaderConfig implements WebMvcConfigurer {

  /**
   * This method is used to add the argument resolvers.
   *
   * @param resolvers List of argument resolvers.
   */
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(new RequestHeaderResolve());
  }
}
