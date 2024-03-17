package com.entropiat.unicorns;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(144);
		config.setTitle("Unicorns");
		config.useVsync(true);
		config.setWindowedMode(1600, 960);
		new Lwjgl3Application(new UnicornsTest(), config);
	}
}
