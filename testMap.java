import java.util.*;
import java.io.*;

public class testMap {
	public static void main (String[] args) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		System.out.println (map.put('a', 0));
		System.out.println (map.put('b', 0));
		System.out.println (map.put('a', 2));
		System.out.println (map.put('a', 5));
		System.out.println (map.put('a', 7));

	}
}