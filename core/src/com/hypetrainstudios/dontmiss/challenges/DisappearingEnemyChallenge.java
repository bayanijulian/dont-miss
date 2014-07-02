package com.hypetrainstudios.dontmiss.challenges;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.hypetrainstudios.dontmiss.Creator;

public class DisappearingEnemyChallenge extends Challenge{
	
	
	private static Circle circleToDisappearWhenHit = 
			new Circle(	Gdx.graphics.getWidth()/2,
						Gdx.graphics.getHeight()/2,
						450 );
	private static Circle circleToAppearWhenHit = 
			new Circle(	Gdx.graphics.getWidth()/2,
						Gdx.graphics.getHeight()/2,
						175 );
	@Override
	public void update(float delta) {
		for(int i = 0; i<Creator.enemies.size(); i++){
			if( Creator.enemies.get(i).getCircle().overlaps( circleToDisappearWhenHit ) ){
				Creator.enemies.get(i).enableDisappearing();
				//System.out.println("disapearing");
			}
			if( Creator.enemies.get(i).getCircle().overlaps( circleToAppearWhenHit ) ){
				Creator.enemies.get(i).disableDisappearing();
			}
		}
	}

}
