package collections;

import java.util.PriorityQueue;

public class MinPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        minQueue.add(5);
        minQueue.add(20);
        minQueue.add(1);
        minQueue.add(8);
        System.out.println("Queue: " + minQueue);
        System.out.println("When poll:"); // Luôn đảm bảo thứ tự ưu tiên khi lấy ra
        while (!minQueue.isEmpty()) {
            System.out.println(minQueue.poll());
        }

        Integer[] a = {111,2,3};
    }
}
