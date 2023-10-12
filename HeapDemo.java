import java.util.Comparator;
import java.util.Random;

public class HeapDemo{
	public static void main(String[] args) {
		ComparatorHeap<Integer> heap = new ComparatorHeap<Integer>(Comparator.naturalOrder());

		for (int i = 0; i < 20; i++) {
			int num = new Random().nextInt(100);
			System.out.print(num + " ");
			heap.add(num);
		}
		System.out.println();
		for (Integer num = heap.remove(); num != null; num = heap.remove()) {
			System.out.print(num + " ");
		}
	}
}
