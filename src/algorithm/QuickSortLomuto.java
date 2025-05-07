package algorithm;

import java.util.Arrays;

public class QuickSortLomuto {
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        // partition
        int pivotIndex = lomutoPartition(arr, low, high);
        // Recursion with left part and right part of array that after partition
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    static int lomutoPartition(int[] arr, int low, int high) {
        // Step 1: select pivot
        int pivot = arr[high];
        int i = low - 1; // i theo dõi phần tử nhỏ hơn pivot (Lúc đầu do chưa tìm dc phần tử nào nhỏ hơn nên i = -1)
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap nếu phần tử < pivot
                swap(arr, i, j);
            }
        }
        // Đưa pivot về đúng vị trí
        swap(arr, i + 1, high);

        return i + 1; // Trả về vị trí đúng của pivot sau khi chia mảng
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 9 , 15, 2, 9, 5, 4, 33, 9, 6, 12, 2, 8};
        System.out.println("Origin arr: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After quick sort: " + Arrays.toString(arr));
    }
}
