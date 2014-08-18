package com.hypetrainstudios.dontmiss.entities;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Entity {
	
	public abstract void update(float delta);
	public abstract void draw(SpriteBatch renderer);
	public abstract void resize();
	public abstract void remove();
	public abstract boolean signsOfLife();
	public abstract void collision(Object object);
	
}
