package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;

public class ProjectileLoading{
	
	public static Animation animLoadingBlue = new Animation(1/30f,AssetHandler.manager.get(AssetHandler.atlasLoadingProjBlue).findRegions("loadingProjBlue"));;
	public static Sprite spr = new Sprite(animLoadingBlue.getKeyFrame(0));
	public static float time;
	
	
	public static void create(){
		spr.setPosition((Gdx.graphics.getWidth()/2)-(spr.getWidth()/2), (Gdx.graphics.getHeight()/2)-(spr.getHeight()/2));
		time=0;
		animLoadingBlue.setPlayMode(PlayMode.NORMAL);
	}
	public ProjectileLoading(){

	}
	public static Sprite getSprite(){
		return spr;
	}
	public static void update(float delta){
		time = Creator.fireRateCounter/Creator.fireRate;
		spr.setRegion((animLoadingBlue.getKeyFrame(time)));
//		if(!(animLoadingBlue.isAnimationFinished(time)))
//			time+=delta;
//		else
//			time = 0;
	}
}
