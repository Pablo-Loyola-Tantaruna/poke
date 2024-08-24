package com.qori.tech.ux.pokes.config;

import com.qori.tech.ux.pokes.config.factory.ReactiveClientFactory;
import com.qori.tech.ux.pokes.framework.config.api.ReactiveAutoInject;
import java.lang.reflect.Field;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * <p> This class is used to BeanPostProcessor for inject the client.</p>
 * <p> The function of this class is to be used to BeanPostProcessor for inject the client.</p>
 * <p><b>Class</b>: ReactiveClientInjector</p>
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
@Component
@RequiredArgsConstructor
public class ReactiveClientInjector implements BeanPostProcessor {
  private final ReactiveClientFactory reactiveClientFactory;

  @Override
  public Object postProcessBeforeInitialization(Object bean, @NotNull String beanName) {
    Field[] fields = bean.getClass().getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(ReactiveAutoInject.class)) {
        ReactiveAutoInject annotation = field.getAnnotation(ReactiveAutoInject.class);
        Class<?> clientClass = annotation.clientClass();
        String apiName = annotation.apiName();
        Object client = reactiveClientFactory.createClient(clientClass, apiName);
        field.setAccessible(true);
        ReflectionUtils.setField(field, bean, client);
      }
    }
    return bean;
  }
}
