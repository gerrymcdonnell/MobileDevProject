package com.opengl10.demo2;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MySurfaceView extends GLSurfaceView{

	public MySurfaceView(Context context) {
		super(context);
		
		//set for open Gl 1.0
		this.setEGLContextClientVersion(1);
		this.setRenderer(new MyRenderer(context));
		
	}

}
