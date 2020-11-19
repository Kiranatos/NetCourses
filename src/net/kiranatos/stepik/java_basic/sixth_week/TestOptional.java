package net.kiranatos.stepik.java_basic.sixth_week;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class TestOptional {
    public static void main(String[] args) {
        /*
        (int a, int b) -> {  return a + b; } 
        () -> System.out.println("Hello World"); 
        (String s) -> { System.out.println(s); } 
        () -> 42 
        () -> { return 3.1415 };
        
        • Lambda-выражения могут иметь от 0 и более входных параметров.
        • Тип параметров можно указывать явно либо может быть получен из контекста. 
            Например (int a) можно записать и так (a)
        • Параметры заключаются в круглые скобки и разделяются запятыми. 
            Например (a, b) или (int a, int b) или (String a, int b, float c)
        • Если параметров нет, то нужно использовать пустые круглые скобки. 
            Например () -> 42
        • Когда параметр один, если тип не указывается явно, скобки можно опустить. 
            Пример: a -> return a*a
        • Тело Lambda-выражения может содержать от 0 и более выражений.
        • Если тело состоит из одного оператора, его можно не заключать в 
            фигурные скобки, а возвращаемое значение можно указывать 
            без ключевого слова return.
        • В противном случае фигурные скобки обязательны (блок кода), 
            а в конце надо указывать возвращаемое значение с использованием 
            ключевого слова return (в противном случае типом возвращаемого 
            значения будет void).        
        */
        
        new Thread( () -> System.out.println("hello world") ).start();    
        
        /*************************************************************/
        
        Consumer<Integer>  a1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println("In anonymus class" + x);
            }
        };            
        Consumer<Integer>  a2 = (Integer x)->{ System.out.println("In Lambda" + x); };    
        a1.accept(Integer.SIZE);
        a2.accept(100);
        
        /*************************************************************/
        
        BiConsumer<Integer, String> b1 = new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer x, String y) {
                System.out.println(x + " : " + y);
            }
        };
        BiConsumer<Integer, String> b2 = (Integer x, String y) -> System.out.println(x + " : " + y);
        b1.accept(10, "anonymus class");
        b2.accept(20, "Lambda");
        
        /*************************************************************/
        Predicate<String> c1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s == null;
            }
        };
        Predicate<String> c2 = (String s) -> s == null;
        
        /*************************************************************/
        
        System.out.println("========================= Experiment with Optional ====================");
        
        Optional< String > fullName = Optional.ofNullable( null );
        System.out.println( "Full Name is set? " + fullName.isPresent() );       
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        
        System.out.println( fullName.map ( new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "Hey " + s + "!";
            }
        }) );        
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        /** If a value is present, apply the provided mapping function to it,
     * and if the result is non-null, return an {@code Optional} describing the
     * result.  Otherwise return an empty {@code Optional}.
     *
     * @apiNote This method supports post-processing on optional values, without
     * the need to explicitly check for a return status.  For example, the
     * following code traverses a stream of file names, selects one that has
     * not yet been processed, and then opens that file, returning an
     * {@code Optional<FileInputStream>}:
     *
     * <pre>{@code
     *     Optional<FileInputStream> fis =
     *         names.stream().filter(name -> !isProcessedYet(name))
     *                       .findFirst()
     *                       .map(name -> new FileInputStream(name));
     * }</pre>
     *
     * Here, {@code findFirst} returns an {@code Optional<String>}, and then
     * {@code map} returns an {@code Optional<FileInputStream>} for the desired
     * file if one exists.
     *
     * @param <U> The type of the result of the mapping function
     * @param mapper a mapping function to apply to the value, if present
     * @return an {@code Optional} describing the result of applying a mapping
     * function to the value of this {@code Optional}, if a value is present,
     * otherwise an empty {@code Optional}
     * @throws NullPointerException if the mapping function is null
     
    public<U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Optional.ofNullable(mapper.apply(value));
        }
    }*/
        
        Optional<String> op1 = Optional.empty();
        Optional<String> op2 = Optional.of("string op1");
        Optional<String> op3 = Optional.ofNullable("string op3");
        
        Optional<TestA> opTestA1 = Optional.empty();
        Optional<TestA> opTestA2_1 = Optional.of( new TestA("opTestA2_1") );
        // не может быть нулём: Optional<TestA> opTestA2_2 = Optional.of( null );
        Optional<TestA> opTestA3_1 = Optional.ofNullable( new TestA("opTestA3_1") );
        Optional<TestA> opTestA3_2 = Optional.ofNullable( null );
        
        
        
    }
}

class TestA {

    public TestA(String s) {
        System.out.println("TestA = " + s);
    }

    @Override
    public String toString() {
        return "TestA{" + '}';
    }
    
}