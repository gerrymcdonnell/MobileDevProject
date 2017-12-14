package com.opengl20.demo1;



/* Justin's Tutorials
 * https://www.youtube.com/watch?v=OtQBTUZeVv8
 * */


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Bundle;
import android.util.Log;

public class DemoActivity1 extends Activity {
	
	MainSurfaceView mainSurfaceView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		
		
		super.onCreate(savedInstanceState);
		
		//check to see if the device supports open GL2
		ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
		ConfigurationInfo info = am.getDeviceConfigurationInfo();		
		boolean supportES2 = (info.reqGlEsVersion >= 0x20000);		
		
		if (supportES2==true) {		
		
			/*
			 * create new surfaceview and new renderer
			 * set surfaceview to use opengl 2.0
			 * set the renderer of the surfaceview to be the new render we created
			 * set the contentview to the surfaceview object
			 */
			
			//create instance of a Renderer class which does the drawing
			MainRenderer mainRenderer = new MainRenderer();
			
			//create a surface view and pass in context
			mainSurfaceView = new MainSurfaceView(this);
			
			//set the openGL version to 2
			mainSurfaceView.setEGLContextClientVersion(2);
			//set the renderer
			
			mainSurfaceView.setRenderer(mainRenderer);
			
			//set the view on the screen
			this.setContentView(mainSurfaceView);			
		}
		else{
			Log.e("OpenGLES 2", "Your device does not support OpenGLES2. (Current Version: " + info.reqGlEsVersion + ")");
		}

	}
	
	
	@Override
	protected void onResume()
	{
	    // The activity must call the GL surface view's onResume() on activity onResume().
	    super.onResume();
	    mainSurfaceView.onResume();
	}
	 
	@Override
	protected void onPause()
	{
	    // The activity must call the GL surface view's onPause() on activity onPause().
	    super.onPause();
	    mainSurfaceView.onPause();
	}
	
}
