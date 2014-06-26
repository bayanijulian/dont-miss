package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class LimitedProjeciltesChallenge extends Challenge{

	
	private int totalProjectiles = 5;
	private int addOn = 1;
	private float time;
	
	@Override
	public void update(float delta) {
		if(Challenge.currentCode == Challenge.codeCollision){
			totalProjectiles += addOn;
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
	public int getTotalProjectiles(){
		return totalProjectiles;
	}
}
