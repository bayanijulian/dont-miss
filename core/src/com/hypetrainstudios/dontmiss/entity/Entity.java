package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

public abstract class Entity{

	protected boolean active;
	protected Sprite spr;
	protected Circle collisionBounds;
	protected float x;
	protected float y;
	
	public Entity(Sprite spr){
		this.spr = spr;
		this.active = true;
		x = 0;
		y = 0;
		collisionBounds = new Circle(x,y,(spr.getHeight()/2));
	}
	
	public abstract void update(float delta);
	
	public void updateBounds(){
		collisionBounds.setPosition(spr.getX()+ (spr.getWidth()/2)
									,(spr.getY()+spr.getHeight()/2));
	}
	
	public void setActive(boolean active){
		this.active = active;
	}
	
	public boolean isActive(){
		return this.active;
	}
	
	public Sprite getSprite(){
		return this.spr;
	}
	
	public Circle getCircle(){
		return this.collisionBounds;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	
}
