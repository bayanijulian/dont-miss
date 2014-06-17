package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.Creator;

public class Projectile extends Entity{
	
	private float run;
	private float rise;
	
	public Projectile(Sprite spr,float projectileSpeed) {
		super(spr);
		
		this.x = (Gdx.graphics.getWidth()/2) - (spr.getWidth()/2);
		this.y = (Gdx.graphics.getHeight()/2) - (spr.getHeight()/2);
		
		//an attempt to spawn the projectile at the tip of the turret
		spr.setPosition(x + (MathUtils.cosDeg(Creator.player.getRotationCounter()) * (spr.getWidth()*2) ),
						y + (MathUtils.sinDeg(Creator.player.getRotationCounter()) * (spr.getWidth()*2)));
		
		this.run = MathUtils.cosDeg(Creator.player.getRotationCounter()) * projectileSpeed;
		this.rise = MathUtils.sinDeg(Creator.player.getRotationCounter()) * projectileSpeed;
		
		
	}

	@Override
	public void update(float delta) {
		//no need for delta because in run and rise the degrees are multiplied by delta, I may be wrong
		spr.translate(run, rise);
		this.updateBounds();
	}

}
