package net.kiranatos.epam.summer20.p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TEST2_ListImpl implements List {


    private Node head;

    private int nElements;

    public TEST2_ListImpl(){
        nElements = 0;
    }

    static class Node{

        Node(){

        }
        Node(Object data){
            this.data = data;
            next = null;
        }
        Node(Object data, Node n){
            this.data = data;
            next = n;
        }
        Object data;
        Node next;

    }

    @Override
    public void clear() {
        for (Node current = head; current!=null;) {
            Node newNode = current.next;
            current.data = null;
            current.next = null;
            current = newNode;
        }


       head = null;
        nElements = 0;

    }


    @Override
    public int size() {
       return nElements;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        Node current = head;

        @Override
        public boolean hasNext() {

            return current != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                Object dat = current.data;
                current = current.next;
                return dat;
            }
           throw new NoSuchElementException();
        }

    }

    @Override
    public void addFirst(Object element) {
        if (element == null) {
            return;
        }
        if (head == null) {
            head = new Node(element);
            nElements++;
            return;
        }
        Node tmp = new Node(element,head);
        head = tmp;
        nElements++;
    }

    @Override
    public void addLast(Object element) {

        if (head == null) {
            head = new Node(element);
            nElements++;
        }else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            Node newNode = new Node(element,null);
            current.next = newNode;
            nElements++;
        }
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            return;
        }
        Node tmp = head;
        head = head.next;
        tmp = null ;
        nElements--;
    }

    @Override
    public void removeLast() {
        if (head == null) {
            return;
        }

        Node current =head;
        while (current.next.next!=null){
            current = current.next;
        }
        current.next= null;
        nElements--;
    }

    @Override
    public Object getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public Object getLast() {
        if (head == null) {
            return null;
        }
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Object search(Object element) {

        Node current = head;
        while (current.next!=null){
            if(current.next.data == null){
                if (element==null) {
                    return null;
                }
            }
            if (element.equals(current.next.data)) {
                return element;
            }
            current = current.next;
        }

        return null;
    }

    
    @Override
    public String toString() {
        if (nElements==0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node current = head;

        while (current!=null){

           if (current.next== null) {
               sb.append(current.data);
               sb.append(']');
               break;
           }


           sb.append(current.data);

           sb.append(',').append(' ');
           current = current.next;
       }

        return sb.toString();


    }

    public static void main(String[] args) {
        List t = new TEST2_ListImpl();
        t.addFirst("red");
        t.addFirst(null);
        t.addFirst("blue");
        t.addFirst(null);
        t.addFirst("blue");
        
        System.out.println(t.size());
        System.out.println(t.remove(null));
        System.out.println(t.size());
    }
    
    public boolean remove(Object element) {

        if (head == null) {
            return false;
        }

        Node current = head;

        while (current!=null){
            if(current.data == null){
                if (element == null) {
                    current = current.next;
                    nElements--;
                    return true;
                }else{
                    continue;
                }

            }
            if (current.data.equals(element)) {

                current = current.next;

                nElements--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}