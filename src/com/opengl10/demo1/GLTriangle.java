package com.opengl10.demo1;



import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLTriangle {

	//x,y
	private float vertices[]={
		0f,1f,		//point 0 
		1f,-1f,		//point 1
		-1f,-1f		//p 2
	};
	
	private FloatBuffer vertBuff;
	
	private short[]pIndex={ 0,1,2};
	
	private ShortBuffer pBuff;
	
	public GLTriangle()
	{
		ByteBuffer bBuff=ByteBuffer.allocateDirect(vertices.length*4);
		
		bBuff.order(ByteOrder.nativeOrder());
		
		vertBuff=bBuff.asFloatBuffer();
		vertBuff.put(vertices);
		vertBuff.position(0);
		
		ByteBuffer pbBuff=ByteBuffer.allocateDirect(pIndex.length*2);
		pbBuff.order(ByteOrder.nativeOrder());
		pBuff=pbBuff.asShortBuffer();
		pBuff.put(pIndex);
		pBuff.position(0);
	}
	
	public void draw(GL10 gl){
		//connect points
		gl.glFrontFace(GL10.GL_CW);	//clock wise
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);		//use vertix array		
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertBuff);
		
		gl.glDrawElements(GL10.GL_TRIANGLES, pIndex.length, GL10.GL_UNSIGNED_SHORT, pBuff);
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
		
		
	}
}
