package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class DisappearingPlayerChallenge extends Challenge{
	
	private float time = 0;
	@Override
	public void update(float delta) {
		time+=delta;
		if(time>=4){
			time = 0;
			Creator.midTurret.getSprite().setAlpha(0);
		}
		if(time>=1&& Creator.midTurret.getSprite().getColor().a<=.15)
			Creator.midTurret.getSprite().setAlpha(1);
	}

}
