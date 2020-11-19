package net.kiranatos.stepik.java_basic.sixth_week;

import java.util.*;
import java.util.function.*;

/**
 * Реализуйте generic-класс Pair, похожий на Optional, 
 * но содержащий пару элементов разных типов и не запрещающий 
 * элементам принимать значение null.
 * 
 * Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а 
 * также статический фабричный метод of(). Конструктор должен быть 
 * закрытым (private).
 * 
 * С корректно реализованным классом Pair должен компилироваться и 
 * успешно работать следующий код:
 */
public class Ex_6_1_12 {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        
     
    }
}

class Pair<T,K> {
    private static final Pair<?,?> EMPTY = new Pair<>();
    private final T tValue;
    private final K kValue;
    
    private Pair() {
        this.tValue = null;
        this.kValue = null;
    }
    
    public static<T,K> Pair<T,K> empty() {
        @SuppressWarnings("unchecked")
        Pair<T,K> t = (Pair<T,K>) EMPTY;
        return t;
    }
    
    private Pair(T tValue, K kValue) {
        this.tValue = tValue;
        this.kValue = kValue;
    }
    
    public static <T,K> Pair<T,K> of(T tValue, K kValue) {
        return new Pair<>(tValue, kValue);
    }
    
    /*public static <T,K> Pair<T,K> ofNullable(T tValue, K kValue) {
        return ((tValue == null)&&(kValue == null)) ? empty() : of(tValue, kValue);
    }*/
    
    public T getFirst() {
        if (tValue == null) {
            throw new NoSuchElementException("No value present");
        }
        return tValue;
    }
    
    public K getSecond() {
        if (kValue == null) {
            throw new NoSuchElementException("No value present");
        }
        return kValue;
    }
   /* 
    public boolean isPresent() {
        return ((kValue != null)&((tValue != null)));
    }
    
    public void ifPresent(Consumer<? super T> tConsumer, Consumer<? super K> kConsumer) {
        if (tValue != null) {
            tConsumer.accept(tValue);            
        }
        if (kValue != null) {            
            kConsumer.accept(kValue);
        }
    }
    
    
    public Pair<T,K> filter(Predicate<? super T> tPredicate, Predicate<? super K> kPredicate) {
        Objects.requireNonNull(tPredicate);
        Objects.requireNonNull(kPredicate);
        if (!isPresent()) return this;
        else
            return ((tPredicate.test(tValue))&&(kPredicate.test(kValue))) ? this : empty();
    }
   /*
    public<W> Pair<T,K> map(BiFunction<? super T, ? super K, ? extends W> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            //return Optional.ofNullable(mapper.apply(value));            
            return Pair.ofNullable(tValue, kValue);
        }
    }
  /*  
    public<U> Optonal<U> flatMap(Function<? super T, Optional<U>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Objects.requireNonNull(mapper.apply(value));
        }
    }*/
    /*
    public T orElse(T other) {
        return value != null ? value : other;
    }
    
    
    public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }
    
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair<? , ?> other = (Pair<? , ?>) obj;
        return Objects.equals(kValue, other.kValue) && Objects.equals(tValue, other.tValue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(kValue) + Objects.hashCode(tValue);
    }
    
    /*
    @Override
    public String toString() {
        return ((tValue != null)&(tValue != null))
            ? String.format("Optional[%s %s]", tValue, kValue)
            : "Optional.empty";
    }*/

}