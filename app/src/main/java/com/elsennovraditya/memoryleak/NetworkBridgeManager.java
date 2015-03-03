package com.elsennovraditya.memoryleak;

import java.util.ArrayList;

/**
 * Created by elsen on 2/26/15.
 */
public class NetworkBridgeManager {

    private static final String TAG = NetworkBridgeManager.class.getSimpleName();

    private static volatile NetworkBridgeManager instance;

    public static NetworkBridgeManager getInstance() {
        if (instance == null) {
            synchronized (NetworkBridgeManager.class) {
                if (instance == null) {
                    final NetworkBridgeManager tmp = new NetworkBridgeManager();
                    instance = tmp;
                }
            }
        }
        return instance;
    }

    public NetworkBridgeManager() {

    }

    private final ArrayList<NetworkObserver> observers = new ArrayList<>();

    public void register(NetworkObserver observer) {
        observers.add(observer);
    }

    public void unregister(NetworkObserver observer) {
        observers.remove(observer);
    }

    public void notifyClient(boolean available) {
        for (NetworkObserver observer : observers) {
            observer.onConnectionChange(available);
        }
    }

}