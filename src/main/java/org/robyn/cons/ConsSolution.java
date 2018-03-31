package org.robyn.cons;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConsSolution {

  public static <T> Function<BiFunction<T, T, T>, T> cons(T x, T y) {
    return m -> m.apply(x, y);
  }

  public static <T> T car(Function<BiFunction<T, T, T>, T> cons) {
    return cons.apply((a, b) -> a);
  }

  public static <T> T cdr(Function<BiFunction<T, T, T>, T> cons) {
    return cons.apply((a, b) -> b);
  }

}
