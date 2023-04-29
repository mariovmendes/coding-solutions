public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] arr = {2,2};
        sol.lastStoneWeight(arr);
    }
}



class Solution {
    public int lastStoneWeight(int[] stones) {
        while(stones.length != 1)
            stones = squash(stones); 
        return stones[0];
    }

    private int[] squash(int[] stones){
        int iMax = -1, max = Integer.MIN_VALUE;
        for(int i=0;i<stones.length;i++){
            if(stones[i] > max){
                iMax = i;
                max = stones[i];
            }
        }
        int iSMax = -1, sMax = Integer.MIN_VALUE;
        for(int i=0;i<stones.length;i++){
            if(stones[i] > sMax && i!=iMax){
                iSMax = i;
                sMax = stones[i];
            }
        }

        int[] res;
        if(sMax == max){
            if(stones.length == 2) return new int[1];
            res = new int[stones.length - 2];
        }
        else{
            res = new int[stones.length - 1];
            res[res.length-1] = max - sMax;
        }
        
        int resIndex = 0;
        for(int j=0;j<stones.length;j++){
            if(j != iSMax && j!= iMax){
                res[resIndex] = stones[j];
                resIndex++;
            }
        }
        return res;
    }
}