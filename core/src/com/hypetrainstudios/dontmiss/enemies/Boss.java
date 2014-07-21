package com.hypetrainstudios.dontmiss.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.entity.Enemy;

public class Boss extends Enemy{
	
	private float tempDistance;
	private static final float amountToMove = 300f;
	
	private static final Circle circleTurret = new Circle(175,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);;
	public Boss(Sprite spr, Sprite sprTarget, float enemySpeed, float degrees) {
		super(spr, sprTarget, enemySpeed, degrees);
		changeLocation();
		timeToComplete = 2;
	}
	
	
	
	@Override
	public void update(float delta) {
		this.updateBounds();
		if(!(moveToTarget(delta))){
			changeLocation();
		}
		if(collisionBounds.overlaps(circleTurret)){
			changeLocation();
			System.out.println("too much");
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
