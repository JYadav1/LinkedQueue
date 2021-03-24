package LinkedQueue_Homework;

import java.security.SecureRandom; // This is cryptographically stronger for random number generation.

public class Driver {

	// Declaring store variables for simulation:
	static final int STORE_TIMER = 60;
	static int servicedCustomers, maxLineLength;
	static SecureRandom customerChance = new SecureRandom();
	static LinkedQueue line = new LinkedQueue();

	public static void main(String[] args) {

		// Begin store simulation:
		for (int i = 1; i <= STORE_TIMER; i++) {

			// Check for a new customer:
			if (customerChance.nextInt(4) == 0) { // One Fourth Chance - Gives a number up to but NOT including 4 (or 0
													// - 3)
				line.enqueue(new Customer());

				System.out.println("New customer added with service time of: " + line.getFirst().getServiceTime()
						+ ".  Queue length is now: " + line.getSize());

				// Change maxLineLength if we add a customer above the previously recorded
				// number:
				if (line.getSize() > maxLineLength) {
					maxLineLength = line.getSize();
				}
			}

			// Service the customer at the front of the line - ONLY IF there is one in line:
			if (!line.isEmpty()) {
				line.getFirst().decServiceTime();

				// Only dequeue them if they have been fully serviced, then increment the
				// serviced counter;
				if (line.getFirst().getServiceTime() == 0) {
					line.dequeue();

					System.out.println(
							"Customer serviced and removed from the queue.  Queue length is now: " + line.getSize());

					servicedCustomers++;
				}
			}

			// End of store minute signifier:
			System.out.println("------------------------- timer: " + i + " --------------------------");

		}

		// End of simulation information:
		System.out.println("The total amount of serviced customers was: " + servicedCustomers);
		System.out.println("The max line length was: " + maxLineLength);
	}
}
