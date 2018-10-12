import java.util.*;
import javafx.util.*;

class NQueens  {
	
	private static int n;

	private static List<Pair<Integer, Integer>> qPos;

	private static boolean isSafe(int row, int col) {
		Iterator<Pair<Integer, Integer>> iter = qPos.iterator();
		while (iter.hasNext()) {
			Pair<Integer, Integer> temp = iter.next();
			int r = temp.getKey();
			int c = temp.getValue();
			if (r == row || c == col || r - row == c - col)
				return false;
		}
		return true;
	}

	private static void printqPos() {
		System.out.println ("Current QPositions:");
		for (Pair<Integer, Integer> i : qPos)
			System.out.println (i.toString());
	}

	private static boolean placeQueens(int col) {
		
		if (col >= n)
			return true;

		// System.out.println ("Placing in column: " + col);
		for (int row = 0; row < n; row++) {
			if (isSafe(row, col)) {
				qPos.add(new Pair<Integer, Integer>(row, col));
				if (placeQueens(col + 1))
					return true;
				else {
					// printqPos();
					// System.out.println ("Unsuccessful for row: " + row + " col = " + col);
					qPos.remove(qPos.size() - 1);
				}
			}
		}
		return false;
	}

	public static void main (String[] args) {
		qPos = new LinkedList<Pair<Integer, Integer>>();
		n = 15;
		placeQueens (0);
		printqPos();
	}
}