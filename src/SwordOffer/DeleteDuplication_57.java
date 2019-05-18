package SwordOffer;

/*删除排序链表的重复节点*/
public class DeleteDuplication_57 {
    public static void main(String[] args) {
        Node head = new Node(4);
        Node nNext = head.next = new Node(4);
        Node n2Next = nNext.next = new Node(4);
        Node n3Next = n2Next.next = new Node(4);
        Node n4Next = n3Next.next = new Node(4);
        Node n5Next = n4Next.next = new Node(4);
        Node n6Next = n5Next.next = new Node(4);

        deleteDuplication(head);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void deleteDuplication(Node node){
        if(node==null){
            return;
        }

        Node now = node;

        while (now!=null) {
            Node pre = now;
            int len = 1 ;
            while (now.next!=null&&(now.next.val==now.val)){
                len++;
                now = now.next;
            }

            if(len>1){
                now = pre.next = now.next;
            }else{
                now = now.next;
            }
        }
    }
}
