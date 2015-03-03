package com.elsennovraditya.memoryleak;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;

/**
 * Created by elsen on 2/26/15.
 */
public class FourthActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exampleOne();
//        exampleTwo();
    }

    private void exampleOne() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(1000);
                }
            }
        }.start();
    }

    private void exampleTwo() {
        new MyThread().start();
    }

    private static class MyThread extends Thread {

        private MyThread() {
        }

        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }

}
