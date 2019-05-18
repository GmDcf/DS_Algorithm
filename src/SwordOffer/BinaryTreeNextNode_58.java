package SwordOffer;


/*find next node of gigen node in the tree within inOder*/
public class BinaryTreeNextNode_58 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rLeft = root.left=new TreeNode(2);
        rLeft.left= new TreeNode(4);
        TreeNode rLR = rLeft.right = new TreeNode(5);
        rLR.left=new TreeNode(7);
        rLR.right =new TreeNode(8);
        TreeNode rRight = root.right=new TreeNode(3);
        rRight.left=new TreeNode(6);
        rRight.right=new TreeNode(7);

        TreeNode next = findNextInTree(root,rLeft);
        if(next!=null){
            System.out.println(next.val);
        }else {
            System.out.println("null");
        }

    }

    public static TreeNode findNextInTree(TreeNode root, TreeNode node){
        if(root==null){
            return null;
        }

        if(node.right!=null){
            node = node.right;
            while (node!=null){
                node = node.left;
            }
            return node;
        }else{
            //节点是父节点的左子节点，返回父节点
            //否则 向上寻找到第一个 节点是其父节点的子节点的节点
        }

        return node;
    }
}
