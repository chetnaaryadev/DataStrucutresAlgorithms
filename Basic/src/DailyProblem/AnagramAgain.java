package DailyProblem;

import java.util.HashMap;
import java.util.Map;

public class AnagramAgain {

    public static void main(String[] args) {
        int[] nums = {5,5,5,5};
        System.out.println("Anagram of both strings: " + anagramStrings("lisren","silent"));

    }

    private static boolean anagramStrings(String s1, String s2) {
        if(s1.isEmpty() && s2.isEmpty())
            return true;

        if(s1.length() != s2.length())
            return false;

        HashMap<Integer, Character> map = new HashMap<>();
        for(char c: s1.toCharArray()){
                map.put(s1.indexOf(c),c);
        }
        for(char c: s2.toCharArray()){
            if(map.containsValue(c)){
                map.remove(s1.indexOf(c));
            }
        }

        if(map.isEmpty())
            return true;
        else
            return false;
    }

        public static boolean isAnagram(String s, String t) {

            if (s.length() != t.length())
                return false;

            Map<Character, Integer> map = new HashMap<>();

            // Count frequency of characters in first string
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Reduce frequency using second string
            for (char c : t.toCharArray()) {

                if (!map.containsKey(c))
                    return false;

                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0)
                    map.remove(c);
            }

            return map.isEmpty();
        }

            public static boolean isAnagramOptimal(String s, String t) {

                if (s.length() != t.length())
                    return false;

                int[] count = new int[26];

                for (int i = 0; i < s.length(); i++) {
                    count[s.charAt(i) - 'a']++;
                    count[t.charAt(i) - 'a']--;
                }

                for (int num : count) {
                    if (num != 0)
                        return false;
                }

                return true;
            }

}
