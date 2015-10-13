package com.emiliano.cafdLibrary.providers;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;

public class ProviderManager {

	private Context androidContext;
	private List<OnProviderChangeListener> listeners;
	private FaceDetectorProvider[] providers;

	private static Class[] providerClasses = new Class[] { WebServiceFaceRect.class };

	public ProviderManager(Context androidContext) {
		this.androidContext = androidContext;
		this.listeners = new LinkedList<OnProviderChangeListener>();
		this.providers = new FaceDetectorProvider[providerClasses.length];
		for (int i = 0; i < providerClasses.length; i++) {
			try {
				this.providers[i] = (FaceDetectorProvider) (providerClasses[i]
						.getConstructor().newInstance());
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}

	public void setOnContextChangeListener(OnProviderChangeListener listener) {
		listeners.add(listener);
	}

	public FaceDetectorProvider getProvider(int index) {
		return providers[index];
	}
	
	public FaceDetectorProvider getProvider(String name) {
		for (int i = 0; i < providers.length; i++) {
			if(providers[i].getName().equals(name))
				return providers[i];
		}
		return null;
	}

	public FaceDetectorProvider[] getProviders() {
		return providers;
	}
	
	public int getNumberOfProviders() {
		return providers.length;
	}

}
