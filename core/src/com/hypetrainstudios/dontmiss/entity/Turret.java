package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.Creator;


public class Turret extends Entity{

	private float rotationSpeed;
	private float rotationCounter;
	private boolean sheild;
	
	public Turret(Sprite spr,float rotationSpeed) {
		super(spr);
		x = Gdx.graphics.getWidth()/2;
		y = Gdx.graphics.getHeight()/2;
		spr.setCenter(x, y);
		spr.setRotation(-90);
		this.rotationSpeed = rotationSpeed;
		rotationCounter = 0;
		sheild = true;
		this.updateBounds();
		
	}
	
	public void enableSheild(){
		this.sheild = true;
		collisionBounds.setRadius(128);
		this.updateBounds();
		for(int i = 0; i<Creator.misc.size(); i ++)
			if(Creator.misc.get(i).getName().equals("shield"))
				Creator.misc.get(i).getSprite().setAlpha(1);	
	}
	public void disableSheild(){
		this.sheild = false;
		collisionBounds.setRadius(64);
		this.updateBounds();
		for(int i = 0; i<Creator.misc.size(); i ++)
			if(Creator.misc.get(i).getName().equals("shield"))
				Creator.misc.get(i).getSprite().setAlpha(0);
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
		if(sheild)
			disableSheild();
		else
			Creator.gameOver = true;
	}
}
