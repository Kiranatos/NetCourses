package net.kiranatos.epam.summer20.p2.old2;

import java.util.Iterator;
import net.kiranatos.epam.summer20.p2.Stack;

public class StackImplOLD implements Stack {
    private int sizeStack = 0;
    private Node ghostNode = new Node();
    
    public StackImplOLD() { 
        this.clear();
    }
            
    public static void main(String[] args) {        
        StackImplOLD kill = new StackImplOLD();
        System.out.println(kill.pop());
        
        
        kill.push("A");
        kill.push("B");        
        kill.push("C");
        kill.push(null);
//        System.out.println(kill);
//        StackImplOLD.printIter(kill);
        

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
     * @return 
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
        else throw new java.util.NoSuchElementException();
    }

    /**
     * Returns the top element.
     * 
     * @return 
     */
    @Override
    public Object top() {
        if (sizeStack > 0) return ghostNode.under.obj;
        else throw new java.util.NoSuchElementException();
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