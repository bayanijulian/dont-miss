package com.hypetrainstudios.dontmiss.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.entity.Enemy;

public class Boss extends Enemy{
	private float spawnRate;
	private float spawnCounter;
	private float tempDistance;
	private static final float amountToMove = 300f;
	private static float []  xCoords ={	(Gdx.graphics.getWidth()*.1f),	
										(Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()*.1f)),
										(Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()*.1f)),
										(Gdx.graphics.getWidth()*.1f)};
	
	private static float [] yCoords = {	(Gdx.graphics.getHeight()*.1f),
										(Gdx.graphics.getHeight()*.1f),
										(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()*.1f)),
										(Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()*.1f))};
		
	private int coordCounter;
	
	
	public Boss(Sprite spr, Sprite sprTarget, float enemySpeed, float degrees) {
		super(spr, sprTarget, enemySpeed, degrees);
		spr.setPosition(xCoords[0], yCoords[0]);
		timeToComplete = 4;
		timeToCompleteCounter= 0;
		coordCounter = 1;
		spawnRate = 5f;
		changeLocation();
	}
	private void spawnEnemies(float delta){
		if(spawnCounter>=spawnRate){
			spawnCounter = 0;
			Creator.createEnemy(this.spr.getX(),this.spr.getY());
		}
		else	spawnCounter+=delta;
	}
	@Override
	public void update(float delta) {
		this.updateBounds();
		if(!(moveToTarget(delta))){
			changeLocation();
		}
		spawnEnemies(delta);
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
		
		if(coordCounter>=3) coordCounter = 0;
		else	coordCounter++;
	}
	private void getNewCoords(){
		this.xTarget = xCoords[coordCounter];
		this.yTarget = yCoords[coordCounter];
		System.out.println(coordCounter);
	}
}
