package com.company;

import java.util.Iterator;

public class Merger {
    public static OneWayLinkedList<Integer> merge(
            OneWayLinkedList<Integer> list1,
            OneWayLinkedList<Integer> list2) {

        OneWayLinkedList<Integer> result = new OneWayLinkedList<>();

        while (list1.head != null && list2.head != null) {
            if (list1.head.getValue() < list2.head.getValue()) {
                result.add(list1.head.getValue());
                list1.head = list1.head.getNext();
            } else {
                result.add(list2.head.getValue());
                list2.head = list2.head.getNext();
            }
        }
        if (list1.head != null && list2.head == null) {
            while (list1.head != null) {
                result.add(list1.head.getValue());
                list1.head = list1.head.getNext();
            }
        } else if (list1.head == null && list2.head == null) {
            return result;
        } else {
            while (list2.head != null) {
                result.add(list2.head.getValue());
                list2.head = list2.head.getNext();
            }
        }
        return result;
    }
}
