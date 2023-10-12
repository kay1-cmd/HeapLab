import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * This class implements a Heap based Priority Queue with an ArrayList. 
 * It uses a comparator to determine structure based on priority.
 * 
 * @param <T> Type parameter for the elements used/taken by the heap.
 * */
public class ComparatorHeap<T> {
	
	private final List<T> arr = new ArrayList<>();
	private final Comparator<T> comparator;

	/**
	 * Constructs a heap with a specific comparator
	 * 
	 * @param comparator The comparator used in the heap
	 */
	public ComparatorHeap(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * A helper method to determine the index of the left child of a heap element
	 * 
	 * @param i The index of the heap element
	 * @return The index of the element's left child
	 */
	private int left(int i) {
		return 2 * i + 1;
	}

	/**
	 * A helper method to determine the index of the right child of a heap element
	 * 
	 * @param i The index of the heap element
	 * @return The index of the element's right child
	 */
	private int right(int i) {
		return 2 * i + 2;
	}

	/**
	 * A helper method to determine the index of the parent of a heap element
	 * 
	 * @param i The index of the heap element
	 * @return The index of the element's parent or 0 if the element is the root
	 */
	private int parent(int i) {
		return i == 0 ? 0 : (i - 1) / 2;
	}

	/**
	 * A helper method to swap two heap elements
	 * 
	 * @param i The index of the fist element
	 * @param j The index of the second element
	 */
	private void swap(int i, int j) {
		T tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}

	/**
	 * This method adds an element to the heap preserving the heap property
	 * 
	 * @param element The element to add to the heap
	 */
	public void add(T element) {
		// add the element to the end of the heap to preserve the complete tree property
		arr.add(element);
		// move the element along the path to the root by swapping it with its parent
		// until it finds its proper place in the heap
		for (int i = arr.size() - 1; i > 0; i = parent(i)) {
			if (comparator.compare(arr.get(i), arr.get(parent(i))) < 0) {
				swap(i, parent(i));
			} else {
				break;
			}
		}
	}

	/**
	 * This method removes an element from the root of the heap preserving the heap
	 * property
	 * 
	 * @return The deleted element
	 */
	public T remove() {
		// Check if there's anything to remove
		if (arr.isEmpty()) {
			return null;
		}
		// remove the root
		T ret = arr.get(0);
		// place the last element at the root
		arr.set(0, arr.get(arr.size() - 1));
		arr.remove(arr.size() - 1);
		// move the new root element down the heap by swapping it with the smallest
		// child until it finds its proper place in the heap
		for (int i = 0; left(i) < arr.size();) {
			int leastIdx = left(i);
			if (right(i) < arr.size() && comparator.compare(arr.get(left(i)), arr.get(right(i))) > 0) {
				leastIdx = right(i);
			}
			if (comparator.compare(arr.get(i), arr.get(leastIdx)) > 0) {
				swap(i, leastIdx);
				i = leastIdx;
			} else {
				break;
			}
		}
		return ret;
	}
}
