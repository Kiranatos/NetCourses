package net.kiranatos.epam.summer20.p2.old1;

import java.util.Iterator;
import net.kiranatos.epam.summer20.p2.Stack;

public class StackImplOLD implements Stack {
    private int sizeStack = 0;
    private Node ghostNode = new Node();
    
    public StackImplOLD() { 
        ghostNode.top = ghostNode;
        ghostNode.under = ghostNode;
    }
    
    public static void printIter(Stack abc) {
        System.out.print(" ITER: ");
        Iterator<Object> it = abc.iterator();
        while (it.hasNext()) {
            Object a = it.next();
            if (a!=null) System.out.print(" ||| " + a.toString());
            else System.out.print(" ||| NULL");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Stack kill = new StackImplOLD();
        kill.push(null);
        kill.push(new Object());        
        kill.push(null);
        kill.push(new Object());
        kill.push(null);
        
        System.out.println(" .top() = " + kill.top());        
        System.out.println(" .size() = " + kill.size());        
        System.out.println(" .kill = " + kill);
        
        
        Stack manga = new StackImplOLD();
        manga.push("Berserk");
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        
        manga.push("Dorohedoro");
        manga.push("Overlord");
        manga.push(null);
        manga.push("Blame!");
        manga.push("Uzumaki");
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        
        manga.clear();
        System.out.println(manga.size() + " items, top = exception");
        System.out.println(manga);
        printIter(manga);
//        System.out.println(" 0 item = " + manga.top());

        System.out.println("\n****** Removes and returns the top element. .pop()");
        manga.push("Wanko no Osewa");
        manga.push("Akira");
        manga.push("Alien Hunter Shia");
        manga.push("Amaetagari");
        manga.push("Rinkan Glamorous");
        manga.push("Saimin Seishidou");
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        System.out.println(" pop = " + manga.pop());
        
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        System.out.println(" pop = " + manga.pop());
        
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        System.out.println(" pop = " + manga.pop());
        
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        System.out.println(" pop = " + manga.pop());
        
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        System.out.println(" pop = " + manga.pop());
        
        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
        System.out.println(" pop = " + manga.pop());
        
//        System.out.println(manga.size() + " items, top = " + manga.top());
        System.out.println(manga);
        printIter(manga);
//        System.out.println(" pop = " + manga.pop());

        System.out.println("**************** iter delete **********");
        manga.push("Gleipnir");
        manga.push("Hitozuma Life");
        manga.push("Hitozuma Mire");
        manga.push("Homunculus");
        manga.push("Nana to Kaoru");
        manga.push("Natural Another One");
        manga.push("Hankouki");
        Iterator<Object> it = manga.iterator();
        while (it.hasNext()) {
            Object a = it.next();
            if ("Gleipnir".equals(a)) it.remove();
            if ("Homunculus".equals(a)) it.remove();
            if ("Hankouki".equals(a)) it.remove();
            System.out.print(" ||| " + a.toString());
        }
        System.out.println("\n" + manga);
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
        
        //getLast(ghostNode).top = temp;  
        sizeStack++;        
    }
    
//    private Node getLast(Node currentUpper){
//        if (sizeStack > 0) {            
//            Node walker = ghostNode.top;
//            Node last = walker;
//            while (!walker.equals(currentUpper)){
//                last = walker;
//                walker = walker.top;
//            }            
//            return last;
//        }
//        else return ghostNode;
//    }

    /**
     * Removes and returns the top element.
     * 
     * @return 
     */
    @Override
    public Object pop() {        
        Object removable = ghostNode.under.obj;         
        ghostNode.under.under.top = ghostNode;
        ghostNode.under = ghostNode.under.under;
        sizeStack--;
        return removable;        
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

/*
4.3. Create StackImpl class that implements the Stack interface.
In case the three elements  A, B, C were added to the container using ‘push’ method , then:
1)   toString method should return the following string "[A, B, C]”
3)  the elements iteration order should be: C B A
4.3. In the StackImpl class, create ‘main’ method where you should demonstrate the functionality of:
1)  all the methods from the Stack interface (including those inherited from Container and Interable);
2)  all the methods of the Iterator interface (hasNext/next/remove).
*/