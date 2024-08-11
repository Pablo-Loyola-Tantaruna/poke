package com.qori.tech.ux.pokes.framework.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCategory {
  INTERNAL_SERVER_ERROR("Internal Server Error", 500),
  BAD_REQUEST("Bad Request", 400),
  NOT_FOUND("Not Found", 404),
  UNAUTHORIZED("Unauthorized", 401),
  FORBIDDEN("Forbidden", 403),
  CONFLICT("Conflict", 409),
  UNPROCESSABLE_ENTITY("Unprocessable Entity", 422),
  TOO_MANY_REQUESTS("Too Many Requests", 429),
  SERVICE_UNAVAILABLE("Service Unavailable", 503),
  GATEWAY_TIMEOUT("Gateway Timeout", 504),
  UNKNOWN("Unknown", 900);

  private final String value;

  private final int httpStatus;

}
