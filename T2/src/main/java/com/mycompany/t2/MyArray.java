package com.mycompany.t2;

public class MyArray {
    
    public static  <T> void listAll(T[] list){
        for (T t : list) {
            System.out.print(t+" ");
        }
    }
    public static void main(String[] args) {
        Integer[] intArr = {1,2,3,4,5};
        String[] strArr = {"Jane","Tom","Bob"};
        Character[] charArr = {'a','b','c'};
        listAll(intArr);
        System.out.println();
        listAll(strArr);
        System.out.println();
        listAll(charArr);
    }
}
