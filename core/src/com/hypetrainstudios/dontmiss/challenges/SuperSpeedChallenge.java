package com.hypetrainstudios.dontmiss.challenges;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.SpawnHandler;



public class SuperSpeedChallenge extends Challenge{
	//private static ShapeRenderer sr = new ShapeRenderer();
	private float time;
	private int numOfEnemies = 4;
	private int counter;
	private float tempSpeed;
	private static float superSpeed = .7f;
	@Override
	public void update(float delta) {
		time+=delta;
		if(time>=10){
			//System.out.println("now its time");
			
			SpawnHandler.spawn = false;
			Creator.enemySpeed = superSpeed;
			if(Creator.enemies.size()<=0){
				sendInEnemy();
				counter++;
			}
			if(counter==numOfEnemies){
				numOfEnemies++;
				time = 0;
				Creator.enemySpeed = tempSpeed;
				SpawnHandler.spawn = true;
			}
		}
		else
			tempSpeed = Creator.enemySpeed;
		
	}
	
	private void sendInEnemy(){
		float degrees = Creator.midTurret.getRotationCounter() + 75;
		Creator.createEnemy(degrees);
		System.out.println("incoming" + Creator.enemySpeed);
	}

}
