package com.practicejava.runpingpong;

class RunPingPong implements Runnable {
    private String word;    // what word to print
    private int delay;      // how long to pause

    RunPingPong(String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }

    public void run() {
        try {
            for (;;) {
                System.out.print(word + " ");
                Thread.sleep(delay); // wait until next time
            }
        } catch (InterruptedException e) {
            return;             // end this thread
        }
    }

    public static void main(String[] args) {
        Runnable ping = new RunPingPong("ping",  33);
        Runnable pong = new RunPingPong("PONG", 100);
        Thread p1 = new Thread(ping);
        Thread p2 = new Thread(pong);
        
        p1.start();
        p2.start();
    }
}
