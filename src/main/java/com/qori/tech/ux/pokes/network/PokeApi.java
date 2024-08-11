package com.qori.tech.ux.pokes.network;


import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import feign.Headers;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;



@CircuitBreaker(name = "pokeApi-v1")
public interface PokeApi {

  /**
   * Get all pokes
   *
   * @return {link Flux} of {@link ListAllPokesResponse}
   */

  @Headers({"Content-Type: application/json"})
  @GetMapping("pokemon?limit=100000")
  Flux<ListAllPokesResponse> getAllPokes();
}
