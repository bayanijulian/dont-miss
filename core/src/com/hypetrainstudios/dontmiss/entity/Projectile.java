package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;

public class Projectile extends Entity{
	
	private float run;
	private float rise;
	
	private static Circle circleExplosion = new Circle(-1000,-1000,312);
	private boolean collisionWithEnemy;
	public Projectile(Sprite spr,float projectileSpeed) {
		super(spr);
		
		this.x = (Gdx.graphics.getWidth()/2) - (spr.getWidth()/2);
		this.y = (Gdx.graphics.getHeight()/2) - (spr.getHeight()/2);
		
		//an attempt to spawn the projectile at the tip of the turret
		spr.setPosition(x + (MathUtils.cosDeg(Creator.player.getRotationCounter()) * (spr.getWidth()*2) ),
						y + (MathUtils.sinDeg(Creator.player.getRotationCounter()) * (spr.getWidth()*2)));
		
		this.run = MathUtils.cosDeg(Creator.player.getRotationCounter()) * projectileSpeed;
		this.rise = MathUtils.sinDeg(Creator.player.getRotationCounter()) * projectileSpeed;
		collisionWithEnemy = false;
		
	}
	public Projectile(Sprite spr,float projectileSpeed,float degrees) {
		super(spr);
		
		this.x = (Gdx.graphics.getWidth()/2) - (spr.getWidth()/2);
		this.y = (Gdx.graphics.getHeight()/2) - (spr.getHeight()/2);
		
		//an attempt to spawn the projectile at the tip of the turret
		spr.setPosition(x + (MathUtils.cosDeg(degrees) * (spr.getWidth()*2) ),
						y + (MathUtils.sinDeg(degrees) * (spr.getWidth()*2)));
		
		this.run = MathUtils.cosDeg(degrees) * projectileSpeed;
		this.rise = MathUtils.sinDeg(degrees) * projectileSpeed;
		collisionWithEnemy = false;
		
	}
	@Override
	public void update(float delta) {
		//no need for delta because in run and rise the degrees are multiplied by delta, I may be wrong
		if(!collisionWithEnemy){
			spr.translate(run, rise);
			this.updateBounds();
		}
		
		if(spr.getX()<(0-spr.getHeight())||spr.getY()<(0-spr.getHeight())||spr.getX()>(Gdx.graphics.getWidth()+spr.getHeight())||spr.getY()>(Gdx.graphics.getHeight()+spr.getHeight()))
		{
			active = false;
			Challenge.currentCode = Challenge.codeMiss;
		}
		if(collisionWithEnemy){	
			if(BonusHandler.currentBonus==1){	collateral();	}
			else if(BonusHandler.currentBonus==2){ explode(); }
			else	active = false;
		}
	}
	
	private void explode(){
		circleExplosion.setPosition(spr.getX(), spr.getY());
		for(int i = 0; i<Creator.enemies.size();i++){
			if(Creator.enemies.get(i).getCircle().overlaps(circleExplosion)){
				Creator.enemies.get(i).setActive(false);
			}
		}
		this.active = false;
	}
	private void collateral(){
		collisionWithEnemy = false;
	}
	public void setCollisionWithEnemy(boolean collisionWithEnemy){
		this.collisionWithEnemy = collisionWithEnemy;
	}
	
}
