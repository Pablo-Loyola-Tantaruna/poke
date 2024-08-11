package com.qori.tech.ux.pokes.framework.body;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> This class is responsible for managing the response message.</p>
 * <p> The function of this class is to manage the response message.</p>
 * <p><b>Class</b>: ResponseMessage</p>
 * <p><b>Package</b>: com.qoritech.logic.accounts.framework.body</p>
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

@Getter
@Setter
@Builder
public class ResponseMessage {

  private String message;

}
