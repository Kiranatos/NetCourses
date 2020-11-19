package net.kiranatos.epam.summer20.p2.old2;

import java.util.Iterator;
import net.kiranatos.epam.summer20.p2.Queue;

public class QueueImplOLD implements Queue {
    private int sizeQueue;
    private Node ghostNode = new Node();
    
    public QueueImplOLD() {
        this.clear();
    }
        
    public static void main(String[] args) {
        Queue kill = new QueueImplOLD();   
        kill.clear();
        
        kill.enqueue(null);        
//        System.out.println(" - where my null? " + kill.dequeue());
        
        kill.enqueue("string One");
        kill.enqueue("string Two");
        
        System.out.println(kill);
        System.out.println(kill.dequeue());
        System.out.println(kill);
        System.out.println(kill.dequeue());
        System.out.println(kill);
        System.out.println(kill.dequeue());
        System.out.println(kill);
//        System.out.println(kill.dequeue());
//        System.out.println(kill);
        
        //kill.clear();
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
        if (sizeQueue > 0) {
            Object delete = top();
            ghostNode.next = ghostNode.next.next;
            sizeQueue--;
            return delete;
        }
        else throw new java.util.NoSuchElementException();
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