package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimatedEntity {
	
	private float time;
	private Animation animation;
	
	public AnimatedEntity(int amountOfFrames, TextureRegion [] frames,PlayMode mode){
		time = 0;
		animation = new Animation((1f/amountOfFrames), frames);
		animation.setPlayMode(mode);
	}
	
	public void updateUsingDelta(float delta){
		if(animation.isAnimationFinished(time))	time = 0;
		else	time += delta;
		
	}
	
	public void updateUsingAbstract(float time){
		this.time = time;
	}
	
	public TextureRegion getFrame(){
		return animation.getKeyFrame(time);
	}
	
	public void setPlayMode(PlayMode mode){
		animation.setPlayMode(mode);
	}
}
