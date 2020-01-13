package barquitos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Funcionalidad del juego de barquitos.
 * @author POO
 *
 */
public class Barquitos extends Ventana implements IBarquitos {

	private int[] numBarcosLong;	
	private int tamanioTablero;

	private Tablero tableroColores;
	private Tablero tableroBarcos;

	private int idBarco;
	private ArrayList<Barco> barcos;
	private HashMap<Casilla, Integer> mapaBarcos;
	
	/**
	 * Crea un juego de los Barquitos.
	 * @param numBarcosLong Longitud máxima de los barcos.
	 * @param tamanioTablero Tamaño de las dimensiones del Tablero.
	 */
	public Barquitos(int[] numBarcosLong, int tamanioTablero) {
	  super(tamanioTablero);
	  this.tamanioTablero = tamanioTablero;
	  tableroColores = new Tablero(tamanioTablero);
	  tableroBarcos = new Tablero(tamanioTablero);
	  this.numBarcosLong = new int[numBarcosLong.length];
	  for (int i=0;i<numBarcosLong.length;i++)
		  this.numBarcosLong[i] = numBarcosLong[i];

	  idBarco = 0;
	  barcos = new ArrayList<>();

	  // crea la vista
	  Vista vista = new Vista(tableroColores);
	  vista.addMouseListener(new Controlador(this));
	  insertarVista(vista);

	  // indica que objetos son vistas de que modelo		
	  tableroColores.addPropertyChangeListener(vista);        // ******** Modelo Vista Controlador
	  
	}
	
	/**
	 * Devuelve el número de casillas máximo que puede ocupar un Barco.
	 * @return Tamaño máximo del Barco.
	 */
	public int getTamanioMaximoBarco() {
	  return numBarcosLong.length;
	}
	
	/**
	 * Devuelve el tamaño de la dimensión del tablero (cuadrado).
	 * @return Tamaño del Tablero.
	 */
	public int getTamanioTablero() {
	  return tamanioTablero;
	}
	
	/**
	 * Coloca los barcos en posiciones aleatorias, en vertical u horizontal
	 * El numero de barcos que coloca se encuntra en numBarcosLong
	 * numBarcosLong[0] indica el numero de barcos de 1 recuadro de tamanio
	 * numBarcosLong[1] indica el numero de barcos de 2 recuadro de tamanio, etc
	 * Cada Barco se identifica por un valor entero en el tablero; por ejemplo,
	 * tres 9 en vertical indica un Barco de 3 posiciones puesto en vertical.
	 */
	public void colocarBarcos() {
	  Random r = new Random();
	  int x,y,orientacion;
	  
	  for (int tamanio=1;tamanio<=numBarcosLong.length;tamanio++) {
		  int barcosColocados=0;
		  while (barcosColocados<numBarcosLong[tamanio-1]) {
			 x = r.nextInt(tamanioTablero);
			 y = r.nextInt(tamanioTablero);
			 orientacion = r.nextInt(2);
			 if (orientacion==0) //horizontal
			  if (cabeBarcoHorizontal(x,y,tamanio)) {
			 	Barco b = new Barco(idBarco);
				for (int i=0;i<tamanio;i++) {
					tableroBarcos.setPosicion(x + i, y, tamanio * 10 + barcosColocados);
					b.aniadePosicion(x+i, y);
				}
				barcos.add(b);
				idBarco++;
				barcosColocados++;
			  } else // vertical
			  if (cabeBarcoVertical(x,y,tamanio)) {
			    Barco b = new Barco(idBarco);
				for (int i=0;i<tamanio;i++) {
					tableroBarcos.setPosicion(x, y + i, tamanio * 10 + barcosColocados);
					b.aniadePosicion(x, y+i);
				}
				barcos.add(b);
				idBarco++;
				barcosColocados++;
			  }
		  } // while
	  } // for 

		mapaBarcos = new HashMap<>();
		for(Barco b: barcos){
			for(Casilla c: b.getCasillas()){
				mapaBarcos.put(c, b.getIdBarco());
			}
		}

	}
	
	private boolean cabeBarcoHorizontal (int x, int y, int tamanio) {
	  boolean cabe=true;
	  if (x+tamanio>tamanioTablero)
		return false;
	  else {
		  int i=0;
		  while (cabe&&i<tamanio) {
			cabe=tableroBarcos.getPosicion(x+i,y)==0; // si la posicion es igual a 0 (hay Barco), por ahora cabe
			i++;
		  }
	  }
	  return cabe;
	}
	
