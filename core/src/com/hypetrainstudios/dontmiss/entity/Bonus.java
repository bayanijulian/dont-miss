package com.hypetrainstudios.dontmiss.entity;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;


public class Bonus extends Entity{
	
	private float timeActive;
	private float activeCounter;
	private float timeToComplete;
	private float timeToCompleteCounter;
	private float percent;
	private float xTarget;
	private float yTarget;
	private float tempDistance;
	private static final float amountToMove = 300f;
	private int bonusType;
	public Bonus(Sprite spr, int bonusType) {
		super(spr);
		timeActive = 10f;
		activeCounter = 0;
		
		timeToComplete = 3.3f;
		timeToCompleteCounter = 0;
		
		xTarget = 0;
		yTarget = 0;
		x = MathUtils.random(Gdx.graphics.getWidth());
		y = MathUtils.random(Gdx.graphics.getHeight());
		percent = 0;
		tempDistance = 0;
		getNewCoords();
		spr.setPosition(x, y);
		spr.setSize(64, 64);
		this.changeBounds();
		
		this.bonusType = bonusType;
	}
	
	@Override
	public void update(float delta) {
		this.updateBounds();
		activeCounter+=delta;
		timeToCompleteCounter +=delta;
		percent = timeToCompleteCounter/timeToComplete;
		
		if(activeCounter>=timeActive)
			active = false;
		if(timeToCompleteCounter<timeToComplete)	
			spr.setPosition(x + (xTarget - x) * percent, y + (yTarget - y) * percent);
		if(timeToCompleteCounter>=timeToComplete)
			changeLocation();
	}
	
	public void collisionWithProjectile(){
		this.active = false;
		BonusHandler.lastKilledX = spr.getX();
		BonusHandler.lastKilledY = spr.getY();
		BonusHandler.setActiveBonus(bonusType);
		
	}
	
	private void changeLocation(){
		timeToCompleteCounter = 0;
		x=spr.getX();
		y=spr.getY();
		
		getNewCoords();
	}
	private void getNewCoords(){
		while(tempDistance!=amountToMove){
			xTarget = MathUtils.random(Gdx.graphics.getWidth());
			yTarget = MathUtils.random(Gdx.graphics.getHeight());
			tempDistance = (float) Math.sqrt(	Math.pow(  (xTarget-x)   , 2) +
										Math.pow(  (yTarget-y)   , 2)
									);
			tempDistance = MathUtils.round(tempDistance);
		}
		tempDistance = 0;
		
	}
}
