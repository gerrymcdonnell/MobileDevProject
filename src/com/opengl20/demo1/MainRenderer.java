package com.opengl20.demo1;

/*
http://www.learnopengles.com/android-lesson-one-getting-started/

Visualizing a 3D world

In this section, we’ll start looking at how OpenGL ES 2 works and how we can start drawing stuff onto the screen. 
In the activity we passed in a custom GLSurfaceView.Renderer to the GLSurfaceView, which will be defined here. 
The renderer has three important methods which will be automatically called by the system whenever events happen:

1 public void onSurfaceCreated(GL10 glUnused, EGLConfig config)
This method is called when the surface is first created. It will also be called if we lose our surface context and it is later recreated by the system.

2 public void onSurfaceChanged(GL10 glUnused, int width, int height)
This is called whenever the surface changes; for example, when switching from portrait to landscape. It is also called after the surface has been created.

3 public void onDrawFrame(GL10 glUnused)
This is called whenever it’s time to draw a new frame.
 */

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;

public class MainRenderer implements Renderer {

	
	//This is called whenever it’s time to draw a new frame.
	public void onDrawFrame(GL10 gl) {
		
		//clear the screen (red colour)		
		//R G B Alpha 100% opaque background colour will be this
		GLES20.glClearColor(0.8f, 0.0f, 0.0f, 1.0f);
		
		//clear the colours and the depth
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
		
	}

	
	//This is called whenever the surface changes; for example, when switching from portrait to landscape. 
	//It is also called after the surface has been created.
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	
	//This method is called when the surface is first created
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		
	}

}

