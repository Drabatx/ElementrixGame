/*********************************************************
 * Clase Score, Maneja el Score del juego en tiempode ejecucion.
 *
 * Autor: Jose Luis Toxtle Ocotoxtle
 *
 ********************************************************/
package com.drabatx.game.Elementrix.Models;

/*OBJETO TEMPORAL PARA IR ALMACENANDO EL SCORE*/
public class Score 
{
	public static int score;
	public static void SetScore()
	{
		/*SE ESTABLECE ELSCORE EN 0*/
		score=0;
	}
	public static int getScore()
	{
		/*REGRESA EL SCORE*/
		return score;	
	}
}
