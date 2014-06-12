package com.drabatx.game.Elementrix.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.drabatx.game.Elementrix.game.*;

public class PantallaSound implements Screen{
	public 	Game 				game;
	public 	OrthographicCamera 	guiCam;
	public 	SpriteBatch 		batcher;
	public 	BoundingBox 		SonidoBound;
	public 	Vector3 			touchPoint;
	public 	static String 		Sonido="ON";
	private BoundingBox 		AtrasBound;
	/*Se encarga de crear los distintos */
	public PantallaSound(Game game) 
	{
		this.game=game;
		guiCam=new OrthographicCamera(100,150);
		guiCam.position.set(100f/2, 150f/2, 0);
		batcher=new SpriteBatch();
		Assets.font.setScale(.3f);
		SonidoBound=new BoundingBox(new Vector3(40, 55, 0), new Vector3(60,80,0));
		AtrasBound=new BoundingBox(new Vector3(80, 0, 0), new Vector3(100,20,0));
		touchPoint= new Vector3();
	}
	@Override
	public void dispose() {
		batcher.dispose();
	}
	@Override
	public void hide() 		{	}
	@Override
	public void pause() 	{	}
	/**/
	@Override
	public void render(float arg0) {
		/*Varifica si la pantalla ha sido tocada.*/
		if (Gdx.input.justTouched()) 
		{
			guiCam.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(), 0));
			/*Verifica si se toco la pantalla.*/
			if (SonidoBound.contains(touchPoint)) 
			{
				/*Verifica si se presiono ON*/
				if(Sonido.equals("ON"))
				{
					Assets.music.pause();
					Sonido="OFF";
					com.drabatx.game.Elementrix.game.Settings.soundEnabled=false;
					return;
				}
				/*Verifica si se presiono OFF*/
				if(Sonido.equals("OFF"))
				{
					Assets.music.play();
					Sonido="ON";
					com.drabatx.game.Elementrix.game.Settings.soundEnabled=true;
					return;
				}
			}
			/*Si se toca el boton de atras lo que hace es mostrar la ventana Mainscreen*/
			if(AtrasBound.contains(touchPoint))
			{
				Assets.font.scale(1);
				game.setScreen(new MainMenuScreen(game));
				return;
			}
		}
		GL20 gl = Gdx.graphics.getGL20();
		gl.glClearColor(0,0,0,1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		batcher.setProjectionMatrix(guiCam.combined);
		/*Muestra Backgroun de fondo.*/
		batcher.begin();
		batcher.draw(Assets.backMadera, 0, 0, 100, 150);
		batcher.end();
		batcher.begin();
		/*Muestra Boton Sonido*/
		Assets.font.draw(batcher, "SONIDO ", 0, 150);
		batcher.end();
		batcher.begin();
		Assets.font.draw(batcher, ""+Sonido, 40, 80);
		batcher.end();
		/*Muestra Boton Atras*/
		batcher.enableBlending();
		batcher.begin();
		batcher.draw(Assets.Atras, 80, 0, 20, 20);
		batcher.end();
	}
	@Override
	public void resize(int arg0, int arg1) {	}

	@Override
	public void resume() {	}

	@Override
	public void show() 	{	}

}