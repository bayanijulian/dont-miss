package com.hypetrainstudios.dontmiss.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.hypetrainstudios.dontmiss.DontMiss;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;

public class Turret implements InputProcessor,Entity{
	private Sprite platform;
	private Sprite turret;
	
	private float platformWidth;
	private float platformHeight;
	
	private float turretWidth;
	private float turretHeight;
	
	private boolean signsOfLife;
	
	private float rotationCounter;
	private float rotationSpeed;
	
	private Circle bounds;
	
	public Turret() {
		platform  = new Sprite(AssetHandler.get("platform"));
		platformHeight = 256f;
		platformWidth = 256f;
		
		platform.setCenter(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
		
		turret = new Sprite(AssetHandler.get("turret"));
		turretWidth = 256f;
		turretHeight = 256f;
		
		turret.setCenter(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
		
		signsOfLife = true;
		rotationCounter = 0f;
		rotationSpeed = 170f;
	}
	
	
	
	public float getRotationCounter() {
		return rotationCounter;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update(float delta) {
		rotationCounter += rotationSpeed * delta;
		turret.setRotation(rotationCounter-90);
	}
	
	

	@Override	
	public void draw(SpriteBatch renderer) {
		platform.draw(renderer);
		turret.draw(renderer);
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
	public boolean keyDown(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		DontMiss.createProjectile();
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}



	@Override
	public void remove() {
	}

	





}
