package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LazySeq<T> {
  
  private final List<T> list;
  private Predicate<? super T> predicate;
  
  public LazySeq(List<T> input) {
    this.list = new ArrayList<>(input);
  }
  
  public LazySeq<T> filter(Predicate<? super T> predicate) {
    this.predicate = predicate;
    return this;
  }
  
  public void forEach(Consumer<? super T> consumer) {
    if (predicate == null) {
      list.forEach(consumer);
    } else {
      for (T element : list) {
        if (predicate.test(element)) {
          consumer.accept(element);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    LazySeq<Integer> lazySeq = new LazySeq<>(Arrays.asList(1,2,3,4,5));
    lazySeq = lazySeq.filter(i -> i % 2 == 0);
    lazySeq.forEach(System.out::println);
  }
}