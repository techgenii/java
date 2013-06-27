package com.practicejava.pingpong;

public class PingPong extends Thread {
    private String word;  // what word to print
    private int delay;    // how long to pause

    public PingPong(String whatToSay, int delayTime) {
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
        PingPong ping = new PingPong("ping",  33); // 1/30 second
        PingPong pong = new PingPong("PONG", 100); // 1/10 second
        
        System.out.println("Current Thread=" + Thread.currentThread().getName());
        
        ping.start();
        pong.start();
    }
}