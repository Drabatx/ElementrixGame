/*Se encarga de mostrar controlar el mundo del videojuego.
 * */
package com.drabatx.game.Elementrix.Models;
import java.util.Vector;
import com.drabatx.game.Elementrix.game.*;
import com.drabatx.game.Elementrix.screen.*;
public class World {
	
	public boolean isFinished;
	public static Element[][] elementos;
	public final static int FIRE=1;
	public final static int WHATER=2;
	public final static int EARTH=3;
	public final static int WIND=4;
	public final static int TRUENO=5;
	static int ELEM;
	final static int TotalE=5;
	public final static int FILAS=9;
	public final static int COLUMNAS=8;
	public Vector<Cordenada> vector=new Vector<Cordenada>(2,1); 
	/*Inicializa el Mundo.*/
	public World() 
	{	
		initialize();
	}
	/*Se encarga de llenar una matriz*/
	public void Llenar()
	{
		/*Se encarga de llenar la matriz del juego, con valores aleatorios.
		 */
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j <COLUMNAS; j++) 
			{
				ELEM=(int) (Math.random()*TotalE+1);
				elementos[i][j]=new Element(1+j,3+i,ELEM);
			}
		}
	}
	/*Inicializa el arreglo
	 */
	private void initialize() 
	{
		/*CREA NUEVOS ELEMENTOS CON LAS DIMENSIONES ESPECIFICADAS Y LAS LLENA*/
		elementos=new Element[FILAS][COLUMNAS];
		Llenar();
	}
	/*
	 * */
	public void Destruccion0(int x,int y)
	{
		/*EVENTO QUE SE ENCARGA DE VERIFICAR SI EXISTEN
		 * ESFERAS DEL MISMO TIPO ALREDOR DE EL SI ES ASI
		 * ENTONCES LAS ALMACENA EN UN VECTOR*/
		int i=0;
		/*OBTIENE EL ELEMENTO EN LA QUE SE LE DIO UN TOUCH*/
		int Element=elementos[x][y].ELEMENTO;
		/*A ESE ELEMENTO SE LE ASIGNA QUE TRUE INDICANDO QUE YA FUE VISITADO*/
		elementos[x][y].isValue=true;
		/*AL VECTOR SE LE APILAN LAS CORDENADAS 0,0*/
		vector.add(new Cordenada(x, y));
		/*MIENTRAS I SEA MENOR AL TAMA�O DEL VECTOR
		 * APILARA LAS CORDENADAS*/
		while(i<vector.size()&&vector.get(i)!=null)
		{
			/*OBTIENE X ,Y DEL DATO APILADO*/
			x=vector.get(i).x;
			y=vector.get(i).y;
			/*VERIFICA SI EL ELEMENTO DE ABAJO ES MAYOR A LA DIMENSION*/
			if(x-1>=0)
			{
				/*SI EL ELEMENTO ES IGUAL Y NO HA SIDO VISITADO 
				 * ENTONCES LO APILA Y SE HACE LO MISMO CON LOS DEMAS*/
				if(Element==elementos[x-1][y].ELEMENTO&&elementos[x-1][y].isValue==false)
				{
					vector.add(new Cordenada(x-1, y));
					elementos[x-1][y].isValue=true;
				}
			}
			/*VERIFICA SI EL ELEMENTO DE ARRIBA ES MENOR A LA DIMENSION*/
			if(x+1<FILAS)
			{
				/*SI EL ELEMENTO ES IGUAL Y NO HA SIDO VISITADO 
				 * ENTONCES LO APILA Y SE HACE LO MISMO CON LOS DEMAS*/
				if(Element==elementos[x+1][y].ELEMENTO&&elementos[x+1][y].isValue==false)
				{
						vector.add(new Cordenada(x+1, y));
						elementos[x+1][y].isValue=true;
				}
			}
			/*VERIFICA SI EL ELEMENTO DE A LA IZQUIERDA ES MAYOR O IGUAL
			 * A LA DIMENSION MINIMA*/
			if(y-1>=0)
			{
				/*SI EL ELEMENTO ES IGUAL Y NO HA SIDO VISITADO 
				 * ENTONCES LO APILA Y SE HACE LO MISMO CON LOS DEMAS*/
				if(Element==elementos[x][y-1].ELEMENTO&&elementos[x][y-1].isValue==false)
				{
						vector.add(new Cordenada(x, y-1));
						elementos[x][y-1].isValue=true;
				}	
			}
			/*VERIFICA SI EL ELEMENTO DE A LA DERECHA ES MENOR O 
			 * IGUAL A KA DIMENSION*/
			if(y+1<COLUMNAS)
			{
				/*SI EL ELEMENTO ES IGUAL Y NO HA SIDO VISITADO 
				 * ENTONCES LO APILA Y SE HACE LO MISMO CON LOS DEMAS*/
				if (Element==elementos[x][y+1].ELEMENTO&&elementos[x][y+1].isValue==false)
				{
						vector.add(new Cordenada(x, y+1));
						elementos[x][y+1].isValue=true;
				}	
			}
			/*AVANZA A LISGUENTE PILA*/
			i++;
		}
	}
	public void ExistSolution()
	{
		vector=null;
		
	}
	public void Destruccion1() 
	{
		int x,y,i=0;
		/*SI EL TAMA�O DEL VECTOR ES MAYOR O IGUAL A 3 ENTONCES 
		 * REALIZA LA DESTRUCCION SI NO ES ASI LA OMITE*/
		if(vector.size()>=3)
		{
			/*MIENTRAS EL INDICADOR SEA MENOR AL TAMA�O 
			 * DESAPILARA LOS VALORES*/
			while(i<vector.size())
			{
				/*SE OBTIENEN LAS CORDENADAS DEL VECTOR*/
				x=vector.get(i).x;
				y=vector.get(i).y;
				/*A LOS ELEMENTOS SE LE ASIGNAN 0 SIMULANDO LA DESTRUCCION*/
				elementos[x][y].ELEMENTO=0;
				/*AUMENTA EL SCORE EN 10 PUNTOS*/
				Score.score+=10;
				/*AVANZA AL SIGUIENTE VECTOR*/
				i++;
			}
			/*A TODA LA MATRIZ QUE TIENE ELEMENTOS VISITADOS 
			 * LOS MARCA NO VISITADOS CON UN FALSE*/
			for (int j = 0; j < FILAS; j++) {
				for (int j2 = 0; j2 < COLUMNAS; j2++) {
					elementos[j][j2].isValue=false;
				}
			}
			/*SI LA MUSCIA ESTA ACTIVADA REPRODUCE UN SONIDO*/
			if(PantallaSound.Sonido=="ON")
			Assets.bip.play();
			/*MANDA A LLAMAR AL METODO RANDOMFULL*/
			RandomFull();
		}
	}
	public void Actualiza()
	{
		/*SI ENCONTRO UN ELEMENTO DESTRUIDO LE ASIGNA A LEAOTORIAMENTE OTRO*/
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j <COLUMNAS; j++) 
			{
				
				if(elementos[i][j].ELEMENTO==0)
				{
					ELEM=(int) (Math.random()*TotalE+1);
					switch(ELEM){
						case FIRE  :elementos[i][j]=new Element(1+j,3+i,FIRE);
							break;
						case WHATER:elementos[i][j]=new Element(1+j,3+i,WHATER);
							break;
						case EARTH :elementos[i][j]=new Element(1+j,3+i,EARTH);
							break;
						case WIND  :elementos[i][j]=new Element(1+j,3+i,WIND);
							break;
						case TRUENO  :elementos[i][j]=new Element(1+j,3+i,TRUENO);
							break;
						}
				}	
			}
		}
	}
	public void RandomFull()
	{
		/*ESTE METODO SE ENCARGA SE ELEGIR ALEATORIAMENTE UN ELEMENTO DE LA MATRIZ
		 *Y CREA UNA LINEA DE TRES ESTO GARANTIZA QUE EN EL JUEGO SIEMPRE HABRA ALMENOS UNA LINEA DE 3
		 *QUE DESTRUIR*/
		int xi,yi;
		xi=(int) (Math.random()*(FILAS-2)+1);
		yi=(int) (Math.random()*(COLUMNAS-2)+1);
		int e=(int) (Math.random()*TotalE+1);
		
		elementos[xi][yi].ELEMENTO=	e;
		elementos[xi][yi-1].ELEMENTO=e;
		elementos[xi][yi+1].ELEMENTO=e;
	}
	public void update(float delta) 
	{
		/*RECORRE LA MATRIZ VERIFICANDO SI HUBO DESTRUCCION, 
		 *SI LO HUBO RECORRE LA MATRIZ HACIA ABAJO*/
		for(int k=0;k<FILAS;k++)
		for (int i =0; i <FILAS; i++) {
			for (int j =0; j <COLUMNAS; j++) 
			{
				if(elementos[i][j].ELEMENTO==0&&i<FILAS-1)
				{
					elementos[i][j].ELEMENTO=elementos[i+1][j].ELEMENTO;
					elementos[i+1][j].ELEMENTO=0;
				}
					
			}
		}
		/*ACTUALIZA Y AL VECTOR REMUEVE TODOS LOS ELEMENTOS*/
		Actualiza();
		vector.removeAllElements();
	}
}
