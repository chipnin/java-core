package collections;

import java.time.Instant;
import java.util.*;

public class ArrayDequeClass {
    public static void main(String[] args) {
        Long a = Instant.now().getEpochSecond();
        System.out.println(a);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
    }
}
