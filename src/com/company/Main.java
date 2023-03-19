package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        OneWayLinkedList<String> list = new OneWayLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.indexOf("c"));
        Iterator<String> iterator = list.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(list.removeAt(1));
        System.out.println(list.get(1));

        OneWayLinkedList<Integer> list1 = new OneWayLinkedList<>();
        OneWayLinkedList<Integer> list2 = new OneWayLinkedList<>();
        OneWayLinkedList<Integer> result = new OneWayLinkedList<>();
//        System.out.println(list.isEmpty());
        list1.add(1);
        list1.add(3);
        list1.add(5);

        list2.add(2);
        list2.add(4);
        list2.add(6);

        result = Merger.merge(list1, list2);
        for (Integer x: result
             ) {
            System.out.println(x);
        }

    }
}
