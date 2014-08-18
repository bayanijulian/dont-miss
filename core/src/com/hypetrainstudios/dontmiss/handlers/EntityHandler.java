package com.hypetrainstudios.dontmiss.handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hypetrainstudios.dontmiss.DontMiss;
import com.hypetrainstudios.dontmiss.entities.Bonus;
import com.hypetrainstudios.dontmiss.entities.Projectile;
import com.hypetrainstudios.dontmiss.entities.enemies.Enemy;

public class EntityHandler {
	public static void update(float delta){
		for(Projectile projectile : DontMiss.projectiles)
			projectile.update(delta);
		DontMiss.turret.update(delta);
		for(Enemy enemy:DontMiss.enemies)
			enemy.update(delta);
		for(Bonus bonus:DontMiss.bonuses)
			bonus.update(delta);
	}
	public static void draw(SpriteBatch renderer){
		renderer.begin();
		for(Projectile projectile : DontMiss.projectiles)
			projectile.draw(renderer);
		DontMiss.turret.draw(renderer);
		for(Enemy enemy:DontMiss.enemies)
			enemy.draw(renderer);
		for(Bonus bonus:DontMiss.bonuses)
			bonus.draw(renderer);
		renderer.end();
	}
	public static void checkGarbage(){

		if(!DontMiss.turret.signsOfLife())
			DontMiss.turret.remove();
		
		for(Projectile projectile : DontMiss.projectiles)
			if(!projectile.signsOfLife())
				projectile.remove();
		
		for(Enemy enemy:DontMiss.enemies)
			if(!enemy.signsOfLife())
				enemy.remove();
		
		for(Bonus bonus:DontMiss.bonuses)
			if(!bonus.signsOfLife())
				bonus.remove();
	}
	public static void checkCollision(){
		for(Projectile projectile : DontMiss.projectiles){
			for(Enemy enemy:DontMiss.enemies){
				
			}
		}
	}
}
