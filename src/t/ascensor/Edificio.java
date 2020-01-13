package t.ascensor;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Programa principal que visualiza el panel de control de los ascensores;
 * Cada ascensor se implementa con un Thread, de manera que los ascensores
 * se mueven concurrentemente. Cada ascensor es un modelo y todos los modelos
 * se visualizan en una misma vista.
 * @author POO
 *
 */
public class Edificio extends Frame {
	
  public static final int NUM_MAX_PISOS=50;
  public static final int NUM_ASCENSORES=20;
  
  private int[][] limites = { {0,49},{0,49},{0,49},{0,49},{0,49},{0,25},{0,25},{0,25},{0,10},{0,10},
		  					  {0,35},{0,35},{25,49},{25,49},{25,49},{0,49},{0,49},{0,49},{0,49},{0,49}
							};

  private Ascensor[] ascensor;
  private VistaAscensor vistaAscensor;
  
  /**
   * Crea la instancia Edificio y sus NUM_ASCENSORES; asigna la vista (VistaAscensor) a cada Ascensor;
   * Cada Ascensor se implementa con un Thread.
   */
  public Edificio() {   
    ascensor = new Ascensor[NUM_ASCENSORES];

	vistaAscensor = new VistaAscensor(this);						//  NUM_ASCENSORES Vistas
	this.add(vistaAscensor);
	  
	for (int i=0;i<NUM_ASCENSORES;i++) {							//  Incluimos NUM_ASCENSORES vistas en este Frame
      ascensor[i] = new Ascensor(i,limites[i][0],limites[i][1]);	//  NUM_ASCENSORES Modelos
      new Thread(ascensor[i]).start();
        // indica que objetos son vistas de que modelo
        ascensor[i].addPropertyChangeListener(vistaAscensor);        // ******** Modelo Vista Controlador
	}
		  
	addWindowListener(new WindowAdapter() 
	   {public void windowClosing(WindowEvent e) 
	      {dispose(); System.exit(0);}  
	   }
	);
	
	setSize(930,360); 
	setVisible(true); 
  }
  
  /**
   * Devuelve el ascensor  solicitado.
   * @param i Índice de ascensor (entre 0 y NUM_ASCENSORES-1).
   * @return Ascensor i-ésismo.
   */
  public Ascensor getAscensor(int i) {return ascensor[i];}

  /**
   * Arranca la apliacación.
   * @param a No requiere argumentos.
   */
  public static void main(String[] a) {
	 new Edificio();
  }

}








