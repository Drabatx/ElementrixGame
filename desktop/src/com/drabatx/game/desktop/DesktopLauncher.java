package com.drabatx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.drabatx.game.Elementrix.game.ElementrixGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ElementrixGame(), "Elementrix Game", 600, 800);
		//new LwjglApplication(new ElementrixGame(), config);
	}
}
