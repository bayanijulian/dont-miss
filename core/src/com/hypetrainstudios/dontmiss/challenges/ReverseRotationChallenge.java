package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class ReverseRotationChallenge extends Challenge{

	@Override
	public void update() {
		if(currentCode==codeCollision){
			Creator.turretRotationSpeed*=-1;
			Creator.player.setRotationSpeed(Creator.turretRotationSpeed);
		}
			
	}

}
