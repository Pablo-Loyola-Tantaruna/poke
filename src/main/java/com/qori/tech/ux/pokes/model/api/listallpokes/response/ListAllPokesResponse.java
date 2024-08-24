package com.qori.tech.ux.pokes.model.api.listallpokes.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
public class ListAllPokesResponse {
  @SerializedName("count")
  int count;

  @SerializedName("results")
  List<PokemonResult> results;

}
