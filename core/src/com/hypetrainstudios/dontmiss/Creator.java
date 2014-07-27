   package com.hypetrainstudios.dontmiss;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.bonuses.AssassinBonus;
import com.hypetrainstudios.dontmiss.bonuses.BaseBonus;
import com.hypetrainstudios.dontmiss.bonuses.BiggerProjectilesBonus;
import com.hypetrainstudios.dontmiss.bonuses.ExplosiveProjectilesBonus;
import com.hypetrainstudios.dontmiss.bonuses.ExtraTurretBonus;
import com.hypetrainstudios.dontmiss.bonuses.LandMineBonus;
import com.hypetrainstudios.dontmiss.bonuses.MultipleProjectilesBonus;
import com.hypetrainstudios.dontmiss.bonuses.NukeBonus;
import com.hypetrainstudios.dontmiss.bonuses.SheildBonus;
import com.hypetrainstudios.dontmiss.bonuses.SlowEnemyBonus;
import com.hypetrainstudios.dontmiss.bonuses.SpikeBonus;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.challenges.ColorMatchChallenge;
import com.hypetrainstudios.dontmiss.enemies.Pawn;
import com.hypetrainstudios.dontmiss.enemies.Swift;
import com.hypetrainstudios.dontmiss.entity.Bonus;
import com.hypetrainstudios.dontmiss.entity.Enemy;
import com.hypetrainstudios.dontmiss.entity.Misc;
import com.hypetrainstudios.dontmiss.entity.Projectile;
import com.hypetrainstudios.dontmiss.entity.Turret;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;
import com.hypetrainstudios.dontmiss.handlers.ChallengeHandler;
import com.hypetrainstudios.dontmiss.handlers.InGameUIHandler;
import com.hypetrainstudios.dontmiss.handlers.SpawnHandler;


public class Creator {
	
	public static float projectileSpeed = 35f;
	public static float enemySpeed = .08f;
	public static float turretRotationSpeed = 155f;
	public static int totalProjectiles = 5;
	
	public static float gameTime = 180;
	public static boolean gameOver = false;
	public static int totalProjectilesShotSoFar = 0;
	public static float spawnWaveRate = 7;
	public static float spawnWaveCounter = 7;
	public static final float spawnRateMax = 7f,spawnRateMin = 4f;
	
	public static float fireRate = .8f;
	public static final float  fireRateMin = .3f,fireRateMax = 3f;
	public static float fireRateCounter = .8f;
	
	public static ArrayList<Challenge> challenges = new ArrayList<Challenge>();
	public static ArrayList<BaseBonus> bonusTypes = new ArrayList<BaseBonus>();
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Turret> turrets = new ArrayList<Turret>();
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public static ArrayList<Misc> misc = new ArrayList<Misc>();
	public static ArrayList<Bonus> bonuses = new ArrayList<Bonus>();
	public static Turret midTurret = new Turret(new Sprite(AssetHandler.manager.get(AssetHandler.imgTurret)),turretRotationSpeed);
	
	
	
