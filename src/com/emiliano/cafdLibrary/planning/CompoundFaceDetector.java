package com.emiliano.cafdLibrary.planning;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.net.Uri;

import com.emiliano.cafdLibrary.FaceDetectionException;
import com.emiliano.cafdLibrary.FaceDetectionResult;
import com.emiliano.cafdLibrary.FaceDetector;
import com.emiliano.cafdLibrary.utils.FaceDetectionFutureTask;

public class CompoundFaceDetector implements FaceDetector{
	
	private FaceDetector[] faceDetectors;
	private boolean parallelExecution=false;
	
	public CompoundFaceDetector(FaceDetector ... faceDetectors){
		this(false,faceDetectors);
	}
	
	public CompoundFaceDetector(boolean parallelExecution,FaceDetector ... faceDetectors){
		this.faceDetectors=faceDetectors;
		this.parallelExecution=parallelExecution;
	}
	
	@Override
	public FaceDetectionResult detect(Uri image) throws FaceDetectionException,
			FileNotFoundException {

		FaceDetectionResult[] results=new FaceDetectionResult[this.faceDetectors.length];
		
		if(parallelExecution==false){
			for(int i=0;i<faceDetectors.length;i++){
				results[i]=this.faceDetectors[i].detect(image);
			}
		}else{
			FaceDetectionFutureTask[] tasks=new FaceDetectionFutureTask[faceDetectors.length];
			ExecutorService executor = Executors.newFixedThreadPool(2);
	        
			for(int i=0;i<faceDetectors.length;i++){
				tasks[i]=new FaceDetectionFutureTask(faceDetectors[i],image);
				executor.execute(tasks[i]);
				
			}
			for(int i=0;i<faceDetectors.length;i++){
				try {
					results[i]=tasks[i].get();
				} catch (InterruptedException e) {
					throw new FaceDetectionException(e);
				} catch (ExecutionException e) {
					throw new FaceDetectionException(e);
				}
			}
		}
		
		return new CompoundFaceDetectionResult(results);
	}

}
