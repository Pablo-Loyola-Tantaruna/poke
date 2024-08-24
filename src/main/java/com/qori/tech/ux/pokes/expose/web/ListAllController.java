package com.qori.tech.ux.pokes.expose.web;

import com.qori.tech.ux.pokes.business.ListAllService;
import com.qori.tech.ux.pokes.framework.header.manager.RequestHeaderModel;
import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import com.qori.tech.ux.pokes.util.header.ApiHeader;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
@Tag(name = "ListAllPokes")
@RequestMapping("/list-all-pokes")
@Slf4j
@RequiredArgsConstructor
public class ListAllController {

  private final ListAllService listAllService;
  
  @InitBinder
  public void initBinder(DataBinder dataBinder) {
    dataBinder.setDisallowedFields();
  }

  /**
   * This method is to get all the pokémon.
   *
   * @param apiHeader ApiHeader.
   * @return {link ResponseMessage}
   */
  @GetMapping(
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
      tags = "AccountsResponse",
      summary = "ListAll",
      description = "classpath:swagger/notes/listAll.md",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Pokemons found",
              content = @Content(schema = @Schema(implementation = ListAllPokesResponse.class))),
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
  public Flux<ResponseEntity<ListAllPokesResponse>> getAll(
      @RequestHeaderModel(ApiHeader.class) ApiHeader apiHeader) {
    return listAllService.process(apiHeader);
  }
}