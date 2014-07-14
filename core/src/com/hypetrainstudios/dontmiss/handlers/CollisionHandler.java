package com.hypetrainstudios.dontmiss.handlers;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.Challenge;

/* Author:	Bayani Julian
 * The class to handle collision 
 */

public class CollisionHandler {
	public static void update(){
		
		//Checks collision between projectile and enemies
		for (int x=0; x<Creator.projectiles.size();x++)
			for (int k=0; k<Creator.enemies.size();k++)
				if( Creator.projectiles.get(x).getCircle().overlaps( Creator.enemies.get(k).getCircle() ) )
					enemyCollision(k,x);
		
		//Checks collision between projectiles and the player
		for(int  x= 0; x<Creator.enemies.size();x++)
			if(Creator.enemies.get(x).getCircle().overlaps(Creator.midTurret.getCircle()))
				playerCollision();
		
		//Checks collision between projectile and bonuses
		for (int x=0; x<Creator.projectiles.size();x++)
			for (int k=0; k<Creator.bonuses.size();k++)
				if( Creator.projectiles.get(x).getCircle().overlaps( Creator.bonuses.get(k).getCircle() ) )
					bonusCollision(k,x);
		
	}
	
	private static void enemyCollision(int k, int x){
		//Removes both the projectile and enemy from the screen
		Creator.enemies.get(k).setActive(false);
		//Creator.projectiles.get(x).setActive(false);
		Creator.projectiles.get(x).setCollisionWithEnemy(true);
		//sends a signal to the challenge class saying there has been a collision (essentially)
		Challenge.currentCode = Challenge.codeCollision;
		
		ScoreHandler.score +=1;
		System.out.println(ScoreHandler.score);
		
	}
	
	private static void bonusCollision(int k, int x){
		Creator.bonuses.get(k).setActive(false);
		Creator.projectiles.get(x).setCollisionWithEnemy(true);
	}
	
	private static void playerCollision(){
		//puts the game in a game over state
		Creator.gameOver = true;
	}
}
