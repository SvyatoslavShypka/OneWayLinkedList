package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        OneWayLinkedList<String> list = new OneWayLinkedList<>();
        System.out.println(list.isEmpty());
        list.add("a");

        System.out.println(list.isEmpty());
        list.add("b");
        Iterator<String> iterator = list.iterator();
        System.out.println(iterator);
        System.out.println(iterator.hasNext());
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.indexOf("c"));
/*
        for (String x: list
             ) {
            System.out.println(x);
        }
*/
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

    }
}
