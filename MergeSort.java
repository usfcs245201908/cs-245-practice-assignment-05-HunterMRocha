public class MergeSort implements SortingAlgorithm {


	public void sort(int myArray[]) {
		sort1(myArray, 0, myArray.length - 1);
	}

	public void sort1(int[] myArray, int start, int end) {
		if (start >= end) {
			return; // we're done traversing the array
		}

		int mid = (start + end) / 2;
		sort1(myArray, start, mid); // sort left half
		sort1(myArray, mid + 1, end); // sort right half
		merge(myArray, start, mid, end); // merge sorted results into the input array

	}

	public void merge(int[] myArray, int start, int mid, int end) {
		int[] tempArray = new int[end - start + 1];

		int leftSlot = start; // index counter for the left side of the array
		int rightSlot = mid + 1; // index counter for the right side of the array
		int k = 0;

		// if the left exceeds the mid point
		// if the right exceeds the end point
		// then loop won't execute
		while (leftSlot <= mid && rightSlot <= end) {
			if (myArray[leftSlot] < myArray[rightSlot]) {
				tempArray[k] = myArray[leftSlot];
				leftSlot++;
			} else {
				tempArray[k] = myArray[rightSlot];
				rightSlot++;
			}
			k++;
		}

		/**
		 * When it gets to hear then the above loop has completed. So both the right and
		 * left side of the subarray can be considered sorted
		 */

		if (leftSlot <= mid) { // consider the right side done being sorted. Left must be sorted already
			while (leftSlot <= mid) {
				tempArray[k] = myArray[leftSlot];
				leftSlot++;
				k++;
			}
		} else if (rightSlot <= end) {
			while (rightSlot <= end) {
				tempArray[k] = myArray[rightSlot];
				rightSlot++;
				k++;
			}
		}
		
		//coping over temp array into appropriate slots myArray
		for(int i = 0; i < tempArray.length; i++) {
			myArray[start + i] = tempArray[i];
			
		}

	}

}