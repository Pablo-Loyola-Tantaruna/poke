package com.qori.tech.ux.pokes.util;

public class Utils {
  public static boolean isNull(Object obj) {
    return obj == null;
  }

  public static boolean isEmpty(String str) {
    return str == null || str.isEmpty();
  }
}
