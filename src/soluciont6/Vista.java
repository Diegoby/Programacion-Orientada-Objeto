package soluciont6;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Vista del Juego de la Vida.
 * @author POO.
 *
 */
public class Vista extends Canvas implements PropertyChangeListener {

  private Graphics2D g2d;
  private Tablero tablero;

  /**
   * Método establecido en el modo gráfico 2D para dibujar en el Canvas.
   */
  public void paint(Graphics g) {	
	g2d = (Graphics2D) g;
	for (int x=0;x<tablero.size();x++)
	  for (int y=0;y<tablero.size();y++) {	
		switch (tablero.getCasilla(x,y)) {
		  case Tablero.VACIO: g2d.setColor(java.awt.Color.WHITE); break;
		  case Tablero.VIVO: g2d.setColor(java.awt.Color.GREEN); break;
		  case Tablero.MUERTO: g2d.setColor(java.awt.Color.RED); break;
		}
        g2d.fillRect(10+x*10, 10+y*10, 10, 10);
	  }  
  } 
  
  
  /**
   * Actualiza la Vista, invocando al método paint, mediante el método repaint.
   */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        tablero = (Tablero) evt.getNewValue();
        repaint();
    }
}