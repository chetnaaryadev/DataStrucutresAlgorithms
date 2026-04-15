package Search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 15, 18, 20, 30};
        int[] arr1 = {10, 15, 15,18, 20, 20,20};
        int[] arr3 = {10, 10,10};
        int[] arr4 = {0, 0, 0,1, 1, 1,1};
        int[] arr5 = {1,10, 15, 20,40, 60, 80,100,200,500,1000, 1100, 1250,1270};
        int[] arr6 = {10, 15, 18, 20, 30,5,7,9};
        int res = bSearch(arr,15);
        int a = 20, b= 10, c= 25;
        System.out.println("Index of number 15 in array is : "+ res);
        System.out.println("First occurrence of number "+ a+" in array is : "+ firstOccurence(arr1,a));
        System.out.println("First occurrence of number "+ b+" in array is : "+ firstOccurenceOptimized(arr3,b));
        System.out.println("last occurrence of number "+ a+" in array is : "+ lastOccurrenceOptimized(arr1,a));
        System.out.println("Count occurrence of number "+ a +" in array is : "+ countOccurrenceOptimized(arr1,a));
        System.out.println("Count 1 in array is : "+ count1inSortedArray(arr4));
        System.out.println("Square root of "+c+" is : " + squareRoot(c));
        System.out.println("Index of 100 in a assumed infinite array is : " + searchInInfiniteSizedArray(arr5,100));
        System.out.println("index of 7 in rotated sorted array is : " + binarySearchInRotatedSortedArray(arr6,7));
    }

    public static int bSearch(int[] arr, int num) {
        int n = arr.length;
        int high = n-1, low =0;
        int mid = 0;
        while(low<=high){
             mid = (high + low)/2;
            if(arr[mid] == num)
                return mid;
            else if(arr[mid]> num)
                high = mid -1;
            else if(arr[mid]< num)
                low = mid+1;
        }
        return mid;
    }

    public static int firstOccurence(int[] arr, int num) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] == num)
                return i;
        }
           return -1;
    }

    public static int firstOccurenceOptimized(int[] arr, int num) {
        int n = arr.length;
        int high = n-1, low =0;
        int mid = 0;
        while(low<=high){
            mid = (high + low)/2;
            if(arr[mid]> num)
                high = mid -1;
            else if(arr[mid]< num)
                low = mid+1;
            else {
                if(mid == 0 || arr[mid-1] != arr[mid])
                    return mid;
                else
                    high = mid -1;
            }
        }
        return -1;
    }

    public static int lastOccurrenceOptimized(int[] arr, int num) {
        int n = arr.length;
        int high = n-1, low =0;
        int mid = 0;
        while(low<=high){
            mid = (high + low)/2;
            if(arr[mid]> num)
                high = mid -1;
            else if(arr[mid]< num)
                low = mid+1;
            else {
                if(mid != n-1 || arr[mid] != arr[mid+1])
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static int countOccurrenceOptimized(int[] arr, int num) {
        int first = firstOccurenceOptimized(arr,num);
        if(first == -1)
            return 0;
        else
            return (lastOccurrenceOptimized(arr,num) - first +1);

    }

    public static int count1inSortedArray(int[] arr) {
        int n = arr.length;
        int high = n-1, low =0;
        while(low<=high){
          int  mid = (high + low)/2;
            if(arr[mid] == 0)
                low = mid +1;
            else {
                if(mid == 0 || arr[mid-1] == 0)
                    return n-mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static int squareRoot(int n) {
        int high = n, low =0, ans = -1;
        while(low<=high){
            int  mid = (high + low)/2;
            int mySq = mid * mid;
            if(mySq == n)
                return mid;
            else if (mySq > n) {
                high = mid -1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static int searchInInfiniteSizedArray(int[] arr,int n) {
        if (arr[0] == n)
            return 0;
        int i =1;
        while(arr[i]<n){
            i = i*2;
        }
        if(arr[i] == n)
            return i;
        return binarySearch(arr,n,i/2 + 1, i-1);
    }

    public static int binarySearch(int[] arr, int num,int low, int high) {
        int n = arr.length;
        int mid = 0;
        while(low<=high){
            mid = (high + low)/2;
            if(arr[mid] == num)
                return mid;
            else if(arr[mid]> num)
                high = mid -1;
            else if(arr[mid]< num)
                low = mid+1;
        }
        return mid;
    }

    public static int binarySearchInRotatedSortedArray(int[] arr, int num) {
        int n = arr.length;
        int mid = 0, low =0, high = n-1;
        while(low<=high){
            mid = (high + low)/2;
            if(arr[mid] == num)
                return mid;
           if(arr[low] <= arr[mid]){
               if(num >= arr[low] && num < arr[mid]){
                   high = mid -1;
               }else{
                   low = mid + 1;
               }
           }
           else {
               if(num > arr[mid] && num <= arr[high]){
                   low = mid +1;
               }else{
                   high = mid -1;
               }
           }
        }
        return -1;
    }


}
