package com.emiliano.cafdLibrary;

public class FaceExpression {
	public FaceExpression(String expressionName,float confidence){
		this.expressionName=expressionName;
		this.confidence=confidence;
	}
	
	public String expressionName;
	public float confidence;
}
