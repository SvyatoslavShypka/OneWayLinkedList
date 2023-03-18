package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OneWayLinkedList<T> implements IList<T> {

    private class Element{

        private T value;
        private Element next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }



        Element(T data){
            this.value = data;
            this.next = null;
        }
    }

    Element head = null;

    @Override
    public void add(T value) {
        Element newElement = new Element(value);
        if (isEmpty()) {
            head = newElement;
        }
        else {
            Element lastElement = head;
            while (lastElement.getNext() != null) {
                lastElement = lastElement.getNext();
            }
            lastElement.setNext(newElement);
        }
    }

    @Override
    public void addAt(int index, T value) throws NoSuchElementException {
        // TODO
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    @Override
    public T get(int index) throws NoSuchElementException {
        Element actElem = head;
        while(index>0 && actElem != null){
            index--;
            actElem = actElem.getNext();
        }
        return actElem.getValue();
    }

    @Override
    public void set(int index, T value) throws NoSuchElementException {
        Element actElem = head;
        while(index>0 && actElem != null){
            index--;
            actElem = actElem.getNext();
        }
        if(actElem == null) {
            throw new NoSuchElementException();
        }
        else {
            actElem.setValue(value);
        }
    }

    @Override
    public int indexOf(T value) {
        int pos = 0;
        Element actElem = head;
        while(actElem != null) {
            if(actElem.getValue() == value) {
                return pos;
            }
            pos++;
            actElem = actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T removeAt(int index) throws NoSuchElementException {
        // TODO
        T x = (T) new Object();
        return x;
    }

    @Override
    public boolean remove(T value) {
        // TODO
        return true;
    }

    @Override
    public int size() {
        int pos = 0;
        Element actElem = head;
        while(actElem != null)
        {
            pos++;
            actElem = actElem.getNext();
        }
        return pos;
    }

    @Override
    public Iterator<T> iterator() {
        return new OneWayLinkedListIterator();
    }

    private class OneWayLinkedListIterator implements Iterator<T> {

        Element actElem;

        public OneWayLinkedListIterator() {
            actElem = head;
        }

        @Override
        public boolean hasNext() {
            if (actElem == null) return false;
            return this.actElem.getNext() != null;
        }

        @Override
        public T next() {
            T currentValue = (T) actElem.getValue();
            actElem = actElem.getNext();
            return currentValue;
        }
    }
}
