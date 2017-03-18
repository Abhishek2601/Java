package ex.abhi.Thread;
import java.io.*;
import java.util.*;

/**
 * Created by abhishekshukla on 1/25/17.
 */
public class ThreadSynchronize {

    // A Java program to demonstrate working of
// synchronized.
    // A Class used to send a message

    public void send(String msg) {

        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}

    // Class for send a message using Threads
    class ThreadedSend extends Thread
    {
        private String msg;
        private Thread t;
        ThreadSynchronize  sender;

        // Recieves a message object and a string
        // message to be sent
        ThreadedSend(String m,  ThreadSynchronize obj)
        {
            msg = m;
            sender = obj;
        }

        public void run()
        {
            // Only one thread can send a message
            // at a time.
            synchronized(sender)
            {
                // synchronizing the snd object
                sender.send(msg);
            }
        }
    }

    // Driver class
    class SyncDemo
    {
        public static void main(String args[])
        {
            ThreadSynchronize snd = new ThreadSynchronize();
            ThreadedSend S1 =
                    new ThreadedSend( " Hi " , snd );
            ThreadedSend S2 =
                    new ThreadedSend( " Bye " , snd );

            // Start two threads of ThreadedSend type
            S1.start();
            S2.start();

            // wait for threads to end
            try
            {
                S1.join();
                S2.join();
            }
            catch(Exception e)
            {
                System.out.println("Interrupted");
            }
        }
    }

