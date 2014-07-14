package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Array;

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
	protected boolean birthEnabled;
	protected boolean livingEnabled;
	protected boolean deathEnabled;
	protected boolean birthAbstractTime;
	protected boolean livingAbstractTime;
	protected boolean deathAbstractTime;
	
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
		
		birthEnabled = false;
		livingEnabled = false;
		deathEnabled = false;
		
		birthAbstractTime = false;
		livingAbstractTime = false;
		deathAbstractTime = false;
	}
	
	public abstract void update(float delta);
	
	public void createBirthAnimation(int amountOfFrames, Array<TextureAtlas.AtlasRegion> frames,PlayMode mode,boolean birthAbstractTime){
		birthAnimation = new Animation(1f/amountOfFrames,frames);
		timeAnimation = 0;
		birthAnimation.setPlayMode(mode);
		birthEnabled =true;
		this.birthAbstractTime = birthAbstractTime;
	}
	public void createLivingAnimation(int amountOfFrames, Array<TextureAtlas.AtlasRegion> frames,PlayMode mode,boolean livingAbstractTime){
		livingAnimation = new Animation(1f/amountOfFrames,frames);
		timeAnimation = 0;
		livingAnimation.setPlayMode(mode);
		livingEnabled = true;
		this.livingAbstractTime = livingAbstractTime;
	}
	public void createDeathAnimation(int amountOfFrames,	Array<TextureAtlas.AtlasRegion> frames,PlayMode mode,boolean deathAbstractTime){
		deathAnimation = new Animation(1f/amountOfFrames,frames);
		timeAnimation = 0;
		deathAnimation.setPlayMode(mode);
		deathEnabled = true;
		this.deathAbstractTime = deathAbstractTime;
	}
	public void updateBirthAnimation(float time){
		spr.setRegion(birthAnimation.getKeyFrame(timeAnimation));
		
		if(!birthAbstractTime)
		{
			if(birthAnimation.isAnimationFinished(timeAnimation)){	
				timeAnimation = 0;
				livingEnabled=false;
			}
			else	timeAnimation += time;
		}
		else	timeAnimation = time;
	}
	public void updateLivingAnimation(float time){
		
		spr.setRegion(livingAnimation.getKeyFrame(timeAnimation));
		if(!livingAbstractTime)
		{
			if(livingAnimation.isAnimationFinished(timeAnimation)){	
				timeAnimation = 0;
			}
			else	timeAnimation += time;
		}
		else	timeAnimation = time;
		
	}
	public void updateDeathAnimation(float time){
		spr.setRegion(deathAnimation.getKeyFrame(timeAnimation));
		if(!deathAbstractTime){
			if(deathAnimation.isAnimationFinished(timeAnimation)){
				timeAnimation = 0;
				deathEnabled=false;
			}
			else	timeAnimation += time;
		}
		else	timeAnimation = 0;
	}
	
	public void updateAnimations(float delta){
		if(birthEnabled){
			updateBirthAnimation(delta);
		}
		else if(livingEnabled){
			updateLivingAnimation(delta);
		}
		else if(deathEnabled){
			updateDeathAnimation(delta);
		}
	}
	
	
	
	
	
	public void setCenter(float x,float y){
		spr.setCenter(x, y);
	}
	
	public void updateBounds(){
		collisionBounds.setPosition(spr.getX()+ (spr.getWidth()/2)
									,(spr.getY()+spr.getHeight()/2));
	}
	public void changeBounds(){
		collisionBounds.setRadius(spr.getHeight()/2);
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
