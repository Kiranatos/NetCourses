package net.kiranatos.epam.summer20.p2.old1;

import java.util.Iterator;
import net.kiranatos.epam.summer20.p2.Array;

public class ArrayImplOLD implements Array {
    
    private int sizeOfInnerArray = 5;
    private Object[] innerArray = new Object[sizeOfInnerArray];    
    private int sizeArrayImpl = 0;

    public ArrayImplOLD() {
        sizeOfInnerArray = 10;
    }
    
    public ArrayImplOLD(int memory) {
        sizeOfInnerArray = memory;
    }
    
    public static void printIter(Array abc) {
        Iterator<Object> it = abc.iterator();
        while (it.hasNext()) {
            Object a = it.next();
            System.out.println("\t\t" + a.toString());
        }
    }
    
    public static void main(String[] args) {
        Array abc = new ArrayImplOLD();
//        for (int i = 0; i < 10; i++) {
//            abc.add(i);            
//        }        
//        abc.set(5, 666);
        abc.add(new Object());
        abc.add(new Object());
        abc.add(null);
        abc.add(new Object());
        abc.add(null);
        
        System.out.println(" .get() = " + abc.get(0));
        System.out.println(" .size() = " + abc.size());
        System.out.println(" .get() = " + abc.get(3));
        System.out.println(" .abc = " + abc);
        
        
//        System.out.println(" ====== clear ===== ");
//        Array abc = new ArrayImpl();
//        abc.add(10);
//        abc.add(20);
//        abc.add(30);
//        System.out.println(" size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        abc.clear();
//        System.out.println(" size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        
//        System.out.println(" ====== set ===== ");
//        abc.add("адын");
//        abc.add("два");
//        abc.add("трэ");
//        abc.add("трэ и адын");
//        System.out.println(" size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        abc.set(2, "гдэ я? - ты внутрэ");
//        System.out.println(" SET 2 size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        abc.set(0, "гдэ я? - ты пабэдытелъ");
//        System.out.println(" SET 0 size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        abc.set(6, "гдэ я? - ты в ж");
//        System.out.println(" SET 6 size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        
//        System.out.println(" ====== get ===== ");
//        for (int i = 0; i < abc.size(); i++) {
//            System.out.println("\t\t\t" + abc.get(i));
//        }
//        
//        System.out.println(" ====== indexOf ===== ");
//        System.out.println("два = " + abc.indexOf("два"));
//        String str = "I AM TANK !!!";
//        abc.set(2, str);
//        System.out.println(" toString = " + abc.toString());
//        System.out.println("str = " + abc.indexOf(str));
//        
//        System.out.println(" ====== remove ===== ");
//        abc.remove(0);
//        System.out.println(" size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        abc.remove(2);
//        System.out.println(" size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        abc.remove(abc.size()-1);
//        System.out.println(" size = " + abc.size());
//        System.out.println(" toString = " + abc.toString());
//        printIter(abc);
//        System.out.println(" *************** ");        
//        while(abc.size() > 0) {
//            abc.remove(0);
//            System.out.println(" size = " + abc.size());
//            System.out.println(" toString = " + abc.toString());
//            printIter(abc);
//            
//        }
//        
//        System.out.println("\n *********** CLEAR and Iterator remove ");
//        abc.clear();
//        abc.add("aa");
//        abc.add("bb");
//        abc.add("cc");
//        abc.add(10);
//        abc.add(20);
//        abc.add(30);
//        System.out.println(abc);
//        
//        Iterator<Object> it = abc.iterator();
//        while (it.hasNext()) {
//            Object a = it.next();
//            System.out.println("\t\t" + a.toString());
//        }
//        
//        System.out.println("**************** one element ***********************");
//        abc.clear();
//        abc.add("problem 1?");
//        System.out.println(abc);
        
    }
    
    @Override
    public void clear() { sizeArrayImpl = 0; }
    
    @Override
    public int size() {
        return sizeArrayImpl;
    }
    
    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }
    
    @Override
    public void add(Object element) {  
//        this.set(sizeArrayImpl, element);
        if (sizeArrayImpl < innerArray.length) {
            innerArray[sizeArrayImpl] = element;
            sizeArrayImpl++;
        }
        else {
            Object[] tempArray = new Object[innerArray.length + 10];
            System.arraycopy(innerArray, 0, tempArray, 0, sizeArrayImpl);
            innerArray = tempArray;
            innerArray[sizeArrayImpl] = element;
            sizeArrayImpl++;
        }
    }
    
    @Override
    public void set(int index, Object element) {
        if (index >= sizeArrayImpl) throw new java.util.NoSuchElementException();
        else innerArray[index] = element;
                
//        if (++sizeArrayImpl < innerArray.length) {            
//            for (int i = sizeArrayImpl; i > index; i--) {
//                innerArray[i]=innerArray[i-1];
//            }            
//            innerArray[index] = element;
//        }
//        else {
//            Object[] tempArray = new Object[innerArray.length + 10];
//            tempArray[index] = element;
//            System.arraycopy(innerArray, 0, tempArray, 0, index);            
//            System.arraycopy(innerArray, index, tempArray, index+1, sizeArrayImpl-index);
//            innerArray = tempArray;            
//            sizeArrayImpl++;
//        }
    }
    
    @Override
    public Object get(int index) {
        if (index < sizeArrayImpl) return innerArray[index];
        else throw new java.util.NoSuchElementException();
    }
    
    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < sizeArrayImpl; i++) {
            if (innerArray[i].equals(element)) return i;
        }
        return -1;
    }
    
    @Override
    public void remove(int index) {
        if (index >= sizeArrayImpl) throw new java.util.NoSuchElementException();
        
        if (index == sizeArrayImpl-1) sizeArrayImpl--;
        else {
            for (int i = index; i < sizeArrayImpl; i++) {
                innerArray[i]=innerArray[i+1];
            }
            sizeArrayImpl--;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (sizeArrayImpl > 0) {
            for (int i = 0; i < sizeArrayImpl; i++) {
                if (null != innerArray[i])
                    str.append(innerArray[i].toString());
                else str.append("null");
                str.append(", ");
            }
            str.deleteCharAt(str.length()-1)
                    .deleteCharAt(str.length()-1);
        }
        str.append("]");
        return str.toString();
    }
    
    private class IteratorImpl implements Iterator<Object> {
        private int iteratorIndex = 0;
        @Override
        public boolean hasNext() {
            return iteratorIndex < sizeArrayImpl;
        }

        @Override
        public Object next() {
            if (this.hasNext()) return innerArray[iteratorIndex++];
            else throw new java.util.NoSuchElementException();
        }
    }
}
