package com.hypetrainstudios.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class FrostChallenge extends Challenge{

	@Override
	public void update() {
		if(currentCode==codeCollision)
			Creator.fireRate*=1.5;
		if(currentCode==codeMiss)
			Creator.fireRate/=2;
	}
	
}