	private boolean cabeBarcoVertical (int x, int y, int tamanio) {
	  boolean cabe=true;
	  if (y+tamanio>tamanioTablero)
		return false;
	  else {
		  int i=0;
		  while (cabe&&i<tamanio) {
			cabe=tableroBarcos.getPosicion(x,y+i)==0; // si la posicion es igual a 0 (hay Barco), por ahora cabe
			i++;
		  }
	  }
	  return cabe;
	}
	
    
    public void disparo2(int x, int y) {
	  if (x>=0&&y>=0&&x<tamanioTablero&&y<tamanioTablero&&tableroColores.getPosicion(x,y)==Colores.CUBIERTO.getValor()) {
		if (tableroBarcos.getPosicion(x,y)==0)  // posicion sin Barco
			tableroColores.setPosicion(x, y, Colores.AGUA.getValor());
		else {
		  int[][] hundido = hundido(x,y);
		  if (hundido==null)
			  tableroColores.setPosicion(x, y, Colores.TOCADO.getValor());
		  else
			for (int i=0;i<getTamanioMaximoBarco();i++)
			  if (hundido[0][i]!=-1)
				  tableroColores.setPosicion(hundido[0][i], hundido[1][i], Colores.HUNDIDO.getValor());
		  if (finPartida()) 
			mostrarFinPartida();
		 }	
	  System.out.println(tableroColores);  
	  }
	}

	public void disparo (int x, int y){
		Integer id = mapaBarcos.get(new Casilla(x, y));
		if(id==null) tableroColores.setPosicion(x, y, Colores.AGUA.getValor());
		else {
			Barco b = barcos.get(id);
			b.actualizaPosicion(x, y);
			if(!b.estaHundido()) {
				tableroColores.setPosicion(x, y, Colores.TOCADO.getValor());
			} else {
				for(Casilla c: b.getCasillas()){
					tableroColores.setPosicion(c.getX(), c.getY(), Colores.HUNDIDO.getValor());
				}
			}
		}
		if(finPartida2()) mostrarFinPartida();
	}

	/**
	 * Implementación poco eficiente para determinar si un Barco tocado se ha hundido.
	 * @return array de posiciones del Barco hundido, o (null o -1 -1...) si no es Barco hundido
	 */
	private int[][] hundido(int x, int y) {
		int posicion=1;
		int[][] posicionesBarcoHundido = new int[2][getTamanioMaximoBarco()];
		for (int i=1;i<getTamanioMaximoBarco();i++) {
		  posicionesBarcoHundido[0][i]=-1;
		  posicionesBarcoHundido[1][i]=-1;
		}
		posicionesBarcoHundido[0][0]=x;
		posicionesBarcoHundido[1][0]=y;

		int posicionesCubiertas=0;
		int idBarco = tableroBarcos.getPosicion(x,y);  // obtenemos el id del Barco
		for (int px=0;px<tamanioTablero;px++)
		  for (int py=0;py<tamanioTablero;py++)
			if (tableroBarcos.getPosicion(px,py)==idBarco) {
			  int colorBarco = tableroColores.getPosicion(px, py);
			  if (colorBarco==Colores.CUBIERTO.getValor()) {
				  posicionesCubiertas++;
				  if (posicionesCubiertas==2) // La que se ha pulsado y cualquier otra
					return null;
			  }
			  if (colorBarco==Colores.TOCADO.getValor()) {
					posicionesBarcoHundido[0][posicion]=px;
					posicionesBarcoHundido[1][posicion]=py;
					posicion++;
			  }
			}
		return posicionesBarcoHundido;
	}
	

   public boolean finPartida() {
	for (int y=0;y<tamanioTablero;y++) 
	  for (int x=0;x<tamanioTablero;x++) 
		if (tableroBarcos.getPosicion(x,y)!=0&&tableroColores.getPosicion(x, y)==Colores.CUBIERTO.getValor())
		 return false;
	return true;
   }

   public boolean finPartida2(){
		boolean fin = true;
		for(Barco b: barcos){
			fin = fin && b.estaHundido();
		}
		return fin;
   }
   
   public void mostrarFinPartida() {
	 for (int y=0;y<tamanioTablero;y++) 
	   for (int x=0;x<tamanioTablero;x++) 	
		 if (tableroColores.getPosicion(x, y)==Colores.CUBIERTO.getValor())
		   tableroColores.setPosicion(x, y,Colores.AGUA.getValor());
   }

	public String toString() {
	  return tableroBarcos.toString();
	}
	
	public static void main(String[] a) {
		int[] numBarcosLong = {4,3,3,2};
		Barquitos b = new Barquitos(numBarcosLong,10);
		b.colocarBarcos();
		System.out.println(b);
	}
	
}
