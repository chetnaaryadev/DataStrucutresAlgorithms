package DailyProblem;

import java.util.Arrays;



public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println("Using Brute force, the indexes of two sum are : " + Arrays.toString(removeDuplicatesFromSortedArrayNaive(nums)));
        
    }

    private static int[] removeDuplicatesFromSortedArrayNaive(int[] nums) {

        int n = nums.length;
        if(n==1 || n==2)
            return nums;

        int val = nums[0];
        int count=0;
        for(int i=1;i<n;i++){
            if(val != nums[i]){
                count++;
                nums[count] = nums[i];
                val = nums[i];
            }
        }

        return nums;
    }

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0)
            return 0;

        int uniqueIndex = 0;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1;
    }
}
