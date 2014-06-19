package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class IncreasingDifficultyChallenge extends Challenge{

	private static float time = 0;
	@Override
	public void update(float delta) {
		time+=delta;
		if(time>=2){
			time = 0;
			Creator.spawnWaveRate -= .03;
			if(Creator.enemySpeed<=.3)
				Creator.enemySpeed+=.001;
		}
	}
}
