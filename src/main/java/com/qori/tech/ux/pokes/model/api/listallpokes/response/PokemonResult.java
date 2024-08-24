package com.qori.tech.ux.pokes.model.api.listallpokes.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonResult {
  @SerializedName("name")
  String name;
  @SerializedName("url")
  String url;
}
