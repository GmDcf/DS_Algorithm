package SwordOffer;

class TreeNode {

        public int val;
       public TreeNode left;
        public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
    //对该节点中序遍历
    public String toString(){
        String leftStr = left==null?"":left.toString();
        String rightStr = right==null?"":right.toString();
        return leftStr+""+val+""+rightStr;
    }
}
