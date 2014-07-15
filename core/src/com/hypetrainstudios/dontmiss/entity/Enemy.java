package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;


public class Enemy extends Entity{
	private float run;
	private float rise;
	private boolean disappearing;
	private Sprite sprTarget;
	private boolean collisionWithProjectile;
	private boolean collisionWithTurret;
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
		//parametric slope is used below
		run=((x-((sprTarget.getX()+(sprTarget.getWidth()/2))-(spr.getWidth()/2)))*enemySpeed);
		rise=((y-((sprTarget.getY()+(sprTarget.getHeight()/2))-(spr.getHeight()/2)))*enemySpeed);
		disappearing = false;
		collisionWithProjectile = false;
		collisionWithTurret = false;
	}

	public void setSpeed(float speed){
		run=((x-((sprTarget.getX()+(sprTarget.getWidth()/2))-(spr.getWidth()/2)))*speed);
		rise=((y-((sprTarget.getY()+(sprTarget.getHeight()/2))-(spr.getHeight()/2)))*speed);
	}
	

	public void setCollisionWithProjectile(boolean collisionWithProjectile) {
		this.collisionWithProjectile = collisionWithProjectile;
	}

	public void setCollisionWithTurret(boolean collisionWithTurret) {
		this.collisionWithTurret = collisionWithTurret;
	}

	
	private void checkCollision(){
		if(collisionWithTurret){
			
		}
		else if(collisionWithProjectile){
			
		}
	}
	
	@Override
	public void update(float delta) {
		//needs delta, because delta acts as the T in a parametric funtion
		spr.translate(run*delta*-1, rise*delta*-1);
		
		spr.setAlpha(alpha);
		this.updateBounds();
		if(disappearing){
			System.out.println(alpha);
			alpha-=.75*delta;
			alpha = (alpha<=0) ? 0: alpha;
		}
		else
			alpha = 1;
		checkCollision();
	}
	public void enableDisappearing(){
		disappearing = true;
		
	}
	public void disableDisappearing(){
		disappearing = false;
	}
	
	
	public void collisionWithProjectile(){
		
	}
	public void collisionWithTurret(){
		
	}
}
