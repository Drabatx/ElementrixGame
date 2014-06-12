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
public class PantallaScore implements Screen{
	Game game;
	OrthographicCamera guiCam;
	SpriteBatch batcher;
	private BoundingBox AtrasBound;
	private Vector3 touchPoint;
	String[] highScore= new String[5];
	public PantallaScore(Game game) 
	{
		this.game=game;
		guiCam=new OrthographicCamera(100,150);
		guiCam.position.set(100f/2, 150f/2, 0);
		batcher=new SpriteBatch();
		Assets.font.setScale(.3f);
		AtrasBound=new BoundingBox(new Vector3(80, 0, 0), new Vector3(100,20,0));
		touchPoint= new Vector3();
		for (int i = 0; i < 5; i++) 
		{
			highScore[i] = i + 1 + ". " + com.drabatx.game.Elementrix.game.Settings.highscores[i];
		}
	}
	@Override
	public void dispose() {
		batcher.dispose();
	}
	@Override
	public void hide() {	}
	@Override
	public void pause() {	}
	@Override
	public void render(float arg0) {
		/*Verifica que si la pantalla ha sido creada.*/
		if (Gdx.input.justTouched()) 
		{
			guiCam.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(), 0));
			/*Verficia si el el boton de atras ha sido tocado.*/
			if(AtrasBound.contains(touchPoint))
			{
				Assets.font.scale(1);
				game.setScreen(new MainMenuScreen(game));
				return;
			}
		}
		GL20 gl = Gdx.graphics.getGL20();
		gl.glClearColor(1,0,0,1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		batcher.setProjectionMatrix(guiCam.combined);
		/*Se encarga de dibujar el sacore*/
		batcher.begin();
		batcher.draw(Assets.backScore, 0, 0, 100, 150);
		batcher.end();
		/*Dibuja el boton de atras.*/
		batcher.begin();
		batcher.draw(Assets.Atras, 80, 0, 20, 20);
		batcher.end();
		/*Se engarga de mostrar los distintos backgrounds*/
		batcher.begin();
		float y = 60;
		for (int i = 4; i >= 0; i--) {
			Assets.font.draw(batcher, highScore[i],20 , y);
			y += Assets.font.getLineHeight();
		}	
		batcher.end();
	}
	@Override
	public void resize(int arg0, int arg1) {	}

	@Override
	public void resume() 	{	}

	@Override
	public void show() 		{	}

}