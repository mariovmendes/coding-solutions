public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4};
        System.out.println(sol.findKthPositive(arr, 2));
    }
}



class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] full = new int[arr[arr.length-1]];

        for(int i=0; i<arr.length;i++){
            full[arr[i]-1] = 1;
        }

        for(int i=0;i<full.length;i++){
            if(full[i] == 0){
                k--;
                if(k==0)
                    return i+1;
            }
        }

        return full.length+k;
    }
}