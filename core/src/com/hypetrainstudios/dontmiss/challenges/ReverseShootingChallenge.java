package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class ReverseShootingChallenge extends Challenge{
	private static boolean didAlready = false;
	@Override
	public void update(float delta) {
		if(!didAlready){
			Creator.player.setRotationCounter(Creator.player.getRotationCounter()+180);
			didAlready =true;
		}
			
	}

}
