package DesignModel.ProducerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;

public class Producer implements  Runnable{
    static int num = 0;
    Products products;
    Producer(Products products ){
        this.products = products;
    }
    @Override
    public void run(){
        while (true) {
            try {
                products.lock.lock();
                while (products.linkedList.size() == products.max) {
                    products.empty.await();
                }
                Thread.sleep(100);
                products.linkedList.add(new Object());
                System.out.println("生产第" + num++ + "个产品");
                products.full.signalAll();
            } catch (InterruptedException ex) {

            } finally {
                products.lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
