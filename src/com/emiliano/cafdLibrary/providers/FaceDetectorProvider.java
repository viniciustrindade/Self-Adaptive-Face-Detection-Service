package com.emiliano.cafdLibrary.providers;

import com.emiliano.cafdLibrary.FaceDetector;

public interface FaceDetectorProvider extends FaceDetector {
	public String getName();
	public FaceDetectorDescriptor getDescriptor();
}
