package net.kiranatos.epam.summer20.p2.old2;

import java.util.Iterator;
import net.kiranatos.epam.summer20.p2.List;

public class ListImplOLD implements List {
    private Node ghostNode = new Node();
    private int sizeList;
    
    public ListImplOLD() {        
        this.clear();
    }
    
    public static void main(String[] args) {
        List kill = new ListImplOLD();
        kill.addFirst(null);
        kill.addFirst("string One");
        kill.addFirst("string Two");
        
        kill.clear();        
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