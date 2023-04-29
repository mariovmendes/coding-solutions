public class Main {
    
}

class SmallestInfiniteSet {

    int smallest;
    int[] infiniteset = new int[1000];

    public SmallestInfiniteSet() {
        smallest = 0;
        for(int i=0;i<1000;i++)
            infiniteset[i] = 1;
    }
    
    public int popSmallest() {
        int result = smallest+1;
        infiniteset[smallest] = 0;
        smallest = findNextSmallest();
        return result;
    }
    
    public void addBack(int num) {
        infiniteset[num-1] = 1;
        if(num-1 < smallest)
            smallest = num-1;
    }

    private int findNextSmallest() {
        for(int i=0;i<1000;i++){
            if (infiniteset[i] == 1){
                return i;
            }
        }
        return -1;
    }
}
