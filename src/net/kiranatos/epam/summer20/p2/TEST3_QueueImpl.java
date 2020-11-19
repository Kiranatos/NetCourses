package net.kiranatos.epam.summer20.p2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class TEST3_QueueImpl implements Queue {


    private Node head;
    private Node tail;
    private int nItems;

    static class Node{
        private Object data;
        private Node next;
        Node(){
        }
        Node(Object data){
            this.data = data;
        }

    }


    public TEST3_QueueImpl() {

        nItems =0;
    }


    @Override
    public void clear() {

        head = null;
        tail = null;
        nItems = 0;

    }

    @Override
    public int size() {
        return nItems;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

      Node current = head;

        @Override
        public boolean hasNext() {
            if (current == tail) {
                return false;
            }
            return current!=null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                Object dat = current.data;
                current = current.next;
                return dat;
            }
          else {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public void enqueue(Object element) {
         Node tmp = new Node();
         tmp.data = element;
         tmp.next = null;
        if (head == null) {
            head = tmp;
            nItems++;
            return;
        }

        if (head.next == null) {
            tail = tmp;
            head.next = tail;
            nItems++;
            return;
        }

        tail.next = tmp;

        nItems++;
        return;
    }

    @Override
    public Object dequeue() {

        if (head == null) {
            return null;
        }

        Node tmp = new Node();
        tmp = head;
        head = tmp.next;
        nItems--;

        return  tmp.data;
    }

    @Override
    public Object top() {
        return head.data;
    }

    @Override
    public String toString() {

        if (nItems==0)
            return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        
        Node current = head; 
        
        while(current!=null){
            if (current.next == null) {
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

     QueueImpl queue = new QueueImpl();
     queue.enqueue("A");
     queue.enqueue("B");
     queue.enqueue("C");
     queue.dequeue();
     System.out.println(queue);
        System.out.println(queue.top());
    }

}
