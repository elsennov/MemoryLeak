package com.elsennovraditya.memoryleak;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class MainActivity extends ActionBarActivity implements NetworkObserver {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkBridgeManager.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        NetworkBridgeManager.getInstance().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onConnectionChange(boolean available) {

    }

}
