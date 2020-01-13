package ajedrez;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Programa principal; crea la vista y el modelo (TableroAprendizaje), y enlaza el controlador; 
 * visualiza el tablero en un Frame.
 * @author jbobi
 *
 */
public class JuegoAjedrez extends Frame {
	
	private TableroAprendizaje tablero;
	private Vista vista;
	
	public JuegoAjedrez() {
	  tablero = new TableroAprendizaje ();
	  vista = new Vista(tablero);
	  
      this.add(vista);
      
      // indica qué objetos son vistas de qué modelo		
      tablero.addPropertyChangeListener(vista);        // ******** Modelo Vista Controlador
      
	  addWindowListener(new WindowAdapter() 
	      {public void windowClosing(WindowEvent e) 
	         {dispose(); System.exit(0);}  
	      }
	  );
	  
	  vista.addMouseListener(new Controlador(tablero)); 
		
	  setSize(ITablero.SIZE*Vista.CASILLA_SIZE+20, ITablero.SIZE*Vista.CASILLA_SIZE+40); 
	  setVisible(true); 
	  
      tablero.initTablero();
	      
	}
	
	
	public static void main(String[] args) {
		JuegoAjedrez ja = new JuegoAjedrez();
	}
		

}
