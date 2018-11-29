package com.luxoft.training.java2.functional;

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class FunctionalInterfacesExample {

  public static void main(String... __) {

    // java.util.functions

    // () -> void
//    Runnable runnable = () -> System.out.println("lorem");
    withRunnable(() -> System.out.println("lorem"));

    //() -> T
    Callable<Integer> callable = () -> 1;
    withCallable(callable);
    withCallable(() -> 1);

    //() -> T
    Supplier<Integer> supplier = () -> 2;
    withSupplier(supplier);
    withSupplier(() -> 2);

    // T -> void
//    Consumer<Integer> integerConsumer = integer -> System.out.println(integer);
    Consumer<Integer> integerConsumer = System.out::println;
    withConsumer(integerConsumer);
//    withConsumer(integer -> System.out.println(integer));
    withConsumer(System.out::println);

    // T1 -> T2
    Function<Integer, String> integerStringFunction = String::valueOf;
    withFunction(integerStringFunction);
    withFunction(String::valueOf);

    // (T1, T2) -> T3
    BiFunction<Integer, Double, String> integerDoubleStringBiFunction =
        (integer, double1) -> String.valueOf(integer + double1);
    withBiFunction(integerDoubleStringBiFunction);
    withBiFunction((integer, double1) -> String.valueOf(integer + double1));
  }

  public static void withRunnable(@NotNull Runnable runnable) {
      runnable.run();
  }

  @SneakyThrows
  public static void withCallable(@NotNull Callable<Integer> integerCallable) {
    System.out.println(integerCallable.call());
  }

  public static void withSupplier(@NotNull Supplier<Integer> integerSupplier) {
    System.out.println(integerSupplier.get());
  }

  public static void withConsumer(@NotNull Consumer<Integer> integerConsumer) {
    integerConsumer.accept(5);
  }

  public static void withFunction(@NotNull Function<Integer, String> integerStringFunction) {
    System.out.println("integerStringFunction.apply(6) = "
        + integerStringFunction.apply(6));
  }

  public static void withBiFunction(@NotNull BiFunction<Integer, Double, String> integerDoubleStringBiFunction) {
    System.out.println("integerDoubleStringBiFunction.apply(5, 0.5) = "
        + integerDoubleStringBiFunction.apply(5, 0.5));
  }
}
