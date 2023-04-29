public class Main
{
    public static void main(String[] args)
    {

    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        Hashtable<Integer, ArrayList<ListNode>> nodes = new Hashtable<>();
        while(head!=null){
            if(nodes.containsKey(head.val) && nodes.get(head.val).contains(head))
                return true;
            else {
                if(!nodes.containsKey(head.val))
                    nodes.put(head.val, new ArrayList<ListNode>());
                nodes.get(head.val).add(head);
                head = head.next;
            }
        }
        return false;
    }
}