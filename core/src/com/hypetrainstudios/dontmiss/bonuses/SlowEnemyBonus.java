package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;

public class SlowEnemyBonus extends BaseBonus{
	private static float tempSpeed = 0;
	private float slowSpeed = .01f;
	private float timeCounter;
	private float timeToLast;

	@Override
	public void enable() {
		tempSpeed = Creator.enemySpeed;
		Creator.enemySpeed = slowSpeed;
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setSpeed(slowSpeed);
		}
		timeCounter = 0;
		timeToLast = 5;
	}

	@Override
	public void disable() {
		Creator.enemySpeed = tempSpeed;
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setSpeed(tempSpeed);
		}
	}

	@Override
	public boolean update(float delta) {
		
		timeCounter += delta;
		if(timeCounter>=timeToLast)
			return false;
		else
			return true;
	}

}
