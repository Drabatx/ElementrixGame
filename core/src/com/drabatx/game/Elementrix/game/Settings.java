/*********************************************************
 * Clase Settings, se encarga de la configuacion de ajustes del juego.
 *
 * Autor: Jose Luis Toxtle Ocotoxtle
 *
 ********************************************************/
package com.drabatx.game.Elementrix.game;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import com.badlogic.gdx.Gdx;
public class Settings {
	/*Variable para controlar el sonido.*/
	public static boolean soundEnabled = true;
	/*Matriz con los primeros score.*/
	public final static int[] highscores = new int[] {100, 80, 50, 30, 10};
	/*Archivo donde se guardan los score.*/
	public final static String file = ".elementrix";
	/*Carga el archivo de score*/
	public static void load () {
		/*Variable para leer en archivos.*/
		BufferedReader in = null;
		try {
			/**/
			in = new BufferedReader(new InputStreamReader(Gdx.files.external(file).read()));
			/*Lee la variable de sonido.*/
			soundEnabled = Boolean.parseBoolean(in.readLine());
			/*Obtiene los score mas altos*/
			for (int i = 0; i < 5; i++) {
				highscores[i] = Integer.parseInt(in.readLine());
			}
		} catch (Throwable e) {
			// :( It's ok we have defaults
		} finally {
			try {
				/*Cierra el archivo*/
				if (in != null) in.close();
			} catch (IOException e) {
			}
		}
	}
	/*Guarda la configuracion del juego, y los score.*/
	public static void save () 
	{
		/*Variable de contro del escritura*/
		BufferedWriter out = null;
		try {
			/*Escribe la configuracion*/
			out = new BufferedWriter(new OutputStreamWriter(Gdx.files.external(file).write(false)));
			/*Obtiene la configuracion del sonido.*/
			out.write(Boolean.toString(soundEnabled));
			/*Obtiene los Score mas altos*/
			for (int i = 0; i < 5; i++) {
				out.write(Integer.toString(highscores[i]));
			}
		} catch (Throwable e) {
			} finally {
				try {
					/*Cierra el archivo*/
						if (out != null) out.close();
					} catch (IOException e) {
				}
		}
	}

	public static void addScore (int score) {
		for (int i = 0; i < 5; i++) {
			if (highscores[i] < score) {
				for (int j = 4; j > i; j--)
					highscores[j] = highscores[j - 1];
				highscores[i] = score;
				break;
			}
		}
	}
}
