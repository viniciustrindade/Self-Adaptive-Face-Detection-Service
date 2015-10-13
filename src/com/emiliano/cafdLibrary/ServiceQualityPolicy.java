package com.emiliano.cafdLibrary;

public class ServiceQualityPolicy {
	
	public ServiceQualityPolicy(double weightResponseTime,double weightBatteryUsage,double weightAccuracy){
		this.weightResponseTime=weightResponseTime;
		this.weightBatteryUsage=weightBatteryUsage;
		this.weightAccuracy=weightAccuracy;
	}
	
	public ServiceQualityPolicy(){
		this(1.0,0.0,0.0);
	}
	
	public final double weightResponseTime;
	public final double weightBatteryUsage;
	public final double weightAccuracy;
}
