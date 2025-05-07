package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(3);
        list.add(5);
        System.out.println("Before sort: " + list);
//        list.sort((a, b) -> b.compareTo(a));
//        System.out.println("After sort: " + list);
//        Collections.reverse(list);
//        System.out.println("After reverse: " + list);
        Collections.sort(list);
        System.out.println("After sort: " + list);
    }
}
