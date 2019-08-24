package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * hashmap+doublelinkednode = lru
 * Created by yl on 2019/8/23.
 */
public class LruDouLinkedMap<T extends Comparable> {
    /**
     * 查找HashMap
     */
    private Map<T, DoubleLinkedNode<T>> lru = new HashMap<>();

    /**
     * 双向链表
     */
    private DoubleLink<T> doubleLink = new DoubleLink<>();
    /**
     * 缓存大小
     */
    private int size;

    public LruDouLinkedMap(int size) {
        this.size = size;
    }

    private DoubleLinkedNode<T> getValNode(T val){
        return lru.get(val);
    }

    public boolean hasVal(T val){
        return getValNode(val)==null;
    }

    /**
     * 获取缓存，并更新列表
     * @param val
     */
    public void getValInLru(T val){
        DoubleLinkedNode<T> node = getValNode(val);
        //1.has : insert into head
        if(node!=null){
            doubleLink.deleteNode(node);
            doubleLink.insertHead(node);
        }
        //2.no full?delete tail insert head :insert head
        else{
            DoubleLinkedNode<T> doubleLinkedNode = new DoubleLinkedNode<>(val);
            if(size>0){
                doubleLink.insertHead(doubleLinkedNode);
                size--;
            }else{
                DoubleLinkedNode<T> tail = doubleLink.deleteTail();
                lru.remove(tail.getVal());
                doubleLink.insertHead(doubleLinkedNode);
            }
            lru.put(doubleLinkedNode.getVal(),doubleLinkedNode);
        }
    }

    @Override
    public String toString() {
        return "LRUImpHashAndDoubleLinkedNode{" +
                "doubleLink=" + doubleLink +
                '}';
    }

    public static void main(String[] args) {
        LruDouLinkedMap<Integer> lru = new LruDouLinkedMap<>(5);
        System.out.println(lru.toString());
        lru.getValInLru(1);
        lru.getValInLru(2);
        System.out.println(lru.toString());
        lru.getValInLru(3);
        System.out.println(lru.toString());
        lru.getValInLru(1);
        System.out.println("update 1:::"+lru.toString());
        lru.getValInLru(4);
        lru.getValInLru(5);
        System.out.println(lru.toString());
        lru.getValInLru(6);
        System.out.println(lru.toString());
    }

}
