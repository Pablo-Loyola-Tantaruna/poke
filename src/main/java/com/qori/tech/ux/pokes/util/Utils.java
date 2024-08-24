package com.qori.tech.ux.pokes.util;

/**
 * <p> This class is used to create methods that are used in the application.</p>
 * <p> The function of this class is to be used to
 * create methods that are used in the application.</p>
 * <p><b>Class</b>: Utils</p>
 * <p><b>Package</b>: com.qoritech.logic.accounts.util</p>
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
public class Utils {

  /**
   * This method is used to validate if an object is null.
   *
   * @param obj object
   * @return boolean
   */
  public static boolean isNull(Object obj) {
    return obj == null;
  }

  /**
   * This method is used to validate if a string is empty.
   *
   * @param str string
   * @return boolean
   */
  public static boolean isEmpty(String str) {
    return str == null || str.isEmpty();
  }

}
