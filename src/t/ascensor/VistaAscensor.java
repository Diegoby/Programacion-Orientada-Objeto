package t.ascensor;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observer;
import java.util.Observable;

/**
 * Vista del Edificio; Ascensor es el Modelo y Edificio contiene NUM_ASCENSORES;
 * En esta vista cada ascensor se representa mediante un rectángulo donde se visualiza, en tiempo real,
 * el piso en el que se encuentra cada Ascensor.
 * @author POO
 *
 */
public class VistaAscensor extends Canvas implements PropertyChangeListener {   // ******** Modelo Vista Controlador

  private Graphics2D g2d;
  private Edificio edificio;
  private Font font = new Font("Arial Bold",Font.BOLD,30);
  
  /**
   * Creamos la vista dibujando la posición inicial de los ascensores en el panel de control de ascensores.
   * @param edificio Instancia conteniendo los NUM_ASCENSORES existentes.
   */
  public VistaAscensor(Edificio edificio) {
	this.edificio = edificio;
  }
  		
  public void paint(Graphics g) {
    g2d = (Graphics2D) g;	
    g2d.setFont(font);
  	dibujaAscensores();
  }
  
  private void dibujaAscensores() {
	String sPiso;
	int piso;
	for (int i=0;i<Edificio.NUM_ASCENSORES;i++) {
	  piso = edificio.getAscensor(i).getPiso();
	  if (piso<10)
		sPiso = "0"+piso;
	  else
		sPiso=""+piso;
	  g2d.setColor(java.awt.Color.BLUE);
	  g2d.fillRect(30+(30+60)*(i%10), 30+(30+120)*(i/10), 60, 120);
	  g2d.setColor(java.awt.Color.GRAY);
	  g2d.drawString(sPiso, 40+(30+60)*(i%10), 100+(30+120)*(i/10));
	}
  }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}
