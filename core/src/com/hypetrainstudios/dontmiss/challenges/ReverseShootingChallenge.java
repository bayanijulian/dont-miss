package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class ReverseShootingChallenge extends Challenge{
	private boolean didAlready = false;
	@Override
	public void update(float delta) {
		if(!didAlready){
			Creator.midTurret.setRotationCounter(Creator.midTurret.getRotationCounter()+180);
			didAlready =true;
		}
			
	}

}
