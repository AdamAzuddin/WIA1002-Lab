
import java.util.*;

class MyGeneric<T> {

    private T e;

    public MyGeneric() {
    }

    public MyGeneric(T element) {
        e = element;
    }

    public T getE() {
        return e;
    }

    public void setE(T element) {
        e = element;
    }
}

class CompareMax<T extends Comparable> {

    public T maximum(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }

        return max;
    }
}

class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {

    private T first, second;

    public StorePairGeneric(T a, T b) {
        first = a;
        second = b;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T a, T b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "first = " + first + " second = " + second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StorePairGeneric) {
            StorePairGeneric<?> other = (StorePairGeneric<?>) obj;
            return this.first.equals(other.first);
        }
        return false;
    }

    @Override
    public int compareTo(StorePairGeneric<T> other) {
        return this.first.compareTo(other.first);
    }
}

class Circle<T extends Comparable<T>> implements Comparable<Circle<T>> {

    public T radius;

    public Circle(T r) {
        radius = r;
    }

    @Override
    public int compareTo(Circle<T> obj) {
        return this.radius.compareTo(obj.radius);
    }

    @Override
    public String toString() {
        return "Circle with radius of " + radius;
    }
}

class MinMaxTwoDArray {

    public static <E extends Comparable<E>> E min(E[][] list) {
        E min = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (list[i][j].compareTo(min) < 0) {
                    min = list[i][j];
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (list[i][j].compareTo(max) > 0) {
                    max = list[i][j];
                }
            }
        }
        return max;
    }
}

public class L2 {

    public static void main(String[] args) {
        Q6();
    }

    public static void Q1() {
        MyGeneric<String> stringObj = new MyGeneric<>("Hello world");
        MyGeneric<Integer> integerObj = new MyGeneric<>(69);
        System.out.println(stringObj.getE());
        System.out.println(integerObj.getE());
    }

    public static void Q2() {
        CompareMax<Double> obj1 = new CompareMax<>();
        System.out.println(obj1.maximum(1.23, 9.11, 9.9));
    }

    public static void Q3() {
        StorePairGeneric<Integer> a = new StorePairGeneric<>(6, 4);
        StorePairGeneric<Integer> b = new StorePairGeneric<>(2, 2);
        StorePairGeneric<Integer> c = new StorePairGeneric<>(6, 3);

        System.out.println(a.equals(c));
        System.out.println(a.compareTo(c));

    }

    public static void Q4() {
        Integer[] intArr = {5, 3, 7, 1, 4, 9, 8, 2};
        String[] strArr = {"red", "blue", "orange", "tan"};
        System.err.println(minmax(intArr));;
        System.out.println(minmax(strArr));
    }

    public static void Q5() {
        Integer[] a = {1, 2, 3};
        String[] b = {"red", "green", "blue"};
        Circle[] c = {new Circle(3.0), new Circle(2.9), new Circle(5.9)};

        System.out.println(max(a));
        System.out.println(max(b));
        System.out.println(max(c));
    }
    
    public static void Q6(){
        
        Integer[][] arr = {{4,5,6},{1,2,3}};
        MinMaxTwoDArray obj = new MinMaxTwoDArray();
        
        System.out.println(obj.min(arr));
        System.out.println(obj.max(arr));
    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(max) > 0) {
                max = list[i];
            }
        }
        return max;
    }

    public static <T extends Comparable> String minmax(T[] arr) {
        T min = arr[0];
        T max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return "Min = " + min + " Max = " + max;
    }
}
