package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Misc extends Entity{
	private String name;
	public Misc(Sprite spr,String name) {
		super(spr);
		this.name = name;
	}
	
	@Override
	public  void update(float delta){
		updateAnimations(delta);
	}
	public String getName(){
		return name;
	}
}
