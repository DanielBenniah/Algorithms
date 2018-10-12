import java.io.*;
import java.util.*;

class MinHeaps {

	//private int capacity;

	// private int size = 0;

	List<Integer> items;

	private int leftIndex (int p) {
		return 2 * p + 1;
	}

	private int rightIndex (int p) {
		return 2 * p + 2;
	}

	private int parentIndex (int c) {
		return (c - 1) / 2;
	}

	private boolean hasLeft (int p) {
		return leftIndex(p) < items.size();
	}

	private boolean hasRight (int p) {
		return rightIndex(p) < items.size();
	}

	private boolean hasParent (int p) {
		return parentIndex(p) >= 0;
	}

	private int leftChild (int p) {
		return items.get(leftIndex(p));
	}

	private int rightChild (int p) {
		return items.get(rightIndex(p));
	}

	private int parent (int c) {
		return items.get(parentIndex(c));
	}

	public int peek () throws Exception{
		if (items.size() == 0)
			throw new IllegalStateException();
		return items.get(0);
	}

	public int poll () {
		if (items.size() == 0)
			throw new IllegalStateException();
		int firstElement = items.get(0);
		items.set(0, items.get(items.size() - 1));
		items.remove(items.size() - 1);
		heapifyDown();
		return firstElement;
	}

	public void add (int item) {
		items.add(item);
		heapifyUp();
	}

	public void heapifyDown() {
		int index = 0;
		int smallIndex = 0;
		while (hasLeft(index))  {
			smallIndex = leftIndex(index);
			while (hasRight(index) && rightChild(index) < leftChild(index)) {
				smallIndex = rightIndex(index);
			}
			if (items.get(index) < items.get(smallIndex))
				break;
			int temp = items.get(smallIndex);
			items.set(smallIndex, items.get(index));
			items.set(index, temp);
			index = parentIndex(index);
			index = smallIndex;
		}
	}

	public void heapifyUp() {
		int index = items.size() - 1;
		while (hasParent(index) && parent(index) < items.get(index))  {
			int temp = items.get(parentIndex(index));
			items.set(parentIndex(index), items.get(index));
			items.set(index, temp);
			index = parentIndex(index);
		}
	}

	public static void main (String args[]) {

	}
}