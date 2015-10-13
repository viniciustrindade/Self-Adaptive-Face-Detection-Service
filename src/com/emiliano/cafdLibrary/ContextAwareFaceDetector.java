package com.emiliano.cafdLibrary;

import java.io.FileNotFoundException;

import android.content.Context;
import android.net.Uri;

import com.emiliano.cafdLibrary.ServiceFeatures.Feature;
import com.emiliano.cafdLibrary.context.ContextManager;
import com.emiliano.cafdLibrary.context.ContextState;
import com.emiliano.cafdLibrary.context.ContextState.BatteryState;
import com.emiliano.cafdLibrary.context.ContextState.ConnectivityState;
import com.emiliano.cafdLibrary.context.OnContextChangeListener;
import com.emiliano.cafdLibrary.planning.FMBasedPlanner;
import com.emiliano.cafdLibrary.planning.Planner;
import com.emiliano.cafdLibrary.providers.FaceDetectorDescriptor;
import com.emiliano.cafdLibrary.providers.FaceDetectorProvider;
import com.emiliano.cafdLibrary.providers.OnProviderChangeListener;
import com.emiliano.cafdLibrary.providers.ProviderManager;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextAwareFaceDetector.
 */
public class ContextAwareFaceDetector implements FaceDetector,OnContextChangeListener,OnProviderChangeListener{

	/** The context manager. */
	private ContextManager contextManager;
	
	/** The current context state. */
	private ContextState currentContextState;
	
	/** The provider manager. */
	private ProviderManager providerManager;
	
	/** The face detector providers. */
	private FaceDetectorProvider[] providers;
	
	/** The planner. */
	private Planner planner;
	

	
	/** The required service features. */
	private ServiceFeatures requiredServiceFeatures;
	
	/** The service quality policy. */
	private ServiceQualityPolicy serviceQualityPolicy;
	
	/** The current face detector. */
	private FaceDetector currentFaceDetector;

	/**
	 * Instantiates a new context aware face detector.
	 *
	 * @param androidContext the android context
	 * @param requiredServiceFeatures the required service features
	 * @param serviceQualityPolicy the service quality policy
	 */
	public ContextAwareFaceDetector(Context androidContext,
			ServiceFeatures requiredServiceFeatures,
			ServiceQualityPolicy serviceQualityPolicy){

		this.contextManager=new ContextManager(androidContext);
		this.contextManager.setOnContextChangeListener(this);
		this.currentContextState=this.contextManager.getContextState();
		
		this.providerManager=new ProviderManager(androidContext);
		this.providers=this.providerManager.getProviders();
		
		this.requiredServiceFeatures=requiredServiceFeatures;
		this.serviceQualityPolicy=serviceQualityPolicy;
		
		this.planner=new FMBasedPlanner();
		this.planner.setContextState(currentContextState);
		this.planner.setProviders(this.providers);
		this.planner.setRequiredServiceFeatures(requiredServiceFeatures);
		this.planner.setServiceQualityPolicy(serviceQualityPolicy);
		
		this.currentFaceDetector=this.planner.selectBestFaceDetector();
	}

	/**
	 * Instantiates a new context aware face detector.
	 *
	 * @param androidContext the android context
	 */
	public ContextAwareFaceDetector(Context androidContext){
		this(androidContext,new ServiceFeatures(),new ServiceQualityPolicy());
	}

	/* (non-Javadoc)
	 * @see com.emiliano.cafdLibrary.FaceDetector#detect(android.net.Uri)
	 */
	@Override
	public FaceDetectionResult detect(Uri image) throws FaceDetectionException, FileNotFoundException {
		return this.currentFaceDetector.detect(image);
	};
	
	/* (non-Javadoc)
	 * @see com.emiliano.cafdLibrary.context.OnContextChangeListener#onBatteryStateChange(com.emiliano.cafdLibrary.context.ContextState.BatteryState, com.emiliano.cafdLibrary.context.ContextState.BatteryState)
	 */
	@Override
	public void onBatteryStateChange(BatteryState newBatteryState,
			BatteryState pastBatteryState) {
		this.currentContextState.batteryState=newBatteryState;
		this.planner.onBatteryStateChange(newBatteryState,pastBatteryState);
		this.currentFaceDetector=this.planner.selectBestFaceDetector();
	}

	/* (non-Javadoc)
	 * @see com.emiliano.cafdLibrary.context.OnContextChangeListener#onConnectivityStateChange(com.emiliano.cafdLibrary.context.ContextState.ConnectivityState, com.emiliano.cafdLibrary.context.ContextState.ConnectivityState)
	 */
	@Override
	public void onConnectivityStateChange(
			ConnectivityState newConnectivityState,
			ConnectivityState pastConnectivityState) {
		this.currentContextState.connectivityState=newConnectivityState;
		this.planner.onConnectivityStateChange(newConnectivityState,pastConnectivityState);
		this.currentFaceDetector=this.planner.selectBestFaceDetector();
	}
	
	/* (non-Javadoc)
	 * @see com.emiliano.cafdLibrary.providers.OnProviderChangeListener#onProviderDescriptorChange(int, com.emiliano.cafdLibrary.providers.FaceDetectorDescriptor)
	 */
	@Override
	public void onProviderDescriptorChange(String providerName,
			FaceDetectorDescriptor descriptor) {
		this.planner.onProviderDescriptorChange(providerName,descriptor);
		this.currentFaceDetector=this.planner.selectBestFaceDetector();
	}
	
	/**
	 * Gets the required service features.
	 *
	 * @return the required service features
	 */
	public ServiceFeatures getRequiredServiceFeatures() {
		return requiredServiceFeatures;
	}

	/**
	 * Sets the required service features.
	 *
	 * @param requiredServiceFeatures the new required service features
	 */
	public void setRequiredServiceFeatures(ServiceFeatures requiredServiceFeatures) {
		this.requiredServiceFeatures = requiredServiceFeatures;
		this.planner.setRequiredServiceFeatures(requiredServiceFeatures);
		this.currentFaceDetector=this.planner.selectBestFaceDetector();
	}

	/**
	 * Gets the service quality policy.
	 *
	 * @return the service quality policy
	 */
	public ServiceQualityPolicy getServiceQualityPolicy() {
		return serviceQualityPolicy;
	}

	/**
	 * Sets the service quality policy.
	 *
	 * @param serviceQualityPolicy the new service quality policy
	 */
	public void setServiceQualityPolicy(ServiceQualityPolicy serviceQualityPolicy) {
		this.serviceQualityPolicy = serviceQualityPolicy;
		this.planner.setServiceQualityPolicy(serviceQualityPolicy);
		this.currentFaceDetector=this.planner.selectBestFaceDetector();
	}

}
