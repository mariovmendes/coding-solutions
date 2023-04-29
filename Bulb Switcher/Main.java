import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class

public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.bulbSwitch(4)); 
    }
}



class Solution {
    /*public int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        int res = 0;
        for(int i=1;i<=n;i++){
            rounds(bulbs,i);
            if(bulbs[i-1])
                res++;
        }
        
        return res;
    }

    public void rounds(boolean[] list, int n){
        for(int i=n-1;i<list.length;i+=n){
            list[i] = !list[i];
        }
    }*/

    /*public int bulbSwitch(int n) {
        int res = 0;
        int cur = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    cur++;
            }
            if (cur % 2 != 0)
                res++;
            cur = 0;
        }

        return res;
    }*/

    public int bulbSwitch(int n) {
        HashMap<Integer, ArrayList<Integer>> multiples = new HashMap<Integer, ArrayList<Integer>>();
        int res = 0;

        for(int i=1;i<=n;i++){
            int m=0;
            for(int j=1;j<=i;j++){
                if(multiples.containsKey(i) && multiples.get(i).contains(i/j))
                    break;
                else if(i%j==0){
                    if(!multiples.containsKey(i))
                        multiples.put(i, new ArrayList<>());
                    multiples.get(i).add(j);
                    if(i!=j && !multiples.get(i).contains(i/j))
                        multiples.get(i).add(i/j);
                }
            }
            if(multiples.containsKey(i) )
                m += multiples.get(i).size();
            if(m%2!=0)
                res++;
        }

        /*for(int j=1;j<=n;j++){
            int m=1;
            for(int k=1;k*j<=n;k++){
                if(multiples.containsKey(k*j))
                    multiples.put(k*j, multiples.get(k*j) + 1);
                else
                    multiples.put(k*j, 1);
            }
        }
        
        for (int i : multiples.keySet()) {
            if(multiples.get(i)%2 != 0)
                res++;
        }*/

        return res;
    }
}