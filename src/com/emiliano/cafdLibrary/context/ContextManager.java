package com.emiliano.cafdLibrary.context;

import java.util.LinkedList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.util.Log;

import com.emiliano.cafdLibrary.context.ContextState.BatteryState;
import com.emiliano.cafdLibrary.context.ContextState.ConnectivityState;

public class ContextManager extends BroadcastReceiver{
	
	private Context androidContext;
	private List<OnContextChangeListener> listeners;
	private ContextState currentContextState;
	
	private BatteryManager batteryManager;
	private ConnectivityManager connectivityManager;
	
	public ContextManager(Context androidContext){
		this.androidContext=androidContext;
		this.listeners=new LinkedList<OnContextChangeListener>();
		
		this.batteryManager=(BatteryManager) this.androidContext.getSystemService(Context.BATTERY_SERVICE);
		this.connectivityManager=(ConnectivityManager) this.androidContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		this.androidContext.registerReceiver(this, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
		Log.i("CAFD","ContextManager was created");
		this.currentContextState=new ContextState(BatteryState.MEDIUM_BATTERY, ConnectivityState.WIFI_CONNECTION);
	}
	public ContextState getContextState(){
		return currentContextState;
	};
	
	public void setOnContextChangeListener(OnContextChangeListener listener){
		listeners.add(listener);
	}
	@Override
	public void onReceive(Context context, Intent intent) {
        Log.d("CAFD", "Network connectivity change");

        if (intent.getExtras() != null) {
            final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo ni = connectivityManager.getActiveNetworkInfo();

            if (ni != null && ni.isConnectedOrConnecting()) {
                Log.i("CAFD", "Network " + ni.getTypeName() + " connected");
            } else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE)) {
                Log.d("CAFD", "There's no network connectivity");
            }
        }
	};
	
//	private void notify(ContextChangeEvent event){
//		for(OnContextChangeListener listener:listeners)
//			listener.onContextChange(event);
//	}
	
}
