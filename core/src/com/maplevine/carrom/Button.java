package com.maplevine.carrom;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Button {
	
	
	Texture appearance;
	Sprite button;
	public Rectangle hitPoint;
	float x = 0, y = 0, width = 0, height = 0;
	float x2 = 0, y2 = 0, width2 = 0, height2 = 0;
	Boolean pressed = false;
	
	public Button(Texture texture, float x, float y, float width, float height){
		
		
		appearance = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.x2 = x;
		this.y2 = y;
		this.width2 = width;
		this.height2 = height;


		
		button = new Sprite(appearance);
		button.setPosition(x,y);
		button.setSize(width,height);

		hitPoint = new Rectangle(x,y,width,height);

		
	}

	
	
	public void draw(SpriteBatch batch){
		
	
		

		
		if (width > width2){
			
			pressed = true;
		
		}else{
			
			pressed = false;
		}




		button.draw(batch);
		button.setPosition(x,y);
		button.setSize(width,height);

	}
	
	
	public void press(){
		
	x = x - ((float) ((width*1.2 - width)/2));  	
	y = y - ((float) ((height*1.2 - height)/2));  		
	width = (float) (width*1.2);
	height = (float) (height*1.2);

	
		
	}
	
	
	public void release(){
		
		
		x = x2;
		y = y2;
		width = width2;
		height = height2;
		
			
	}

	public  void setAlpha(float a){
		button.setAlpha(a);
	}

	public boolean isPressed(){
		return pressed;
	}
		
	

}
