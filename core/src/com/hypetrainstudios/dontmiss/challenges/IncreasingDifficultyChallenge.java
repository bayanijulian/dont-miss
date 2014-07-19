package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class IncreasingDifficultyChallenge extends Challenge{

	private static float time = 0;
	public static float speed = .07f;
	@Override
	public void update(float delta) {
		time+=delta;
		if(time>=2){
			time = 0;
			Creator.spawnWaveRate -= .03;
			if(Creator.enemySpeed<=.3){
				speed+=.002f;
				Creator.enemySpeed=speed;
			}
				
		}
	}
}
