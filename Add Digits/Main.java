public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.addDigits(38));
    }
}


class Solution {
    public int addDigits(int num) {
        int res = num;
        while(res >= 10){
            res = stepProcess(res);
        }
        return res;
    }

    private int stepProcess(int num){
        int total = 0;
        while(num > 0){
            total += num % 10;
            num = num / 10;
        }
        return total;
    }
}