package com.qori.tech.ux.pokes.util.header;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> This model class represents the request header.</p>
 * <p> This class is used for the validation of the request header.</p>
 * <p><b>Class</b>: ApiHeader</p>
 * <p><b>Package</b>: com.qoritech.logic.accounts.util.header</p>
 * <p><b>Project</b>: Create-Account</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: QoriTech Solutions Company</p>
 * <p><b>Creation Date</b>: 2024-06-15</p>
 * <p><b>Copyright</b>: QoriTech Solutions (QTS)</p>
 * <p>@author Pablo Sergio Loyola Tantaruna (ZLT)</p>
 * <div>
 *   <u>Developed by</u>:
 *   <ul>
 *   <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <div>
 *   <u>Reviewed by</u>:
 *   <ul>
 *   <li>Pablo Sergio Loyola Tantaruna</li>
 *   </ul>
 * </div>
 * <p><b>Version</b>: 1.0.0</p>
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiHeader {

  @JsonIgnoreProperties("sessionId")
  @Pattern(regexp = "^([a-zA-Z0-9]{8}-[0-9a-xA-X]{6}-[20][0-5d-xD-X]"
      + "{3}-[14ab][0-2a-wA-W]{5}-[0-8a-mA-M]{8}$)",
      message = "Invalid session id")
  @Schema(description = "Session id",
      example = "12345678-1234-5678-1234-567812345678",
      type = "string",
      name = "sessionId")
  @NotNull
  @NotEmpty
  private String sessionId;

  @Pattern(regexp = "^[a-zA-Z\\-0-9]+$")
  @Schema(description = "Device Name",
      example = "Laptop IUSACELL-1234",
      type = "string",
      name = "deviceName")
  private String deviceName;


  @Pattern(regexp = "^[a-zA-Z\\-0-9]+$")
  @Schema(description = "Application Code",
      example = "ZGRG",
      type = "string",
      name = "appCode")
  @NotNull
  @NotEmpty
  private String appCode;

  @Pattern(regexp = "^[a-zA-Z\\-0-9]+$")
  @Schema(description = "UserName",
      example = "Emilio12",
      type = "string",
      name = "userName")
  private String userName;

  @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}"
      + "[+-]\\d{4}([a-z]|[A-Z]|\\d)?$")
  @Schema(description = "request date",
      example = "2021-08-12T12:12:12.123+0000",
      type = "string",
      name = "requestDateTime")
  @NotNull
  @NotEmpty
  private String requestDateTime;

  @Pattern(regexp = "^([a-zA-Z0-9]{8}-[0-9a-xA-X]{6}-[20][0-5d-xD-X]{3}-[14ab]"
      + "[0-2a-wA-W]{5}-[0-8a-mA-M]{8}$)")
  @Schema(description = "Request id",
      example = "12345678-1234-5678-1234-567812345678",
      type = "string",
      name = "requestId")
  @NotNull
  @NotEmpty
  private String requestId;
}
