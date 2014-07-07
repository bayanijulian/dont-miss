package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;

public class SlowEnemyBonus extends BonusEffect{
	private static float tempSpeed = 0;
	private float slowSpeed = .001f;
	public SlowEnemyBonus() {
		timeToLast = 5f;
	}

	@Override
	public void enable() {
		tempSpeed = Creator.enemySpeed;
		Creator.enemySpeed = slowSpeed;
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setSpeed(slowSpeed);
		}
	}

	@Override
	public void disable() {
		Creator.enemySpeed = tempSpeed;
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setSpeed(tempSpeed);
		}
	}

}
