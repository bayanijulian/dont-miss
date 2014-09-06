package com.hypetrainstudios.dontmiss.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class SizeSystem extends IteratingSystem{

	public SizeSystem(Family family) {
		super(family);
		
	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
	}

}
