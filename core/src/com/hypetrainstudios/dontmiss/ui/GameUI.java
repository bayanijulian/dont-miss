package com.hypetrainstudios.dontmiss.ui;

import java.text.DecimalFormat;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypetrainstudios.dontcrash.DontCrash;

public class GameUI {
	public static Stage stage;
	private static FitViewport view;
	
	private static ButtonStyle pauseBtnStyle;
	private static Button pauseBtn;
	
	private static Listener listener;
	
	private static BitmapFont audiowideFont;
	private static DecimalFormat df;
	
	private static class Listener extends ChangeListener{
		@Override
		public void changed(ChangeEvent event, Actor actor) {
			
			
		}
	}
}
