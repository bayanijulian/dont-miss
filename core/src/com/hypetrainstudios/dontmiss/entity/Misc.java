package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Misc extends Entity{
	
	public Misc(Sprite spr,float x, float y) {
		super(spr);
		
	}
	public abstract void create();
	@Override
	public abstract void update(float delta);
	
}
