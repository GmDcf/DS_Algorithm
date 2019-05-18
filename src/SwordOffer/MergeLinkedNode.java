package SwordOffer;

public class MergeLinkedNode {
    public static LinkedNode merge(LinkedNode p1, LinkedNode p2){
        if(p1==null){
            return p2;
        }

        if(p2==null){
            return p1;
        }

        LinkedNode root;

        if(p1.value<=p2.value){
                 root = p1;
                root.next=merge(p1.next,p2);
        }else {
            root = p2;
            root.next = merge(p1, p2.next);
        }

        return root;
    }


    public static LinkedNode mergerCur(LinkedNode p1, LinkedNode p2){
         LinkedNode root=null, pre=null;

        LinkedNode node;
        while (p1!=null&&p2!=null){
            if(p1.value<=p2.value){
                node = p1;
                p1 = p1.next;
            }else {
                node = p2;
                p2= p2.next;
            }
            if(pre==null){
                pre = node;
                root = pre;
            }else {
                pre.next = node;
                pre = pre.next;
            }
         }

         if(p1==null){
               node = p2;
         }else {
             node = p1;
         }

         if(pre==null){
             root = node;
         }else {
             pre.next = node;
         }

        return root;
    }
    public static void main(String[] args) {
        LinkedNode root1 = new LinkedNode(0);
        root1.next = new LinkedNode(2);
        root1.next.next = new LinkedNode(4);

        LinkedNode root2 = new LinkedNode(1);
        root2.next = new LinkedNode(3);
        root2.next.next = new LinkedNode(5);

      //  LinkedNode root = merge(root1,root2);
        LinkedNode root = merge(root1, root2);
        while (root!=null){
            System.out.print(root.value+", ");
            root = root.next;
        }
    }
}
