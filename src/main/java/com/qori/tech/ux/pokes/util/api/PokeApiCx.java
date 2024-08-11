package com.qori.tech.ux.pokes.util.api;

import com.qori.tech.ux.pokes.framework.config.api.ReactiveAutoInject;
import com.qori.tech.ux.pokes.network.PokeApi;
import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import com.qori.tech.ux.pokes.util.exception.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
public class PokeApiCx {

  @ReactiveAutoInject(clientClass = PokeApi.class, apiName = "poke-api")
  private PokeApi pokeApi;

  public Flux<ListAllPokesResponse> invokeGetAllPokes() {
    return pokeApi.getAllPokes()
            .doOnError(throwable -> log.error("Error occurred while fetching all pokes", throwable))
            .onErrorResume(throwable -> Flux.error(ExceptionUtils.getApiExceptionBuilderFromHttpCall(throwable, "PokeApiCx")))
            .subscribeOn(Schedulers.boundedElastic());
  }
}
