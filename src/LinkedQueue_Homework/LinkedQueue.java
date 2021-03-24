package LinkedQueue_Homework;

/*
 * NOTE***: This ONLY stores information regarding your customer queue
 *           and should not have any store logic in it. You can technically
 *           put it in here, but it is not good practice as you split your
 *           store logic between two files, which is never a good idea. 
 */
class LinkedQueue {

	private int size;
	private Customer first, last;

	public LinkedQueue() {
		size = 0;
		first = last = null;
	}

	public int getSize() {
		return size;
	}

	public Customer getFirst() {
		return first;
	}

	public Customer getLast() {
		return last;
	}

	public Boolean isEmpty() {
		return first == null;
	}

	public void enqueue(Customer c) {
		if (isEmpty()) {
			first = c;
		} else {
			last.setNext(c);
		}

		last = c;

		size++;
	}

	public Customer dequeue() {
		if (isEmpty()) {
			return null;
		}

		Customer temp = first;
		first = first.getNext();

		if (isEmpty()) {
			last = null;
		}

		size--;

		return temp;
	}
}
