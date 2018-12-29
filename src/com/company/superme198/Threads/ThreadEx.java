package com.company.superme198.Threads;

public class ThreadEx implements Runnable {
    @Override
    public void run() {
        System.out.println("thanh tai nguyen");
    }

    public static void main(String...args){

        Thread t = new Thread(new ThreadEx());
        t.start();

    }
}
