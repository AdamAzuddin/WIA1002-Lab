package com.mycompany.t2;

import java.util.*;

class Container<T> {

    private T t;

    public Container() {

    }

    public void add(T a) {
        this.t = a;
    }

    public T retrieve() {
        return this.t;
    }
}

public class T2 {

    public static void main(String[] args) {
        Q8();
    }

    public static void Q1() {
        Container c1 = new Container();
        Container c2 = new Container();
        c1.add(50);
        c2.add("Java");

        System.out.println(c1.retrieve());
        System.out.println(c2.retrieve());
    }

    public static void Q8() {
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();
        displayList(numOfCars, milesPerHour);
    }

    public static void displayList(List<?> list1, List<?> list2) {
        System.out.println("List 1");
        for ( Object elem : list1 ) {
            System.out.print(elem + " ");
        }
        System.out.println("List 2");
        for ( Object elem : list2 ) {
            System.out.print(elem + " ");
        }

    }
}
