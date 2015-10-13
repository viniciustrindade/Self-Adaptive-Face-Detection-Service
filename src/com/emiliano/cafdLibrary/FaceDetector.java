package com.emiliano.cafdLibrary;

import java.io.FileNotFoundException;

import com.emiliano.cafdLibrary.providers.FaceDetectorDescriptor;

import android.net.Uri;

public interface FaceDetector {
	
	public FaceDetectionResult detect(Uri image) throws FaceDetectionException,FileNotFoundException;
}
