package com.hypetrainstudios.dontmiss.handlers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetHandler {
	public static final AssetManager manager = new AssetManager();

	public static final AssetDescriptor<Texture> imgTurretLayout = new AssetDescriptor<Texture>("turretLayout.png", Texture.class);
	public static final AssetDescriptor<Texture> imgTurretRed = new AssetDescriptor<Texture>("turretRed.png", Texture.class);
	public static final AssetDescriptor<Texture> imgTurretBlue = new AssetDescriptor<Texture>("turretBlue.png", Texture.class);
	public static final AssetDescriptor<Texture> imgTurretYellow = new AssetDescriptor<Texture>("turretYellow.png", Texture.class);

	public static final AssetDescriptor<Texture> imgProjectileRed = new AssetDescriptor<Texture>("projectileRed.png", Texture.class);
	public static final AssetDescriptor<Texture> imgProjectileBlue = new AssetDescriptor<Texture>("projectileBlue.png", Texture.class);
	public static final AssetDescriptor<Texture> imgProjectileYellow = new AssetDescriptor<Texture>("projectileYellow.png", Texture.class);

	public static final AssetDescriptor<Texture> imgEnemyRed = new AssetDescriptor<Texture>("enemyRed.png", Texture.class);
	public static final AssetDescriptor<Texture> imgEnemyBlue = new AssetDescriptor<Texture>("enemyBlue.png", Texture.class);
	public static final AssetDescriptor<Texture> imgEnemyYellow = new AssetDescriptor<Texture>("enemyYellow.png", Texture.class);
	
	public static final AssetDescriptor<BitmapFont> fontPlay = new AssetDescriptor<BitmapFont>("play.fnt", BitmapFont.class);
	
	public static void load(){
		manager.load(imgTurretLayout);
		manager.load(imgTurretRed);
		manager.load(imgTurretBlue);
		manager.load(imgTurretYellow);

		manager.load(imgProjectileRed);
		manager.load(imgProjectileBlue);
		manager.load(imgProjectileYellow);

		manager.load(imgEnemyRed);
		manager.load(imgEnemyBlue);
		manager.load(imgEnemyYellow);
		
		manager.load(fontPlay);
	}

	public static void setTextures(){
		manager.get(imgTurretLayout).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgTurretRed).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgTurretBlue).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgTurretYellow).setFilter(TextureFilter.Linear,TextureFilter.Linear);

		manager.get(imgProjectileRed).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgProjectileBlue).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgProjectileYellow).setFilter(TextureFilter.Linear,TextureFilter.Linear);

		manager.get(imgEnemyRed).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgEnemyBlue).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgEnemyYellow).setFilter(TextureFilter.Linear,TextureFilter.Linear);
	}

	public static void dispose(){
		manager.dispose();
	}
}
