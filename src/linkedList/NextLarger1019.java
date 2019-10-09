package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author yanglong09
 * @date 2019/10/8.
 */
public class NextLarger1019 {
    /**
     * 2 1 5
     * 5 5 0
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        HashMap<Integer, ArrayList<Integer>>  stats = new HashMap<>();

        int index = -1;
        while (head!=null){
            index++;
            if(!stats.containsKey(head.val)){
                stats.put(head.val, new ArrayList<>());
            }
            ArrayList<Integer> list = stats.get(head.val);
            list.add(index);
            head = head.next;
        }

        int[] res = new int[index];



        return res;
    }

    public static void main(String[] args) {
        NextLarger1019 nextLarger1019 = new NextLarger1019();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        int[] res = nextLarger1019.nextLargerNodes(head);
        System.out.println(Arrays.toString(res));
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}