package com.hypetrainstudios.dontmiss.bonuses;

public class LandMineBonus extends BonusEffect{
	public LandMineBonus(){
		timeToLast = 5f;
	}

	@Override
	public void enable() {
	}

	@Override
	public void disable() {
	}

	@Override
	public boolean update() {
		return true;
	}
}
