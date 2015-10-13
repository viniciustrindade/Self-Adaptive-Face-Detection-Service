package com.emiliano.cafdLibrary.providers;

/**
* Descriptor of the measured non-functional properties, i.e. the quality of service, of a FaceDetector object. 
*
* @author Emiliano Sanchez
*/

public class ServiceQuality {
	
	public ServiceQuality(int measuredResponseTime,int measuredBatteryUsage,double measuredAccuracy){
		this.measuredResponseTime=measuredResponseTime;
		this.measuredBatteryUsage=measuredBatteryUsage;
		this.measuredAccuracy=measuredAccuracy;
	}
	
	public final int measuredResponseTime;
	public final int measuredBatteryUsage;
	public final double measuredAccuracy;
}
