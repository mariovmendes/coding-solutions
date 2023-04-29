import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        
        Solution solution = new Solution();
        //ListNode firstList = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        //ListNode secondList = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode firstList = null;
        ListNode secondList = new ListNode(0, null);
        solution.printNodeList(solution.mergeTwoLists(firstList,secondList));
    }
}


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;

        ListNode result = new ListNode(-1,null);
        ListNode firstPos = result;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                result.next = new ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                result.next = new ListNode(list2.val, null);;
                list2 = list2.next;
            }
            result = result.next;
        }

        if(list1 == null)
            result.next = list2;
        else if(list2 == null)
            result.next = list1;

        return firstPos.next;
    }

    public void printNodeList(ListNode l){
        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }
    } 
}