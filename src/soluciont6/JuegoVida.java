package soluciont6;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Objeto abstracto que crea instancias de Vista y Modelo y las relaciona entre sí.
 * @author POO.
 *
 */
public abstract class JuegoVida extends Frame {
	
	private final int SIZE=40;
	private Tablero tablero, tableroSiguiente;
	private Vista vista;

	/**
	 * Creación de un juego de la vida.
	 */
	public JuegoVida() {
	  tablero = new Tablero (SIZE);
	  tablero.initRandom(80, Tablero.VIVO);
	  tablero.initRandom(80, Tablero.MUERTO);
	  vista = new Vista();
	  
      this.add(vista);
      
      // indica qué objetos son vistas de qué modelo		
      tablero.addPropertyChangeListener(vista);        // ******** Modelo Vista Controlador
	  tablero.set(tablero);
      
	  addWindowListener(new WindowAdapter()
	      {public void windowClosing(WindowEvent e)
	         {dispose(); System.exit(0);}
	      }
	  );

	  setSize(SIZE*10+20, SIZE*10+40); 
	  setVisible(true); 
	  	    
	}

	/**
	 * Arranca el juego de la vida.
	 */
	public void start() {
	  do {
	   try {
		 Thread.sleep(700);
	   } catch(Exception e) {}
		 tableroSiguiente = evolucion(tablero);
		 tablero.set(tableroSiguiente);
	  } while (true);	
	}
	
	/**
	 * A partir del Modelo en un tiempo t, se obtiene el Modelo en un tiempo t+1.
	 * @param tablero Modelo en el tiempo t.
	 * @return Modelo en el tiempo t+1.
	 */
	public abstract Tablero evolucion(Tablero tablero);

}
