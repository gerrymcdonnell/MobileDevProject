package com.opengl10.demo2;



import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;


import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class MyRenderer implements Renderer {
	
	private Context context;
	private int texId;
	
	//4 points (vertex)  (x,y,z)
	
	private float[] vertex={
			-1.0f,	-1.0f, 	0.0f,  //v1 bottom left
			-1.0f,	1.0f, 	0.0f,  //v2 top left
			1.0f,	-1.0f, 	0.0f,  //v3 bottom right
			1.0f,	1.0f, 	0.0f,  //v4 top right			
	};
	
	private float textureCoords[]={
			//mapping coords for vertices
			0.0f,	1.0f,		//top left
			0.0f,	0.0f,		//bottom left
			1.0f,	1.0f,		//top right
			1.0f,	0.0f		//bottom right
			
	};
	
	
	//setup buffers
	private ByteBuffer byteBuffer;	
	private FloatBuffer vertexBuffer;
	private FloatBuffer textureBuffer;
	
	
	//init block called when contructor is called
	{
		
		byteBuffer=ByteBuffer.allocateDirect(4*vertex.length);	//4 bytes in a float, 9 elements in array
		
		//set the order to native order, device needs this set (devices use different orders)
		byteBuffer.order(ByteOrder.nativeOrder());	
		
		vertexBuffer=byteBuffer.asFloatBuffer();
		
		//put vertext in to vertextbuffer
		vertexBuffer.put(vertex);
		
		//set the position at 0 in the buffer
		vertexBuffer.position(0);
		
		
		//texturevertex buffer
		byteBuffer=ByteBuffer.allocateDirect(4*vertex.length);
		byteBuffer.order(ByteOrder.nativeOrder());	
		textureBuffer=byteBuffer.asFloatBuffer();
		textureBuffer.put(textureCoords);
		textureBuffer.position(0);
	}
	
	
	//when render surface is made	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
		
		
		//red, green, blue, alpha		
		gl.glClearColor(0.0f,0.8f,0.0f,1.0f);	
		
		gl.glEnable(GL10.GL_TEXTURE_2D);		
		
		//load the asset image
		
		//another example image
		//texId=TextureLoader.loadTexture("test.png", context.getAssets(), gl);
		
		texId=TextureLoader.loadTexture("Sprite.png", context.getAssets(), gl);
	
		//blend the image remove border around it
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
	}
	
	
	@Override
	public void onDrawFrame(GL10 gl) {
		//clear buffers that are used
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		update(gl);
		render(gl);
		
	}

	private void render(GL10 gl) {
		
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);
		
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);		
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		
		//clock wise
		gl.glFrontFace(GL10.GL_CW);
		
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
		
		//red colour
		//gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
		
		//vertex has 3 points, GL10.GL_FLOAT, as were passing in floats,stride is offset (0), vertex made up of 3, so how many vertexs we have
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertex.length/3);
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	}


	private void update(GL10 gl) {
		
		gl.glLoadIdentity();
		
		//move square from camera by 5 (distance from object - value zooms out, + value moes closer)
		gl.glTranslatef(0.0f, 0.0f, -12);
		
	}


	//setup view port
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		
		float ratio=(float) width/height;
		gl.glViewport(0, 0, width, height);
		
		//projection mode
		gl.glMatrixMode(GL10.GL_PROJECTION);
		
		gl.glLoadIdentity();
		
		//45 degree camera
		GLU.gluPerspective(gl, 45.0f, ratio, 1, 100);
		
		//change matrix mode
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		gl.glLoadIdentity();
	}
	
	
	public MyRenderer(Context context){
		this.context=context;
	}

}

