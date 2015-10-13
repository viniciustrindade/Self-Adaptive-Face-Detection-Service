package com.emiliano.cafdLibrary.planning;

import com.emiliano.cafdLibrary.Face;
import com.emiliano.cafdLibrary.FaceDetectionResult;
import com.emiliano.cafdLibrary.providers.FaceImpl;

public class CompoundFaceDetectionResult implements FaceDetectionResult{

	private FaceImpl[] faces;
	private String stringResult;
	
	public CompoundFaceDetectionResult(FaceDetectionResult ...detectionResults){
		// TODO Auto-generated method stub
//		if(detectionResults!=null && detectionResults.length>0){
//			FaceDetectionResult detectionResult=detectionResults[0];
//			this.faces=new FaceImpl[detectionResult.getDetectedFaces().length];
//			
//		}
	}
	
	@Override
	public Face[] getDetectedFaces() {
		return faces;
	}

	@Override
	public String getStringResult() {
		return stringResult;
	}

}
