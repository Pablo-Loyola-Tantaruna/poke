package com.qori.tech.ux.pokes.framework.header;

import com.qori.tech.ux.pokes.framework.header.manager.RequestHeader;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * <p> This class is responsible for resolving the headers of the requests.</p>
 * <p> The function of this class is to resolve the headers of the requests.</p>
 * <p><b>Class</b>: RequestHeaderObject</p>
 * <p><b>Package</b>: com.qoritech.logic.accounts.framework.header</p>
 * <p><b>Project</b>: Create-Account</p>
 * <p><b>Version</b>: 1.0.0</p>
 * <p><b>Company</b>: QoriTech Solutions Company</p>
 * <p><b>Creation Date</b>: 2024-03-16</p>
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
public class RequestHeaderResolve implements HandlerMethodArgumentResolver {

  /**
   * This method is used to know if it supports the parameter.
   *
   * @param parameter Parameter.
   * @return boolean
   */
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(RequestHeader.class);
  }

  /**
   * This method is used to resolve the argument.
   *
   * @param parameter Parámetro.
   * @param mavContainer Contenedor de la vista.
   * @param webRequest Solicitud web.
   * @param binderFactory Fábrica de enlace web.
   * @return Object
   * @throws Exception Excepción.
   */
  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                  @NotNull NativeWebRequest webRequest,
                  WebDataBinderFactory binderFactory) throws Exception {
    RequestHeader headerObject = parameter.getParameterAnnotation(RequestHeader.class);
    assert headerObject != null;
    String headerName = headerObject.value();
    if (headerName.isEmpty() || headerName.isBlank()) {
      headerName = headerObject.name();
    }

    String headerValue = webRequest.getHeader(headerName);

    if (headerValue == null && headerObject.required()) {
      throw new ServletRequestBindingException("Required header " + headerName + " not present");
    }

    return headerValue;
  }
}
