package com.qori.tech.ux.pokes;

import com.qori.tech.ux.pokes.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * <p> This is the main class of the application.</p>
 * <p> This class is responsible for starting the application.</p>
 * <p><b>Class</b>: PokesApiConnectionApplication</p>
 * <p><b>Package</b>: com.qori.tech.ux.pokes</p>
 * <p><b>Project</b>: PokesApiConnection</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: QoriTech Solutions Company</p>
 * <p><b>Creation Date</b>: 2024-06-15</p>
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
 */

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class PokesApiConnectionApplication {

  /**
   * Main method of the application.
   *
   * @param args Application arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(PokesApiConnectionApplication.class, args);
  }
}
