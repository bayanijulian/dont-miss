package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;

public abstract class Entity{

	protected boolean active;
	protected Sprite spr;
	protected Circle collisionBounds;
	protected float x;
	protected float y;
	protected float alpha;

	
	protected Animation birthAnimation;
	protected Animation livingAnimation;
	protected Animation deathAnimation;
	protected float timeAnimation;
	public Entity(Sprite spr){
		this.spr = spr;
		this.active = true;
		alpha = 1f;
		x = 0;
		y = 0;
		collisionBounds = new Circle(x,y,(spr.getHeight()/2));
		spr.setAlpha(alpha);
		spr.setColor(1, 1, 1, 1);
		birthAnimation = null;
		livingAnimation = null;
		deathAnimation = null;
		timeAnimation = 0;
	}
	
	public abstract void update(float delta);
	
	public void createBirthAnimation(int amountOfFrames, TextureRegion[] frames,PlayMode mode){
		birthAnimation = new Animation(1f/amountOfFrames,frames);
		timeAnimation = 0;
		birthAnimation.setPlayMode(mode);
	}
	public void createLivingAnimation(int amountOfFrames, TextureRegion[] frames,PlayMode mode){
		livingAnimation = new Animation(1f/amountOfFrames,frames);
		timeAnimation = 0;
		livingAnimation.setPlayMode(mode);
	}
	public void createDeathAnimation(int amountOfFrames, TextureRegion[] frames,PlayMode mode){
		deathAnimation = new Animation(1f/amountOfFrames,frames);
		timeAnimation = 0;
		deathAnimation.setPlayMode(mode);
	}
	public void updateBirthAnimation(float delta){
		spr.setRegion(birthAnimation.getKeyFrame(timeAnimation));
		if(birthAnimation.isAnimationFinished(timeAnimation))	timeAnimation = 0;
		else	timeAnimation += delta;
	}
	public void updateLivingAnimation(float delta){
		spr.setRegion(livingAnimation.getKeyFrame(timeAnimation));
		if(livingAnimation.isAnimationFinished(timeAnimation))	timeAnimation = 0;
		else	timeAnimation += delta;
	}
	public void updateDeathAnimation(float delta){
		spr.setRegion(deathAnimation.getKeyFrame(timeAnimation));
		if(deathAnimation.isAnimationFinished(timeAnimation))	timeAnimation = 0;
		else	timeAnimation += delta;
	}
	
	
	
	public void updateBounds(){
		collisionBounds.setPosition(spr.getX()+ (spr.getWidth()/2)
									,(spr.getY()+spr.getHeight()/2));
	}
	
	public void setActive(boolean active){
		this.active = active;
	}
	
	public boolean isActive(){
		return this.active;
	}
	
	public Sprite getSprite(){
		return this.spr;
	}
	
	public Circle getCircle(){
		return this.collisionBounds;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	
}
