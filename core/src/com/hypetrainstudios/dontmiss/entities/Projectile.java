package com.hypetrainstudios.dontmiss.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.DontMiss;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;

public class Projectile implements Entity{
	
	
	private Sprite image;
	private float x;
	private float y;
	private float dirX;
	private float dirY;
	private float width;
	private float height;
	private float speed;
	private boolean signsOfLife;
	private float deathCounter;
	private float deathRate;
	private Circle bounds;
	private float degrees;
	public Projectile(){
		x = Gdx.graphics.getWidth()/2;
		y = Gdx.graphics.getHeight()/2;
		
		degrees = DontMiss.turret.getRotationCounter();
		
		width = 64;
		height = 64;
		
		image = new Sprite(AssetHandler.get("projectile"));
		image.setCenter(x, y);
		image.setRotation(degrees-90);
		
		
		deathRate = 1.5f;
		deathCounter = 0;
		
		signsOfLife = true;
		
		speed = 1500;
		dirX = MathUtils.cosDeg(degrees)*speed;
		dirY = MathUtils.sinDeg(degrees)*speed;
	}

	@Override
	public void update(float delta) {
		x += dirX * delta;
		y += dirY * delta;
		image.setCenter(x, y);
		deathCounter += delta;
		if(deathCounter>=deathRate)
			signsOfLife = false;
	}

	@Override
	public void draw(SpriteBatch renderer) {
		image.draw(renderer);
	}

	@Override
	public void resize() {
	}

	@Override
	public boolean signsOfLife() {
		return signsOfLife;
	}

	@Override
	public void collision(Object object) {
	}

	@Override
	public void remove() {
	}

}
