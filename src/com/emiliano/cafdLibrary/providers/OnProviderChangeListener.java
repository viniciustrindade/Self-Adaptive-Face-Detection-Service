package com.emiliano.cafdLibrary.providers;


public interface OnProviderChangeListener {
	public void onProviderDescriptorChange(String providerName,FaceDetectorDescriptor descriptor);
}
