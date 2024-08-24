package com.qori.tech.ux.pokes.model.util;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ServiceGroupProperties {

  private Map<String, ApiConfigProperties> pokeApi = new HashMap<>();
}
