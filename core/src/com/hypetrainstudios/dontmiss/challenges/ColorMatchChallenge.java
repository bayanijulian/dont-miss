package com.hypetrainstudios.dontmiss.challenges;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;

public class ColorMatchChallenge extends Challenge{

	public static boolean colorEnabled = false;
	private static int nextProjectileColor = 0;
	
	
	public ColorMatchChallenge(){
		colorEnabled = true;
		nextProjectile();
	}
	
	@Override
	public void update(float delta) {
		
	}
	
	
	
	private static void nextProjectile(){
		nextProjectileColor = MathUtils.random(2);
		if(nextProjectileColor==0){		
			for(int i = 0; i< Creator.misc.size(); i++){	
				if(Creator.misc.get(i).getName().equals("reloadBlue")){
					Creator.misc.get(i).getSprite().setAlpha(1);
				}
				else if	(Creator.misc.get(i).getName().equals("reloadRed")){
					Creator.misc.get(i).getSprite().setAlpha(0);
				}
				else if(Creator.misc.get(i).getName().equals("reloadYellow")){
					Creator.misc.get(i).getSprite().setAlpha(0);
				}
			}
		}
		else if(nextProjectileColor==1){	
			for(int i = 0; i< Creator.misc.size(); i++){	
				if(Creator.misc.get(i).getName().equals("reloadBlue")){
					Creator.misc.get(i).getSprite().setAlpha(0);
				}
				else if	(Creator.misc.get(i).getName().equals("reloadRed")){
					Creator.misc.get(i).getSprite().setAlpha(1);
				}
				else if(Creator.misc.get(i).getName().equals("reloadYellow")){
					Creator.misc.get(i).getSprite().setAlpha(0);
				}
			}
		}
		else{		
			for(int i = 0; i< Creator.misc.size(); i++){	
				if(Creator.misc.get(i).getName().equals("reloadBlue")){
					Creator.misc.get(i).getSprite().setAlpha(0);
				}
				else if	(Creator.misc.get(i).getName().equals("reloadRed")){
					Creator.misc.get(i).getSprite().setAlpha(0);
				}
				else if(Creator.misc.get(i).getName().equals("reloadYellow")){
					Creator.misc.get(i).getSprite().setAlpha(1);
				}
			}
			
		}
	}
	public static Texture randomProjectileColor(){
		
		if(nextProjectileColor==0){		
			nextProjectile();
			return AssetHandler.manager.get(AssetHandler.imgProjectileBlue);
		}
		else if(nextProjectileColor==1){	
			nextProjectile();
			return AssetHandler.manager.get(AssetHandler.imgProjectileRed);
		}
		else{		
			nextProjectile();
			return AssetHandler.manager.get(AssetHandler.imgProjectileYellow);
		}
	}
	
	public static Texture randomEnemyColor(){
		int rdm = MathUtils.random(2);
		if(rdm==0)		return AssetHandler.manager.get(AssetHandler.imgEnemyBlue);
		else if(rdm==1)	return AssetHandler.manager.get(AssetHandler.imgEnemyRed);
		else			return AssetHandler.manager.get(AssetHandler.imgEnemyYellow);
	}
}
