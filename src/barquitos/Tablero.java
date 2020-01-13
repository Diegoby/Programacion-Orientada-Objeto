package barquitos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Tablero para el juego de los barquitos.
 * @author POO
 *
 */
public class Tablero implements ITablero {

	private int [][] tablero, tableroAnterior;
	private int tamanio;
	private PropertyChangeSupport support;

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	/**
	 * Tablero inicializado con el valor 0 de la clase colores (correspondiente a "agua");
	 * El Tablero es cuadrado.
	 * @param tamanio Tamaño del Tablero de los barquitos.
	 */
	public Tablero(int tamanio) {
	  	this.tamanio = tamanio;
		tablero = new int[tamanio][tamanio];
	  	support = new PropertyChangeSupport(this);
	}
				
    public int[][] getTablero() {
	  return tablero;
	}
		
	public void setTablero(int[][] tablero) {
	   this.tablero=tablero;
	}
	
	public int getTamanio() {
		return tamanio;
	}

	public int getPosicion(int x, int y) {
		return tablero[x][y];
	}

	public void setPosicion(int x, int y, int valor) {
	  System.out.println("Tablero.setPosicion(x:"+x+", y:"+y+", valor: "+valor+")");

	  tableroAnterior = copiaTablero();
	  tablero[x][y]=valor;
	  support.firePropertyChange("tablero", tableroAnterior, tablero); // ******** Modelo Vista Controlador
	}
	
	public void borra() {
	  for (int y=0;y<tamanio;y++) 
		for (int x=0;x<tamanio;x++) 
		  tablero[x][y]	= 0;
	}
	
	public int ocupacion() {
	  int cont=0;
	  for (int y=0;y<tamanio;y++) 
		for (int x=0;x<tamanio;x++) 
		  if (tablero[x][y]!=0)
			cont++;
	  return cont;
	}

	private int [][] copiaTablero() {
		int [][] t = new int[tamanio][tamanio];
		for (int x=0;x<tamanio;x++)
			for (int y=0;y<tamanio;y++)
				t[x][y] = tablero[x][y];
		return t;
	}

	public String toString() {
	  String resultado="";
	  for (int y=0;y<tamanio;y++) {
		for (int x=0;x<tamanio;x++) {
			if (tablero[x][y] < 10) resultado += " ";
			resultado = resultado + tablero[x][y] + " ";
		}
		resultado=resultado+"\n";
	  }	
	  resultado=resultado+"\n\n";
	  return resultado;
	}
}
