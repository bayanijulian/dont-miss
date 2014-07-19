package com.hypetrainstudios.dontmiss.handlers;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.challenges.ColorMatchChallenge;

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
				playerCollision(x);
		
		//Checks collision between projectile and bonuses
		for (int x=0; x<Creator.projectiles.size();x++)
			for (int k=0; k<Creator.bonuses.size();k++)
				if( Creator.projectiles.get(x).getCircle().overlaps( Creator.bonuses.get(k).getCircle() ) )
					bonusCollision(k,x);
		//Checks collision between misc(landmines or spikes) and enemies
		for(int  x= 0; x<Creator.enemies.size();x++)
			for (int k=0; k<Creator.misc.size();k++)
				if(Creator.enemies.get(x).getCircle().overlaps(Creator.misc.get(k).getCircle())&&(Creator.misc.get(k).getName().equals("landmine")||Creator.misc.get(k).getName().equals("spikes")))
					miscCollision(x,k);
	}
	
	private static void enemyCollision(int k, int x){
		//Removes both the projectile and enemy from the screen
		if(ColorMatchChallenge.colorEnabled){
			if(
					(Creator.enemies.get(k).getSprite().getTexture()==AssetHandler.manager.get(AssetHandler.imgEnemyBlue)
					&&Creator.projectiles.get(x).getSprite().getTexture()==AssetHandler.manager.get(AssetHandler.imgProjectileBlue))
					
					||
					
					(Creator.enemies.get(k).getSprite().getTexture()==AssetHandler.manager.get(AssetHandler.imgEnemyRed)
					&&Creator.projectiles.get(x).getSprite().getTexture()==AssetHandler.manager.get(AssetHandler.imgProjectileRed))
					
					||
					
					(Creator.enemies.get(k).getSprite().getTexture()==AssetHandler.manager.get(AssetHandler.imgEnemyYellow)
					&&Creator.projectiles.get(x).getSprite().getTexture()==AssetHandler.manager.get(AssetHandler.imgProjectileYellow))
					
				)
				{
				Creator.enemies.get(k).collisionWithProjectile();
				//Creator.projectiles.get(x).setActive(false);
				Creator.projectiles.get(x).collisionWithEnemy();
				}
		}
		else{
			Creator.enemies.get(k).collisionWithProjectile();;
			//Creator.projectiles.get(x).setActive(false);
			Creator.projectiles.get(x).collisionWithEnemy();
		}
		
		//sends a signal to the challenge class saying there has been a collision (essentially)
		Challenge.currentCode = Challenge.codeCollision;
		ScoreHandler.score +=10;
		System.out.println(ScoreHandler.score);
		
	}
	private static void miscCollision(int x, int k){
		Creator.enemies.get(x).collisionWithMisc();
		Creator.misc.get(k).collisionWithEnemy();
	}
	private static void bonusCollision(int k, int x){
		Creator.bonuses.get(k).collisionWithProjectile();
		
	}
	
	private static void playerCollision(int x){
		//puts the game in a game over state
		Creator.midTurret.collisionWithEnemy();
		Creator.enemies.get(x).collisionWithTurret();
	}
}
