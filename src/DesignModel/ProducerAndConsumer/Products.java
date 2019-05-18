package DesignModel.ProducerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Products {
    LinkedList<Object> linkedList;
    int max;
    Lock lock;
    Condition empty;
    Condition full;

    public Products(LinkedList<Object> linkedList, int max, ReentrantLock lock) {
        this.linkedList = linkedList;
        this.max = max;
        this.lock = lock;
        this.empty = lock.newCondition();
        this.full = lock.newCondition();
    }

    public static void main(String[] args) {
        Products products = new Products(new LinkedList<>(), 3, new ReentrantLock());
        Producer[] producers = new Producer[3];
        Consumer[] consumers = new Consumer[3];

        for(int i=0; i<3; i++){
            producers[i] = new Producer(products);
            new Thread(producers[i]).start();
            consumers[i] = new Consumer(products);
            new Thread(consumers[i]).start();
        }
    }
}
