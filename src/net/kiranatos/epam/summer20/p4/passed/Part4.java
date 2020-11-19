package net.kiranatos.epam.summer20.p4.passed;

import java.io.File;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements java.lang.Iterable<String>  {

    public static void main(String[] args) {
        Part4 part4 = new Part4();
        for (String s : part4) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorImpl();
    }
    
    private class IteratorImpl implements Iterator<String> {
        private static final String NAME_OF_FILE = "part4.txt";        
        private static final String REGEX_SENTENCE = "\\p{Lu}[^.]*\\.";        
        private String[] someArr = new String[0];
        int index = 0;

        public IteratorImpl() {
            File file = Demo.checkFileOrCreateByDefault(NAME_OF_FILE);
            String text = Demo.readFromFile(file);
            someArr = getAppropriateStringArr(text);
        }
        
        private String[] getAppropriateStringArr(String line) {
            line = line.replaceAll(System.lineSeparator(), " ");
            StringBuilder sb = new StringBuilder();
            Matcher mName = Pattern.compile(REGEX_SENTENCE).matcher(line);
            while (mName.find()) {
                sb.append(mName.group()).append('\u82F1');
            }
            return sb.toString().split("\u82F1");
        }

        @Override
        public boolean hasNext() {
            return index < someArr.length;
        }

        @Override
        public String next() {
            String el = someArr[index++];
            if (el == null) 
                throw new java.util.NoSuchElementException();
            else 
                return el;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    public static int uslessMethodForJUnitTestCalculateABA(int a, int b) {
        return a+b+a;
    }
}