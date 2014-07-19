package com.hypetrainstudios.dontmiss.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.entity.Enemy;

public class Swift extends Enemy{

	public Swift(Sprite spr, Sprite sprTarget, float enemySpeed, float degrees) {
		super(spr, sprTarget, enemySpeed, degrees);
		
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void collisionWithMisc() {
	}

	@Override
	public void collisionWithProjectile() {
	}

	@Override
	public void collisionWithTurret() {
	}

	
}
