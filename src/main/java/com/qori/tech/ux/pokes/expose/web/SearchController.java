package com.qori.tech.ux.pokes.expose.web;

import com.qori.tech.ux.pokes.framework.body.ResponseMessage;
import com.qori.tech.ux.pokes.util.header.ApiHeader;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p> This class is responsible for search the pokemon.</p>
 * <p> The function of this class is to search the pokemon.</p>
 * <p><b>Class</b>: SearchController</p>
 * <p><b>Package</b>: com.qori.tech.ux.pokes.expose.web</p>
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

@RefreshScope
@RestController
@Tag(name = "SearchPokes")
@RequestMapping("/search-pokes")
@Slf4j
@RequiredArgsConstructor
public class SearchController {

  @InitBinder
  public void initBinder(DataBinder dataBinder) {
    dataBinder.setDisallowedFields();
  }

  /*
   * This method is to search the pokemon.
   *
   * @param apiHeader ApiHeader.
   * @param SearchPokeRequest SearchPokeRequest.
   * @return {link ResponseMessage}
   *
  @GetMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
      tags = "AccountsResponse",
      summary = "Search",
      description = "classpath:swagger/notes/search.md",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Pokemons found",
              content = @Content(schema = @Schema(implementation = SearchPokeResponse.class))),
          @ApiResponse(
              responseCode = "400",
              description = "Bad Request",
              content = @Content(schema = @Schema(implementation = Exception.class))),
          @ApiResponse(
              responseCode = "403",
              description = "Account already exist",
              content = @Content(schema = @Schema(implementation = Exception.class))),
          @ApiResponse(
              responseCode = "500",
              description = "Internal Server Error",
              content = @Content(schema = @Schema(implementation = Exception.class))),
          @ApiResponse(
              responseCode = "503",
              description = "Service Unavailable",
              content = @Content(schema = @Schema(implementation = Exception.class)))
      })
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseEntity<ResponseMessage>> search(
      @ParameterObject @RequestHeader ApiHeader apiHeader,
      @RequestBody SearchPokeRequest SearchPokeRequest) {
    return SearchPokeService.process(apiHeader, SearchPokeRequest);
  }*/
}
