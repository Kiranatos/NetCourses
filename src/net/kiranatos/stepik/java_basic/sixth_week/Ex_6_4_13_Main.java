package net.kiranatos.stepik.java_basic.sixth_week;

/* ЗАСЧИТАЛО !!! */

import java.util.*;
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
public class Ex_6_4_13_Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);        
        Scanner scanner = new Scanner("Мама мыла-мыла-мыла раму!");
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.next()).append(" ");
        }                
        //System.out.println(sb.toString());
        qwerty(sb.toString());
        
        System.out.flush();
    }   
    
    private static void qwerty(String str) {  
        Collection<String> collection = Arrays.asList(str);
        Stream<String> streamFromCollection = collection.stream();

        String[] sM =                 
                streamFromCollection.flatMap((String p) -> Arrays.asList( p.toLowerCase().split("([^а-яa-z0-9]+)") ).stream())    
                .toArray(String[]::new);
        
        List<String> f = Arrays.asList(sM);        
        Map<String, Integer> countString = f.stream().collect(HashMap::new, (HashMap<String, Integer> m, String c) -> {
            if(m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else
                m.put(c, 1);
        },                 
                HashMap::putAll
        );
        
        countString.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparing((Map.Entry<String, Integer> entry) -> entry.getValue()).reversed())
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey()));  
    
        
    }
}
