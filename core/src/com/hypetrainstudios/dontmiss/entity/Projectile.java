package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.Challenge;


public class Projectile extends Entity{
	
	private float run;
	private float rise;
	
	private static Circle circleExplosion = new Circle(-1000,-1000,312);
	
	/* Assassin Bonus Variables */
	private float assassinTimer;
	private float percent;
	private static float timeToComplete = .1f;
	private float timeToCompleteCounter;
	private float xTarget;
	private float yTarget;
	private float tempDistance;
	private static float amountToMove = 400f;
	private int activeBonus;
	public Projectile(Sprite spr,float projectileSpeed,int activeBonus) {
		super(spr);
		
		this.x = (Gdx.graphics.getWidth()/2) - (spr.getWidth()/2);
		this.y = (Gdx.graphics.getHeight()/2) - (spr.getHeight()/2);
		
		//an attempt to spawn the projectile at the tip of the turret
		spr.setPosition(x + (MathUtils.cosDeg(Creator.midTurret.getRotationCounter()) * (spr.getWidth()*2) ),
						y + (MathUtils.sinDeg(Creator.midTurret.getRotationCounter()) * (spr.getWidth()*2)));
		
		this.run = MathUtils.cosDeg(Creator.midTurret.getRotationCounter()) * projectileSpeed;
		this.rise = MathUtils.sinDeg(Creator.midTurret.getRotationCounter()) * projectileSpeed;
		
		this.activeBonus = activeBonus;
		if(activeBonus == 2) {
			spr.setSize(128, 128);
			changeBounds();
		}
		
	}
	public Projectile(Sprite spr,float projectileSpeed,float degrees,int activeBonus) {
		super(spr);
		
		this.x = (Gdx.graphics.getWidth()/2) - (spr.getWidth()/2);
		this.y = (Gdx.graphics.getHeight()/2) - (spr.getHeight()/2);
		
		//an attempt to spawn the projectile at the tip of the turret
		spr.setPosition(x + (MathUtils.cosDeg(degrees) * (spr.getWidth()*2) ),
						y + (MathUtils.sinDeg(degrees) * (spr.getWidth()*2)));
		
		this.run = MathUtils.cosDeg(degrees) * projectileSpeed;
		this.rise = MathUtils.sinDeg(degrees) * projectileSpeed;
		
		
		this.activeBonus = activeBonus;
		
	}
	@Override
	public void update(float delta) {
		//no need for delta because in run and rise the degrees are multiplied by delta, I may be wrong
		
		
		this.updateBounds();
		
		if(activeBonus==1){
			assassinUpdate(delta);
		}
		else{
			spr.translate(run, rise);
		}
		
		//if the projectile is off the screen remove it, and it also counts as a miss
		if(spr.getX()<(0-spr.getHeight())||spr.getY()<(0-spr.getHeight())||spr.getX()>(Gdx.graphics.getWidth()+spr.getHeight())||spr.getY()>(Gdx.graphics.getHeight()+spr.getHeight()))
		{
			active = false;
			Challenge.currentCode = Challenge.codeMiss;
		}
		
	}
	
	/* Explosive Bonus */
	private void explode(){
		circleExplosion.setPosition(spr.getX(), spr.getY());
		for(int i = 0; i<Creator.enemies.size();i++){
			if(Creator.enemies.get(i).getCircle().overlaps(circleExplosion)){
				Creator.enemies.get(i).setActive(false);
			}
		}
		this.active = false;
	}
	/* Assassin Bonus */
	private void assassinUpdate(float delta){
		assassinTimer += delta;
		
		timeToCompleteCounter += delta;
		percent = timeToCompleteCounter/timeToComplete;
		
		if(assassinTimer>=10)
			active = false;
		if(timeToCompleteCounter<timeToComplete)	
			spr.setPosition(x + (xTarget - x) * percent, y + (yTarget - y) * percent);
		if(timeToCompleteCounter>=timeToComplete)
			changeLocation();
	}
	public void changeLocation(){
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
	
	private void assassinCollision(){
		
	}

	
	public void collisionWithEnemy(){
		if(activeBonus==1)	assassinCollision();	
		else if(activeBonus==3) explode(); 
		else	active = false;
	}
	public void collisionWithBonus(){
		
	}
}
