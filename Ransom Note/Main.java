import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a","b"));
    }
}



class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> containedChars = new HashMap<Character, Integer>();

        for(int i=0;i<ransomNote.length();i++){
            if(containedChars.get(ransomNote.charAt(i))==null)
                containedChars.put(ransomNote.charAt(i),1);
            else containedChars.put(ransomNote.charAt(i),containedChars.get(ransomNote.charAt(i)) + 1);
        }

        for(int i=0;i<magazine.length();i++){
            if(containedChars.get(magazine.charAt(i))!=null)
              containedChars.put(magazine.charAt(i),containedChars.get(magazine.charAt(i)) - 1);
        }

        for (Character i : containedChars.keySet()) {
            if(containedChars.get(i) > 0)
                return false;
        }

        return true;
    }
}