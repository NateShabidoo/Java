public class insertSortVariation {
	private static int elements[];

	public static void swap(int a, int b) {
		int temp;
		temp = elements[a];
		elements[a] = elements[b];
		elements[b] = temp;
	}

	// find insert position method
	public static int FindInsertPosition(int i) {
		int target = elements[i]; // target is the value we want to insert
		int j = i - 1; // starting point to find out the insert pos
		while(j >= 0) {
			// we compare each element we visit with the target value
			if(elements[j] > target)
				--j;
			else
				break;
		}
		return j+1;
	}

	// shift elements right method
	public static void ArrayRightShift(int x, int y) {
		for(int i = y-1; i>=x; i-- ) {
			elements[i+1] = elements[i];
		}
	}

	public static void main(String[] args) {
		elements = new int[20];

		int i = 0;
		while(i < 20) {
			elements[i] = (int)(Math.random() * 50);
			++i;
		}

		for (i = 1; i < elements.length; i++) {
			int x = FindInsertPosition(i); // insert element at index i
			// elements before i (index 0....i-1) are sorted
			//System.out.println(x);
			// now x indicates the insert position to insert elements[i]
			int temp = elements[i];
			// now we right shift
			ArrayRightShift(x,i);
			elements[x]=temp;
		}

		for(int x : elements)
			System.out.print(x + " ");
	}
}
