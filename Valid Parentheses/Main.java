public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("({[)"));
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0)
            return false;
        int sumLetter = 0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == '(')
                sumLetter = 1;
            else sumLetter = 2;
            for(int j=i+1;j<s.length();j+=2){
                if((s.charAt(i) + sumLetter) == s.charAt(j)) {
                    if(!isValid(s.substring(j+1, s.length())))
                        return false;
                    s = s.substring(0, j) + s.substring(j+1, s.length());
                    break;
                } 
                else if((j + 2) > s.length()-1)
                    return false;
            }
        }
        return true;
    }
}