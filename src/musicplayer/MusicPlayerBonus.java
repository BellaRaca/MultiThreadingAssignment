/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplayer;

/**
 * Extend MusicPlayerControllerMainTask code to allow the user to play the song
 * Twinkle Twinkle Little Start. The music tone for this song is as follows:
 *
 * do do sol sol la la sol fa fa mi mi re re do sol sol fa fa mi mi re sol sol
 * fa fa mi mi re do do sol sol la la sol fa fa mi mi re re do
 *
 * The two threads must coordinate to play the music tone. Thread 1 can only
 * play do, mi, sol, si, do-octave. Similarly, thread 2 can only play re, fa,
 * la, do-octave.
 *
 * @author bellarao
 */
public class MusicPlayerBonus {

    private static final Object LOCK = new Object();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                FilePlayer.play("./Sounds/do.wav");
                FilePlayer.play("./Sounds/do.wav");
                FilePlayer.play("./Sounds/sol.wav");
                FilePlayer.play("./Sounds/sol.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/sol.wav");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // For rhythm
                }
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/mi.wav");
                FilePlayer.play("./Sounds/mi.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/do.wav");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // For rhythm
                }
                FilePlayer.play("./Sounds/sol.wav");
                FilePlayer.play("./Sounds/sol.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/mi.wav");
                FilePlayer.play("./Sounds/mi.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/sol.wav");
                FilePlayer.play("./Sounds/sol.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/mi.wav");
                FilePlayer.play("./Sounds/mi.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/do.wav");
                FilePlayer.play("./Sounds/do.wav");
                FilePlayer.play("./Sounds/sol.wav");
                FilePlayer.play("./Sounds/sol.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/sol.wav");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // For rhythm
                }
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/mi.wav");
                FilePlayer.play("./Sounds/mi.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/do.wav");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/la.wav");
                FilePlayer.play("./Sounds/la.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/fa.wav");
                FilePlayer.play("./Sounds/fa.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/re.wav");
                FilePlayer.play("./Sounds/re.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/fa.wav");
                FilePlayer.play("./Sounds/fa.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/re.wav");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // For rhythm
                }
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/fa.wav");
                FilePlayer.play("./Sounds/fa.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/re.wav");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // For rhythm
                }
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/la.wav");
                FilePlayer.play("./Sounds/la.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/fa.wav");
                FilePlayer.play("./Sounds/fa.wav");
                awakeAnotherThreadAndSleepCurrentThread();
                FilePlayer.play("./Sounds/re.wav");
                FilePlayer.play("./Sounds/re.wav");
                synchronized (LOCK) {
                    LOCK.notifyAll();
                }
            }
        });

        thread2.start();
        thread1.start();
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
