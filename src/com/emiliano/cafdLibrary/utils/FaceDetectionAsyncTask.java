package com.emiliano.cafdLibrary.utils;

import java.io.FileNotFoundException;

import com.emiliano.cafdLibrary.FaceDetectionException;
import com.emiliano.cafdLibrary.FaceDetectionResult;
import com.emiliano.cafdLibrary.FaceDetector;
import com.emiliano.cafdLibrary.providers.FaceDetectorDescriptor;

import android.net.Uri;
import android.os.AsyncTask;

public class FaceDetectionAsyncTask extends AsyncTask<Uri, Integer, FaceDetectionResult>{

	private FaceDetector faceDetector;
	private OnFaceDetectionDone callback;
	private FaceDetectionException exception;
	
	public FaceDetectionAsyncTask(FaceDetector faceDetector,OnFaceDetectionDone callback){
		this.faceDetector=faceDetector;
		this.callback=callback;
	}

	@Override
	protected FaceDetectionResult doInBackground(Uri... params) {
		FaceDetectionResult result = null;
		try {
			result=faceDetector.detect(params[0]);
		} catch (FaceDetectionException e){
			this.exception=e;
		} catch (Exception e){
			this.exception=new FaceDetectionException(e);
		}
		return result;
	}

	protected void onPostExecute(FaceDetectionResult result) {
        if(result==null)
        	this.callback.onFailure(exception);
        else
        	this.callback.onSucced(result);
    }
}
