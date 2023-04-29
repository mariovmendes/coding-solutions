public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String[] strs = {"acc","aaa","aaba"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}



class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        int smallestSize = smallestSize(strs);
        String commonPrf = strs[0].substring(0,smallestSize);
        
        for(String nextString: strs){
            for(int i=0;i<commonPrf.length() && !commonPrf.equals("") && !commonPrf.equals(nextString.substring(0,smallestSize));i++){
                if(nextString.charAt(i) != commonPrf.charAt(i)){
                    commonPrf = commonPrf.substring(0,i);
                    break;
                }
            }
        }

        return commonPrf;
    }

    private int smallestSize(String[] strs){
        int size = strs[0].length();
        for(String nextString: strs)
            if(nextString.length() < size)
                size = nextString.length();
        
        return size;
    }
}
