package com.opengl10.demo1;



/* 
 * simple demo based on youtube tutorials the openGl 1.0
 * https://www.youtube.com/watch?v=JVr4eDNedbY&index=1&list=PLA78E46B65FF4BEAC
 */

/*open GL 1.0
 *  Triangle Demo
 */
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

public class OpenGL1Activity1 extends Activity {
	
	GLSurfaceView ourSurface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.activity_glexample);
		
		ourSurface=new GLSurfaceView(this);
		ourSurface.setRenderer(new GLRenderer());
		
		setContentView(ourSurface);	
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurface.onPause();
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurface.onResume();
	}
	
}
