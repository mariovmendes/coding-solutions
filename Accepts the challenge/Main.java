public class Main {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.acceptTheChallenge(36060));
    }
}

class Solution{
    public long acceptTheChallenge(int k){
        int score = 0;
        for(int i=k;i>0;i--){
            int x = i;
            score += x;
            x *= 2;
            score += x;
            x *= 2;
            while(score < k){
                score += x;
                x *= 2;
            }
            if(score == k)
                return i;
            score = 0;
            x = 0;
        }
        return -1;
    }
}