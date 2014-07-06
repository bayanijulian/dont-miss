package com.hypetrainstudios.dontmiss;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.bonuses.BonusAffect;
import com.hypetrainstudios.dontmiss.bonuses.CollateralProjectilesBonus;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.enemies.EnemyType;
import com.hypetrainstudios.dontmiss.entity.Bonus;
import com.hypetrainstudios.dontmiss.entity.Enemy;
import com.hypetrainstudios.dontmiss.entity.Misc;
import com.hypetrainstudios.dontmiss.entity.Projectile;
import com.hypetrainstudios.dontmiss.entity.Turret;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.ChallengeHandler;
import com.hypetrainstudios.dontmiss.handlers.SpawnHandler;

public class Creator {
	
	public static float projectileSpeed = 35f;
	public static float enemySpeed = .05f;
	public static float turretRotationSpeed = 155f;
	public static int totalProjectiles = 5;
	
	public static float gameTime = 180;
	public static boolean gameOver = false;
	
	public static float spawnWaveRate = 7;
	public static float spawnWaveCounter = 7;
	public static final float spawnRateMax = 7f,spawnRateMin = 4f;
	
	public static float fireRate = .8f;
	public static final float  fireRateMin = .3f,fireRateMax = 3f;
	public static float fireRateCounter = .8f;
	
	public static ArrayList<Challenge> challenges = new ArrayList<Challenge>();
	public static ArrayList<BonusAffect> bonusTypes = new ArrayList<BonusAffect>();
	public static ArrayList<EnemyType> enemyTypes = new ArrayList<EnemyType>();
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public static ArrayList<Misc> misc = new ArrayList<Misc>();
	public static ArrayList<Bonus> bonuses = new ArrayList<Bonus>();
	public static Turret player = new Turret(new Sprite(AssetHandler.manager.get(AssetHandler.imgTurretLayout)),turretRotationSpeed);
	
	public static void createProjectile(){
		if(fireRateCounter >= fireRate){
			fireRateCounter = 0;
			projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed));
		}
	}
	public static void createEnemy(float degrees){
			enemies.add(new Enemy(new Sprite(AssetHandler.manager.get(AssetHandler.imgEnemyBlue)),player.getSprite(),enemySpeed,degrees));
	}
	public static void createBonus(){
		bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.imgBonus))));
	}
	public static void update(float delta)
	{
		gameTime-=delta;
		fireRateCounter += delta;
		updateSpawn(delta);
		updateEntites(delta);
		updateChallenge(delta);
		checkForGarbage();
	}
	
	private static void updateSpawn(float delta){
		
		if(spawnWaveCounter>=spawnWaveRate){
			SpawnHandler.update(gameTime);
			spawnWaveCounter = 0;
		}
		else
			spawnWaveCounter+=delta;
	}
	public static void createBonus(int bonusType){
//		if(bonusType==0)		bonus.add(new Bonus());
//		else if(bonusType==1)	bonus.add(new Bonus());
//		else if(bonusType==2)	bonus.add(new Bonus());
//		else if(bonusType==3)	bonus.add(new Bonus());
//		else if(bonusType==4)	bonus.add(new Bonus());
//		else if(bonusType==5)	bonus.add(new Bonus());
//		else if(bonusType==6)	bonus.add(new Bonus());
//		else if(bonusType==7)	bonus.add(new Bonus());
//		else if(bonusType==8)	bonus.add(new Bonus());
//		else if(bonusType==9)	bonus.add(new Bonus());
		
	}
	public static void reset(){
		gameOver = false;
		SpawnHandler.spawn = true;
		challenges.clear();
		enemies.clear();
		projectiles.clear();
		enemyTypes.clear();
		bonusTypes.clear();
		misc.clear();
		
		gameTime = 180;
		spawnWaveRate = 7f;
		spawnWaveCounter = 7f;
		fireRate = .3f;
		fireRateCounter = .8f;
		turretRotationSpeed = 155f;
		projectileSpeed = 35f;
		enemySpeed = .05f;
		totalProjectiles = 5;
		
		player.setRotationSpeed(turretRotationSpeed);
		player.getSprite().setRotation(270);
		player.setRotationCounter(0);
		player.getSprite().setAlpha(1);
		
		ChallengeHandler.challengeCounter = 0;
	}
	private static void checkForGarbage()
	{
		//removes projectiles
		for(int i=0;i<projectiles.size();i++)
		{
			if(!(projectiles.get(i).isActive()))
				projectiles.remove(i);
		}
		//removes enemies
		for(int i=0;i<enemies.size();i++)
		{
			if(!(enemies.get(i).isActive()))
				enemies.remove(i);
		}
	}
	private static void updateChallenge(float delta){
		ChallengeHandler.update(gameTime);
		for(int i = 0; i < challenges.size(); i ++){
			challenges.get(i).update(delta);
		}
		Challenge.currentCode = Challenge.codeDefault;
	}
	private static void updateEntites(float delta){
		player.update(delta);
		
		for(int i = 0; i<projectiles.size();i++)
			projectiles.get(i).update(delta);
		for(int i = 0; i < enemies.size(); i++)
			enemies.get(i).update(delta);
		for(int i = 0; i<bonuses.size();i++)
			bonuses.get(i).update(delta);
		
	}
}
