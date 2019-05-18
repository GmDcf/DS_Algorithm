package SwordOffer;

public class EntryOfLoopInLink_56 {


    public static void main(String[] args) {
        Node head = new Node(1);
        Node nNext = head.next = new Node(2);
        Node n2Next = nNext.next = new Node(3);
        Node n3Next = n2Next.next = new Node(4);
        Node n4Next = n3Next.next = new Node(5);
        Node n5Next = n4Next.next = new Node(6);
        n5Next.next = n2Next;

        System.out.println(findEntryOfLoop(head).val);
    }

    public static Node findEntryOfLoop(Node head){
        // first find a node in loop
        // then calculate the num of loop
        // last find the entry
        Node node = nodeInLoop(head);
        if(node!=null){
            int lenOfLoop = 1;  //初始长度1
            Node start = node;
            while (node.next!=start){
                lenOfLoop++;
                node = node.next;
            }

            Node after = head;
            Node before = head;
            while (lenOfLoop>0){
                before = before.next;
                lenOfLoop--;
            }

            while (after!=before){
                after = after.next;
                before = before.next;
            }
            return after;

        }else {
            return null;
        }

    }

    public static Node nodeInLoop(Node head){
        if(head==null){
            return null;
        }

        Node slow = head.next;
        if(slow==null){
            return null;
        }

        Node fast = slow.next;
        while (fast!=null&&slow!=null){
            if(fast==slow){
                return slow;
            }else {
                slow = slow.next;
                if(fast.next==null){
                    return null;
                }else {
                    fast = fast.next.next;
                }
            }
        }
        return null;
    }

}
class Node{
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }
}