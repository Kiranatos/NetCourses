package net.kiranatos.stepik.java_basic.sixth_week;

//https://stepik.org/lesson/Stream-API-12781/step/13?course=Java-%D0%91%D0%B0%D0%B7%D0%BE%D0%B2%D1%8B%D0%B9-%D0%BA%D1%83%D1%80%D1%81&discussion=119160&reply=121621


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Напишите программу, читающую из System.in текст в кодировке UTF-8, 
 * подсчитывающую в нем частоту появления слов, и в конце выводящую 
 * 10 наиболее часто встречающихся слов.
 * 
 * Словом будем считать любую непрерывную последовательность символов, 
 * состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!"
 * ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 * 
 * Подсчет слов должен выполняться без учета регистра, 
 * т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. 
 * Выводите слова в нижнем регистре.
 * 
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * 
 * Если в тексте некоторые слова имеют одинаковую частоту, 
 * т.е. их нельзя однозначно упорядочить только по частоте, 
 * то дополнительно упорядочите слова с одинаковой частотой в 
 * лексикографическом порядке.
 * 
 * Задача имеет красивое решение через стримы без циклов и 
 * условных операторов. Попробуйте придумать его.
 * 
 * Sample Input 1: Мама мыла-мыла-мыла раму!
 * Sample Output 1:
 * мыла
 * мама
 * раму
 * 
 * Sample Input 2:
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
 * Sed sodales consectetur purus at faucibus. Donec mi quam, 
 * tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia 
 * velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet 
 * sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. 
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
 * Integer vel odio nec mi tempor dignissim.
 * 
 * Sample Output 2:
 * consectetur
 * faucibus
 * ipsum
 * lorem
 * adipiscing
 * amet
 * dolor
 * eget
 * elit
 * mi
 */
public class Ex_6_4_13_Main_for_study {
    public static void main(String[] args) {        
        String ex1 = "Мама мыла-мыла-мыла 33 раму!";
        System.out.println(ex1);
        String ex2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        System.out.println(ex2);
        
        //System.out.println( ex1.replaceAll("([^а-яa-z0-9])", "*") );
        
        qwerty(ex2);
    }   
    
    private static class MyComparator implements Comparator<Object>{
        @Override
        public int compare(Object o1, Object o2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
    private static String qwerty(String str) {        
        //Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
        Collection<String> collection = Arrays.asList(str);
        Stream<String> streamFromCollection = collection.stream();

        String[] sM =                 
                streamFromCollection.flatMap((String p) -> Arrays.asList( p.toLowerCase().split("([^а-яa-z0-9]+)") ).stream())    
                .toArray(String[]::new);
        
        //for (int i = 0; i < sM.length; i++) {System.out.println(sM[i]); }        
        /*textInChar = text.chars().mapToObj(e->(char)e).collect(Collectors.toList());*/
        
        List<String> f = Arrays.asList(sM);        
        Map<String, Integer> countString = f.stream().collect(
                HashMap::new, 
                
                new BiConsumer<HashMap<String, Integer>, String>() {
                    @Override
                    public void accept(HashMap<String, Integer> m, String c) {
                        if(m.containsKey(c))
                            m.put(c, m.get(c) + 1);
                        else
                            m.put(c, 1);
                    }
                }, 
                
                HashMap::putAll
        );
        

    
        Iterator<Map.Entry<String,Integer>> it = countString.entrySet().iterator();
        while ( it.hasNext() ) {
            Map.Entry<String,Integer> pair = it.next();
            String k = pair.getKey();
            Integer v = pair.getValue(); 
            System.out.println(k + " : " + v);           
        }
        
        countString.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparing((Map.Entry<String, Integer> entry) -> entry.getValue()).reversed())
                .forEach(entry -> System.out.println("[" + entry.getKey() + ":" + entry.getValue() + "]" ));
         //.sorted(Comparator.comparing((Map.Entry<String, Long> entry) -> entry.getValue()).reversed());
        
         
        
        

        
        return null;
    }
}


/*
collect(groupingBy(Function.identity(), counting())) или 
регулярки [\\p{Blank}\\p{Punct}]+
collect(groupingBy(Map.Entry::getValue, Collectors.counting())).

регулярки [\\p{Blank}\\p{Punct}]+
[\\p{Punct}\\s]+
.split("[^\\p{L}\\p{Digit}_]+")
Подошли разные варианты, на самом деле. Cамый правильный разделитель для функции split, получается, такой:

^\pL\pM\p{Nd}\p{Nl}\p{Pc}[\p{InEnclosedAlphanumerics}&&\p{So}]

Этот монст есть правильный юникодный эквивалент \W в java.

Пруф: http://stackoverflow.com/a/4307261

Ответ нашла на https://stackoverflow.com/questions/4304928/unicode-equivalents-for-w-and-b-in-java-regular-expressions
Для будущих искателей)) в Java  \w ограничен символами [A-Za-z0-9_] 
*/