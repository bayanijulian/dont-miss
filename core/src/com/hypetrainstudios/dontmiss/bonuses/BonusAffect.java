package com.hypetrainstudios.dontmiss.bonuses;

public abstract class BonusAffect {
	protected float timeToLast;
	public BonusAffect(){
		timeToLast=0;
	}
	public abstract void enable();
	public abstract void disable();
}
