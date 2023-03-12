import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 5, 5};
        int[] dep = {4, 5, 12, 9, 12};
        int maxTime = maxGuests(arr, dep);
        System.out.println("Maximum guests at time " + maxTime);
    }

    // Returns maximum guests at any time in the party
    public static int maxGuests(int[] arr, int[] dep) {
        // Sort arrival and exit times
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 0, j = 0, guests = 0, maxGuests = 0, maxTime = 0;

        // Traverse through arrival and exit times
        while (i < n && j < n) {
            // If next event is arrival, increment guests
            if (arr[i] <= dep[j]) {
                guests++;
                // Update maximum guests and time if required
                if (guests > maxGuests) {
                    maxGuests = guests;
                    maxTime = arr[i];
                }
                i++;
            }
            // If next event is exit, decrement guests
            else {
                guests--;
                j++;
            }
        }

        return maxTime;
    }
}