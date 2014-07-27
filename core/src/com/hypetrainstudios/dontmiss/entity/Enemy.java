package com.hypetrainstudios.dontmiss.entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
public abstract class Enemy extends Entity{
	
	protected boolean disappearing;
	private Sprite sprTarget;
	
	protected float xTarget;
	protected float yTarget;
	protected float timeToComplete;
	protected float timeToCompleteCounter;
	protected float percent;
	
	
	
	public Enemy(Sprite spr, Sprite sprTarget, float enemySpeed,float degrees) {
		super(spr);
		this.sprTarget = sprTarget;
		//gets the widest length of the screen so they all spawn just right out of view
		float radius = (float) Math.sqrt(   (Math.pow((Gdx.graphics.getWidth()/2),2)) + (Math.pow((Gdx.graphics.getHeight()/2),2)) );
		//sets the location of the enemy then it can start updating/moving in a straight line towards target, this is based on the value of the degrees
		//the turret is the origin
		x=(MathUtils.cosDeg(degrees)*radius)+((Gdx.graphics.getWidth()/2)-(spr.getWidth()/2));
		y=(MathUtils.sinDeg(degrees)*radius)+((Gdx.graphics.getHeight()/2)-(spr.getHeight()/2));
		
		spr.setPosition(x, y);
		
		timeToCompleteCounter = 0;
		timeToComplete = 15f;
		percent = 0;
		xTarget = Gdx.graphics.getWidth()/2;
		yTarget = Gdx.graphics.getHeight()/2;
		
		
		disappearing = false;
	}
	public Enemy(Sprite spr, Sprite sprTarget, float enemySpeed,float x,float y) {
		super(spr);
		this.sprTarget = sprTarget;
		//gets the widest length of the screen so they all spawn just right out of view
		float radius = (float) Math.sqrt(   (Math.pow((Gdx.graphics.getWidth()/2),2)) + (Math.pow((Gdx.graphics.getHeight()/2),2)) );
		//sets the location of the enemy then it can start updating/moving in a straight line towards target, this is based on the value of the degrees
		//the turret is the origin
		x=this.x;
		y=this.y;
		
		spr.setPosition(x, y);
		
		timeToCompleteCounter = 0;
		timeToComplete = 15f;
		percent = 0;
		xTarget = Gdx.graphics.getWidth()/2;
		yTarget = Gdx.graphics.getHeight()/2;
		
		
		disappearing = false;
	}
	public void setSpeed(float speed){
		timeToComplete = speed;
	}
	public void enableDisappearing(){
		disappearing = true;
		
	}
	public void disableDisappearing(){
		disappearing = false;
	}
	public abstract void update(float delta);
	public abstract void collisionWithMisc();
	public abstract void collisionWithProjectile();
	public abstract void collisionWithTurret();
	public void deactivate(){
		this.active = false;
	}
	public boolean moveToTarget(float delta){
		percent = timeToCompleteCounter/timeToComplete;
		timeToCompleteCounter+=delta;
		spr.setPosition(x + (xTarget - x) * percent, y + (yTarget - y) * percent);
		if(timeToCompleteCounter>timeToComplete)
			return false;
		else
			return true;
	}
}