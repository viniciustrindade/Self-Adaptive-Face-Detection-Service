package com.emiliano.cafdLibrary.providers;

import com.emiliano.cafdLibrary.Face;
import com.emiliano.cafdLibrary.FaceDetectionResult;

public class WebServiceResult implements FaceDetectionResult{

	public WebServiceResult(String jsonResult,Face[] faces){
		this.jsonResult=jsonResult;
		this.faces=faces;
	};
	
	private String jsonResult;
	private Face[] faces;
	
	public String getJsonResult(){
		return jsonResult;
	};
	
	@Override
	public Face[] getDetectedFaces() {
		return faces;
	}

	@Override
	public String getStringResult() {
		return jsonResult;
	}
}
