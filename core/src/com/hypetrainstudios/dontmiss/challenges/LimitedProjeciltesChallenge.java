package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class LimitedProjeciltesChallenge extends Challenge{

	
	
	private int amountToAddOnToProjectilesAferCollision = 1;
	private float time;
	
	@Override
	public void update(float delta) {
		if(Challenge.currentCode == Challenge.codeCollision){
			Creator.totalProjectiles += amountToAddOnToProjectilesAferCollision;
		}
		if(Challenge.currentCode == Challenge.codeMiss){
			if(Creator.totalProjectiles<0)
				Creator.fireRate = 5;
			else
				Creator.totalProjectiles -= 1;
		}
		if(Creator.fireRate==5){
			time+=delta;
			if(time>=5)
				Creator.totalProjectiles = 5;
		}
		
	}
	
}
