package com.hypetrainstudios.dontmiss.handlers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetHandler {
	public static final AssetManager manager = new AssetManager();
	public static final AssetDescriptor<TextureAtlas> atlas = new AssetDescriptor<TextureAtlas>("images.pack", TextureAtlas.class);
	
	public static TextureRegion get(String name){
		return manager.get(atlas).findRegion(name);
	}
	public static void load(){
		manager.load(atlas);
	}
	public static void dispose(){
		manager.dispose();
	}
}
