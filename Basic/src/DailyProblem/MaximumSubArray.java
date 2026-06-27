package DailyProblem;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] subMax = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Sub maximum array : " + maxSubArray(subMax));
    }


    public static int maxSubArray(int[] nums){

        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i=1;i<nums.length;i++){

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
