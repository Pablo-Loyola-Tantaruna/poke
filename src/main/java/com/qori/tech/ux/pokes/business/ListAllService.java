package com.qori.tech.ux.pokes.business;

import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import com.qori.tech.ux.pokes.util.header.ApiHeader;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

/**
 * <p>This interface is used like service for the validate account.</p>
 * <p>The function of this interface is to be used like service for the validate account.</p>
 * <p><b>Interface</b>: ValidateAccountService</p>
 * <p><b>Package</b>: com.qoritech.createaccount.business</p>
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
public interface ListAllService {
  Flux<ResponseEntity<ListAllPokesResponse>> process(ApiHeader apiHeader);
}
