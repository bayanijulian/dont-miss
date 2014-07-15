package com.hypetrainstudios.dontmiss.bonuses;

import com.hypetrainstudios.dontmiss.handlers.BonusHandler;

public class BaseBonus {
	
	
	public  void enable(){
	
	}
	public  void disable(){
		BonusHandler.activeBonus = 0;
	}
	public boolean update(float delta){
		return true;
	}
}
