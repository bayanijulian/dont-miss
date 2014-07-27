package com.hypetrainstudios.dontmiss.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.entity.Enemy;

public class Swift extends Enemy{

	private float [] xCoords;
	private float [] yCoords;
	private int coordCounter;
	
	public Swift(Sprite spr, Sprite sprTarget, float enemySpeed, float degrees) {
		super(spr, sprTarget, enemySpeed, degrees);
		coordCounter = 8;
		createCoords();
		xTarget = xCoords[8];
		yTarget = yCoords[8];
		timeToComplete = .8f;
		timeToCompleteCounter = 0;
	}
	
	
	private void createCoords(){
		float spacedIntervalAmount = (.25f * (Gdx.graphics.getWidth()/2))/2;
		float amplitude = .4f * (Gdx.graphics.getHeight()/2);
		int counterAmp = 0;
		xCoords = new float[9];
		yCoords = new float[9];
		
		for(int i = 0; i<9; i ++)
			xCoords[i]=(Gdx.graphics.getWidth()/2) + (spacedIntervalAmount * i);
		
		for(int i = 0; i<9; i ++){
			if(counterAmp==0)	yCoords[i] = Gdx.graphics.getHeight()/2;
			else if(counterAmp==1) yCoords[i] = (Gdx.graphics.getHeight()/2) + amplitude;
			else if(counterAmp==2) yCoords[i] = (Gdx.graphics.getHeight()/2);
			else if(counterAmp==3) yCoords[i] = (Gdx.graphics.getHeight()/2) - amplitude;
			
			if(counterAmp>=3) counterAmp = 0;
			else counterAmp++;
		}
		for(int i = 0; i<9; i ++){
		System.out.println(xCoords[i]);
		System.out.println(yCoords[i]);
		}
	}
	
	
	@Override
	public void update(float delta) {
		this.updateBounds();
		if(!(moveToTarget(delta))){
			changeLocation();
		}
	}

	@Override
	public void collisionWithMisc() {
	}

	@Override
	public void collisionWithProjectile() {
	}

	@Override
	public void collisionWithTurret() {
	}

	private void changeLocation(){
		timeToCompleteCounter = 0;
		x=spr.getX();
		y=spr.getY();
		getNewCoords();
		
		if(coordCounter<=0) coordCounter = 8;
		else	coordCounter--;
	}
	private void getNewCoords(){
		this.xTarget = xCoords[coordCounter];
		this.yTarget = yCoords[coordCounter];
		System.out.println(coordCounter);
	}
}
