package com.emiliano.cafdLibrary.context;

import com.emiliano.cafdLibrary.context.ContextState.BatteryState;
import com.emiliano.cafdLibrary.context.ContextState.ConnectivityState;

public interface OnContextChangeListener {
	public void onBatteryStateChange(BatteryState newBatteryState,BatteryState pastBatteryState);
	public void onConnectivityStateChange(ConnectivityState newConnectivityState,ConnectivityState pastConnectivityState);
}
