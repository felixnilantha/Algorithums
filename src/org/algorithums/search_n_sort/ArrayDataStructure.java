package org.algorithums.search_n_sort;

public class ArrayDataStructure {

	private int[] intArray = new int[50];

	private int arraySize = 10;

	//
	public void generateRandomArray() {
		for (int i = 0; i < arraySize; i++) {
			intArray[i] = (int) (Math.random() * 10) + 10;
		}
	}

	public int get(int index) {
		if (index < arraySize) {
			return intArray[index];
		}
		return 0;
	}

	public boolean isExist(int searchValue) {
		boolean valueInArray = false;
		for (int i = 0; i < arraySize; i++) {
			if (intArray[i] == searchValue) {
				valueInArray = true;
			}
		}
		return valueInArray;
	}

	public void delete(int index) {
		if (index < arraySize) {
			for (int i = 0; i < (arraySize - 1); i++) {
				intArray[i] = intArray[i + 1];
			}
			arraySize--;
		}

	}

	public void insert(int value) {

		if (arraySize < 50) {
			intArray[arraySize] = value;
			arraySize++;
		}

	}

	public String linearSearch(int value) {

		boolean valueFound = false;

		String indexWithValue = "";

		System.out.println("Search results : ");

		for (int i = 0; i < arraySize; i++) {
			if (intArray[i] == value) {
				valueFound = true;
				System.out.print(i + " found");
				indexWithValue += i + " ";

			}
			printHorzArray(i, -1);
		}
		if (!valueFound) {
			indexWithValue = "not found";
			System.out.println(indexWithValue);
		}

		return indexWithValue;

	}

	public void binarySearch(int value) {

		int lowIndex = 0;
		int highIndex = arraySize - 1;

		while (lowIndex <= highIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;
			if (intArray[middleIndex] < value) {

				middleIndex = lowIndex + 1;

			} else if (intArray[middleIndex] > value) {
				highIndex = middleIndex - 1;
			} else {
				System.out.println("\n Search result : " + middleIndex);
				lowIndex = highIndex + 1;
			}
		}

	}

	/*
	 * At each iteration one element is selected and compared with every other
	 * element to find the smallest element and place it at the first position
	 * of the list So in the worst case 'N' elements are checked for every
	 * selected element
	 * 
	 * The complexity of selection sort is O(N^2)
	 * 
	 * 
	 */

	public void selectionSort() {

		for (int x = 0; x < arraySize; x++) {

			int smallest = x;
			for (int y = x; y < arraySize; y++) {
				if (intArray[smallest] > intArray[y]) {
					smallest = y;
				}
			}
			// Helper method to swap

			// O(N) to get the element in the correct place
			swapValues(x, smallest);

			printHorzArray(x, -1);

		}
	}

	public void insertionSort() {

		for (int i = 1; i < arraySize; i++) {

			int j = i;
			int insertValue = intArray[i];
			while ((j > 0) && (intArray[j - 1] > insertValue)) {
				intArray[j] = intArray[j - 1];
				j--;

				printHorzArray(i, j);
			}

			intArray[j] = insertValue;
			printHorzArray(i, j);

			System.out.println(
					"\nArray[i] = " + intArray[i] + " Array[j] = " + intArray[j] + " Insert Value = " + insertValue);

		}
	}

	/*
	 * At each iteration, every element is compared with its neighbor and swap
	 * if they are not in the correct order. This will result the smallest
	 * element to bubble up to the beginning of the list
	 * 
	 * In the worst case if the original list was sorted descending and needed to be 
	 * sorted ascending N elements are checked and swapped
	 * 
	 * The complexity of bubble sort is O(N^2) but its a stable sort and could brake the loop early
	 */

	public void bubbleSort() {

		for (int i = arraySize - 1; i > 1; i--) {
			
			
			boolean swapped = false;
			for (int j = 0; j < i; j++) {
				if (intArray[j] > intArray[j + 1]) {
					
					// number of swapped that we do in bubble sort is higher than selection sort 
					// which makes the complexity as O(N^2) swaps 
					swapValues(j, j + 1);
					swapped = true;
					printHorzArray(i, j);
				}

				printHorzArray(i, j);

			}
			
			// this will keeps track of any swap was done 
			// in the second loop, if not the list is sorted and could break;
			if (!swapped) {
				break;
			}
		}

	}

	private void swapValues(int first, int next) {

		int temp = intArray[first];
		intArray[first] = intArray[next];
		intArray[next] = temp;

	}

	public void printHorzArray(int i, int j) {

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + intArray[n] + " ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		if (j != -1) {

			for (int k = 0; k < ((j * 5) + 2); k++)
				System.out.print(" ");

			System.out.print(j);

		}

		if (i != -1) {

			for (int l = 0; l < (5 * (i - j) - 1); l++)
				System.out.print(" ");

			System.out.print(i);

		}

		System.out.println();

	}

	public static void main(String[] args) {
		ArrayDataStructure array = new ArrayDataStructure();

		array.generateRandomArray();
		array.bubbleSort();
	}

}
