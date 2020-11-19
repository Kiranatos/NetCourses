package net.kiranatos.epam.summer20.p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test4_StackImpl implements Stack {

    private Node head;
    private int nElements;

    public Test4_StackImpl(){
        nElements=0;
    }

    static class Node{
        private Object data;
        private Node next;
        Node(){

        }
        Node(Object data){
            this.data = data;
        }

    }

    @Override
    public void clear() {
        head =null;
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
            return current!= null;
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
    public void push(Object element) {
        if (head == null) {
            head = new Node(element);
            return;
        }
        Node node = new Node(element);
        node.next = head;
        head  = node;
        nElements++;
    }

    @Override
    public Object pop() {
        if (head == null) {
            return null;
        }

        Node tmp = head;

        head = tmp.next;

        nElements--;

        return tmp.data;
    }

    @Override
    public Object top() {
        return head.data;
    }

    @Override
    public String toString() {
        if (nElements==0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node current = head;
        ArrayImpl array = new ArrayImpl();

        while (current!=null){
           array.add(current.data);
           current = current.next;
        }

        int i = array.size();

        while(i>=0){
            Object object  = array.get(i-1);
            sb.append(object);
            if (i==1) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
            i--;
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);
    }

}