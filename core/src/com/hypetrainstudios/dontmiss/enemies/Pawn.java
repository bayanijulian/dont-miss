package com.hypetrainstudios.dontmiss.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.entity.Enemy;

public class Pawn extends Enemy{

	public Pawn(Sprite spr, Sprite sprTarget, float enemySpeed, float degrees) {
		super(spr, sprTarget, enemySpeed, degrees);
		
	}



	@Override
	public void update(float delta) {
		spr.translate(run*delta*-1, rise*delta*-1);
		
		spr.setAlpha(alpha);
		this.updateBounds();
		if(disappearing){
			alpha-=.75*delta;
			alpha = (alpha<=0) ? 0: alpha;
		}
		else
			alpha = 1;
	}

	@Override
	public void collisionWithMisc() {
		this.active = false;
	}

	@Override
	public void collisionWithProjectile() {
		this.active = false;
	}

	@Override
	public void collisionWithTurret() {
		this.active = false;
	}

}
