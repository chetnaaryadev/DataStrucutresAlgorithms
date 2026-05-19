package Search;

import java.util.HashMap;
import java.util.Map;

public class Searching {

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 3, 2,2};
        int[] arr1 = {10, 15, 15, 18, 20, 20, 20};

        System.out.println("Repeating element is : " + repeatingElement1(arr,6));
    }
    public static int repeatingElement(int[] arr, int l){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],0);
        for(int i=1;i<l;i++){
            if(map.containsKey(arr[i]))
                return arr[i];
            else
                map.put(arr[i],0);
        }
        return -1;
    }

    public static int repeatingElementOptimized(int[] arr, int n) {
        boolean[] visited = new boolean[n];

        for (int num : arr) {
            if (visited[num])
                return num;

            visited[num] = true;
        }

        return -1;
    }
}
