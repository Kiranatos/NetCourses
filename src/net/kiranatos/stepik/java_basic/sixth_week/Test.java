package net.kiranatos.stepik.java_basic.sixth_week;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {    
    public static void main(String[] args) throws IOException {
        int sum = IntStream.iterate(1, n->n+1)
                .filter(n->n%5==0&&n%2!=0)
                .limit(10)                
                .map(n->n*n)                
                .sum();
                
        
        
        /*
        Stream<String> str;
        Collection<?> collection = new ArrayList<Integer>();
        Object object = new Integer(2);
        //collection.addAll(Arrays.asList(object));
        collection.toArray();         
        collection.clear();
        collection.iterator();
        collection.contains(object);
        collection.remove(object);
        collection.size();*/
    }
}



class Example<X> {
    Optional<X> t;
    public void someMethod() {
        
    }
}
    /*
    public static void main(String[] args) {        
        Example<Integer> ert = new Example<Integer>();
        ert.someMethod(new String());
        ert.someMethod(new Example<String>());
        
    }    
}


class Example<X> {
    public void someMethod(Object obj) {
        X[] c;
        X vb = (X)obj;
        Optional.empty();
        if (obj instanceof Optional<X>) {}
        X[] d = new X[10]{};
    }
}*/