package lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LazySeqImp<T> implements Iterable<T> {
  
  Iterable<? extends T> iterable;
  Predicate<? super T> predicate;
  Function<? super T, ? extends T> mapper;
  Long size;
  
  public LazySeqImp(Iterable<? extends T> iterable) {
    this.iterable = iterable;
  }

  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<T> iterator() {
    return new LazySeqIterator();
  }
  
  public void forEach(Consumer<? super T> consumer) {
    if (predicate == null && mapper == null) {
      iterable.forEach(consumer);
    } else {
      Iterator<T> lazy = iterator();
      if (size != null) {
        while (lazy.hasNext() && size > 0) {
          T element = lazy.next();
          consumer.accept(element);
          size--;
        }
        size = null;
      } else {
        while (lazy.hasNext()) {
          T element = lazy.next();
          consumer.accept(element);
        }
      }
    }
  }
  
  public LazySeqImp<T> filter(Predicate<? super T> predicate) {
    this.predicate = predicate;
    return this;
  }
  
  public LazySeqImp<T> map(Function<? super T, ? extends T> mapper) {
    this.mapper = mapper;
    return this;
  }
  
  public LazySeqImp<T> limit(long maxSize) {
    this.size = maxSize;
    return this;
  }
  
  class LazySeqIterator implements Iterator<T> {
    Iterator<? extends T> iterator = iterable.iterator();
    T next = null;
    
    public LazySeqIterator() {
    }
    
    private void getNext() {
      while (iterator.hasNext()) {
        T node = iterator.next();    
        if (predicate != null) {
          if (predicate.test(node)) {
            if (mapper != null) {
              node = mapper.apply(node);
            }
            next = node;
            break;
          }
        } else {
          if (mapper != null) {
            node = mapper.apply(node);
          }
          next = node;
          break;
        }
      }
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
      getNext();
      if (next != null) {
        return true;
      }
      return false;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    @Override
    public T next() {
      T tmp = next;
      next = null;
      return tmp;
    }
    
  }
  
  public static void main(String[] args) {
    LazySeqImp<Integer> lazySeq = new LazySeqImp<Integer>(Arrays.asList(1,2,3,4,5));
    lazySeq = lazySeq.filter(i -> i % 2 == 0);
    lazySeq.forEach(System.out::println);
    Iterator<Integer> lazy = lazySeq.iterator();
    while (lazy.hasNext()) {
      System.out.println(lazy.next());
    }
    lazySeq.map(x -> x * x).limit(1).forEach(System.out::println);
  }
  
}