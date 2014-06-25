package com.hypetrainstudios.dontmiss.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hypetrainstudios.dontmiss.DontMiss;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DontMiss(), config);
		config.height = 1080;
		config.width = 1920;
		config.resizable = false;
	}
}
