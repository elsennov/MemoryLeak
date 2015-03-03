package com.elsennovraditya.memoryleak;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by elsen on 2/26/15.
 */
public class ThirdActivity extends Activity {

    private static final String TAG = ThirdActivity.class.getSimpleName();

    private String log = "Inside Inner Class";

    private final Handler mLeakyHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };

    /**
     * Instances of static inner classes do not hold an implicit
     * reference to their outer class.
     */
    private static class MyHandler extends Handler {

        private final WeakReference<ThirdActivity> mActivity;

        public MyHandler(ThirdActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ThirdActivity activity = mActivity.get();
            if (activity != null) {

            }
        }
    }

    private final MyHandler mHandler = new MyHandler(this);

    /**
     * Instances of anonymous classes do not hold an implicit
     * reference to their outer class when they are "static".
     */
    private static final Runnable sRunnable = new Runnable() {

        @Override
        public void run() {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Post a message and delay its execution for 10 minutes.
//        mLeakyHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.d(TAG, log);
//            }
//        }, 1000 * 60 * 10);

        // Post a message and delay its execution for 10 minutes.
        mHandler.postDelayed(sRunnable, 1000 * 60 * 10);

    }


}
