import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading {

    /*
    -Create 26 threads each representing the alphabet and output each thread in alphabetical order
    using the wait and notifyall functions in a synchronized method that will add to an array when it becomes it's turn
    -Arraylist and Multithreading
    */

    static Object LOCK = new Object();
    static List<Character> alphabet = new ArrayList<Character>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(26);
        for(int i = 0; i < 26; i++){
            executor.submit(new Alpha((char)('a' + i), i));
        }
        executor.shutdown();
    }

    public static class Alpha extends Thread {

        private char letter;

        private int turn;

        public Alpha(char letter, int turn) {
            this.letter = letter;
            this.turn = turn;
        }
        public void run() {
            synchronized (LOCK) {
                while (turn != alphabet.size()) {
                    try {
                        System.out.println("Thread " + letter + " is waiting");
                        LOCK.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("Thread " + letter + " is adding " + letter);
                alphabet.add(letter);
                System.out.println("Alphabet contains " + alphabet);
                LOCK.notifyAll();
            }
        }
    }
}
