package com.emiliano.cafdLibrary.test;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.emiliano.cafdLibrary.ContextAwareFaceDetector;
import com.emiliano.cafdLibrary.FaceDetectionException;
import com.emiliano.cafdLibrary.FaceDetectionResult;
import com.emiliano.cafdLibrary.ServiceFeatures;
import com.emiliano.cafdLibrary.ServiceQualityPolicy;
import com.emiliano.cafdLibrary.utils.FaceDetectionAsyncTask;
import com.emiliano.cafdLibrary.utils.OnFaceDetectionDone;

public class MinimalCafdActivity extends Activity implements OnFaceDetectionDone{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        android.content.Context appContext = this.getApplicationContext();
        ContextAwareFaceDetector faceDetector = new ContextAwareFaceDetector(appContext);
    
        ServiceFeatures requiredServiceFeatures = new ServiceFeatures();
        faceDetector.setRequiredServiceFeatures(requiredServiceFeatures);
        
        ServiceQualityPolicy serviceQualityPolicy = new ServiceQualityPolicy();
        faceDetector.setServiceQualityPolicy(serviceQualityPolicy);
        
        FaceDetectionAsyncTask detectionTask=new FaceDetectionAsyncTask(faceDetector, this);
        Uri input=Uri.parse("/storage/sdcard0/DCIM/Camera/picture1.jpg");
        detectionTask.execute(input);
    }
	
	@Override
	public void onSucced(FaceDetectionResult result) {
		Log.i("CAFDSimpleActivity", "Face detection succeeded with the following result: "+result.getStringResult());
	}

	@Override
	public void onFailure(FaceDetectionException exception) {
		Log.i("CAFDSimpleActivity", "Face detection failed with the following exception: "+exception.getMessage());
	}

}