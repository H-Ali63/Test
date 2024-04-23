package QuadB_Tech;

public class Return_index {
	public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 5, 7, 9, 9, 9, 11};
        int target = 9;
        int firstOccurrenceIndex = findFirstOccurrence(sortedArray, target);
        
        if (firstOccurrenceIndex != -1) {
            System.out.println("First occurrence of " + target + " is at index " + firstOccurrenceIndex);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
	
    public static int findFirstOccurrence(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

}
