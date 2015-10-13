package com.emiliano.cafdLibrary;

import java.util.Set;
import java.util.TreeSet;

/**
* Descriptor of the available features, i.e. the service interface, of a FaceDetector object. 
*
* @author Emiliano Sanchez
*/

public class ServiceFeatures {
	
	public enum Feature{
		FACEPOSITION_DETECTION,
		FACEORIENTATION_DETECTION,
		LANDMARK_DETECTION,
		GENDER_CLASSIFICATION,
		AGE_CLASSIFICATION,
		RACE_CLASSIFICATION,
		OPENCLOSEEYES_CLASSIFICATION,
		SMILE_CLASSIFICATION,
		FACIALEXPRESSIONS_CLASSIFICATION
	}
	
	private boolean[] features;
	
	public ServiceFeatures(){
		this.features=new boolean[Feature.values().length];
		this.features[Feature.FACEPOSITION_DETECTION.ordinal()]=true;
	}
	
	public ServiceFeatures(Feature[] features){
		this();
		for(Feature feature:features){
			this.features[feature.ordinal()]=true;
		}
	};
	
	public ServiceFeatures(Feature feature){
		this(new Feature[]{feature});
	};
	
	public void addFeature(Feature feature){
		this.features[feature.ordinal()]=true;
	}
	
	public void removeFeature(Feature feature){
		this.features[feature.ordinal()]=false;
	}
	
	public boolean hasFeature(Feature feature){
		return this.features[feature.ordinal()];
	}
	
	public Feature[] getFeatures(){
		Set<Feature> features=new TreeSet<Feature>();
		for(int i=0;i<this.features.length;i++){
			if(this.features[i]==true)
				features.add(Feature.values()[i]);
		}
		return features.toArray(new Feature[features.size()]);
	}
}
