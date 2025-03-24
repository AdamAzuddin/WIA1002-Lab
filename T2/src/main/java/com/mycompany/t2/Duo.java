package com.mycompany.t2;

public class Duo<A,B> {
    A first;
    B second;
    
    public Duo(A a, B b){
        this.first = a;
        this.second = b;
    }
    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo("Hi",2);
        Duo<Double, Double> points = new Duo(1.5,2);
    }
}
