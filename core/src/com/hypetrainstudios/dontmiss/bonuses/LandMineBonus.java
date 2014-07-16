package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;

public class LandMineBonus extends BaseBonus{
	
	@Override
	public void enable() {
		Creator.createLandmine();
	}

	@Override
	public void disable() {
		BonusHandler.activeBonus = 0;
	}

	@Override
	public boolean update(float delta) {
		return false;
	}
}
