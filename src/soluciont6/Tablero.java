package soluciont6;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 * Modelo del juego de la vida; Tablero donde cada casilla representa un organismo.
 * @author POO.
 *
 */
public class Tablero {
	
	public static final int VACIO=0;
	public static final int VIVO=1;
	public static final int MUERTO=2;	

	private int[][] tablero;
	private int size;

	private PropertyChangeSupport support;

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	/**
	 * Inicializa el Tablero (cuadrado) con el tamaño especificado.
	 * @param size Tamaño del Tablero cuadrado.
	 */
	public Tablero(int size) {
		support = new PropertyChangeSupport(this);
		tablero = new int[size][size];
		this.size = size;
	}
	
	/**
	 * Asigna el estado a la casilla (al organismo que representa la casilla).
	 * @param x Coordenada x de la casilla.
	 * @param y Coordenada y de la casilla.
	 * @param estado Estado que se asigna a la casilla.
	 */
	public void setCasilla (int x, int y, int estado) {
		tablero[x][y] = estado;
	}
	
	/**
	 * Devuelve el estado de la casilla (del organismo que representa la casilla).
	 * @param x Coordenada x de la casilla.
	 * @param y Coordenada y de la casilla.
	 * @return estrado de la casilla.
	 */
	public int getCasilla (int x, int y) {
		return tablero[x][y];
	}
	
	/**
	 * Tamaño físico del Tablero.
	 * @return Tamaño del tablero.
	 */
	public int size() {
	  return size;
	}
	
	/**
	 * Contabiliza el número de casillas que contienen el estado indicado.
	 * @param estado Estado de los organismos que se contabilizan.
	 * @return Número de casillas que contienen el estado proporcionado.
	 */
	public int size(int estado) {
		int cont=0;
		for (int x=0;x<size;x++)
		  for (int y=0;y<size;y++)
			if (tablero[x][y]==estado) 
			  cont++;
	    return cont;			
	}
	
	/**
	 * Inicializa el Tablero con una serie de organismos con el estado dado.
	 * @param numCasillas Número de casillas a rellenar.
	 * @param estado estado con el que se rellenan las casillas.
	 */
	public void initRandom(int numCasillas, int estado) {
		Random rx = new Random();
		Random ry = new Random();
		int i=0;
		do {
		  int x = rx.nextInt(size);
		  int y = ry.nextInt(size);
		  if (tablero[x][y]==VACIO) {
		    tablero[x][y] = estado;	
		    i++;
		  }
		} while(i<numCasillas);
	}
	
	public Tablero clone() {
	  Tablero t = new Tablero(size);
	  for (int x=0;x<size;x++)
		for (int y=0;y<size;y++)
		  t.setCasilla(x,y,tablero[x][y]); 	 
	  return t;
	}
	
	/**
	 * Actualiza el tablero con el que se le pasa como argumento.
	 * @param tablero Tablero que se va a tomar como origen.
	 */
	public void set(Tablero tablero) {
	  System.out.println("Tablero.set()");

	  support.firePropertyChange("tablero", this.tablero, tablero); // ******** Modelo Vista Controlador
	  for (int x=0;x<size;x++)
		for (int y=0;y<size;y++)
		  this.tablero[x][y] = tablero.getCasilla(x,y);
	}
	
	public String toString() {
	 String aux="";
	 for (int x=0;x<size;x++) {
	   for (int y=0;y<size;y++)
		 aux=aux+tablero[x][y]; 
	   aux=aux+"\n";
	 }
	 return aux;
	}

}
