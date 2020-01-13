package ajedrez;

import java.awt.event.*;
import java.util.LinkedList;

/**
 * Permite realizar un movimiento de Figura de ajedrez y obtener un movimiento de respuesta del programa. 
 * @author POO
 *
 */
public class Controlador extends MouseAdapter {

  private TableroAprendizaje tablero;   // ******** Modelo Vista Controlador. El tablero es nuestro modelo.
  
  private int xPressed,yPressed,xReleased,yReleased;
  private LinkedList<Posicion> movimientos=null;
  private Figura figura;
  
  public Controlador(TableroAprendizaje tablero) {
	 this.tablero = tablero;   // ******** Modelo Vista Controlador
  }
  
  /**
   * Selecciona la Figura a mover y calcula sus movimientos permitidos.
   */
  public void mousePressed(MouseEvent e) {

	  xPressed = (e.getX()-Vista.MARGEN)/Vista.CASILLA_SIZE;
	  yPressed = (e.getY()-Vista.MARGEN)/Vista.CASILLA_SIZE;
	  if (enMargenes(xPressed,yPressed)&&tablero.get(new Posicion(xPressed,yPressed))!=null) {
	    figura = tablero.get(new Posicion(xPressed,yPressed));
	    if (figura!=null) {
	      movimientos = figura.movimientos(tablero);     
	      for (Posicion posicion: movimientos) 
		    tablero.setEstado(posicion, ITableroAprendizaje.Estado.MOVIMIENTO_REAL);    
	    }
	  } 
  }
  
  /**
   * Traslada la Figura a la posición de destino y genera un movimiento de respuesta por parte del programa.
   */
  public void mouseReleased(MouseEvent e) {
	  
	  LinkedList<ITablero> escenarios;
	  ITablero escenarioSeleccionado=null;
	
	  xReleased = (e.getX()-Vista.MARGEN)/Vista.CASILLA_SIZE;
	  yReleased = (e.getY()-Vista.MARGEN)/Vista.CASILLA_SIZE;

	  if (enMargenes(xReleased,yReleased)) 
	   if (figura!=null&&(xPressed!=xReleased||yPressed!=yReleased)) // Se traslada la figura
		if (destinoPermitido(xReleased,yReleased)) {
		  tablero.setNull(new Posicion(xPressed,yPressed));       	// Se borra la posición anterior
		  figura.setPosicion(new Posicion(xReleased,yReleased));    // Se asigna a la figura la nueva posición
		  tablero.set(figura);										// Se pone la figura en el Tablero
		  
		  // El programa juega contra el jugador
		  if (figura.getColor()==Figura.Color.BLANCA) {
			escenarios = tablero.escenarios(Figura.Color.NEGRA);		// Obtiene todos los estados de respuesta a la jugada de las blancas				
			escenarioSeleccionado = tablero.estrategia(escenarios, Figura.Color.NEGRA);	  
		  } else {
			escenarios = tablero.escenarios(Figura.Color.BLANCA);		// Obtiene todos los estados de respuesta a la jugada de las negras
			escenarioSeleccionado = tablero.estrategia(escenarios, Figura.Color.BLANCA);
		  }		  
		  	  
		 Posicion[] movimiento = tablero.movimiento(escenarioSeleccionado);
		 tablero.initEstados();
		 tablero.setEstado(movimiento[0], ITableroAprendizaje.Estado.MOVIMIENTO_ORIGEN);
		 tablero.setEstado(movimiento[1], ITableroAprendizaje.Estado.MOVIMIENTO_DESTINO);	
	     tablero.set(escenarioSeleccionado.get());
	    }
		else
	     tablero.initEstados();
  
  }
  
  private boolean enMargenes(int x, int y) {
	 return (x>=0 && y>=0 && x<ITablero.SIZE && y<ITablero.SIZE);
  }
  
  private boolean destinoPermitido(int x, int y) {
    for (Posicion posicion: movimientos) 
	  if (posicion.equals(new Posicion(x,y))) 
		return true;
    return false;
  }

}


