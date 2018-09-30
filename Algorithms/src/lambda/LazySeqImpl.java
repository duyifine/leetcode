package lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LazySeqImpl<T> implements Iterable<T> {
  private Iterable<? extends T> iter;
  private Predicate<? super T> predicate;
  private Function<? super T, ? extends T> mapper;
  
  public LazySeqImpl(Iterable<? extends T> iter) {
    this.iter = iter;
  }

  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<T> iterator() {
    return new LazySeqIterator();
  }
  
  public LazySeqImpl<T> filter(Predicate<? super T> predicate) {
    this.predicate = predicate;
    return this;
  }
  
  public void forEach(Consumer<? super T> consumer) {
    if (mapper == null) {
      iter.forEach(consumer);
    } else {
      for (T element : iter) {
//        if (predicate.test(element)) {
//          consumer.accept(element);
//        }
        element = mapper.apply(element);
        consumer.accept(element);
      }
    }
  }
  
  public LazySeqImpl<T> map(Function<? super T, ? extends T> mapper) {
    this.mapper = mapper;
    return this;
  }
  
  class LazySeqIterator implements Iterator<T> {
    
    private Iterator<? extends T> iterator = iter.iterator();
    private T next = null;
    
    LazySeqIterator() {
      getNext();
    }
    
    private void getNext() {
      next = null;
      while (iterator.hasNext()) {
        T temp = iterator.next();
        if (predicate.test(temp)) {
          System.out.println("pass predicate:" + temp);
          next = temp;
          break;
        }
      }
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
      return next != null;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    @Override
    public T next() {
      T temp = null;
      getNext();
      return temp;
    }
    
  }
  
  public static void main(String[] args) {
    LazySeqImpl<Integer> lazySeq = new LazySeqImpl<Integer>(Arrays.asList(1,2,3,4,5));
    lazySeq = lazySeq.filter(i -> i % 2 == 0);
//    lazySeq.forEach(System.out::println);
    while (lazySeq.iterator().hasNext()) {
      System.out.println(lazySeq.iterator().next());
    }
//    for (Integer i : lazySeq) {
//      System.out.println(i);
//    }
//    lazySeq.map(x -> x * x).forEach(System.out::println);
//    for (Integer i : lazySeq) {
//      System.out.println(i);
//    }
  }
}