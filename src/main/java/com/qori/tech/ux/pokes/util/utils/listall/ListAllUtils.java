package com.qori.tech.ux.pokes.util.utils.listall;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import com.qori.tech.ux.pokes.model.api.listallpokes.response.PokemonResult;
import com.qori.tech.ux.pokes.util.Utils;
import com.qori.tech.ux.pokes.util.api.PokeApiCx;
import io.swagger.model.PaginatedPokedexSummaryList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


/**
 * <p> This class is responsible for list all the pokemon.</p>
 * <p> The function of this class is to list all the pokemon.</p>
 * <p><b>Class</b>: ListAllUtils</p>
 * <p><b>Package</b>: com.qori.tech.ux.pokes.util.utils.listall</p>
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
@RequiredArgsConstructor
@Component
public class ListAllUtils {

  private final PokeApiCx pokeApiCx;

  /**
   * This method is to list all the pokemon.
   *
   * @return {link ResponseEntity}
   */
  public Flux<ResponseEntity<ListAllPokesResponse>> listAllPokemon() {
    return pokeApiCx.invokeGetAllPokes()
            .map(result -> ResponseEntity.ok(listAllPokesResponse(result)));
  }

  private ListAllPokesResponse listAllPokesResponse(
          PaginatedPokedexSummaryList paginatedPokedexSummaryList) {
    return ListAllPokesResponse.builder()
            .results(new ObjectMapper()
                    .convertValue(paginatedPokedexSummaryList.getResults(),
                            new TypeReference<>() {}))
            .count(new ObjectMapper()
                    .convertValue(paginatedPokedexSummaryList.getCount(),
                            Integer.class))
            .build();
  }
}
