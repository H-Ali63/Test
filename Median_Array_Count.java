package QuadB_Tech;

public class Median_Array_Count {
	
	public static void main(String[] args) {
        int[] sortedArray1 = {1, 2, 3, 4, 5};
        System.out.println("Median of sortedArray1: " + findMedian(sortedArray1));

        int[] sortedArray2 = {1, 2, 3, 4, 5, 6};
        System.out.println("Median of sortedArray2: " + findMedian(sortedArray2));
    }
	
    public static double findMedian(int[] sortedArray) {
        int length = sortedArray.length;
        if (length == 0) {
            throw new IllegalArgumentException("Array must not be empty.");
        }

        if (length % 2 == 1) {
            return sortedArray[length / 2];
        } else {
            int midIndex1 = length / 2 - 1;
            int midIndex2 = length / 2;
            return (sortedArray[midIndex1] + sortedArray[midIndex2]) / 2.0;
        }
    }
}
