package com.hypetrainstudios.dontmiss.entity;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;

public class Misc extends Entity{
	private String name;
	private int spikeKilled;
	private Circle circleExplosion;
	private float timeCounter;
	public Misc(Sprite spr,String name) {
		super(spr);
		this.name = name;
		if(name.equals("spikes")){
			spr.setPosition(BonusHandler.lastKilledX,BonusHandler.lastKilledY);
			
			spikeKilled = 0;
		}
		if(name.equals("landmine")){
			spr.setPosition(BonusHandler.lastKilledX,BonusHandler.lastKilledY);
			
			circleExplosion = new Circle(spr.getX(),spr.getY(),spr.getHeight()/2);
		}
		this.updateBounds();
	}
	
	public void collisionWithEnemy(){
		if(name.equals("spikes")){
			spikeKilled++;
			if(spikeKilled>=3){
				this.active = false;
			}
		}
		else if(name.equals("landmine")){
			circleExplosion.setPosition(spr.getX(), spr.getY());
			for(int i = 0; i<Creator.enemies.size();i++){
				if(Creator.enemies.get(i).getCircle().overlaps(circleExplosion)){
					Creator.enemies.get(i).setActive(false);
				}
			}
			this.active = false;
		}
	}
	
	@Override
	public  void update(float delta){
		timeCounter +=delta;
		if(timeCounter>=45&&(name.equals("spikes")||name.equals("landmine"))){
			this.active = false;
		}
	}
	public String getName(){
		return name;
	}
}
