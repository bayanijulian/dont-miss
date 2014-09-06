package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;

public class BirthAnimationComponent extends Component{
	public Animation animation;
	public float counter = 0;
	public BirthAnimationComponent(Animation newAnimation){
		animation = newAnimation;
	}
}
