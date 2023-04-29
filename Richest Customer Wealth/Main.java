public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] array = {{1,2,3},{1,2,3}};
        System.out.println(solution.maximumWealth(array));
    }
}



class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<accounts.length;i++){
            int sum = 0;
            for(int n=0;n<accounts[0].length;n++){
                sum += accounts[i][n];
            }
            if(sum > max)
                max = sum;
        }
        return max;
    }
}