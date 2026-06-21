package DailyProblem;

import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {-1,-1};
        System.out.println("Does this array contains duplicate values : " + conatinsDuplicate(nums));

    }

    private static boolean conatinsDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1 || n ==0)
            return false;

        HashSet<Integer> val = new HashSet<>();
        for (int num : nums) {
            if (val.contains(num))
                return true;
            else
                val.add(num);
        }

        return false;
    }
}
