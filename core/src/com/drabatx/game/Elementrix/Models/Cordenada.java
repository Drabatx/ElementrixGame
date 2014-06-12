/*********************************************************
 * Clase Cordenada, se encarga de la manipulacion de los elementos.
 *
 * Autor: Jose Luis Toxtle Ocotoxtle
 *
 ********************************************************/
package com.drabatx.game.Elementrix.Models;
/*OBJETO DE CORDENADAS*/
public class Cordenada 
{
	/*TIENEN COMO ATRIBUTOS LAS CORDENADAS X,Y*/
	public int x=0;
	public int y=0;
	public Cordenada(int x, int y) 
	{
		/*SE ESTABLECEN LAS CORDENADAS*/
		this.x=x;
		this.y=y;
	}
	public void setCordenada(int x, int y)
	{
		/*SE ESTABLECEN LAS CORDENADAS*/
		this.x=x;
		this.y=y;
	}
}
