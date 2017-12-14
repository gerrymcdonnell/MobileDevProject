package com.opengl20.demo3;



import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;

public class MyRenderer implements Renderer  {

	public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        // Set the background frame color to black i.e rgb alpha
		
		//black background
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		//red
		//GLES20.glClearColor(0.8f, 0.0f, 0.0f, 1.0f);
    }

    public void onDrawFrame(GL10 unused) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

}

