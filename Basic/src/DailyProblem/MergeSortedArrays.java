package DailyProblem;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] num = {1,2,4,0,0,0};
        int[] num1 = {2,5,6};
        System.out.println("Using Brute force, the strings are anagram or not : " + Arrays.toString(mergeSortedArrayMy(num, 3, num1, 3)));
    }

    private static int[] mergeSortedArrayMy(int[] num, int i, int[] num1, int i1) {
        int n = num.length;
        int m = num1.length;
        int[] nums = new int[i+i1];

        if(n == 0 )
            return num1;

        if(m==0)
            return num;

        int low = 0, high = 0, count =0;
        while(count < (i+i1)){
            if(num[low] != 0 && num1[high]  != 0 && num[low] <= num1[high]){
                nums[count] = num[low];
                low++;
                count++;
            }else if(num[low] == 0){
                nums[count] = num1[high];
                high++;
                count++;
            }else  if(num1[high] == 0){
                nums[count] = num[low];
                low++;
                count++;
            }
            else{
                nums[count] = num1[high];
                high++;
                count++;
            }



        }


        return nums;
    }
    public static void merge(
            int[] nums1,
            int m,
            int[] nums2,
            int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0){

            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}
