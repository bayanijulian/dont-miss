package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.Creator;



public class NukeBonus extends BonusEffect{

	public NukeBonus() {
		timeToLast = 5f;
	}

	@Override
	public void enable() {
		for(int i = 0; i<Creator.enemies.size();i++){
			Creator.enemies.get(i).setActive(false);
		}
	}

	@Override
	public void disable() {
	}

}
