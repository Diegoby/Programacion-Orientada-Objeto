package unocerounocero;
import java.util.Observable;

public class Modelo extends Observable {     	 // ******** Modelo Vista Controlador

  private Tablero tableroJuego;
  private FigurasMesa figurasSeleccionables;
  private Puntuacion puntuacion;    			// Array de puntuaciones (puntos de cada figura)
  private Figuras1010 figuras1010;				// Figuras predefinidas del juego
	  
  public Modelo() {
	tableroJuego = new Tablero();
	figurasSeleccionables = new FigurasMesa();
	puntuacion = new Puntuacion();	  
    new Colores(); 						// crea el array de colores, no se creamos propiedad porque tiene metodos estaticos
    figuras1010 = new Figuras1010(); 	//crea las figuras predefinidas
  }
  
  public Tablero getTableroJuego() {
	 return tableroJuego;
  }
  
  public FigurasMesa getFigurasMesa() {
	 return figurasSeleccionables;
  }
  
  public Puntuacion getPuntuacion() {
	 return puntuacion;
  }
  
  public Figuras1010 getFiguras1010() {
	 return figuras1010;
  }
   
 
  public boolean colocaEnPosTablero(boolean[][] forma, int posX, int posY, int indiceColor) {
	boolean figuraColocada;
	figuraColocada = tableroJuego.colocaEnPos(forma,posX,posY,indiceColor,puntuacion);
	if (figuraColocada) {
	  setChanged();           // ******** Modelo Vista Controlador
	  notifyObservers();	  // ******** Modelo Vista Controlador	
	  return true;
	} else
	   return false;
  }
  
  
  public boolean borrarProgresosTablero(Puntuacion puntuacion) {
	boolean progresos;
    progresos = tableroJuego.borrarProgresos(puntuacion);
    if (progresos) {
	   setChanged();           // ******** Modelo Vista Controlador
	   notifyObservers();	   // ******** Modelo Vista Controlador
       return true;
    } else
       return false;
  }
  
  
}




