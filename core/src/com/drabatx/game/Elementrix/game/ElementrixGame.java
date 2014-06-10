/*********************************************************
 * Clase ElementrixGame se encarga de abrir el primer Screen.
 *
 * Autor: Jose Luis Toxtle Ocotoxtle
 *
 ********************************************************/
package com.drabatx.game.Elementrix.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.drabatx.game.Elementrix.screen.SplashScreen;
public class ElementrixGame extends Game {
	public Screen ScreenWelcome;
	@Override
	public void create () 
	{
		Assets.load();
		ScreenWelcome = new SplashScreen(this);
		setScreen(ScreenWelcome);
	}

	@Override
	public void render () 
	{
		super.render();
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		getScreen().dispose();
	}
}
