public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = {5,2,3,1};
        solution.sortArray(result);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        int[] auxVec = new int[nums.length];
        mergeSortR(nums,auxVec,0,nums.length-1);
        return nums;
    }

    protected static <E> void mergeSortR(int[] vec, int[] auxVec,
            int firstPos, int lastPos) {
        if (firstPos < lastPos) {
            int centre = (firstPos + lastPos) / 2;
            mergeSortR(vec, auxVec, firstPos, centre);
            mergeSortR(vec, auxVec, centre + 1, lastPos);
            mergeR(vec, auxVec, firstPos, centre, lastPos);
        }
    }

    protected static <E> void mergeR(int[] vec, int[] auxVec,
            int firstLeft, int lastLeft, int lastRight) {
        int left = firstLeft;
        int right = lastLeft + 1;
        int result = firstLeft;
        while (left <= lastLeft && right <= lastRight)
            if (vec[left] < vec[right])
                auxVec[result++] = vec[left++];
            else
                auxVec[result++] = vec[right++];
        // Copy rest of left sequence.
        while (left <= lastLeft)
            auxVec[result++] = vec[left++];
        // Rest of right sequence in right place.
        // Copy from auxVec to vec.
        // Number of elements to be copied: (result - 1) - firstLeft + 1.
        System.arraycopy(auxVec, firstLeft, vec, firstLeft, result - firstLeft);
    }
}
