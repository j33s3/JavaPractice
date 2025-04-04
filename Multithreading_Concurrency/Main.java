package Multithreading_Concurrency;


public class Main {


    public static void main(String[] args) {

        // Creating Three threads to tackle Downloading Files
        Thread t1 = new Thread(new DownloadManager.DownloadTask("file1.zip", 3000));
        Thread t2 = new Thread(new DownloadManager.DownloadTask("file2.zip", 5000));
        Thread t3 = new Thread(new DownloadManager.DownloadTask("file3.zip", 2000));

        // Starting Those threads
        t1.start();
        t2.start();
        t3.start();

        try {
            // Tells the main thread to wait for each other thread to finish executuin
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println("Thread Interrupted: " + e);
        }

        System.out.println("All downloads completed!");
    }
    
}
