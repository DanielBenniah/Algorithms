import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class PalindromicSubstring {

	public static int longestPalindrome(String s) {
		char[] temp = s.toCharArray();
		char[] T = new char[s.length() * 2 + 3];
		T[0] = '$';
		T[1] = '#';
		for (int i = 2, j = 0; j < s.length(); i++) {
			if (i % 2 == 0) {
				T[i] = temp[j];
				j++;
			} else {
				T[i] = '#';
			}
		}
		T[T.length - 2] = '#';
		T[T.length - 1] = '@';

		// System.out.println("T = " + new String(T));

		int C = 1, R = 1;
		int[] P = new int[T.length];
		Arrays.fill(P, 0);

		int max = 0;

		for (int i = 1; i < T.length - 1; i++) {
			int mirr = 2 * C - i; //Get mirror with respect to the centre
			if (i < R) //if i is less than the right boundary
				P[i] = Math.min(R - i, P[mirr]);

			while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) //Find the longest palindrome with current centre
				P[i]++;

			System.out.println ("C = " + C + " R = " + R + " P[" + i + "] = " + P[i]);

			if (i + P[i] > R) { //if panindrome boundary extends beyond current right border, change centre and right boundary
				C = i;
				R = i + P[i];
			}
		}

		Arrays.sort(P);
		return P[P.length - 1];
	}

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Longest palindrome: " + longestPalindrome(input));
	}
}