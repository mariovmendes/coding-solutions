import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}



class Solution {
    public String longestPalindrome(String s) {
        if(s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s))
            return s;
        String max = s.charAt(0)+"";
        String word = "";
        for(int i=0;i<s.length();i++){
            word += s.charAt(i);
            for(int j=i+1;j<s.length() && word.length() >= max.length();j++){
                word += s.charAt(j);
                if (word.length() > max.length() && isPalindrome(word))
                    max = word;
            }
            word = "";
        }

        return max;
    }

    private boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i) != s.charAt(j))
              return false;
        }


        return true;
    }
}
