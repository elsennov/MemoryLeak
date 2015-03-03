package com.elsennovraditya.memoryleak;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by elsen on 2/26/15.
 */
public class SecondActivity extends Activity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    private String log = "Inside Inner Class";

    private InnerClass mInnerClass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInnerClass = new InnerClass(this);
        mInnerClass.showLog();
    }

//    private class InnerClass {
//
//        private void showLog() {
//            Log.d(TAG, log);
//        }
//
//    }

    private class InnerClass {

        SecondActivity mSecondActivity;

        private InnerClass(SecondActivity secondActivity) {
            mSecondActivity = secondActivity;
        }

        private void showLog() {
            Log.d(TAG, mSecondActivity.log);
            mSecondActivity = null;
        }

    }

}
