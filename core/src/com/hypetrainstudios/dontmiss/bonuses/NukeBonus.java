package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;



public class NukeBonus extends BaseBonus{

	
	@Override
	public void enable() {
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setActive(false);
		}
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
