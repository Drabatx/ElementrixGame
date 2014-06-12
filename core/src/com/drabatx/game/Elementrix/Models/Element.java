/*********************************************************
 * Clase Element, se encarga de la manipulacion de las posiciones de los elementos ademas de
 * de que si han sido visitados.
 * Autor: Jose Luis Toxtle Ocotoxtle
 *
 ********************************************************/
package com.drabatx.game.Elementrix.Models;
import com.badlogic.gdx.math.Vector3;
/*OBJETO ELEMENTO*/
public class Element 
{
	/* ESTE OBJETO TIENE COMO ATRIBUTOS 
	 * UNA POCISION X,Y DENTRO DE LA MATRIZ
	 * UN ELEMENTO Y SI ESTA VISITADO O NO*/
	public Vector3 position;
	public int ELEMENTO=0;
	public boolean isValue=false;
	/*COSNTRUCTOR QUE INICIALIZA EL ELEMENTO*/
	public Element(float x,float y,int elemento) {
		// TODO Auto-generated constructor stub
		position=new Vector3(x,y,0);
		this.ELEMENTO=elemento;
	}
	public int getElement()
	{
		/*OBTIENEN EL VALOR DEL ELEMENTO*/
		return ELEMENTO;
	}
}
