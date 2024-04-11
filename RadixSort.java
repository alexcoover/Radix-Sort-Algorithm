
/**
 * The class defines to sort the integer number in queue.
 * 
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class RadixSort {
	/**
	 * The number of digit queue.
	 */
	public static final int TEN_DIGITS = 10;

	/**
	 * The max digits in a number.
	 */
	public static final int MAX_DIGITS = 4;

	/**
	 * The method sort the queue using radix sort.
	 * 
	 * @param master the queue
	 */
	public static void sort(Deque<Integer> master) {
		@SuppressWarnings("unchecked")
		Deque<Integer>[] buckets = new LinkedDeque[TEN_DIGITS];
		for (int index = 0; index < TEN_DIGITS; index++) {
			buckets[index] = new LinkedDeque<Integer>();
		}
		Deque<Integer> temp = new LinkedDeque<>();
		temp = master;
		for (int i = 1; i < 1001; i *= 10) {
			while (!temp.isEmpty()) {
				int numFull = temp.peek();
				if (numFull < i)
					buckets[0].addRear(temp.remove());
				else {
					int num = (temp.remove() / i) % 10;
					buckets[num].addRear(numFull);
				}
			}
			for (int j = 0; j < 10; j++) {
				while (!buckets[j].isEmpty()) {
					temp.add(buckets[j].remove());
				}
			}

		}
		master = temp;
	}
}
