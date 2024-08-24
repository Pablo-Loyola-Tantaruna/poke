package com.qori.tech.ux.pokes.business.impl;

import com.qori.tech.ux.pokes.business.ListAllService;
import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import com.qori.tech.ux.pokes.util.header.ApiHeader;
import com.qori.tech.ux.pokes.util.utils.listall.ListAllUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * <p> This class is used like service for get all pokes.</p>
 * <p> The function of this class is to be used like service for get all pokes.</p>
 * <p><b>Class</b>: ListAllServiceImpl</p>
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
@Service
@Slf4j
@RequiredArgsConstructor
public class ListAllServiceImpl implements ListAllService {

  private final ListAllUtils listAllUtils;

  @Override
  public Flux<ResponseEntity<ListAllPokesResponse>> process(ApiHeader apiHeader) {
    log.info("ListAllServiceImpl.process");
    return listAllUtils.listAllPokemon();
  }
}
