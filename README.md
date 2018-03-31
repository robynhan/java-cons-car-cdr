根据Alonzo Church 的lambda 算子的思路, 在Lisp 中序对的构造和选择函数, 可以使用以下的定义: 

    (Define (cons x y)
            (λ (m) (m x y)))
    (Define (car x)
            (x (λ (a d) a)))
    (Define (cdr x)
            (x (λ (a d) d)))

这种形式的定义, 仅仅使用了函数定义和函数调用, 而不借助任何的局部变量和赋值语句. 

使用最简化的替代模型, 就可以推演出基本的运行步骤.

    (car (cons 35 47)) =>
    (car ((λ (m) (m 35 47))))
    ((λ (m) (m 35 47)) (λ (a d) a))
    ((λ (a d) a) 35 47)
    35



那么, 在Java 这种面向对象的语言中, 应该如何仅通过函数来定义此类函数呢?

      public static <T> Function<BiFunction<T, T, T>, T> cons(T x, T y) {
        return m -> m.apply(x, y);
      }
    
      public static <T> T car(Function<BiFunction<T, T, T>, T> cons) {
        return cons.apply((a, b) -> a);
      }
    
      public static <T> T cdr(Function<BiFunction<T, T, T>, T> cons) {
        return cons.apply((a, b) -> b);
      }

对应的测试代码如下:

      @Test
      public void test_should_cons_car_cdr() {
        Function<BiFunction<Integer, Integer, Integer>, Integer> cons = cons(1, 2);
    
        Assert.assertThat(car(cons), is(1));
        Assert.assertThat(cdr(cons), is(2));
      }

以以上的代码为例, 可以对比Lisp 和Java 中函数式的写法.

- 函数定义
      Lisp: (λ (m) (m x y))
      Java: m -> m.apply(x, y);
- 函数应用(实参为函数)
