package linkedList;

/**
 * Created by yl on 2019/8/23.
 */
public class DoubleLink<T extends Comparable> {

    private DoubleLinkedNode<T> head;

    private DoubleLinkedNode<T> tail;

    public DoubleLinkedNode<T> getHead() {
        return head;
    }

    public DoubleLinkedNode<T> getTail() {
        return tail;
    }

    /**
     * 查询节点,前提是没有重复节点，否则找到的就是第一个节点
     * @param val
     * @return
     */
    public DoubleLinkedNode<T> findValNode(T val){
        DoubleLinkedNode tmpNow = head;
        while (tmpNow!=null){
            if(tmpNow.getVal()!=null&&tmpNow.getVal().compareTo(val)==0){
                break;
            }else{
                tmpNow=tmpNow.next;
            }
        }
        return tmpNow;
    }

    /**
     * 插入位置节点pos后移，即pos.pre->node->pos
     * @param insertNode
     * @param pos
     * @param befOraft 插在节点前，还是后面
     */
    public void insertNode(DoubleLinkedNode<T> insertNode, DoubleLinkedNode<T> pos, boolean befOraft) {
        if (isEmpty()) {
            head = tail = insertNode;
            return;
        }

        if(pos==null){
            return;
        }

        DoubleLinkedNode<T> pre, aft;
        if(befOraft){
            pre = pos.pre;
            aft = pos;
        }else {
            pre = pos;
            aft = pos.next;
        }

        //插头
        if(pre==null){
            insertNode.next = aft;
            aft.pre = insertNode;
            head = insertNode;
            return;
        }

        //插尾
        if(aft==null){
            pre.next=insertNode;
            insertNode.pre=pre;
            tail=insertNode;
            return;
        }

        //中间插入
        pre.next=insertNode;
        insertNode.pre=pre;
        insertNode.next=aft;
        aft.pre=insertNode;
        return;
    }

    /**
     * 插入头部
     * @param node
     */
    public void insertHead(DoubleLinkedNode<T> node){
        insertNode(node,head,true);
    }

    /**
     * 插入尾部
     * @param node
     */
    public void insertTail(DoubleLinkedNode<T> node){
        insertNode(node,tail,false);
    }

    /**
     * 删除一个节点
     * @param doubleLinkedNode
     * @return
     */
    public  DoubleLinkedNode<T> deleteNode(DoubleLinkedNode<T> doubleLinkedNode){
        //通常是找到并删除，这里直接删除
        if(doubleLinkedNode!=null){
            DoubleLinkedNode<T> next = doubleLinkedNode.next;
            DoubleLinkedNode<T> pre = doubleLinkedNode.pre;
            //只有一个节点
            if(next==null&&pre==null){
                head=tail=null;
                return doubleLinkedNode;
            }

            //删除尾节点
            if(next!=null){
                next.pre=pre;
            }else{
                pre.next = null;
                tail = pre;
                doubleLinkedNode.pre=null;
                return doubleLinkedNode;
            }

            //删除头节点
            if(pre!=null){
                pre.next=next;
            }else{
                next.pre=null;
                head=next;
                doubleLinkedNode.next=null;
                return doubleLinkedNode;
            }

            //头尾非空，且不是同一个节点
            doubleLinkedNode.next=null;
            doubleLinkedNode.pre=null;
        }
        return doubleLinkedNode;
    }

    /**
     * 删除尾部
      * @return
     */
    public DoubleLinkedNode<T> deleteTail(){
        return deleteNode(tail);
    }

    /**
     * 删除头部
     * @return
     */
    public DoubleLinkedNode<T> deleteHead(){
        return deleteNode(head);
    }

    public DoubleLinkedNode deleteValNode(T val){
        DoubleLinkedNode<T> doubleLinkedNode = findValNode(val);
        return deleteNode(doubleLinkedNode);
    }


    /**
     * 链表为空
     * @return
     */
    public boolean isEmpty(){
        return head==null&&tail==null;
    }

    @Override
    public String toString() {
        return "DoubleLink{" +
                "head=" + head +
                '}';
    }
}
