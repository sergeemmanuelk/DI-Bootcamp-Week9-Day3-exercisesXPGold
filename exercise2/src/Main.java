import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] A2 = {2, 1, 8, 3};

        System.out.println("Original Array A1[]:");
        printArray(A1);
        System.out.println("Array A2[]:");
        printArray(A2);

        sortA1ByA2(A1, A2);

        System.out.println("Sorted Array A1[]:");
        printArray(A1);
    }

    // function to sort A1[] according to the order defined by A2[]
    public static void sortA1ByA2(int[] A1, int[] A2) {
        // create a temporary array and copy elements of A1[] to it
        int[] temp = new int[A1.length];
        for (int i = 0; i < A1.length; i++) {
            temp[i] = A1[i];
        }

        // create a visited array and initialize all entries in it as false
        boolean[] visited = new boolean[A1.length];

        // sort the temp array
        Arrays.sort(temp);

        // initialize the output index
        int ind = 0;

        // for every element in A2[], binary search for all occurrences of A2[i] in temp[] and copy all occurrences to A1[]
        for (int i = 0; i < A2.length; i++) {
            int low = 0, high = temp.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp[mid] == A2[i]) {
                    A1[ind++] = temp[mid];
                    visited[mid] = true;
                    break;
                } else if (temp[mid] < A2[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // copy all unvisited elements from temp[] to A1[]
        for (int i = 0; i < temp.length; i++) {
            if (!visited[i]) {
                A1[ind++] = temp[i];
            }
        }
    }

    // function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}