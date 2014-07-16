package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;



public class MultipleProjectilesBonus extends BaseBonus{

	
	private int lastNumOfProjectiles;
	private int amountToShoot = 5;
	
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
