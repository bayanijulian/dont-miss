package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;

public class FrostChallenge extends Challenge{

	@Override
	public void update(float delta) {
		if(currentCode==codeCollision)
			Creator.fireRate/=2;
		if(currentCode==codeMiss)
			Creator.fireRate*=2;
	}
	
}
