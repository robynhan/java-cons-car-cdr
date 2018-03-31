package org.robyn.cons;

import static org.hamcrest.CoreMatchers.is;
import static org.robyn.cons.ConsSolution.car;
import static org.robyn.cons.ConsSolution.cdr;
import static org.robyn.cons.ConsSolution.cons;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

public class ConsSolutionTest {

  @Test
  public void test_should_cons_car_cdr() {
    Function<BiFunction<Integer, Integer, Integer>, Integer> cons = cons(1, 2);

    Assert.assertThat(car(cons), is(1));
    Assert.assertThat(cdr(cons), is(2));
  }
}