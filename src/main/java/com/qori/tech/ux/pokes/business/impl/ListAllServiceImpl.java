package com.qori.tech.ux.pokes.business.impl;

import com.qori.tech.ux.pokes.business.ListAllService;
import com.qori.tech.ux.pokes.model.api.listallpokes.request.ListAllPokesRequest;
import com.qori.tech.ux.pokes.model.api.listallpokes.response.ListAllPokesResponse;
import com.qori.tech.ux.pokes.util.header.ApiHeader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ListAllServiceImpl implements ListAllService {

  @Override
  public Mono<ResponseEntity<ListAllPokesResponse>> process(ApiHeader apiHeader, ListAllPokesRequest request) {
    return Mono.just(ResponseEntity.ok().body(new ListAllPokesResponse()));
  }
}
