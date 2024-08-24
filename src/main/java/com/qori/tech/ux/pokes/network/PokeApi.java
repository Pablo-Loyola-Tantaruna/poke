package com.qori.tech.ux.pokes.network;


import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import feign.Headers;
import feign.RequestLine;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.model.PaginatedPokedexSummaryList;
import reactor.core.publisher.Flux;

/**
 * <p> This interface is responsible for call to the API.</p>
 * <p> The function of this interface is to call to the API.</p>
 * <p><b>Interface</b>: PokeApi</p>
 * <p><b>Package</b>: com.qori.tech.ux.pokes.network</p>
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
@CircuitBreaker(name = "pokeApi-v1")
public interface PokeApi {

  /**
   * This method is to get all the pokemon.
   *
   * @return {link Flux} of {@link ListAllPokesResponse}
   */
  @Headers({"Content-Type: application/json"})
  @RequestLine("GET /pokemon?limit=100000")
  Flux<PaginatedPokedexSummaryList> getAllPokes();
}
