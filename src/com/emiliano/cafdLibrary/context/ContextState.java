package com.emiliano.cafdLibrary.context;

public class ContextState {
	public enum ConnectivityState{
		NO_CONNECTION,
		_3G_CONNECTION,
		_4G_CONNECTION,
		WIFI_CONNECTION
	}
	public enum BatteryState{
		NO_BATTERY,
		LOW_BATTERY,//<=10%
		MEDIUM_BATTERY,//10%<=50%
		HIGH_BATTERY,//50%<
		CHARGING
	}
	
	public ContextState(BatteryState batteryState,ConnectivityState connectivityState){
		this.batteryState=batteryState;
		this.connectivityState=connectivityState;
	}
	public BatteryState batteryState;
	public ConnectivityState connectivityState;
}
