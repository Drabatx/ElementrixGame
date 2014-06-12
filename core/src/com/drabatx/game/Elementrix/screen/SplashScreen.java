package com.drabatx.game.Elementrix.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.drabatx.game.Elementrix.game.Assets;
import com.drabatx.game.Elementrix.game.ElementrixGame;
public class SplashScreen implements Screen
{
	OrthographicCamera guiCam;
	SpriteBatch batcher;
	private ElementrixGame game;
	public SplashScreen(ElementrixGame game) 
	{
		this.game=game;
		guiCam=new OrthographicCamera(10,15);
		guiCam.position.set(10f/2, 15f/2, 0);
		batcher=new SpriteBatch();
	}
	@Override
	public void dispose() 	{	}
	@Override
	public void hide() 		{	}
	@Override
	public void pause() 	{	}
	@Override
	public void render(float delta) 
	{
		handleInput();
		 GL20 gl = Gdx.graphics.getGL20();
		gl.glClearColor(0,0,0,1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*Muestra el SplashScreen*/
		guiCam.update();
		batcher.setProjectionMatrix(guiCam.combined);
		batcher.begin();
		batcher.draw(Assets.SplashBack, 0, 0, 10, 15);
		batcher.end();
	}
	private void handleInput() 
	{
		/*Verifica so se toco la ventana*/
		if(Gdx.input.justTouched())
		{
			game.setScreen(new MainMenuScreen(game));
		}
	}
	@Override
	public void resize(int width, int height) 	{	}
	@Override
	public void resume() {	}
	@Override
	public void show() 	{	}

}
