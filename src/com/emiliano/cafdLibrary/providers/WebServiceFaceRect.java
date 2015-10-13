package com.emiliano.cafdLibrary.providers;

import java.io.FileNotFoundException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;

import com.emiliano.cafdLibrary.FaceDetectionResult;
import com.emiliano.cafdLibrary.FacePosition;
import com.emiliano.cafdLibrary.ServiceFeatures;
import com.emiliano.cafdLibrary.ServiceFeatures.Feature;
import com.loopj.android.http.RequestParams;

public class WebServiceFaceRect extends WebServiceProvider{
	
	public WebServiceFaceRect() {
		super("https://apicloud-facerect.p.mashape.com/process-file.json",
				new String[][]{{"X-Mashape-Key","XXX"}});
	};
	
	
	@Override
	public FaceDetectorDescriptor getDescriptor() {
		// TODO Auto-generated method stub
		return new FaceDetectorDescriptor("Face Rect", 
				new ServiceFeatures(new ServiceFeatures.Feature[]{Feature.FACEPOSITION_DETECTION}), 
				new ServiceQuality(100, 100, 0.5));
	}
	
	@Override
	protected WebServiceResult parseResponse(JSONObject response) throws JSONException {
		JSONArray jfaces=response.getJSONArray("faces");
		FaceImpl[] faces=new FaceImpl[jfaces.length()];	
		for(int i=0;i<jfaces.length();i++){
			org.json.JSONObject jface=jfaces.getJSONObject(i);
			FaceImpl face=new FaceImpl();
			face.setFacePosition(new FacePosition(jface.getInt("x"),jface.getInt("y"), jface.getInt("x")+jface.getInt("width"), jface.getInt("y")+jface.getInt("height")));
			faces[i]=face;
		}
		return new WebServiceResult(response.toString(), faces);
	}
	
	@Override
	protected RequestParams getRequestParams(Uri image)
			throws FileNotFoundException {
		return super.getRequestParams(image);
	}


	@Override
	public String getName() {
		return "Face Rect";
	}
}
