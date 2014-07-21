package com.hypetrainstudios.dontmiss.enemies;

import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.entity.Enemy;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;

public class Pawn extends Enemy{
	private String color;
	private boolean run;
	public Pawn(Sprite spr, Sprite sprTarget, float enemySpeed, float degrees) {
		super(spr, sprTarget, enemySpeed, degrees);
		if(spr.getTexture()==AssetHandler.manager.get(AssetHandler.imgEnemyBlue)){
			createLivingAnimation(45, AssetHandler.manager.get(AssetHandler.atlasEnemies).findRegions("blueLiving/enemyBlueLiving"), PlayMode.LOOP, false);
		}
		else if(spr.getTexture()==AssetHandler.manager.get(AssetHandler.imgEnemyRed)){
			createLivingAnimation(45, AssetHandler.manager.get(AssetHandler.atlasEnemies).findRegions("redLiving/enemyRedLiving"), PlayMode.LOOP, false);
		}
		else if(spr.getTexture()==AssetHandler.manager.get(AssetHandler.imgEnemyYellow)){
			createLivingAnimation(45, AssetHandler.manager.get(AssetHandler.atlasEnemies).findRegions("yellowLiving/enemyYellowLiving"), PlayMode.LOOP, false);
		}
		run = true;
	}



	@Override
	public void update(float delta) {
		if(run){
			moveToTarget(delta);
			this.updateBounds();
			disappear(delta);	
		}
	}
	
	private void disappear(float delta){
		spr.setAlpha(alpha);
		if(disappearing){
			alpha-=.75*delta;
			alpha = (alpha<=0) ? 0: alpha;
		}
		else
			alpha = 1;
	}
	@Override
	public void deactivate() {
		if(run){
			run = false;
			createDeathAnimation(30, AssetHandler.manager.get(AssetHandler.atlasEnemies).findRegions("blueDeath/enemyBlueDeath"), PlayMode.NORMAL, false);	
		}
		
	}
	@Override
	public void collisionWithMisc() {
		this.active = false;
	}

	@Override
	public void collisionWithProjectile() {
		deactivate();
	}

	@Override
	public void collisionWithTurret() {
		this.active = false;
	}

}
