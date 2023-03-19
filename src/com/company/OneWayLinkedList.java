package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OneWayLinkedList<T> implements IList<T> {

    Element head = null;

    public class Element{

        private T value;
        private Element next;

        Element(T data){
            this.value = data;
            this.next = null;
        }

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
    }

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
        Element newElement = new Element(value);
        if (index == 0) {
            newElement.setNext(head);
            head = newElement;
        }
        else {
            Element previousElement = head;
            Element actElem = head;
            while (index > 0 && actElem != null) {
                index--;
                previousElement = actElem;
                actElem = actElem.getNext();
            }
            if (actElem == null) {
                throw new NoSuchElementException();
            } else {
                previousElement.setNext(newElement);
                newElement.setNext(actElem);
            }
        }

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
        if(actElem == null) {
            throw new NoSuchElementException();
        }
        else {
            return actElem.getValue();
        }
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
        if(head == null) throw new NoSuchElementException();
        T result;
        if(index == 0) {
            result = head.getValue();
            head = head.getNext();
            return result;
        }
        Element actElem = head;
        Element previous = head;
        while(index > 0 && actElem.getNext() != null) {
            index--;
            previous = actElem;
            actElem = actElem.getNext();
        }
        if(index != 0) {
            throw new NoSuchElementException();
        }
        result = actElem.getValue();
        previous.setNext(actElem.getNext());
        return result;
    }

    @Override
    public boolean remove(T value) {
            if(head == null) return false;
            if(head.getValue().equals(value)){
                head=head.getNext();
                return true;
            }
            Element actElem = head;
            while(actElem.getNext() != null && !actElem.getNext().getValue().equals(value)) {
                actElem = actElem.getNext();
            }
            if(actElem.getNext() == null) {
                return false;
            }
            actElem.setNext(actElem.getNext().getNext());
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
//            if (actElem == null) return false;
//            return actElem.getNext() != null;
            return actElem != null;
        }

        @Override
        public T next() {
            if (hasNext() == false) throw new NoSuchElementException();
            T currentValue = actElem.getValue();
            actElem = actElem.getNext();
            return currentValue;
        }
    }
}
