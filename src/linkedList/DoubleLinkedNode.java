package linkedList;

/**
 * Created by yl on 2019/8/23.
 */
public class DoubleLinkedNode<T extends Comparable> {
    private T val;

    public DoubleLinkedNode<T> next;

    public DoubleLinkedNode<T> pre;

    public boolean hasNext(){
        return next==null;
    }

    public boolean hasPre(){
        return pre==null;
    }

    public DoubleLinkedNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
