package com.qori.tech.ux.pokes.framework.header.manager;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;


/**
 * <p> This annotation is used to manage the headers of the requests.</p>
 * <p><b>Class</b>: RequestHeaderObject</p>
 * <p><b>Package</b>: com.qoritech.logic.accounts.framework.header.manager</p>
 * <p><b>Project</b>: Create-Account</p>
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
 * <p><b>Version</b>: 1.0.0</p>
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RequestHeader {

  /**
   * This method is used to get the name of the header.
   *
   * @return name
   */
  String name() default "";

  /**
   * This method is used to get the value of the header.
   *
   * @return value
   */
  String value() default "";

  /**
   * This method is used to get if it is required.
   *
   * @return required
   */
  boolean required() default true;

  /**
   * This method is used to set the default value.
   *
   * @return description
   */
  String defaultValue() default "";
}
