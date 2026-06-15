package DailyProblem;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
       int[] nums = {2, 7, 11, 15};
        System.out.println("Using Brute force, the indexes of two sum are : " + Arrays.toString(getTwoSumBruteForce(nums, 9)));
        System.out.println("Using HashMap, the indexes of two sum are : " + Arrays.toString(getTwoSumUsingHashMap(nums, 9)));
    }

    public static int[] getTwoSumBruteForce(int[] arr,int sum){
        int[] res = new int[2];
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j] == sum){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    public static Integer[] getTwoSumUsingHashMap(int[] arr, int sum){
        HashMap<Integer, Integer> twoSumMap = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            int complacent = sum - arr[i];
            if(twoSumMap.containsValue(complacent)){
                twoSumMap.put(i,arr[i]);
                return twoSumMap.keySet().toArray(new Integer[2]);
            }else{
                twoSumMap.put(i,arr[i]);
            }
        }

        return twoSumMap.keySet().toArray(new Integer[0]);
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {

            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{
                        map.get(complement),
                        i
                };
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
