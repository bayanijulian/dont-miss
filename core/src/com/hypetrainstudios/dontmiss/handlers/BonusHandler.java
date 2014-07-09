package com.hypetrainstudios.dontmiss.handlers;

import com.badlogic.gdx.math.MathUtils;

public class BonusHandler {
	//chances are out of 100, so they all need to add up to 100
//	private static int chanceCollateralProjectile = 11;	//1
//	private static int chanceExplosiveProjectile = 16;	//2
//	private static int chanceGuidedProjectile = 7;		//3
//	private static int chanceLandMine = 13;				//4
//	private static int chanceMultipleProjectile = 9;	//5
//	private static int chanceNuke = 6;					//6
//	private static int chanceSheild = 5;				//7
//	private static int chanceSlowEnemy = 16;			//8
//	private static int chanceSpike = 11;				//9
//	private static int chanceVision = 6;				//10
	
	private static int [] percentages = {11,16,7,13,9,6,5,16,11,6};
	
	
	private static int [] bonusChance = new int[100];
	public static int currentBonus = -1;
	
	private static float timeToSpawnBonus = 5;
	private static float timeToSpawnBonusCounter = 0;
	public static void createChances(){
//		int total = 0;
//		for(int i = 0; i<10;i++){
//			total+=percentages[i];
//		}
//		System.out.println("Percentages: " + total);
//		System.out.println(percentages.length);
		int counter = 0;
		for(int i = 0; i<percentages.length;i++){
			for(int x = 0; x<percentages[i];x++){
				
				bonusChance[counter] = i;
				counter++;
			}
		}
		
		
		
	}
	
	
	public static void update(float delta){
		timeToSpawnBonus += delta;
		if(timeToSpawnBonusCounter>=timeToSpawnBonus)
		{
			currentBonus = bonusChance[MathUtils.random(bonusChance.length-1)];
		}
			
	}
}
