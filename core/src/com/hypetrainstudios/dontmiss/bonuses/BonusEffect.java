package com.hypetrainstudios.dontmiss.bonuses;

public abstract class BonusEffect {
	protected float timeToLast;
	public BonusEffect(){
		timeToLast=0;
	}
	public abstract void enable();
	public abstract void disable();
	public abstract boolean update();
}
