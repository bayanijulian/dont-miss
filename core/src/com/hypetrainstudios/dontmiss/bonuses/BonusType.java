package com.hypetrainstudios.dontmiss.bonuses;

public class BonusType {
	public enum Effector{
		Player,
		Field,
		Enemy,
		Projectile,
	}
	protected Effector effector;
	public BonusType(){
		
	}
	public Effector getEffector(){
		return effector;
	}
}
