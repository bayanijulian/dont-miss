package com.hypetrainstudios.dontmiss.handlers;

import java.util.Random;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.FrostChallenge;

public class SpawnHandler {
	
	
	private static Random rdm = new Random();
	private static void spawnAmountRdm(int amountToSpawn){
		for(int i = 0; i<amountToSpawn; i ++)
		{
			Creator.createEnemy((rdm.nextInt(360)));
		}
	}
	private static void spawnAmountSpacedEqually(int amountToSpawn){
		float incrementBy = 360.0f/amountToSpawn;
		float currentDegrees = 0;
		for (int i = 0; i<amountToSpawn; i++)
		{
			currentDegrees+=incrementBy;
			Creator.createEnemy(currentDegrees);
		}
	}
	private static void spawnWithSwitchUp(int amountToSpawn)
	{
		if(rdm.nextBoolean())
			spawnAmountSpacedEqually(amountToSpawn);
		else
			spawnAmountRdm(amountToSpawn);
	}
	private static void spawnMoreRandomly(int potentialAmountToSpawn)
	{
		int actualAmountToSpawn = rdm.nextInt(potentialAmountToSpawn);
		spawnWithSwitchUp(actualAmountToSpawn);
	}
	private static void spawnFor180(){
		
		spawnWithSwitchUp(4);
	}
	private static void spawnFor165(){
		spawnWithSwitchUp(4);
	}
	private static void spawnFor150(){
		spawnWithSwitchUp(5);
	}
	private static void spawnFor135(){
		spawnMoreRandomly(5);
	}
	private static void spawnFor120(){
		spawnWithSwitchUp(5);
	}
	private static void spawnFor105(){
		spawnWithSwitchUp(6);
	}
	private static void spawnFor090(){
		spawnMoreRandomly(6);
	}
	private static void spawnFor075(){
		spawnMoreRandomly(12);
	}
	private static void spawnFor060(){
		spawnWithSwitchUp(5);
	}
	private static void spawnFor045(){
		spawnWithSwitchUp(7);
	}
	private static void spawnFor030(){
		spawnMoreRandomly(9);
	}

	private static void spawnFor015(){
		spawnMoreRandomly(12);
	}

	public static void update(float time){
		if(time<=15)	spawnFor015();
		else if (time<=30) spawnFor030();
		else if (time<=45) spawnFor045();
		else if (time<=60) spawnFor060();
		else if (time<=75) spawnFor075();
		else if (time<=90) spawnFor090();
		else if (time<=105) spawnFor105();
		else if (time<=120) spawnFor120();
		else if (time<=135) spawnFor135();
		else if (time<=150) spawnFor150();
		else if (time<=165) spawnFor165();
		else if (time<=180) spawnFor180();	
	}
}
