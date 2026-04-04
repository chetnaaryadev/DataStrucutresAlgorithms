package Arrays;

import java.util.Arrays;

public class Array1 {

    public static void main(String[] args) {
         int[] arr = {10,15,18,20,30};
        int[] arr1 = {10,20,20,30,30,30,40,40,40,40};
         int res = largestElementOfArray(arr);
         boolean isSorted = isArraySorted(arr);
        System.out.println("Index of Largest element "+ arr[res]+" of Array is "+res);
        System.out.println("Is Given array sorted: "+ isSorted);

        reverseArray(arr);
        System.out.println("Reverse of given array : "+ Arrays.toString(arr));

        int distinctSize = removeDuplicatesFromSortedArray(arr1);

        System.out.println("Distinct size of array "+Arrays.toString(arr1)+ " is : "+ distinctSize);
        }


    public static int largestElementOfArray(int[] arr){
        int n = arr.length;
        int res =0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[res])
                res =i;
        }
        return res;
    }

    public static boolean isArraySorted(int[] arr){
        if(arr.length == 1)
            return true;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i])
                return false;
        }
        return true;
    }

    public static void reverseArray(int[] arr){
        int n = arr.length;
        int low =0, high = n-1;
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static int removeDuplicatesFromSortedArray(int[] arr){
        int n = arr.length;
        int res = 1;
        for(int i=1;i<n;i++){
            if(arr[i] != arr[res-1]){
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }

}
