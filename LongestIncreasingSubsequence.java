import java.util.*;
import java.io.*;

public class LongestIncreasingSubsequence {

	public static int binarySearch (int[] nums, int[] index,int element, int s, int e) {

		// System.out.println ("index = " + Arrays.toString(index));
		// System.out.println ("Start = " + s + " end = " + e);
		while (s <= e) {
			int mid = (int) Math.ceil((s + e)/2);
				
			if(nums[index[mid]] < element)
				s = mid + 1;
			else
				e = mid - 1;
		}

		return s;
	}

	public static List<Integer> longestSubsequence (int[] nums) {
		int[] lis = new int[nums.length];
		int[] parent = new int[nums.length];
		int numsLength = 1;

		lis[0] = 0;
		parent[0] = -1;

		for (int i = 1; i < nums.length; i++) {
			int pos = binarySearch(nums, lis, nums[i], 0, numsLength - 1);
			numsLength = Math.max(numsLength, pos + 1);
			lis[pos] = i;
			if (pos == 0)
				parent[i] = -1;
			else
				parent[i] = lis[pos - 1];
		}

		List<Integer> result = new ArrayList<Integer>();
		result.add(nums[lis[--numsLength]]);
		int current = parent[lis[numsLength]];
		// System.out.println("Parent array:");
		// for (int i : parent)
		// 	System.out.println(i);

		if (current == -1)
			return Arrays.asList(nums[0]);

		while (parent[current] != -1) {
			result.add(nums[current]);
			current = parent[current];
		}
		result.add(nums[current]);
		Collections.reverse(result);

		return result;
	}

	public static void main (String[] args) {
		List<Integer> solution = longestSubsequence(new int[]{5, 4, 3, 2, 1});
		for (int i : solution)
			System.out.println(i);
	}
}