package assign04;

import java.math.BigInteger;
import java.util.Random;

/**
 * This class collects running times for methods of SimplePriorityQueue.
 * 
 * @author Erin Parker
 * @version February 9, 2021
 */
public class PQTimer {
	
	public static void main(String[] args) {
		Random rng = new Random();

		int timesToLoop = 100;

		int incr = 1000;
		for(int probSize = 1000; probSize <= 20000; probSize += incr) {

			
//			BigInteger[] b = new BigInteger[probSize];
			Integer[] I = new Integer[probSize];

			for(int i = 0; i < probSize; i++) 
				I[i] = (rng.nextInt(1200));    // best case of insert: logN + 1 -> O(logN)

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				LargestNumberSolver.findLargestNumber(I);
//				s.insert(rng.nextInt(probSize));  
//				s.deleteMin();  // remove element from priority queue to keep size at N
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
//				rng.nextInt(probSize);
//				s.deleteMin();
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(probSize + "  " + averageTime);
			
		}
	}
}
