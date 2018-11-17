import java.util.*;
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

	public static int bestTimetoBuyandSellStockII(int[] prices){
		 int max_profit = 0;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i] < prices[i+1]) max_profit += prices[i+1] - prices[i];
        }
        return max_profit;
	}

	//Array right rotation given no. of rotation (k) eg. k =3
	public static void rightRotation(int[] arr, int k){
		k = k%arr.length;
		simpleInPlaceArrayReversal(0, arr.length-1, arr);
		simpleInPlaceArrayReversal(0, k-1, arr);
		simpleInPlaceArrayReversal(k, arr.length-1, arr);
	}

	//Array left rotation given no. of rotation (k) eg. k=3
	public static void leftRotation(int[] arr, int k){
		k = k%arr.length;
		simpleInPlaceArrayReversal(0, k-1, arr);
		simpleInPlaceArrayReversal(k, arr.length-1, arr);
		simpleInPlaceArrayReversal(0, arr.length-1, arr);
	}

	public static void simpleInPlaceArrayReversal(int start, int end, int[] arr){
		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static Character firstNonRepeating(String str){
		HashMap<Character, Integer> store = new HashMap<Character, Integer>();
		int resultIndx = Integer.MAX_VALUE;
		for(int i = 0; i < str.length(); i++){
			if(!store.containsKey(str.charAt(i))){
				store.put(str.charAt(i),i);
			}else{
				store.put(str.charAt(i),-1);
			}
		}
		for(HashMap.Entry<Character, Integer> entry : store.entrySet()){
			System.out.println(entry.getKey()+": "+entry.getValue());
			if(entry.getValue() >= 0){
				resultIndx = Math.min(resultIndx, entry.getValue());
			}
		}
		return str.charAt(resultIndx);
	}

	public static void display(int[] arr){
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("*****************END********************");
	}
	public static void main(String[] args){
		int arr1[] = {1,1,2};
		int arr2[] = {0,0,1,1,1,2,2,3,3,4};
		int brr1[] = {7,1,5,3,6,4};
		int brr2[] = {1,2,3,4,5};
		int brr3[] = {7,6,4,3,1};
		simpleInPlaceArrayReversal(0, brr3.length-1, brr3);
		display(brr3);
		rightRotation(brr1, 3);
		leftRotation(brr1, 3);
		display(brr1);
		System.out.println("E".equals("e"));
		System.out.println(firstNonRepeating("Geeksforgeeks"));
		// System.out.println(lenAfteremoveDupsFromSortedArr(arr1));
		// System.out.println(lenAfteremoveDupsFromSortedArr(arr2));
		// System.out.println(bestTimetoBuyandSellStockII(brr1));
		// System.out.println(bestTimetoBuyandSellStockII(brr2));
		// System.out.println(bestTimetoBuyandSellStockII(brr3));

		
	}
}