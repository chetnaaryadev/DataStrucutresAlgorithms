package DailyProblem;

import java.util.Arrays;

public class MoveZero {

    public static void main(String[] args) {
        int[] nums = {1,0,3,0,5};
        System.out.println("Maxiumm profits from buy and sell stocks " + Arrays.toString(moveAllZeroes(nums)));

    }

    private static int[] moveAllZeroes(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums;

        boolean flag = Arrays.stream(nums).anyMatch(x -> x==0);
        if(!flag)
            return nums;

        int posNonZero =0;
        int posZero = Integer.MAX_VALUE;
        boolean passedZero= false;
        for(int i=0;i<n;i++){

            if(nums[i]  != 0){
                posNonZero =i;
                if(passedZero){
                    nums[posZero] = nums[posNonZero];
                    nums[posNonZero] = 0;
                    passedZero = false;
                    posZero = posNonZero;
                }
            }else{
                passedZero = true;
                posZero = Math.min(posZero, i);
            }
        }
        return nums;
    }

    public static void moveZeroes(int[] nums){

        int insertPos = 0;

        for(int i=0;i<nums.length;i++){

            if(nums[i] != 0){

                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;

                insertPos++;
            }
        }
    }
}
