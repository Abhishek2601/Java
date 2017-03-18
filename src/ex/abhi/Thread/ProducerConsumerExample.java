package ex.abhi.Thread;

import java.util.LinkedList;

/**
 * Created by abhishekshukla on 1/27/17.
 */
public class ProducerConsumerExample {
    public static void main(String [] args) throws  InterruptedException{
        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

     static class PC{
        LinkedList<Integer> list = new LinkedList<>();
        int size = 2;

        public void produce() throws InterruptedException{
            int value = 0;
            while(true){
                synchronized (this){
                    while(list.size() == size)
                        wait();
                    System.out.println("Producer Produced - "+value);
                    list.add(value++);
                    notify();
                   Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException{
            while (true){
                synchronized (this){
                    while(list.size() == 0){
                        wait();
                    }
                    int val = list.removeFirst();
                    System.out.println("Consumer Consumed- "+val);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}


