package com.bubbleshoot.habnpam.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bubbleshoot.habnpam.Shooter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Shooter";
		config.width = 900;
		config.height = 600;

		new LwjglApplication(new Shooter(), config);
	}
}
