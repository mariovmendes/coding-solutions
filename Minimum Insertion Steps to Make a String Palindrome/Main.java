public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.minInsertions("ccewnxhytsr"));
    }
}



class Solution {
    public int minInsertions(String s) {
        int alternating = alternatingInsertions(s);
        int total = 0, j = s.length()-1;
        for(int i=0;i<j;i++){
            j = s.length()-i-1;
            if(s.charAt(i) != s.charAt(j)){
                total += 1;
                s = s.substring(0, j+1) + s.charAt(i) + s.substring(j+1, s.length());
                i--;
            }
        }
        return Math.min(total,alternating);
    }


    public int alternatingInsertions(String s) {
        int total = 0, j = s.length()-1, side = 0;
        for(int i=0;i<j;i++){
            j = s.length()-i-1;
            if(side == 0) {
                if(s.charAt(i) != s.charAt(j)){
                    total += 1;
                    String cpyS = "";
                    String firstPart = s.substring(0, j+1);
                    String secondPart = s.substring(j+1, s.length());
                    cpyS += s.charAt(i);
                    if(s.charAt(i) == s.charAt(i+1)){
                        int n = i+1;
                        while(s.charAt(n)==s.charAt(i)){
                            cpyS += s.charAt(i);
                            n++;
                        }
                        side = -1;
                    }
                    s = firstPart + cpyS + secondPart;
                }
                side++;
            } else {
                if(s.charAt(i) != s.charAt(j)){
                    total += 1;
                    String cpyS = "";
                    String firstPart = s.substring(0, i);
                    String secondPart = s.substring(i, s.length());
                    cpyS += s.charAt(i);
                    if(s.charAt(j) == s.charAt(j-1)){
                        int n = j-1;
                        while(s.charAt(n)==s.charAt(j)){
                            cpyS += s.charAt(j);
                            n--;
                        }
                    }
                    s = firstPart + cpyS + secondPart;
                }
                side--;
            }
            
        }
        return total;
    }

    /*public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","");
        s = s. toLowerCase();
        System.out.println(s);
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i) != s.charAt(j))
              return false;
        }


        return true;
    }*/
}