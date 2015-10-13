package com.emiliano.cafdLibrary.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.emiliano.cafdLibrary.Face;
import com.emiliano.cafdLibrary.FacePosition;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;

public class ImageHelper {
    public static Bitmap loadBitmapFromUri(
            Uri imageUri,
            ContentResolver contentResolver) throws FileNotFoundException{
    	InputStream imageInputStream = contentResolver.openInputStream(imageUri);
		Bitmap bitmap = BitmapFactory.decodeStream(imageInputStream, null, null);
		return bitmap;
    }
    
    // Draw detected face rectangles in the original image. And return the image drawn.
    // If drawLandmarks is set to be true, draw the five main landmarks of each face.
    public static Bitmap drawFaceRectanglesOnBitmap(
            Bitmap originalBitmap, Face[] faces) {
        Bitmap bitmap = originalBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        int stokeWidth = Math.max(originalBitmap.getWidth(), originalBitmap.getHeight()) / 100;
        if (stokeWidth == 0) {
            stokeWidth = 1;
        }
        paint.setStrokeWidth(stokeWidth);

        if (faces != null) {
            for (Face face : faces) {
                canvas.drawRect(getRect(face.getFacePosition()),
                        paint);
            }
        }

        return bitmap;
    }
    
    // Crop the face thumbnail out from the original image.
    // For better view for human, face rectangles are resized to the rate faceRectEnlargeRatio.
    public static Bitmap generateFaceThumbnail(
            Bitmap originalBitmap,
            Face face) throws IOException {
    	Rect faceRect = getRect(face.getFacePosition());

        return Bitmap.createBitmap(
                originalBitmap, faceRect.left, faceRect.top, faceRect.right-faceRect.left, faceRect.bottom-faceRect.top);
    }

    public static Rect getRect(FacePosition facePosition){
    	if(facePosition!=null)
    		return new Rect(facePosition.left, facePosition.top, facePosition.right, facePosition.bottom);
    	else
    		return null;
    }
    
}
