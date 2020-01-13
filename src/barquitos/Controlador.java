package barquitos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Controlador de los disparos en el juego de los barquitos; 
 * cada presión en el ratón sobre una casilla del Tablero genera un disparo.
 * @author POO
 *
 */
public class Controlador extends MouseAdapter {

  private Barquitos barquitos;   // ******** Modelo Vista Controlador
  
  public Controlador(Barquitos barquitos) {
	 this.barquitos = barquitos;   // ******** Modelo Vista Controlador
  }
  /**
   * Realiza un disparo en la casilla pulsada. 
   */
  public void mousePressed(MouseEvent e) {
	  int x = (e.getX()-Vista.COMIENZO_X)/Vista.LADO;
	  int y = (e.getY()-Vista.COMIENZO_Y)/Vista.LADO;	 
      barquitos.disparo(x,y);  
  }
}