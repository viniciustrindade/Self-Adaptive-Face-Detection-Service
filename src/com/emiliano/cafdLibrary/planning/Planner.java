package com.emiliano.cafdLibrary.planning;

import com.emiliano.cafdLibrary.FaceDetector;
import com.emiliano.cafdLibrary.ServiceFeatures;
import com.emiliano.cafdLibrary.ServiceQualityPolicy;
import com.emiliano.cafdLibrary.context.ContextState;
import com.emiliano.cafdLibrary.context.OnContextChangeListener;
import com.emiliano.cafdLibrary.providers.FaceDetectorProvider;
import com.emiliano.cafdLibrary.providers.OnProviderChangeListener;

public interface Planner extends OnContextChangeListener,OnProviderChangeListener{

	public void setContextState(ContextState currentContextState);

	public void setProviders(FaceDetectorProvider[] providers);

	public void setRequiredServiceFeatures(
			ServiceFeatures requiredServiceFeatures);

	public void setServiceQualityPolicy(
			ServiceQualityPolicy serviceQualityPolicy);

	public FaceDetector selectBestFaceDetector();

}
