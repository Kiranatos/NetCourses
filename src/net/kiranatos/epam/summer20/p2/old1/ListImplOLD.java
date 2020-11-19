package net.kiranatos.epam.summer20.p2.old1;

import java.util.Iterator;
import net.kiranatos.epam.summer20.p2.List;

public class ListImplOLD implements List {
    private Node ghostNode = new Node();
    private int sizeList = 0;
    
    public ListImplOLD() {
        ghostNode.next = ghostNode;
        ghostNode.prev = ghostNode;
    }
    
    
    public static void printIter(List abc) {
        Iterator<Object> it = abc.iterator();
        while (it.hasNext()) {
            Object a = it.next();
            System.out.println("\t\t" + a.toString());
        }
    }
    
    public static void main(String[] args) {
        List kill = new ListImplOLD();
        kill.addFirst(null);
        kill.addFirst(new Object());        
        kill.addFirst(null);
        kill.addFirst(new Object());
        kill.addFirst(null);
        
        System.out.println(" .get() = " + kill.getLast());
        System.out.println(" .get() = " + kill.getLast());
        System.out.println(" .size() = " + kill.size());        
        System.out.println(" .kill = " + kill);
        
//        List kill = new ListImpl();
//        kill.addFirst("q");
//        kill.addFirst("w");
//        kill.addFirst("e");
//        kill.addFirst("r");
//        kill.addFirst("t");
//        
//        kill.addLast("9");
//        kill.addLast("8");
//        kill.addLast("7");
//        
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        
//        System.out.println(" ********** clear ********** ");
//        kill.clear();
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        
//        System.out.println(" ********** create new: ********** ");
//        
//        kill.addFirst(10);
//        kill.addFirst(20);
//        kill.addFirst(30);
//        kill.addFirst(40);
//        kill.addFirst(50);
//        kill.addFirst(60);
//        kill.addLast("aa");
//        kill.addLast("bb");
//        kill.addLast("cc");
//        kill.addLast("dd");
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        
//        System.out.println(" ********** removeFirst: ********** ");
//        kill.removeFirst();
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        kill.removeFirst();
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        
//        System.out.println(" ********** removeLast: ********** ");
//        kill.removeLast();
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        kill.removeLast();
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        
//        System.out.println(" ********** getFirst: ********** ");
//        System.out.println(kill.getFirst());
//        System.out.println(" ********** getLast: ********** ");
//        System.out.println(kill.getLast());
//        System.out.println(" ********** search: ********** ");
//        System.out.println(kill.search("aa"));
//        System.out.println(" ********** remove: ********** ");
//        System.out.println(kill.remove(20));
//        System.out.println(" size = " + kill.size());
//        System.out.println(kill);
//        printIter(kill);
//        
//        System.out.println(" ********** iterator remove: ********** ");
//        Iterator<Object> it = kill.iterator();
//        while (it.hasNext()) {
//            Object a = it.next();
//            System.out.println("\t" + a.toString());
//            if (a.equals(10)) it.remove();
//        }
//        System.out.println("\n\t size = " + kill.size());
//        System.out.println(kill);
//        
//        System.out.println("**************** one element ***********************");
//        kill.clear();
//        kill.addFirst("problem 1?");
//        System.out.println(kill);
//        kill.clear();
//        kill.addLast("problem 2?");
//        System.out.println(kill);
        
    }   
    
    /**
     * Burn all information
     */
    @Override
    public void clear() {
        ghostNode.next = ghostNode;
        ghostNode.prev = ghostNode;
        sizeList = 0;        
    }

    /**    
     * Returns the number of elements.
     * 
     * @return size of list
     */
    @Override
    public int size() {
        return sizeList;
    }

    /**
     * Returns an iterator over elements.
     * 
     * @return iterator
     */
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void addFirst(Object element) {
        Node node = new Node();
        node.obj = element;
        node.next = ghostNode.next;
        node.prev = ghostNode;
        ghostNode.next.prev = node;
        ghostNode.next = node;
        sizeList++;
    }

    @Override
    public void addLast(Object element) {
        Node node = new Node();
        node.obj = element;
        node.prev = ghostNode.prev;
        node.next = ghostNode;
        ghostNode.prev.next = node;
        ghostNode.prev = node;
        sizeList++;
    }

    @Override
    public void removeFirst() {
        ghostNode.next = ghostNode.next.next;
        ghostNode.next.prev = ghostNode;
        sizeList--;
    }

    @Override
    public void removeLast() {
        ghostNode.prev = ghostNode.prev.prev;
        ghostNode.prev.next = ghostNode;
        sizeList--;        
    }

    @Override
    public Object getFirst() {
        return ghostNode.next.obj;
    }

    @Override
    public Object getLast() {
        return ghostNode.prev.obj;
    }

    @Override
    public Object search(Object element) {
        Node walker = ghostNode.next;
        while (!element.equals(walker.obj)){
            walker = walker.next;
            if (walker.equals(ghostNode)) return null;
        }
        return walker.obj;
    }

    @Override
    public boolean remove(Object element) {
        Node walker = ghostNode.next;
        while (!element.equals(walker.obj)){
            walker = walker.next;
            if (walker.equals(ghostNode)) return false;
        }
        walker.prev.next = walker.next;
        walker.next.prev = walker.prev;
        sizeList--;
        return true;
    }

    @Override
    public String toString() {        
        StringBuilder str = new StringBuilder("[");
        
        if (sizeList > 0) {
            Node walker = ghostNode.next;
            while (!walker.equals(ghostNode)){
                if (null != walker.obj)
                    str.append(walker.obj.toString());
                else str.append("null");
                str.append(", ");
                walker = walker.next;
            }
            str.deleteCharAt(str.length()-1)
                    .deleteCharAt(str.length()-1);
        }
        
        return str.append("]").toString();        
    }
    
    private class IteratorImpl implements Iterator<Object> {
        Node current = ghostNode.next;
        @Override
        public boolean hasNext() {
            if (sizeList > 0) return !current.equals(ghostNode);
            else return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                current = current.next;
                return current.prev.obj;               
            } else throw new java.util.NoSuchElementException();
        }

        @Override
        public void remove() {
            Node del = current.prev;
            del.prev.next = del.next;
            del.next.prev = del.prev;
            sizeList--;            
        }
        
    }
    
    private static class Node {
        Node prev;
        Node next;
        Object obj;     
    }
}


/*
Storage of the objects inside the container should be implemented by using set of nodes - instances of the Node class.
Each node stores an object and a reference to the next node.
Node class should be defined inside the ListImpl class (it should be a static nested class).
The ‘iterator’ method should return an instance of the IteratorImpl class that implements java.util.Iterator<Object> interface.
The IteratorImpl class should be defined inside the ListImpl class (it should be an inner class).
In case the three elements A, B, C were added to the container using the ‘addLast’ method, then:
1)  toString method should return the following string "[A, B, C]”
2)  the elements iteration order should be: A B C
2.3 In the ListImpl class, create ‘main’ method where you should demonstrate the functionality of:
1)  all the methods from the List interface (including those inherited from Container and Iterable);
2)  all the methods of the Iterator interface (hasNext/next/remove).
*/