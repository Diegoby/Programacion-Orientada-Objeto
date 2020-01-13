package ajedrez;

/**
 * Tablero que permite marcar las posiciones a las que se pueden mover las figuras;
 * Diseñado para jugadores principiantes.
 * @author POO
 *
 */
public interface ITableroAprendizaje extends ITablero {
	
      /**
       * Posibles estados que puede tener una casilla;
       * MVIMIENTO_ORIGEN Y MOVIMIENTO_DESTINO señalan el último movimiento reaizado automáticamente por la máquina;
       * MOVIMIENTO_POSIBLE indica las casillas a las que puede transitar la figura elegida (pulsada);
       * MOVIMIENTO_REAL indica la casilla que el jugador ha elegido como destino de su movimiento;
       * VACIO casilla sin Figura, ni destino del movimiento de la máquina, ni posible destino de la Figura elegida por el jugador.
       * @author POO
       *
       */
	  enum Estado {VACIO, MOVIMIENTO_POSIBLE, MOVIMIENTO_REAL, MOVIMIENTO_ORIGEN, MOVIMIENTO_DESTINO};
	  
	  /**
	   * El Tablero de ajedrez se divide en casillas blancas y negras.
	   * @author POO.
	   *
	   */
	  enum Casilla {BLANCA, NEGRA};
	  
	  /**
	   * Actualiza el Tablero.
	   * @param posicion Posicion que se va a actualizar.
	   * @param estado Valor que se va a insertar en la Posicion.
	   */
	  void setEstado(Posicion posicion, Estado estado);
	  
	  /**
	   * Obtiene el estado de una posicion del Tablero.
	   * @param posicion Posicion del tablero.
	   * @return Estado correspondiente a la Posicion seleccionada.
	   */
	  Estado getEstado(Posicion posicion);
	  
	  /**
	   * Asigna a todas las casillas el Estado VACIO.
	   */
	  void initEstados();
	  
	  /**
	   * Indica si la casilla es blanca o negra.
	   * @param posicion Posicion de la casilla a consultar.
	   * @return COlor de la casilla: BLANCA o NEGRA.
	   */
	  static Casilla getColor(Posicion posicion) {
		if ((posicion.getX()+posicion.getY())%2==0)
		  return Casilla.BLANCA;
		else
		  return Casilla.NEGRA;
	  }
	  
}
