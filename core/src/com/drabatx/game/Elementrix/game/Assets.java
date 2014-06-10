package com.drabatx.game.Elementrix.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;

public class Assets 
{
	public static TextureAtlas atlas;
	/*Son los fondos de pantalla de cada una de los diferentes Screen que se tienen.*/
	public static AtlasRegion background;
	public static AtlasRegion background_fire;
	public static AtlasRegion background_whater;
	public static AtlasRegion background_earth;
	public static AtlasRegion background_wind;
	public static AtlasRegion backMadera;
	public static AtlasRegion backScore;
	public static AtlasRegion backPause;
	
	/*Barra Horizontal y Vertical del juego son las barras que rodean a las esferas.*/
	public static AtlasRegion barra_h;
	public static AtlasRegion barra_v;
	
	/*Imagen del boton de atras.*/
	public static AtlasRegion Atras;
	
	/*Letreros o botones del videojuego. Inicio, Soinido, Score.*/
	public static AtlasRegion inicio;
	public static AtlasRegion sound;
	public static AtlasRegion score;
	
	/*Es la variable que abre la fuente que se va a usar en todo el videojuego.*/
	public static BitmapFont font;
	
	/*Variables que nos ayudanran a las distintas animaciones.*/
	public static AtlasRegion SplashBack;
	public static Texture ExpSheet;
	public static TextureRegion[] Expframes;
	
	/*abre ademas la musica del fondo.*/
	public static Music music;
	public static Music bip;
	/*Imagen del boton de pausa*/
	public static AtlasRegion Pause;
	/*Efecto del titulo*/
	public static Animation EfectoTitle;
	/*Lista de esferas de elementos.*/
	public static Animation fire;
	public static Animation whater;
	public static Animation find;
	public static Animation earth;
	public static Animation Explosion;
	public static Animation dark;
	
	/*
	 * Esta funcion lo que hace es cargar todos los recursos del juego si necesidad de crear los objetos muchas veces.
	 * Se crean los Backgrounds, los sprites, y sonidos necesarios.
	 * */
	public static void load()
	{
		/*Lo primero que se hace es abrir el pack que contiene las posicion de las imagenes denominadas image1, image2.*/
		atlas=new TextureAtlas(Gdx.files.internal("pack"));
		/*Se encarga de abrir el background principal*/
		background=atlas.findRegion("Background");
		/*se cargan los distintos backgrounds.*/
		background_fire=atlas.findRegion("Backgroundfi");
		background_earth=atlas.findRegion("Backgrounde");
		background_whater=atlas.findRegion("Backgroundw");
		background_wind=atlas.findRegion("Backgroundwi");
		backScore=atlas.findRegion("BackScore");
		backMadera=atlas.findRegion("BackMadera");
		backPause=atlas.findRegion("PauseBack");
		SplashBack=atlas.findRegion("Splash");
		barra_h=atlas.findRegion("barrah");
		barra_v=atlas.findRegion("barrav");
		/*Se carga la fuente*/
		font=new BitmapFont(Gdx.files.internal("hiero.fnt"),false);
		/*se cargan los distintos letreros*/
		Atras=atlas.findRegion("Atras");
		inicio=atlas.findRegion("inicio");
		sound=atlas.findRegion("sonido");
		score=atlas.findRegion("score");
		Pause=atlas.findRegion("pause");
		/*Se carga el sonido*/
		music=Gdx.audio.newMusic(Gdx.files.internal("soundb.mp3"));
		bip=Gdx.audio.newMusic(Gdx.files.internal("bip.mp3"));
		/*Se carga el efecto de la pantalla de inicio*/
		EfectoTitle=loadSprites("Efecto1.png", 3, 3);
		/*Se cargan las distintas esferas.*/
		fire=loadSprites("Fire.png", 3, 3);
		whater=loadSprites("Agua.png", 3, 3);
		find=loadSprites("Viento.png", 3, 3);
		earth=loadSprites("Tierra.png", 3, 3);
		dark=loadSprites("trueno.png", 3, 3);
	}

	/*
	 * nombre es el nombre de la imagen que se desa abrir.
	 * col es el numero de columnas de cada imagen.
	 * fil es el numero de filas que tiene la imagen.
	 * Este metodo tiene como funcion cargar los sprites.
	 * */
	public static Animation loadSprites(String nombre,int col, int fil)
	{
		/*Se asignan las Filas y columnas de la imagen*/
		int FRAME_COL=col;
		int FRAME_FIL=fil;
		/*se declara un contador*/
		int index = 0;
		/*Se crea una nueva textura para la animacion*/
		ExpSheet=new Texture(nombre);
		/*Se crea una nueva Texture Region y corta las imagenes*/
		TextureRegion[][] tmp=TextureRegion.split(ExpSheet, 
							ExpSheet.getWidth()/FRAME_COL, 
							ExpSheet.getHeight()/FRAME_FIL);
		/*LA matriz de imagenes se convierte en un vector*/
		Expframes = new TextureRegion[FRAME_COL*FRAME_FIL];
		/*Trazladamos la matriz de imagenes al nuevo vector*/
		for (int i = 0; i < FRAME_FIL; i++) {
			for (int j = 0; j < FRAME_COL; j++) {
				Expframes[index++]=tmp[i][j];
			}
		}
		/*Retornamos la animacion*/
		return new Animation(.1f, Expframes);
	}
	
	/*
	 *Es llamado cuando la aplicacion se va a cerrar. 
	 * */
	public static void dispose(){
		atlas.dispose();
	}
}
