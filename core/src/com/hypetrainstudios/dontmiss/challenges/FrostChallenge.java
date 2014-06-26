package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class FrostChallenge extends Challenge{

	@Override
	public void update(float delta) {
		if(currentCode==codeCollision){
			if(Creator.fireRate>Creator.fireRateMin)	Creator.fireRate-=.08;
			else	Creator.fireRate=Creator.fireRateMin;
		}
			
		if(currentCode==codeMiss){
			if(Creator.fireRate<Creator.fireRateMax)	Creator.fireRate+=.1;
			else	Creator.fireRate=Creator.fireRateMax;
		}
			
	}
	
}
