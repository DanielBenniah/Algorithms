public class binarySearch {

	public static int binarySearchUtil (int[] nums, int start, int end, int element) {
		while (start <= end) { 
	        int mid = start + (end - start) / 2; 
	  
	        // Check if x is present at mid 
	        if (nums[mid] == element) 
	            return mid; 
	  
	        // If x greater, ignore left half 
	        if (nums[mid] < element) 
	            start = mid + 1; 
	  
	        // If x is smaller, ignore right half 
	        else
	            end = mid - 1; 
	    } 
  
	    // if we reach here, then element was 
	    // not present 
    	return -1; 
	}

	public static int binarySearch(int[] nums, int element) {
		return binarySearchUtil(nums, 0, nums.length - 1, element);
	}
}