package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.gdx.graphics.g2d.Animation;

public class DeathAnimationComponent {
	public Animation animation;
	public float counter = 0;
	public DeathAnimationComponent(Animation newAnimation){
		animation = newAnimation;
	}
}
