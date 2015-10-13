package com.emiliano.cafdLibrary.planning;

import com.emiliano.cafdLibrary.FaceDetector;
import com.emiliano.cafdLibrary.ServiceFeatures;
import com.emiliano.cafdLibrary.ServiceQualityPolicy;
import com.emiliano.cafdLibrary.context.ContextState;
import com.emiliano.cafdLibrary.context.ContextState.BatteryState;
import com.emiliano.cafdLibrary.context.ContextState.ConnectivityState;
import com.emiliano.cafdLibrary.providers.FaceDetectorDescriptor;
import com.emiliano.cafdLibrary.providers.FaceDetectorProvider;

public class FMBasedPlanner implements Planner{

	public FMBasedPlanner(){
		// TODO Auto-generated method stub
	}
	
	@Override
	public void onBatteryStateChange(BatteryState newBatteryState,
			BatteryState pastBatteryState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectivityStateChange(
			ConnectivityState newConnectivityState,
			ConnectivityState pastConnectivityState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDescriptorChange(String providerName,
			FaceDetectorDescriptor descriptor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContextState(ContextState currentContextState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProviders(FaceDetectorProvider[] providers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequiredServiceFeatures(
			ServiceFeatures requiredServiceFeatures) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServiceQualityPolicy(
			ServiceQualityPolicy serviceQualityPolicy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FaceDetector selectBestFaceDetector() {
		// TODO Auto-generated method stub
		return null;
	}

}
