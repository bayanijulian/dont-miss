package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class ReverseRotationChallenge extends Challenge{

	@Override
	public void update(float delta) {
		if(currentCode==codeCollision){
			Creator.turretRotationSpeed*=-1;
			Creator.midTurret.setRotationSpeed(Creator.turretRotationSpeed);
		}
			
	}

}
