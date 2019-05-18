package DesignModel.ProducerAndConsumer;

public class Consumer implements Runnable {
    static int num = 0;
    Products products;
    Consumer(Products products ){
        this.products = products;
    }
    @Override
    public void run(){
        while (true) {
            try {
                products.lock.lock();
                while (products.linkedList.size() == 0) {
                    products.full.await();
                }
                Thread.sleep(100);
                products.linkedList.removeLast();
                System.out.println("消费第" + num++ + "个产品");
                products.empty.signalAll();
            } catch (InterruptedException ex) {

            } finally {
                products.lock.unlock();
            }
        }
    }
}
