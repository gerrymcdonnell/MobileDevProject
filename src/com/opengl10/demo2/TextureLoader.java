package com.opengl10.demo2;

import java.io.IOException;

import javax.microedition.khronos.opengles.GL10;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;

public class TextureLoader {
	
	
	public static int loadTexture(String filename,AssetManager manager,GL10 gl)
	{
		Bitmap bitmap=null;
		
		//declare array
		int[]textureId=new int[1];
		textureId[0]=-7337;
		
		try {
			bitmap=BitmapFactory.decodeStream(manager.open(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d("texture loader","could not load file");
			
			//quit program
			System.exit(1);
		}
		// 1 texture
		gl.glGenTextures(1, textureId,0);
		
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId[0]);
		
		
		gl.glTexParameterf(
				GL10.GL_TEXTURE_2D, 
				GL10.GL_TEXTURE_MIN_FILTER, 
				GL10.GL_NEAREST
				);
		
		gl.glTexParameterf(
				GL10.GL_TEXTURE_2D, 
				GL10.GL_TEXTURE_MAG_FILTER, 
				GL10.GL_LINEAR
				);
		
		
		GLUtils.texImage2D(
				GL10.GL_TEXTURE_2D, 
				0, 
				bitmap, 
				0
				);
		
		//free mem
		bitmap.recycle();
		
		//return the texture id
		return textureId[0];
	}

}
