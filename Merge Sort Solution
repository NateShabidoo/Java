public class a3mergeSort {

	private static void Merge(int array[], int i, int k, int j) {
		int left[] = new int[k - i + 1];
		int right[] = new int[j - k];
		
		int x, y;
		for(x = 0; x < left.length; ++x)
			left[x] = array[x + i];
		
		for(y = 0; y < right.length; ++y)
			right[y] = array[k + 1 + y];
		
		int start = 0;
		x = y = 0;
		while(x < left.length && y < right.length) {
			if(left[x] < right[y]) {
				array[start + i] = left[x];
				++x;
			}
			else {
				array[start + i] = right[y];
				++y;
			}
			++start;
		}
		
		while(x < left.length) {
			array[start + i] = left[x];
			++x;
			++start;
		}
		
		while(y < right.length) {
			array[start + i] = right[y];
			++y;
			++start;
		}
	}
	
	public static void Our_Merge_Sort(int array[], int i, int j) {
		if(array.length > 64)
			return;

		if(i >= j)
			return;
		int k = i + (j - i) / 2;
		Our_Merge_Sort(array, i, k);
		Our_Merge_Sort(array, k + 1, j);
		Merge(array, i, k, j);
	}
	
	public static int[] Our_Combine_Array(int a[], int b[]) {
        int c[] = new int[a.length + b.length];
        int idx_a, idx_b, idx_c;
        idx_a = idx_b = idx_c = 0;

        while(idx_a < a.length && idx_b < b.length) {
            if(a[idx_a] < b[idx_b]) {
                c[idx_c] = a[idx_a];
                ++idx_a;
                ++idx_c;
            }
            else {
                c[idx_c] = b[idx_b];
                ++idx_b;
                ++idx_c;
            }
        }

        while(idx_a < a.length) {
            c[idx_c] = a[idx_a];
            ++idx_a;
            ++idx_c;
        }

        while(idx_b < b.length) {
            c[idx_c] = b[idx_b];
            ++idx_b;
            ++idx_c;
        }

        return c;
        }
	

	public static void main(String[] args) {
		int BIGarray[] = new int[8 * 64];
		for(int i = 0; i < BIGarray.length; ++i)
			BIGarray[i] = (int)(Math.random() * 1000);

		// copy BIGarray elements to the 8 smaller arrays
		// small array name is given, use it in your subsequent code
		// keep in mind that small itself is a 2D array, small[] is 1D array.
		int small[][] = new int[8][64];
		int r;
		int o = 0;
		for(r=0; r<small.length; r++) {
			for(int c=0; c<small[r].length; c++) {
				small[r][c] = BIGarray[o];
				o++;
			}
		}
		
		//  sort those 8 small arrays by calling Our_Merge_Sort();
		// finish the for loop below to sort those 8 small arrays
		for(int m = 0; m < 8; ++m) {
				Our_Merge_Sort(small[m], 0, 63);
		}
		
		// to better see our progress for further development print small[][] array contents with row and column #
		for(r=0; r<small.length; r++) {
			for(int c=0; c<small[0].length; c++) {
				System.out.println("Array index: " + r + "-" +c+ ": " + small[r][c]);
			}
		}
		
		// combine sorted small arrays together
		int g = 0;
		for(int i = 0; i < 7; i+=2) {
			small[0] = Our_Combine_Array(small[0], small[i+1]);
		}

		for(int i = 0; i<512; i++) {
			BIGarray = small[0];
		}
			int q;
			for(q=0; q<BIGarray.length; q++) {
		 	    System.out.println(BIGarray[q]+" ");
			}
}
}
