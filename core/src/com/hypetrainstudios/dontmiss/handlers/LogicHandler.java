package com.hypetrainstudios.dontmiss.handlers;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.Challenge;

public class LogicHandler {
	public static void update(float delta){
		
		Creator.midTurret.update(delta);
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).update(delta);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).update(delta);
		for(int i = 0; i<Creator.bonuses.size();i++)
			Creator.bonuses.get(i).update(delta);
		for(int i = 0; i <Creator.misc.size(); i ++)
			Creator.misc.get(i).update(delta);
		
		updateChallenge(delta);
		updateSpawn(delta);
		BonusHandler.update(delta);
		
		Creator.gameTime-=delta;
		Creator.fireRateCounter += delta;
	}
	
	private static void updateChallenge(float delta){
		ChallengeHandler.update(Creator.gameTime);
		for(int i = 0; i < Creator.challenges.size(); i ++){
			Creator.challenges.get(i).update(delta);
		}
		Challenge.currentCode = Challenge.codeDefault;
	}
	private static void updateSpawn(float delta){
	
	if(Creator.spawnWaveCounter>=Creator.spawnWaveRate){
		SpawnHandler.update(Creator.gameTime);
		Creator.spawnWaveCounter = 0;
	}
	else
		Creator.spawnWaveCounter+=delta;
	}
	
}
