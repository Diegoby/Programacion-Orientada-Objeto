package barquitos;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Vista del juego de los barquitos utilizando Graphics2D y el Modelo/Vista/Controlador.
 * @author POO
 *
 */
public class Vista extends Canvas implements IVista, PropertyChangeListener {   // ******** Modelo Vista Controlador

  private Graphics2D g2d;
  private Tablero modelo;
  private int[][] tablero;
  

  /**
   * Construye una vista del Tablero inicial.
   * @param modelo Tablero inicial.
   */
  public Vista(Tablero modelo) {
	  this.modelo = modelo;
	  tablero = modelo.getTablero();
  }
  
  public void paint(Graphics g) {	
	g2d = (Graphics2D) g;
	dibujaTablero();
  }
  	  
  private void dibujaTablero() {
  	int tamanio = modelo.getTamanio();

	for (int x=0;x<tamanio;x++)
	  for (int y=0;y<tamanio;y++) {
	    g2d.setColor(Colores.getColor(tablero[x][y]));
		g2d.fillRect(COMIENZO_X+LADO*x, COMIENZO_Y+LADO*y, LADO, LADO);
		g2d.setColor(Colores.BORDE.getColor());
		g2d.drawRect(COMIENZO_Y+LADO*x, COMIENZO_Y+LADO*y, LADO, LADO);
	}
  }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {  // ******** Modelo Vista Controlador
		System.out.println("Vista.propertyChange()\n");

		tablero = (int[][]) evt.getNewValue();
		repaint();
	}
}
