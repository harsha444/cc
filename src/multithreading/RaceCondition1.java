package multithreading;

import java.util.Random;

class RaceCondition1 {
    public static void main(String[] args) throws InterruptedException {
        RaceCondition.runTest();
    }
}

class RaceCondition {
    int randInt;

    Random random = new Random(System.currentTimeMillis());

    void printer() {
        int i = 100000;
        while (i != 0) {
                if (randInt % 5 == 0) {
                    System.out.println(randInt);
                }
            i--;
        }
    }

    void modifier() {
        int i = 100000;
        while (i != 0) {
                randInt = random.nextInt(1000);
                i--;
        }
    }

    public static void runTest() throws InterruptedException {
        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(rc::printer);
        Thread thread2 = new Thread(rc::modifier);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
