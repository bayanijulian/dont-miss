package com.hypetrainstudios.dontmiss.entity;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bonus extends Entity{
	
	private float timeActive;
	private float activeCounter;
	private Random rdm;
	private float timeToComplete;
	private float timeToCompleteCounter;
	private float percent;
	private float xTarget;
	private float yTarget;
	private float timeChangeLocation;
	private float changeLocationCounter;
	private float run;
	private float rise;
	public Bonus(Sprite spr) {
		super(spr);
		timeActive = 10f;
		activeCounter = 0;
		rdm = new Random();
		timeToComplete = 4f;
		xTarget = 700;
		yTarget = 700;
		x = 300;
		y = 300;
		changeLocationCounter = 0;
		timeChangeLocation = 2f;
		spr.setPosition(x, y);
		percent = 0;
		timeToCompleteCounter = 0;
	}
	
	@Override
	public void update(float delta) {
		activeCounter+=delta;
		changeLocationCounter +=delta;
		timeToCompleteCounter +=delta;
		percent = timeToCompleteCounter/timeToComplete;
		if(activeCounter>=timeActive)	active = false;
		
		
		
		if(timeToCompleteCounter<timeToComplete)	
		spr.setPosition(x + (xTarget - x) * percent, y + (yTarget - y) * percent);
		
	}
	private void changeLocation(){
		
	}

}
