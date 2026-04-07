package Arrays;

import java.util.Arrays;

import static java.util.Collections.swap;

public class Array1 {

    public static void main(String[] args) {
         int[] arr = {10,15,18,20,30};
        int[] arr1 = {10,20,20,30,30,30,40,40,40,40};
        int[] arr2 = {10,0,18,0,30};
        int[] arr3 = {7,9,10,4,3,6,5,2};
         int res = largestElementOfArray(arr);
         boolean isSorted = isArraySorted(arr);
        System.out.println("Index of Largest element "+ arr[res]+" of Array is "+res);
        System.out.println("Is Given array sorted: "+ isSorted);

        reverseArray(arr);
        System.out.println("Reverse of given array : "+ Arrays.toString(arr));

        int distinctSize = removeDuplicatesFromSortedArray(arr1);

        System.out.println("Distinct size of array "+Arrays.toString(arr1)+ " is : "+ distinctSize);

        System.out.println("Before moving zeroes of array to the end: "+Arrays.toString(arr2));
        moveZeroes(arr2);
        System.out.println("After moving zeroes of array to the end: "+Arrays.toString(arr2));

        System.out.println("Before rotating array by 1: "+Arrays.toString(arr));
        leftRotateBy1(arr);
        System.out.println("After rotating array by 1"+Arrays.toString(arr));
        System.out.println("Leaders of arrays are ");
                leadersOfArray(arr3);
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

    public static void moveZeroes(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i =0; i< n;i++){
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count]= temp;
                count++;
            }
        }
    }

    public static void leftRotateBy1(int[] arr){
        int n = arr.length;
        int temp = arr[0];
        for (int i =1; i< n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]= temp;
    }

    public static void leadersOfArray(int[] arr){
        int n = arr.length;
        int max = arr[n-1];
        System.out.print(max+" ");
        for (int i =n-2; i >= 0;i--){
            if(arr[i]>max){
                System.out.print(arr[i]+" ");
                max = arr[i];
            }
        }
    }


}
