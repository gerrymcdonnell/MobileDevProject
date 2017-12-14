package com.activity;




//http://www.vogella.com/tutorials/AndroidListView/article.html


import com.opengl10.demo1.OpenGL1Activity1;
import com.opengl10.demo2.OpenGl1Activity2;
import com.opengl20.demo1.DemoActivity1;
import com.opengl20.demo3.DemoActivity3;
import com.opengl20.demo4.OpenGLES20Activity;
import com.opengl20.demo5.DemoActivity5;



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		//setup listview
		String[] values = new String[] { 
				"1. Basic OpenGL 2.0 App (Youtube Tut)", 
				"2. OpenGL 1.0 Drawing Shape (Triangle)",
				"3. OpenGL 2.0 Simple App (Android Site)",
				"4. OpenGL 2.0 Triangle Shape",
				"5. OpenGL 2.0 demo 5 (learnopengles.com)",
				"6. OpenGL 1.0 demo 6 LoadTexture (youtube.com)"
					
		};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	    
		String sItem = (String) getListAdapter().getItem(position);
	    Toast.makeText(this, sItem + " selected", Toast.LENGTH_LONG).show();
	    
	    //simple opengl 2 demo
	    if(position==0)
	    {
	    	//run demo activity
	    	Toast.makeText(this, sItem + " selected", Toast.LENGTH_LONG).show();
	    	
	    	Intent intent1 = new Intent(this, DemoActivity1.class);
	    	startActivity(intent1);
	    }
	    
	    //open gl 1 demo
	    else if(position==1){
	    	//run demo

	    	Toast.makeText(this, sItem + " selected", Toast.LENGTH_LONG).show();
	    	
	    	Intent intent1 = new Intent(this, OpenGL1Activity1.class);
	    	startActivity(intent1);
	    }
	    
	    //android offical opengl 2 example
	    else if(position==2){
	    	
	    	Toast.makeText(this, sItem + " selected", Toast.LENGTH_LONG).show();
	    	
	    	Intent intent1 = new Intent(this, DemoActivity3.class);
	    	startActivity(intent1);
	    }
	    //4 traingle and square with input
	    else if(position==3){
	    	
	    	Toast.makeText(this, sItem + " selected", Toast.LENGTH_LONG).show();
	    	
	    	
	    	Intent intent1 = new Intent(this, OpenGLES20Activity.class);
	    	startActivity(intent1);
	    	
	    }    
	    
	    //http://www.learnopengles.com/android-lesson-one-getting-started/
	    else if(position==4){
	    	
	    	Toast.makeText(this, sItem + " selected", Toast.LENGTH_LONG).show();
	    	
	    	Intent intent1 = new Intent(this, DemoActivity5.class);
	    	startActivity(intent1);	    	
	    }
	    
	    /*
	     * https://www.youtube.com/watch?v=suDX2W60A5E
	     */
	    else if(position==5){
	    	
	    	Toast.makeText(this, sItem + " selected", Toast.LENGTH_LONG).show();
	    	
	    	Intent intent1 = new Intent(this, OpenGl1Activity2.class);
	    	startActivity(intent1);
	    	
	    }

	    
	}
}
