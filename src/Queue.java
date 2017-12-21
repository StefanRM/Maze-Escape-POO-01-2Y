/**
 * This class represents a Queue (data structure) with Point elements
 * 
 * @author Maftei Stefan - Radu
 * @version 1.3
 */
public class Queue {
	/**
	 * Maximum numbers of elements in Queue
	 */
	private int capacity;
	/**
	 * Current number of elements in Queue
	 */
	private int nr_elements;
	/**
	 * Queue array of elements
	 */
	private Point[] array;

	/**
	 * Initializes a Queue with a given capacity
	 * 
	 * @param capacity
	 *            Maximum numbers of elements in Queue
	 */
	public Queue(int capacity) {
		this.nr_elements = 0; // initially, Queue is empty
		this.capacity = capacity;
		this.array = new Point[capacity];
		for (int i = 0; i < capacity; i++) { // initialize Queue array of
												// elements
			array[i] = new Point();
		}
	}

	/**
	 * Inserts the specified Point element into Queue if it is possible to do so
	 * immediately without violating capacity restrictions
	 * 
	 * @param point
	 *            Point element to insert
	 */
	public void enqueue(Point point) {
		if (nr_elements == capacity) { // cannot enqueue if the capacity is
										// reached
			return;
		}

		array[nr_elements] = new Point(point.getX(), point.getY(),
				point.getDistance()); // adding the Point element
		nr_elements++; // increase number of elements

	}

	/**
	 * Removes the head of this queue, if this Queue is not empty.
	 */
	public void dequeue() {
		if (nr_elements == 0) { // cannot dequeue if the Queue is empty
			return;
		}

		for (int i = 0; i < nr_elements - 1; i++) {
			array[i] = new Point(array[i + 1].getX(), array[i + 1].getY(),
					array[i + 1].getDistance()); // permute to left all elements
		}

		nr_elements--; // decrease number of elements
	}

	/**
	 * Retrieves the head of this Queue
	 * 
	 * @return Point element which is the head of the Queue
	 */
	public Point front() {
		return array[0];
	}

	/**
	 * Verifies if the Queue is empty
	 * 
	 * @return True if the Queue is empty, otherwise false
	 */
	public boolean isEmpty() {
		return (nr_elements == 0);
	}
}
