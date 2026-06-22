package DailyProblem;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is the String valid Palindrome : " + IsPalindromeMy(s));
    }

    private static boolean IsPalindromeMy(String s) {
        if(s.isBlank())
            return true;
        if(s.length() == 1)
            return true;

       s= modifyString(s);
       int low = 0;
       int high = s.length()-1;
       char[] c = s.toCharArray();
       while(low<=high){
           if(c[low] != c[high])
               return false;

           low++;
           high--;
       }

       return true;
}
    private static String modifyString(String s) {
        //return s.trim().toLowerCase();
        StringBuilder mod = new StringBuilder();
        for(char c: s.toCharArray()){
          if(c == 44)
                continue;
          if(c == 32)
              continue;
          if(c == 58)
                continue;
            mod.append(c);
        }
        return mod.toString().toLowerCase();
    }

    public static boolean isPalindromeOptimal(String s) {

        if (s == null)
            return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
