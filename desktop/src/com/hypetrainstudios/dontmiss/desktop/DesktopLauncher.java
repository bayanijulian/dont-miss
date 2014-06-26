package com.hypetrainstudios.dontmiss.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hypetrainstudios.dontmiss.DontMiss;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DontMiss(), config);
		config.height = 720;
		config.width = 1280;
		config.resizable = false;
	}
}
