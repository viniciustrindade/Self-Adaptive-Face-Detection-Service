package com.emiliano.cafdLibrary.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import android.net.Uri;

import com.emiliano.cafdLibrary.FaceDetectionResult;
import com.emiliano.cafdLibrary.FaceDetector;

public class FaceDetectionFutureTask extends FutureTask<FaceDetectionResult> {

	private static class FaceDetectionCallable implements
			Callable<FaceDetectionResult> {

		private FaceDetector faceDetector;
		private Uri image;

		public FaceDetectionCallable(FaceDetector faceDetector, Uri image) {
			this.faceDetector = faceDetector;
			this.image = image;
		}

		@Override
		public FaceDetectionResult call() throws Exception {
			return faceDetector.detect(image);
		}

	}

	public FaceDetectionFutureTask(FaceDetector faceDetector, Uri image) {
		super(new FaceDetectionCallable(faceDetector,image));
	}

}
