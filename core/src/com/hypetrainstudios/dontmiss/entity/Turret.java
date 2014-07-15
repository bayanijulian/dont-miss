package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Turret extends Entity{

	private float rotationSpeed;
	private float rotationCounter;
	private boolean sheild;
	
	public Turret(Sprite spr,float rotationSpeed) {
		super(spr);
		x = Gdx.graphics.getWidth()/2;
		y = Gdx.graphics.getHeight()/2;
		spr.setCenter(x, y);
		//spr.setOrigin(128, 78);
		spr.setRotation(-90);
		this.rotationSpeed = rotationSpeed;
		rotationCounter = 0;
		sheild = false;
		this.updateBounds();
		
	}
	
	public void enableSheild(){
		this.sheild = true;
	}
	public void disableSheild(){
		this.sheild = false;
	}
	@Override
	public void update(float delta) {
		rotationCounter += rotationSpeed*delta;
		spr.rotate(rotationSpeed*delta);
			
	}

	public float getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(float rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	public float getRotationCounter() {
		return rotationCounter;
	}

	public void setRotationCounter(float rotationCounter) {
		this.rotationCounter = rotationCounter;
	}
	
	public void collisionWithEnemy(){
		
	}
}
