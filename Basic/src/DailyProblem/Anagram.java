package DailyProblem;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    public static void main(String[] args) {
        System.out.println("Using Brute force, the strings are anagram or not : " + naiveApproach("aabb","baba"));
    }

    public static boolean naiveApproach(String a, String b){
        char[] frequency = new char[1000];
        char[] frequency2 = new char[1000];
        for(char c: a.toCharArray()){
            frequency[c]++;
        }
        for(char c: b.toCharArray()){
            frequency2[c]++;
        }
        return Arrays.equals(frequency, frequency2);
    }

    public static boolean isAnagram(String a, String b){

        if(a.length() != b.length()){
            return false;
        }

        int[] freq = new int[26];

        for(char c : a.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : b.toCharArray()){
            freq[c - 'a']--;
        }

        for(int count : freq){
            if(count != 0){
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagramSorting(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static boolean isAnagramHashMap(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){

            map.put(c,
                    map.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray()){

            if(!map.containsKey(c)){
                return false;
            }

            map.put(c,map.get(c)-1);

            if(map.get(c) == 0){
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

}
