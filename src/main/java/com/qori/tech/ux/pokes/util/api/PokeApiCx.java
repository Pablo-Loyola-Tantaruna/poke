package com.qori.tech.ux.pokes.util.api;

import com.qori.tech.ux.pokes.framework.config.api.ReactiveAutoInject;
import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import com.qori.tech.ux.pokes.network.PokeApi;
import com.qori.tech.ux.pokes.util.exception.ExceptionUtils;
import io.swagger.model.PaginatedPokedexSummaryList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * <p> This class is responsible for call to te interface to call the API.</p>
 * <p> The function of this class is to call to te interface to call the API.</p>
 * <p><b>Class</b>: PokeApiCx</p>
 * <p><b>Package</b>: com.qori.tech.ux.pokes.util.api</p>
 * <p><b>Project</b>: PokesApiConnection</p>
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
 */
@Slf4j
@Service
public class PokeApiCx {

  @ReactiveAutoInject(clientClass = PokeApi.class, apiName = "pokeApi")
  private PokeApi pokeApi;

  /**
   * This method is to list all the pokemon.
   *
   * @return {link Flux}
   */
  public Flux<PaginatedPokedexSummaryList> invokeGetAllPokes() {
    return pokeApi.getAllPokes()
            .doOnError(throwable -> log.error("Error occurred while fetching all pokes", throwable))
            .onErrorResume(throwable -> Flux.error(
                    ExceptionUtils.getApiExceptionBuilderFromHttpCall(throwable,
                            "PokeApiCx")))
            .subscribeOn(Schedulers.boundedElastic());
  }
}
