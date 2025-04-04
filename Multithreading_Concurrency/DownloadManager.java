package Multithreading_Concurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DownloadManager {

    // synchronous to control access to shared resources
    // Only one thread can access this method at any given time
    private static synchronized void logDownload(String fileName) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Download Completed: " + fileName + " @ " + now.format(formatter));
    }

    // Must Implement runnable, Thread requires a runnable in constructor
    // When running thread.start() it calls this classes run() function
    static class DownloadTask implements Runnable {
        private String fileName;
        private int downloadTime;


        /**
         * Constructor
         * @param fileName (String)
         * @param downloadTime (int)
         */
        public DownloadTask(String fileName, int downloadTime) {
            this.fileName = fileName;
            this.downloadTime = downloadTime;
        }

        /**
         * Simulated Downloading a file
         */
        public void run() {
            try {
                System.out.println("Starting Download: " + fileName);
                Thread.sleep(downloadTime);
                logDownload(fileName);
            } catch (InterruptedException e) {
                System.err.println("Download Interrupted: " + fileName);
            }

        }
    }

    
}
