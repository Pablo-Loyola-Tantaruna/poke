package com.qori.tech.ux.pokes.util.exception;

import com.qori.tech.ux.pokes.framework.body.ResponseMessage;
import com.qori.tech.ux.pokes.framework.exception.ErrorCategory;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Supplier;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * <p> This class is responsible for exception utility methods.</p>
 * <p> The function of this class is to provide exception utility methods.</p>
 * <p><b>Class</b>: ExceptionUtils</p>
 * <p><b>Package</b>: com.qoritech.logic.accounts.util.exception</p>
 * <p><b>Project</b>: Logic-Accounts</p>
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
 *
 */
@Slf4j
@Component
@NoArgsConstructor
public class ExceptionUtils extends RuntimeException {

  /**
   * Method to get API exception builder from HTTP call.
   *
   * @param ex Throwable
   * @param component String
   * @return {link ApiException}
   */
  public static ApiException getApiExceptionBuilderFromHttpCall(Throwable ex, String component) {
    ErrorCategory errorCategory;

    if (ex instanceof IllegalArgumentException) {
      errorCategory = ErrorCategory.BAD_REQUEST;
    } else if (ex instanceof NullPointerException) {
      errorCategory = ErrorCategory.INTERNAL_SERVER_ERROR;
    } else if (ex instanceof SecurityException) {
      errorCategory = ErrorCategory.UNAUTHORIZED;
    } else {
      errorCategory = ErrorCategory.UNKNOWN;
    }

    return new ApiException(String.format("Component: %s, Error: %s, Message: %s",
            component, errorCategory.getValue(), ex.getMessage()));
  }

  /**
   * Method to handle exception.
   *
   * @param code int
   * @param message String
   * @param throwable Throwable
   * @return {link Supplier}
   */
  public static @NonNull Supplier<?
          extends @NonNull Throwable> handleApiException(
      int code, String message, Throwable throwable) {
    log.error("Error: ", throwable);
    return (Supplier<? extends Throwable>)
            Single.error(new Exception(
                    String.valueOf(ResponseEntity.status(code).body(ResponseMessage.builder()
                            .message(message).build()))));
  }
}
