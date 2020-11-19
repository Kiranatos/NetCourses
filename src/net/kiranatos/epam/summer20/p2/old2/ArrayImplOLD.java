package net.kiranatos.epam.summer20.p2.old2;

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
        
    public static void main(String[] args) {
        Array abc = new ArrayImplOLD();
        abc.add(10);
        abc.add(20);
        abc.add(30);
        
        abc.add(new Object());
        abc.add(new Object());
        abc.add(null);
        abc.add(new Object());
        abc.add(null);
        
        abc.clear();
    }
    
    @Override
    public void clear() { 
        sizeArrayImpl = 0; 
    }
    
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
