package Search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 15, 18, 20, 30};
        int res = bSearch(arr,15);
        System.out.println("Index of number 15 in array is : "+ res);
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

}
