package DailyProblem;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,2,2};
        System.out.println("Majority element of array is : " + majorityElement(nums));

    }

    private static int majorityElementMy(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count >= n / 2)
                return nums[i];
            else
                count = 0;
        }
        return 0;
    }

    public static int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){

            map.put(num, map.getOrDefault(num,0) + 1);

            if(map.get(num) > nums.length/2){
                return num;
            }
        }

        return -1;
    }
}
