package Search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 15, 18, 20, 30};
        int[] arr1 = {10, 15, 15,18, 20, 20,20};
        int[] arr3 = {10, 10,10};
        int res = bSearch(arr,15);
        int a = 20, b= 10;
        System.out.println("Index of number 15 in array is : "+ res);
        System.out.println("First occurrence of number "+ a+" in array is : "+ firstOccurence(arr1,a));
        System.out.println("First occurrence of number "+ b+" in array is : "+ firstOccurenceOptimized(arr3,b));
        System.out.println("last occurrence of number "+ a+" in array is : "+ lastOccurrenceOptimized(arr1,a));

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

}
