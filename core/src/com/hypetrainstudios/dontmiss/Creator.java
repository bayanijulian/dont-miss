package com.hypetrainstudios.dontmiss;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.entity.Enemy;
import com.hypetrainstudios.dontmiss.entity.Projectile;
import com.hypetrainstudios.dontmiss.entity.Turret;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;

public class Creator {
	
	public static float projectileSpeed = 35f;
	public static float enemySpeed = .05f;
	public static float turretRotationSpeed = 155f;
	
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public static Turret player = new Turret(new Sprite(AssetHandler.manager.get(AssetHandler.imgTurretLayout)),turretRotationSpeed);
		
}
