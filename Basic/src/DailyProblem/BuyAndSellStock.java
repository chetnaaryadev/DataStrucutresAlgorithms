package DailyProblem;

import java.util.Arrays;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = {5,5,5,5};
        System.out.println("Maxiumm profits from buy and sell stocks " + buySellStockSecondAttempt(nums));

    }

    private static int buySellStockMy(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
       // find the minimum and maxium index
        int low = nums[0];
        int min = 0, max =0;
        int minCount =0, maxCount =0;
        for(int i=1;i<n;i++){
            min = Math.min(low,nums[i]);
            if(min < low){
                minCount=i;
                low = min;
            }
        }

        if(minCount == n-1)
            return 0;
        int high = nums[minCount];
        for(int i=minCount+1;i<n;i++){
            max = Math.max(high,nums[i]);
            if(max > high){
                maxCount =i;
                high = max;
            }
        }

        return nums[maxCount] - nums[minCount];
    }

    private static int buySellStockSecondAttempt(int[] nums) {
        //minimum price so far
        //maximum profit so far.
        int n = nums.length;
        if(n == 1)
            return 0;
        int min = nums[0], max =0;
        for(int i=1;i<n;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max, nums[i]-min);
        }
        return max;
    }




}
