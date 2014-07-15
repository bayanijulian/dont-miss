package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;

public class AssassinBonus extends BaseBonus{
	
	private int lastNumOfProjectiles;
	private int amountToShoot = 1;
	
	@Override
	public void enable() {
		lastNumOfProjectiles = Creator.totalProjectilesShotSoFar;
	}

	@Override
	public void disable() {
		BonusHandler.activeBonus = 0;
	}

	@Override
	public boolean update(float delta) {
		
		if(Creator.totalProjectilesShotSoFar>=(lastNumOfProjectiles+amountToShoot)){
			return false;
		}
		return true;
	}

}
