public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.f2(nums,0,0));
    }
}



class Solution {
    public int f(int[] array) {
        int sum = 0;
        for(int v : array)
            sum += v;
        return sum;
    }

    public int f2(int[] array, int sum, int index){
        if(index != array.length){
            sum += array[index];
            index++;
            return f2(array, sum, index);
        } else {
            return sum;
        }
    }
}
