package QuadB_Tech;
import java.util.Random;

public class Kth_Smallest_Element {
	public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int k = 3;
        int kthSmallest = findKthSmallest(array, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }
    public static int findKthSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            throw new IllegalArgumentException("Invalid input or k out of bounds.");
        }

        return quickSelect(array, 0, array.length - 1, k - 1); // Adjust k to 0-based index
    }

    private static int quickSelect(int[] array, int left, int right, int k) {
        if (left == right) {
            return array[left];
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(array, left, right, pivotIndex);

        if (k == pivotIndex) {
            return array[k];
        } else if (k < pivotIndex) {
            return quickSelect(array, left, pivotIndex - 1, k);
        } else {
            return quickSelect(array, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }

        swap(array, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