	public static void createMiscProjectileLoading(){
		Misc reloadBlue = new Misc(new Sprite(AssetHandler.manager.get(AssetHandler.atlasReload).findRegion("reloadBlue")),"reloadBlue");
		reloadBlue.setCenter(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		reloadBlue.createLivingAnimation(30, AssetHandler.manager.get(AssetHandler.atlasReload).findRegions("reloadBlue"), PlayMode.NORMAL,true);
		
		misc.add(reloadBlue);
		
		Misc reloadRed = new Misc(new Sprite(AssetHandler.manager.get(AssetHandler.atlasReload).findRegion("reloadRed")),"reloadRed");
		reloadRed.setCenter(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		reloadRed.createLivingAnimation(30, AssetHandler.manager.get(AssetHandler.atlasReload).findRegions("reloadRed"), PlayMode.NORMAL,true);
		reloadRed.getSprite().setAlpha(0);
		misc.add(reloadRed);
		
		Misc reloadYellow = new Misc(new Sprite(AssetHandler.manager.get(AssetHandler.atlasReload).findRegion("reloadYellow")),"reloadYellow");
		reloadYellow.setCenter(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		reloadYellow.createLivingAnimation(30, AssetHandler.manager.get(AssetHandler.atlasReload).findRegions("reloadYellow"), PlayMode.NORMAL,true);
		reloadYellow.getSprite().setAlpha(0);
		misc.add(reloadYellow);
	}
	public static void createShield(){
		Misc shield = new Misc(new Sprite(AssetHandler.manager.get(AssetHandler.imgShield)),"shield");
		shield.setCenter(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		misc.add(shield);
	}
	public static void createLandmine(){
		misc.add(new Misc(new Sprite(AssetHandler.manager.get(AssetHandler.imgMiscLandMine)),"landmine"));
	}
	public static void createSpikes(){
		misc.add(new Misc(new Sprite(AssetHandler.manager.get(AssetHandler.imgMiscSpikes)),"spikes"));
	}
	public static void createProjectile(){
		if(fireRateCounter >= fireRate){
			fireRateCounter = 0;
			if(ColorMatchChallenge.colorEnabled){
				if(BonusHandler.activeBonus==6){
					projectiles.add(new Projectile(new Sprite(ColorMatchChallenge.randomProjectileColor()), projectileSpeed,midTurret.getRotationCounter()+(90),BonusHandler.activeBonus));
					projectiles.add(new Projectile(new Sprite(ColorMatchChallenge.randomProjectileColor()), projectileSpeed,midTurret.getRotationCounter()-(90),BonusHandler.activeBonus));
					totalProjectilesShotSoFar+=2;
				}
				projectiles.add(new Projectile(new Sprite(ColorMatchChallenge.randomProjectileColor()), projectileSpeed,BonusHandler.activeBonus));
				totalProjectilesShotSoFar++;
			}
			else{
				if(BonusHandler.activeBonus==6){
					projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed,midTurret.getRotationCounter()+(90),BonusHandler.activeBonus));
					projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed,midTurret.getRotationCounter()-(90),BonusHandler.activeBonus));
					totalProjectilesShotSoFar+=2;
				}
				projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed,BonusHandler.activeBonus));
				totalProjectilesShotSoFar++;
			}
		}
	}
	public static void createEnemy(float degrees){
		if(ColorMatchChallenge.colorEnabled)	enemies.add(new Pawn(new Sprite(ColorMatchChallenge.randomEnemyColor()),midTurret.getSprite(),enemySpeed,degrees));
		else	enemies.add(new Pawn(new Sprite(AssetHandler.manager.get(AssetHandler.imgEnemyBlue)),midTurret.getSprite(),enemySpeed,degrees));
	}
	public static void createEnemy(float x,float y){
		if(ColorMatchChallenge.colorEnabled)	enemies.add(new Pawn(new Sprite(ColorMatchChallenge.randomEnemyColor()),midTurret.getSprite(),enemySpeed,x,y));
		else	enemies.add(new Pawn(new Sprite(AssetHandler.manager.get(AssetHandler.imgEnemyBlue)),midTurret.getSprite(),enemySpeed,x,y));
	}
	public static void createBonus(int bonusType){
		if(bonusType==0)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusAlly")),bonusType));
		else if(bonusType==1)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusAssassin")),bonusType));
		else if(bonusType==2)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusBigger")),bonusType));
		
		else if(bonusType==3)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusExplosive")),bonusType));
		else if(bonusType==5)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusLandMine")),bonusType));
		else if(bonusType==6)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusMultiples")),bonusType));
		else if(bonusType==7)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusNuke")),bonusType));
		else if(bonusType==8)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusSheild")),bonusType));
		else if(bonusType==9)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusSlow")),bonusType));
		else if(bonusType==10)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusSpikes")),bonusType));

	}
	public static void setUp(){
		bonusTypes.add(new BaseBonus());
		bonusTypes.add(new AssassinBonus());
		bonusTypes.add(new BiggerProjectilesBonus());
		bonusTypes.add(new ExplosiveProjectilesBonus());
		bonusTypes.add(new ExtraTurretBonus());
		bonusTypes.add(new LandMineBonus());
		bonusTypes.add(new MultipleProjectilesBonus());
		bonusTypes.add(new NukeBonus());
		bonusTypes.add(new SheildBonus());
		bonusTypes.add(new SlowEnemyBonus());
		bonusTypes.add(new SpikeBonus());
		
		
		//turrets.add(new Turret(new Sprite(AssetHandler.manager.get(AssetHandler.imgTurret)),turretRotationSpeed));
		enemies.add(new Swift(new Sprite(AssetHandler.manager.get(AssetHandler.imgEnemyYellow)), midTurret.getSprite(), 4, 0));
		
		createMiscProjectileLoading();
		createShield();
		InGameUIHandler.createUI();
		BonusHandler.createChances();
	}
	
	
	public static void reset(){
		gameOver = false;
		SpawnHandler.spawn = true;
		challenges.clear();
		enemies.clear();
		projectiles.clear();
		
		
		misc.clear();
		bonuses.clear();
		
		gameTime = 180;
		spawnWaveRate = 7f;
		spawnWaveCounter = 7f;
		fireRate = .8f;
		fireRateCounter = .8f;
		turretRotationSpeed = 155f;
		projectileSpeed = 35f;
		enemySpeed = .08f;
		totalProjectiles = 5;
		
		midTurret.setRotationSpeed(turretRotationSpeed);
		midTurret.getSprite().setRotation(270);
		midTurret.setRotationCounter(0);
		midTurret.getSprite().setAlpha(1);
		midTurret.enableSheild();
		
		createMiscProjectileLoading();
		createShield();
		ChallengeHandler.challengeCounter = 0;
	}
	
	
	
}
