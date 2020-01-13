package barquitos;

import java.awt.Graphics;
import java.util.Observable;

/**
 * Definición de la Vista del juego de los barquitos.
 * @author POO
 *
 */
public interface IVista {	  
  int COMIENZO_X=40; // Margen horizontal
  int COMIENZO_Y=40; // Margen vertical
  int LADO=30; // Tamaño del lado de cada casilla (en píxeles).	
  
  /**
   * Dibuja el modelo; no es necesario ponerlo en el interfaz, pero mejora la definición de la práctica.
   * @param g Objeto gráfico.
   */
  void paint(Graphics g);

}
