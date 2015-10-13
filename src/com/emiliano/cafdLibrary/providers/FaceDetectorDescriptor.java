package com.emiliano.cafdLibrary.providers;

import com.emiliano.cafdLibrary.ServiceFeatures;

/**
* Descriptor of a FaceDetector object. This descriptor is compound by: 
* 	the provider name (Name property),
* 	the service interface (ServiceFeatures property),
* 	and the quality of service (serviceQuality property). 
*
* @author Emiliano Sanchez
*/

public class FaceDetectorDescriptor {
	
	private String name;
	private ServiceFeatures serviceFeatures;
	private ServiceQuality serviceQuality;
	
	public FaceDetectorDescriptor(String name,ServiceFeatures serviceFeatures,ServiceQuality serviceQuality){
		this.name=name;
		this.serviceFeatures=serviceFeatures;
		this.serviceQuality=serviceQuality;
	}
	
	public String getName(){
		return this.name;
	}

	public ServiceFeatures getServiceFeatures() {
		return serviceFeatures;
	}

	public ServiceQuality getServiceQuality() {
		return serviceQuality;
	}
	
}
