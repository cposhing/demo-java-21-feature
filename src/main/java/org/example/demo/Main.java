package org.example.demo;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //sequencedCollectionTest();
        //recordPatternsFeature();

        //3. Pattern Matching for switch
    }

    static String isDealDownBeforeJava21(Status status) {

        var result = (String) null;

        switch (status) {
            case PENDING, CANCELLED, FAILED:
                result = "有内鬼，交易未完成";
                break;
            default:
                result = "交易已完成";
        }

        return result;
    }

    static boolean isDealDown(Status status) {
        return switch (status) {
            case PENDING, CANCELLED, FAILED -> false;
            case COMPLETE -> true;
        };
    }


    private static void recordPatternsFeature() {

        //2. Record Patterns

        var customers = getObject();
        // java 17
        if (customers instanceof Customers c) {
            System.out.println("c.getName() = " + c.getName());
        }

        // java 21
        var order = getOrder();
        if (order instanceof Order(String name, Double price)) {
            System.out.println("name = " + name);
            System.out.println("price = " + price);
        }
    }

    private static Object getOrder() {
        return new Order("1", 1.2D);
    }

    private static Object getObject() {
        return new Customers("John");
    }


    private static void sequencedCollectionTest() {
        //1. Sequenced Collections
        var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //System.out.println("list.getFirst() = " + list.getFirst());
        //System.out.println("list.getLast() = " + list.getLast());

        var treeSet = new TreeSet<String>();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");
        treeSet.add("d");

//        System.out.println(treeSet.stream().iterator().next());
//        System.out.println(treeSet.stream().findFirst());

//        System.out.println(treeSet.getFirst());
        System.out.println(treeSet.getLast());
    }
}


enum Status {
    PENDING,
    COMPLETE,
    CANCELLED,
    FAILED,
}

record Order(String number, Double price) {
}

class Customers {
    private String name;

    public Customers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}







