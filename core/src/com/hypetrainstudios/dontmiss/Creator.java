package com.hypetrainstudios.dontmiss;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.entity.Enemy;
import com.hypetrainstudios.dontmiss.entity.Projectile;
import com.hypetrainstudios.dontmiss.entity.Turret;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.ChallengeHandler;

public class Creator {
	
	public static float projectileSpeed = 35f;
	public static float enemySpeed = .05f;
	public static float turretRotationSpeed = 155f;
	
	public static float gameTime = 180;
	
	public static float spawnWaveRate = 7;
	public static float spawnWaveCounter = 7;
	public static float fireRate = .8f;
	public static float fireRateCounter = .8f;
	
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public static ArrayList<Challenge> challenges = new ArrayList<Challenge>();
	public static Turret player = new Turret(new Sprite(AssetHandler.manager.get(AssetHandler.imgTurretLayout)),turretRotationSpeed);
	
	public static void createProjectile(){
		if(fireRateCounter >= fireRate){
			fireRateCounter = 0;
			projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed));
		}
			
	}
	public static void createEnemy(float degrees){
		if(spawnWaveCounter >= spawnWaveRate){
			spawnWaveCounter = 0;
			enemies.add(new Enemy(new Sprite(AssetHandler.manager.get(AssetHandler.imgEnemyBlue)),player.getSprite(),enemySpeed,degrees));
		}
			
	}
	public static void update(float delta)
	{
		gameTime-=delta;
		spawnWaveCounter += delta;
		fireRateCounter += delta;
	}
	public static void reset(){
		
		challenges.clear();
		enemies.clear();
		projectiles.clear();
		
		/* Debugging Comments */
		System.out.println("Enemy Size:" + enemies.size());
		System.out.println("Projectile Size:" + projectiles.size());
		System.out.println("Challenge Size:" + challenges.size());
		/* Debugging Comments */
		
		gameTime = 180;
		spawnWaveRate = 7f;
		spawnWaveCounter = 7f;
		fireRate = .8f;
		fireRateCounter = .8f;
		turretRotationSpeed = 155f;
		projectileSpeed = 35f;
		enemySpeed = .05f;
		
		player.setRotationSpeed(turretRotationSpeed);
		player.getSprite().setRotation(270);
		player.setRotationCounter(0);
		player.getSprite().setAlpha(1);
		
		ChallengeHandler.challengeCounter = 0;
	}
	
}
