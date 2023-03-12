import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 3, 2, 8, 10, 9};
        int k1 = 3;
        sort(arr1, k1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 9, 8, 7, 4, 70, 60, 50};
        int k2 = 4;
        sort(arr2, k2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort(int[] arr, int k) {
        int n = arr.length;

        // Create a min heap of size k+1
        PriorityQueue<Integer> heap = new PriorityQueue<>(k+1);

        // Insert the first k+1 elements into the heap
        for (int i = 0; i <= k; i++) {
            heap.add(arr[i]);
        }

        int index = 0;
        for (int i = k+1; i < n; i++) {
            arr[index++] = heap.poll();  // extract minimum element from heap
            heap.add(arr[i]);  // add next element to heap
        }

        // extract remaining elements from the heap
        while (!heap.isEmpty()) {
            arr[index++] = heap.poll();
        }
    }
}