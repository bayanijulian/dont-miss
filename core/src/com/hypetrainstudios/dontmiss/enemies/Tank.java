package com.hypetrainstudios.dontmiss.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.entity.Enemy;

public class Tank extends Enemy{
	private int numOfHitsBeforeDeath;
	private int hitCounter;
	
	public Tank(Sprite spr, Sprite sprTarget, float enemySpeed, float degrees) {
		super(spr, sprTarget, enemySpeed, degrees);
		numOfHitsBeforeDeath = 3;
		hitCounter = 0;
	}
	
	@Override
	public void update(float delta) {
		//spr.translate(run*delta*-1, rise*delta*-1);
		moveToTarget(delta);
	}

	@Override
	public void collisionWithMisc() {
		if(hitCounter>=numOfHitsBeforeDeath)
			this.active=false;
		else
			hitCounter++;
	}

	@Override
	public void collisionWithProjectile() {
		if(hitCounter>=numOfHitsBeforeDeath)
			this.active=false;
		else
			hitCounter++;
	}

	@Override
	public void collisionWithTurret() {
		this.active=false;
	}
	
}
