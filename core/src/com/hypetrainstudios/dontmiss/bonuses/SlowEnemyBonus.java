package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.IncreasingDifficultyChallenge;

public class SlowEnemyBonus extends BaseBonus{

	private float slowSpeed = .01f;
	private float timeCounter;
	private float timeToLast;

	@Override
	public void enable() {
		
		Creator.enemySpeed = slowSpeed;
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setSpeed(slowSpeed);
		}
		timeCounter = 0;
		timeToLast = 5;
	}

	@Override
	public void disable() {
		Creator.enemySpeed = IncreasingDifficultyChallenge.speed;
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setSpeed(IncreasingDifficultyChallenge.speed);
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
