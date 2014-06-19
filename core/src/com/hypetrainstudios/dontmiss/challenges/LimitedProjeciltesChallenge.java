package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class LimitedProjeciltesChallenge extends Challenge{

	
	private static int totalProjectiles = 30;
	private static float time;
	
	@Override
	public void update(float delta) {
		if(Challenge.currentCode == Challenge.codeCollision){
			totalProjectiles += 3;
		}
		if(Challenge.currentCode == Challenge.codeMiss){
			if(totalProjectiles<0)
				Creator.fireRate = 5;
			else
				totalProjectiles -= 1;
		}
		if(Creator.fireRate==5){
			time+=delta;
			if(time>=5)
				totalProjectiles = 5;
		}
		System.out.println("Total Bullets:\t" + totalProjectiles);
	}
	public static int getTotalProjectiles(){
		return totalProjectiles;
	}
}