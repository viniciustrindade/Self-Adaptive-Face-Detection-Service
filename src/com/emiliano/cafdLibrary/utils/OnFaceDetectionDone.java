package com.emiliano.cafdLibrary.utils;

import com.emiliano.cafdLibrary.FaceDetectionException;
import com.emiliano.cafdLibrary.FaceDetectionResult;

public interface OnFaceDetectionDone {
	public void onSucced(FaceDetectionResult result);
	public void onFailure(FaceDetectionException exception);
}
