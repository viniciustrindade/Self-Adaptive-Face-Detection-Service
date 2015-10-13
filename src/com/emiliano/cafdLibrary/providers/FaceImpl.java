package com.emiliano.cafdLibrary.providers;

import java.util.Set;

import com.emiliano.cafdLibrary.Face;
import com.emiliano.cafdLibrary.FaceExpression;
import com.emiliano.cafdLibrary.FaceLandmark;
import com.emiliano.cafdLibrary.FaceOrientation;
import com.emiliano.cafdLibrary.FacePosition;
import com.emiliano.cafdLibrary.FaceRace;

public class FaceImpl implements Face{

	private FacePosition facePosition;
	private FaceOrientation faceOrientation;
	private Set<FaceLandmark> faceLandmarks;
	private Float isLeftEyeOpenConfidence;
	private Float isRightEyeOpenConfidence;
	private Float isSmilingConfidence;
	private Float isFemaleConfidence;
	private Set<FaceExpression> faceExpressions;
	private Integer age;
	private FaceRace race;

	public void setFacePosition(FacePosition facePosition) {
		this.facePosition = facePosition;
	}

	public void setFaceOrientation(FaceOrientation faceOrientation) {
		this.faceOrientation = faceOrientation;
	}

	public void setFaceLandmarks(Set<FaceLandmark> faceLandmarks) {
		this.faceLandmarks = faceLandmarks;
	}

	public void setIsLeftEyeOpenConfidence(Float isLeftEyeOpenConfidence) {
		this.isLeftEyeOpenConfidence = isLeftEyeOpenConfidence;
	}

	public void setIsRightEyeOpenConfidence(Float isRightEyeOpenConfidence) {
		this.isRightEyeOpenConfidence = isRightEyeOpenConfidence;
	}

	public void setIsSmilingConfidence(Float isSmilingConfidence) {
		this.isSmilingConfidence = isSmilingConfidence;
	}
	
	public void setIsFemaleConfidence(Float isFemaleConfidence) {
		this.isFemaleConfidence = isFemaleConfidence;
	}
	
	public void setFaceExpressions(Set<FaceExpression> faceExpressions) {
		this.faceExpressions = faceExpressions;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setRace(FaceRace race) {
		this.race = race;
	}



	@Override
	public FacePosition getFacePosition() {
		return facePosition;
	}

	@Override
	public FaceOrientation getFaceOrientation() {
		return faceOrientation;
	}

	@Override
	public Set<FaceLandmark> getFaceLandmarks() {
		return faceLandmarks;
	}



	@Override
	public Float getIsLeftEyeOpenConfidence() {
		return isLeftEyeOpenConfidence;
	}

	@Override
	public Float getIsRightEyeOpenConfidence() {
		return isRightEyeOpenConfidence;
	}

	@Override
	public Float getIsSmilingConfidence() {
		return isSmilingConfidence;
	}

	@Override
	public Float getIsFemaleConfidence() {
		return isFemaleConfidence;
	}
	
	@Override
	public Set<FaceExpression> getFaceExpressions() {
		return faceExpressions;
	}

	@Override
	public Integer getAge() {
		return age;
	}

	@Override
	public FaceRace getRace() {
		return race;
	}
}
