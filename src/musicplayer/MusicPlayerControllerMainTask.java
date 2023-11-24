/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musicplayer;

/**
 * Write a Multi-threaded Java application with two threads to play the provided
 * tones as follows:
 *
 * Thread 1 will play do, mi, sol, si, do-octave.
 *
 * Thread 2 will play re, fa, la, do-octave.
 *
 * Notice that you have to synchronize the two threads so that the user will
 * hear do, re, mi, fa, sol, la, si, do-octave in the right sequence. Also, the
 * do-octave tone should be played with the two threads at the same time.
 *
 * @author bellarao
 */
public class MusicPlayerControllerMainTask {

    private static final Object LOCK = new Object();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                FilePlayer.play("./Sounds/do.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/mi.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/sol.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/si.wav");
                synchronized (LOCK) {
                    LOCK.notifyAll();
                }
                FilePlayer.play("./Sounds/do-octave.wav");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/re.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/fa.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/la.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/do-octave.wav");
            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * Awake the other thread and sleep the current thread.
     */
    private static void awakeAnotherThreadAndSleepCurrentThread() {
        try {
            synchronized (LOCK) {
                LOCK.notifyAll();
                LOCK.wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
