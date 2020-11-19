package net.kiranatos.epam.summer20.p2;

import java.util.Iterator;

public class ListImpl implements List {
    private Node ghostNode = new Node();
    private int sizeList = 0;
    
    public ListImpl() {
        ghostNode.next = ghostNode;
        ghostNode.prev = ghostNode;
    }
    
    public static void main(String[] args) {
        List kill = new ListImpl();
        kill.addFirst("first");
        kill.addFirst("second");
        kill.addFirst("third");
        kill.addFirst(null);
        kill.addFirst(new Object());        
        kill.addFirst(null);
        kill.addFirst(new Object());
        kill.addFirst(null);
        kill.addFirst("ZERO");
        kill.addLast("100");
        kill.addLast("101");
        kill.addLast("102");        
        System.out.println(kill);
        System.out.println(" size = " + kill.size());
        System.out.println(kill.remove(null));
        //System.out.println(kill.getLast());
        System.out.println(" size = " + kill.size());
//        
//        for (int i = 0; i < 20; i++) {
//            kill.removeFirst();
//            kill.removeLast();
//            System.out.println(i + " size = " + kill.size());
            System.out.println(kill);
//            
//        }
//        System.out.println(" search = " + kill.search("108"));
                
//        kill.clear();    
//        kill.removeFirst();
//        kill.removeLast();
//        System.out.println(" size = " + kill.size());
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
        if (sizeList > 0) {
            ghostNode.next.next.prev = ghostNode;
            ghostNode.next = ghostNode.next.next;            
            sizeList--;
        }
    }

    @Override
    public void removeLast() {
        if (sizeList > 0) {
            ghostNode.prev.prev.next = ghostNode;
            ghostNode.prev = ghostNode.prev.prev;
            sizeList--;
        }        
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
        if (element == null) return null;
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
        
        if (element == null){
            while (!walker.equals(ghostNode)) {
                if (walker.obj == null) {
                    walker.prev.next = walker.next;
                    walker.next.prev = walker.prev;                    
                    sizeList--;
                    return true;
                }
                walker = walker.next;
            }
            return false;
        } else {
            while (!element.equals(walker.obj)){
                walker = walker.next;
                if (walker.equals(ghostNode)) return false;
            }
            walker.prev.next = walker.next;
            walker.next.prev = walker.prev;
            sizeList--;
        }
        return true;
    }

    @Override
    public String toString() {        
        StringBuilder strL = new StringBuilder("[");
        
        if (sizeList > 0) {
            Node walkerL = ghostNode.next;
            while (!walkerL.equals(ghostNode)){
                if (null != walkerL.obj)
                    strL.append(walkerL.obj.toString());
                else strL.append("null");
                strL.append(", ");
                walkerL = walkerL.next;
            }
            strL.deleteCharAt(strL.length()-1)
                    .deleteCharAt(strL.length()-1);
        }        
        return strL.append("]").toString();
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