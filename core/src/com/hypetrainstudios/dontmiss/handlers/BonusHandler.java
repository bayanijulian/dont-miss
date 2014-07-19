package com.hypetrainstudios.dontmiss.handlers;

import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.Creator;

public class BonusHandler {
	//chances are out of 100, so they all need to add up to 100

	//private static int [] percentages = {11,16,7,13,9,6,5,16,11,6};
	private static int [] percentages = {10,10,10,10,10,10,10,10,10,10};
	
	private static int [] bonusChance = new int[100];
	public static int activeBonus = 0;
	private static int potentialBonus = 0;
	private static float timeToSpawnBonus = 5;
	private static float timeToSpawnBonusCounter = 0;
	public static float lastKilledX;
	public static float lastKilledY;
	public static void createChances(){
		int counter = 0;
		for(int i = 0; i<percentages.length;i++){
			for(int x = 0; x<percentages[i];x++){
				bonusChance[counter] = i;
				counter++;
			}
		}
	}
	
	public static void setActiveBonus(int bonusType){
		Creator.bonusTypes.get(activeBonus).disable();
		Creator.bonusTypes.get(bonusType).enable();
		
		activeBonus = bonusType;
	}
	public static void update(float delta){
		timeToSpawnBonusCounter += delta;
		if(timeToSpawnBonusCounter>=timeToSpawnBonus)
		{
			potentialBonus = bonusChance[MathUtils.random(bonusChance.length-1)];
			
			Creator.createBonus(potentialBonus+1);
			timeToSpawnBonusCounter = 0;
		}
		
		if(!Creator.bonusTypes.get(activeBonus).update(delta))
			Creator.bonusTypes.get(activeBonus).disable();
	}
}
