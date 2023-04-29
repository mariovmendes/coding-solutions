public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] array1 = {1,2,3,4};
        solution.runningSum(array1);
    }
}



class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] newArray = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            newArray[i] = sum;
        }
        return newArray;
    }
}