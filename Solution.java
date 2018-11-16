public class Solution{
	
	public static int lenAfteremoveDupsFromSortedArr(int[] arr){
		if(arr.length == 0){
			return 0;
		}
		if(arr.length == 1){
			return 1;
		}
		int j = 0;
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i] != arr[i+1]){
				arr[j] = arr[i];
				j++; 
			}
		}
		arr[j] = arr[arr.length-1];
		j++;
		return j;
	}

	public static void display(int[] arr){
		for(int i = 0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
		System.out.println("*****************END********************");
	}
	public static void main(String[] args){
		int arr1[] = {1,1,2};
		int arr2[] = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(lenAfteremoveDupsFromSortedArr(arr1));
		System.out.println(lenAfteremoveDupsFromSortedArr(arr2));
		
	}
}