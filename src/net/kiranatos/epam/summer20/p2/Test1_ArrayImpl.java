package net.kiranatos.epam.summer20.p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test1_ArrayImpl implements Array {

    private Object [] arr;
    private int nElements;


    public Test1_ArrayImpl(int max){
     arr = new Object[max];
     nElements  = 0;
    }

    public Test1_ArrayImpl(){

    }


 @Override
    public void clear() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;

        }
        nElements = 0;
    }

 @Override
    public int size() {
        return nElements;
    }
 
 @Override
    public Iterator<Object> iterator() {
     return new IteratorImpl();
    }
 
 private class IteratorImpl implements Iterator<Object> {

     int index;

        @Override
        public boolean hasNext() {

           return index<nElements;
        }

        @Override
        public Object next() {

            if(this.hasNext()) {
                return arr[index++];
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }
 
 @Override
    public void add(Object element) {
        if (arr==null) {
            arr = new Object[2];
            arr[0] = element;
            nElements++;
            return;
        }
        if (nElements<arr.length) {
            set(nElements,element);
            nElements++;
        }else {
            int size = (nElements * 3) / 2 + 1;
            Object[] nArr = new Object[size];
            for (int i = 0; i < size(); i++) {
                nArr[i] = arr[i];
            }
            arr = nArr;
            set(nElements, element);
            nElements++;
        }
    }

 @Override
    public void set(int index, Object element) {
        if(index<arr.length){
        Iterator iterator = iterator();

        int i = 0;
        while (iterator.hasNext()&&i<index){
            iterator.next();
            i++;
        }

        arr[index] = element;
        }
    }

 @Override
    public Object get(int index) {
        if (index<size()) {
            Iterator iterator = iterator();

            int i = 0;
            while (iterator.hasNext()&&i<index){
                iterator.next();
                i++;
            }

            return arr[index];
        }else{
            return null;
        }
    }

 @Override
    public int indexOf(Object element) {

        int i = 0;
        while (i<nElements){
            if (element==null) {
                if (arr[i] == null) {
                    return i;
                }else{
                    i++;
                    continue;
                }
            }
            if (element.equals(arr[i])) {
               return i;
            }else{
                i++;
            }

        }
        return -1;

    }


    @Override
    public void remove(int index) {

     if (index<size()) {
            Object [] nArr = new Object[size()-1];

            for (int i = 0; i < index; i++) {
                nArr[i] = arr[i];
            }


            for (int i = index; i < size()-1; i++) {
                nArr[i] = arr[i+1];
            }
            arr = nArr;
            nElements--;
        }
    }

    @Override
    public String toString() {

     Iterator it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            Object object = it.next();
            sb.append(object);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    public static void main(String[] args) {
        System.out.println("");
Array tt = new Test1_ArrayImpl();
tt.add("aa");
tt.add("aa");
tt.add("aa");
        System.out.println(tt);




        }

}