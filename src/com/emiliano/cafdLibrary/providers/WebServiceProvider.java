package com.emiliano.cafdLibrary.providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;

import com.emiliano.cafdLibrary.FaceDetectionException;
import com.emiliano.cafdLibrary.FaceDetectionResult;
import com.emiliano.cafdLibrary.FaceDetector;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

public abstract class WebServiceProvider extends JsonHttpResponseHandler implements FaceDetectorProvider{

	private SyncHttpClient httpClient;
	private String url;
	private String[][] headers;

	public WebServiceProvider(String url,String[][] headers){
		this.url=url;
		this.headers=headers;
		this.httpClient = new SyncHttpClient();
		for(String[] header:this.headers)
			this.httpClient.addHeader(header[0],header[1]);
	}

	private WebServiceResult result;
	private FaceDetectionException exception;

	@Override
	public FaceDetectionResult detect(Uri image) throws FileNotFoundException,FaceDetectionException {
		this.exception=null;
		this.result=null;
		RequestParams requestParams = getRequestParams(image);//RequestParamnew RequestParams();
		httpClient.post(url,requestParams, this);
		if(this.exception!=null)
			throw this.exception;
		return result;
	}
	
	@Override
	public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
		try{
			this.result=parseResponse(response);
		}catch(Exception exception){
			this.exception=new FaceDetectionException(exception);
		}
    }

	@Override
	public void onFailure(int statusCode, Header[] headers,
			String responseString, Throwable throwable) {
		super.onFailure(statusCode, headers, responseString, throwable);
		this.exception=new FaceDetectionException(new Exception(responseString,throwable));
	}

	protected File fromUriToFile(Uri uri){
		return new File(uri.getPath());
	}
	
	protected RequestParams getRequestParams(Uri image) throws FileNotFoundException {
		RequestParams params = new RequestParams();
		params.put("image", fromUriToFile(image));
		return params;
	}
	
	protected abstract WebServiceResult parseResponse(JSONObject response)  throws JSONException;
}
