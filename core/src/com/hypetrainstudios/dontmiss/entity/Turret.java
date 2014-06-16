package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Turret extends Entity{

	private float rotationSpeed;
	private float rotationCounter;
	
	public Turret(Sprite spr,float rotationSpeed) {
		super(spr);
		x = Gdx.graphics.getWidth()/2 - (spr.getWidth());
		y = Gdx.graphics.getHeight()/2 - (spr.getHeight()/2);
		this.rotationSpeed = rotationSpeed;
		rotationCounter = 0;
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
	
	
}
