package net.kiranatos.epam.summer20.p2.old1;

import java.util.Iterator;
import net.kiranatos.epam.summer20.p2.Queue;

public class QueueImplOLD implements Queue {
    private int sizeQueue = 0;
    private Node ghostNode = new Node();
    
    public QueueImplOLD() {
        ghostNode.next = ghostNode;
    }
    
    public static void printIter(Queue abc) {
        System.out.print(" ITER: ");
        Iterator<Object> it = abc.iterator();
        while (it.hasNext()) {
            Object a = it.next();
            System.out.print(" ||| " + a.toString());
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Queue kill = new QueueImplOLD();
        kill.enqueue(null);
        kill.enqueue(new Object());        
        kill.enqueue(null);
        kill.enqueue(new Object());
        kill.enqueue(null);
        
        System.out.println(" .top() = " + kill.top());        
        System.out.println(" .size() = " + kill.size());        
        System.out.println(" .kill = " + kill);
        
//        Queue tiger = new QueueImpl();
//        tiger.enqueue("ichi");
//        tiger.enqueue("ni");
//        tiger.enqueue("san");
//        tiger.enqueue("yon");
//        tiger.enqueue("go");
//        tiger.enqueue("roku");
//        tiger.enqueue("nana");
//        System.out.println(" size = " + tiger.size());
//        System.out.println(" top() = " + tiger.top());
//        printIter(tiger);
//        System.out.println(tiger);
//        
//        tiger.clear();
//        System.out.println(" size = " + tiger.size());
////        System.out.println(" top() = " + tiger.top());
//        printIter(tiger);
//        System.out.println(tiger);
//        
//        tiger.enqueue("hachi");
//        System.out.println(" size = " + tiger.size());
//        System.out.println(" top() = " + tiger.top());
//        printIter(tiger);
//        System.out.println(tiger);
//        
//        System.out.println("*********** Removes the head. dequeue() ************");
//        System.out.println(" .dequeue() = " + tiger.dequeue());
//        System.out.println(" size = " + tiger.size());
////        System.out.println(" top() = " + tiger.top());
//        printIter(tiger);
//        System.out.println(tiger);
//        
//        tiger.enqueue("kuu");
//        tiger.enqueue("juu");
//        tiger.enqueue("juu-ichi");
//        tiger.enqueue("juu-ni");
//        tiger.enqueue("juu-san");
//        tiger.enqueue("juu-yon");
//        
//        System.out.println(" .dequeue() = " + tiger.dequeue());
//        System.out.println(" size = " + tiger.size());
//        System.out.println(" top() = " + tiger.top());
//        printIter(tiger);
//        System.out.println(tiger);
//        
//        System.out.println(" .dequeue() = " + tiger.dequeue());
//        System.out.println(" size = " + tiger.size());
//        System.out.println(" top() = " + tiger.top());
//        printIter(tiger);
//        System.out.println(tiger);
//        
//        System.out.println("\n\n ************** ITERATOR REMOVE ");
//        tiger.enqueue("yon-juu-nana");
//        tiger.enqueue("hyaku");
//        System.out.println(tiger);
//        Iterator<Object> it = tiger.iterator();
//        while (it.hasNext()) {
//            Object a = it.next();
//            if ("yon-juu-nana".equals(a)) it.remove();
//            if ("hyaku".equals(a)) it.remove();
//            if ("juu-ichi".equals(a)) it.remove();
//            System.out.print(" \\ " + a.toString());
//        }
//        System.out.println("\n" + tiger);
    }

    @Override
    public void clear() {
        ghostNode.next = ghostNode;
        sizeQueue = 0;
    }

    @Override
    public int size() {
        return sizeQueue;
    }

    /**
     * Appends the specified element to the end.
     * 
     * @param element 
     */
    @Override
    public void enqueue(Object element) {
        Node temp = new Node();
        temp.obj = element;
        temp.next = ghostNode;
        getLast().next = temp;  
        sizeQueue++;
    }
    
    private Node getLast(){
        if (sizeQueue > 0) {            
            Node walker = ghostNode.next;
            Node last = walker;
            while (!walker.equals(ghostNode)){
                last = walker;
                walker = walker.next;
            }            
            return last;
        }
        else return ghostNode;
    }

    /**
     * Removes the head.
     * 
     * @return element
     */
    @Override
    public Object dequeue() {
        Object delete = top();
        ghostNode.next = ghostNode.next.next;
        sizeQueue--;
        return delete;
    }

    /**
     * Returns the head.
     * 
     * @return 
     */
    @Override
    public Object top() {
        if (sizeQueue > 0) return ghostNode.next.obj;
        else throw new java.util.NoSuchElementException();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        
        if (sizeQueue > 0) {            
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
    
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }
    
    private static class Node{
        Object obj;
        Node next;
    }
    
    private class IteratorImpl implements Iterator<Object> {
        Node current = ghostNode.next;
        Node removableEl;
        
        @Override
        public boolean hasNext() {
            if (sizeQueue > 0) return !current.equals(ghostNode);
            else return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                removableEl = current;
                current = current.next;
                return removableEl.obj;
            }
            else throw new java.util.NoSuchElementException();
        }

        @Override
        public void remove() {
            if (sizeQueue > 0) {            
                current = removableEl.next;
                getPrevious(removableEl).next = removableEl.next;
                sizeQueue--; 
            }
            else throw new java.util.NoSuchElementException();
        }
        
        private Node getPrevious(Node removable){
            Node previous = ghostNode;
            Node walker = ghostNode.next;
            while (!walker.equals(ghostNode)){                
                if (walker.equals(removable)) {
                    return previous;
                }
                previous = walker;
                walker = walker.next;                
            }
            return ghostNode;
        }
    }
}

/*
3.2. Create QueueImpl class that implements the Queue interface.
In case the three elements A, B, C were added to the container using the ‘enqueue’ method, then:
1)  toString method should return the following string "[A, B, C]”
2)  the elements iteration order should be: A B C
3.3 In the QueueImpl class, create ‘main’ method where you should demonstrate the functionality of:
1)  all the methods from the Queue interface (including those inherited from Container and Interable);
2)  all the methods of the Iterator interface (hasNext/next/remove).
*/