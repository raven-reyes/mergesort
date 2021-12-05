import java.util.Arrays;

public class merge {
	static void Merge(int Arr[], int start, int mid, int end) {

		// create a temp array to store the sorted values one by one 
		int temp[] = new int[Arr.length];

		// crawlers for both intervals and for temp
		int i = start, j = mid+1, k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(i <= mid && j <= end) {
			if(Arr[i] <= Arr[j]) {
				temp[k] = Arr[i];
				k += 1; i += 1;
			}
			else {
				temp[k] = Arr[j];
				k += 1; j += 1;
			}
		}

		// add elements left in the first interval 
		
		if(j > end)
			while(i <= mid) {
				temp[k] = Arr[i];
				k ++ ; i++;
			}
		
		// add elements left in the second interval 
		if(i > mid)
			while(j <= end) {
				temp[k] = Arr[j];
				k ++ ; j++;
			}
		
		// copy temp to original interval
		for(i = start; i <= end; i++) {
			Arr[i] = temp[i-start];
		}
	}

	  // Arr is an array of integer type
	// start and end are the starting and ending index of current interval of Arr

	static void mergeSort(int Arr[], int start, int end) {

		if(start < end) {
			int mid = start + (end- start) / 2;
			mergeSort(Arr, start, mid);
			mergeSort(Arr, mid+1, end);
			Merge(Arr, start, mid,  end);
		}
	}
	// driver code
	public static void main(String[] args) {
		int [] Arr = {7,16,13,9,3,14,1,5,10};
		System.out.println("The original array is : " + Arrays.toString(Arr));
		mergeSort(Arr, 0,  Arr.length-1);
		System.out.println("The sorted array is : " + Arrays.toString(Arr));

	}

}

    