package com.opengl10.demo2;



/* 
 * simple demo based on youtube tutorials the openGl 1.0
 * https://www.youtube.com/watch?v=suDX2W60A5E
 */

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

public class OpenGl1Activity2 extends Activity {
	
	MySurfaceView ourSurface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		MySurfaceView ourSurface=new MySurfaceView (this);
		setContentView(ourSurface);
		
	}

	
}
