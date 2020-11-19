package net.kiranatos.epam.summer20.p2;

import java.util.Iterator;

public class StackImpl implements Stack {
    private int sizeStack = 0;
    private Node ghostNode = new Node();
    
    public StackImpl() { 
        this.clear();
    }
            
    /*
    StackImplTest.shouldPopFromTheTail_IfEmpty FAILED
    java.util.NoSuchElementException

tackImplTest.shouldClearStack FAILED
    java.util.NoSuchElementException
    */
    
    public static void main(String[] args) {        
        StackImpl aa = new StackImpl();
                
        aa.push("A");
        aa.push("B");        
        aa.push("C");
        aa.push(null);
        System.out.println(aa);
        
        aa.clear();
        System.out.println(aa.pop());
        System.out.println(aa.top());
        
        System.out.println(aa);
        
    }

    @Override
    public void clear() { 
        ghostNode.top = ghostNode;
        ghostNode.under = ghostNode;        
        sizeStack = 0;
    }

    @Override
    public int size() {
        return sizeStack;
    }

    /**
     * Pushes the specified element onto the top.
     * 
     * @param element 
     */
    @Override
    public void push(Object element) {
        Node temp = new Node();
        temp.obj = element;
        temp.top = ghostNode;
        temp.under = ghostNode.under;
        
        ghostNode.under.top = temp;
        ghostNode.under = temp;
                
        sizeStack++;        
    }

    /**
     * Removes and returns the top element.
     * 
     * @return element
     */
    @Override
    public Object pop() {      
        if (sizeStack > 0) {
            Object removable = ghostNode.under.obj;         
            ghostNode.under.under.top = ghostNode;
            ghostNode.under = ghostNode.under.under;
            sizeStack--;
            return removable;   
        }
        else return null;
    }

    /**
     * Returns the top element.
     * 
     * @return 
     */
    @Override
    public Object top() {
        if (sizeStack > 0) return ghostNode.under.obj;
        else return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        
        if (sizeStack > 0) {            
            Node walker = ghostNode.top;
            while (!walker.equals(ghostNode)){
                if (null != walker.obj)
                    str.append(walker.obj.toString());
                else str.append("null");
                str.append(", ");
                
                walker = walker.top;
            }
            str.deleteCharAt(str.length()-1)
                    .deleteCharAt(str.length()-1);
        }
        
        return str.append("]").toString();
    }
    
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        Node current = ghostNode.under;
        Node removableEl;

        @Override
        public boolean hasNext() {
            if (sizeStack > 0) return !current.equals(ghostNode);
            else return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                removableEl = current;
                current = current.under;
                return removableEl.obj;
            }
            else throw new java.util.NoSuchElementException();
        }
        
        @Override
        public void remove() {
            if (sizeStack > 0) {            
                current = removableEl.under;
                
                removableEl.top.under = removableEl.under;
                removableEl.under.top = removableEl.top;
                sizeStack--; 
            }
            else throw new java.util.NoSuchElementException();
        }
    }
    
    private static class Node{
        Object obj;
        Node top;
        Node under;
    }
}