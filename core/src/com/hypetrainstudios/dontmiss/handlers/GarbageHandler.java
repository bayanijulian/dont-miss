package com.hypetrainstudios.dontmiss.handlers;

import com.hypetrainstudios.dontmiss.Creator;

public class GarbageHandler {
	public static void update(){
		//removes projectiles
		for(int i=0;i<Creator.projectiles.size();i++){
			if(!(Creator.projectiles.get(i).isActive()))
				Creator.projectiles.remove(i);
		}
		//removes enemies
		for(int i=0;i<Creator.enemies.size();i++){
			if(!(Creator.enemies.get(i).isActive()))
				Creator.enemies.remove(i);
		}
		//removes bonuses
		for(int i = 0; i<Creator.bonuses.size(); i ++){
			if(!(Creator.bonuses.get(i).isActive()))
				Creator.bonuses.remove(i);
		}
		//removes misc
		for(int i = 0; i<Creator.misc.size(); i ++){
			if(!(Creator.misc.get(i).isActive()))
				Creator.misc.remove(i);
		}
	}
}
