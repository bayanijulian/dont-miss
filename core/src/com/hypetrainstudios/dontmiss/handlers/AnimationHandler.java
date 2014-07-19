package com.hypetrainstudios.dontmiss.handlers;

import com.hypetrainstudios.dontmiss.Creator;

public class AnimationHandler {
	public static void update(float delta){
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).updateAnimations(delta);
		
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).updateAnimations(delta);
		
		for(int i =0; i < Creator.bonuses.size(); i++)
			Creator.bonuses.get(i).updateAnimations(delta);
		
		for(int i = 0; i < Creator.misc.size(); i ++){
			if(Creator.misc.get(i).getName().substring(0, 6).equals("reload")){
				Creator.misc.get(i).updateAnimations(Creator.fireRateCounter/Creator.fireRate);
			}
			else
				Creator.misc.get(i).updateAnimations(delta);
		}
		
		Creator.midTurret.updateAnimations(delta);
	}
}
