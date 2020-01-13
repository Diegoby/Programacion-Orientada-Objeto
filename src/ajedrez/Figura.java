package ajedrez;

import java.util.LinkedList;

/**
 * Abstracción de una Figura de ajedrez;
 * Color de la figura, posición y movimientos permitidos; 
 * El color de cada figura se establece en su instanciación, y no varía;
 * La posición inicial de la figura en el tablero se establece en su instanciación;
 * Cada tipo de figura tiene un valor táctico diferente, que se establece en las diversas clases que implementan este interfaz.
 * @author POP

 */
public abstract class Figura {
	
	/**
	 * Las figuras del juego de ajedrez pueden ser blancas o negras.
	 */
	public enum Color {BLANCA, NEGRA};
	
	private Color color;
	private Posicion posicion;

	
	/** 
	 * Creación de una Figura genérica de ajedrez.
	 * @param color BLANCA o NEGRA.
	 * @param posicion Casilla del tablero, definida por sus valores x e y.
	 */
	public Figura(Color color, Posicion posicion) {
	  this.color = color;
	  this.posicion = posicion;
	}
	
	
	/**
	 * Devuelve el color de la figura.
	 * @return Color de la figura.
	 */
	public Color getColor() {
	  return color;
	}
	
	
	/**
	 * Indica la posición de la figura, en el tablero, en cualquier momento de la partida.
	 * @return Posicion que tiene la figura en el tablero.
	 */
	public Posicion getPosicion() { 
	  return posicion;
	}
	
	/**
	 * Método poloimórfico; Devuelve el valor táctico de la Figura.
	 * @return valor de la Figura.
	 */
	public abstract int getValor();
	
	/**
	 * Representación de la figura en el Tablero; Para simplificar asumimos una sola Vista; En una implementación
	 * más completa haríamos posible el uso de diferentes Vistas; La representación sería un tipo genérico, y Tablero 
	 * usuaría el mecanismo de genéricos de Java.
	 * @return Caracter con el que se va a representar la figura.
	 */
	public abstract char getRepresentacion();
	
	/**
	 * Varía la posición de la figura, en el tablero, en cualquier momento de la partida.
	 * @param posicion Nueva posición de la figura en el tablero.
	 */
	public void setPosicion(Posicion posicion) {
	  this.posicion = posicion;
	}
	
	public abstract Figura clone();	
	 
	 /**
	  * Calcula las posiciones posibles (en tablero con Figuras) a las que puede evolucionar la figura
	  * a partir de su posición inicial; Facilita la visualización de los movimientos de las figuras, para los
	  * principiantes en el juego; Permite validar los movimientos de los jugadores; La lista de posiciones será un 
	  * subconjunto de las obtenidas usando el método movimientos().
	  * @param tablero Tablero existente en el momento de la jugada.
	  * @return Lista de posiciones a las que puede evolucionar la Figura, teniendo en cuenta las restricciones del Tablero.
	  */
	 public abstract LinkedList<Posicion> movimientos(ITablero tablero);
	 
	 
	  /**
	   * Obtiene los escenarios (Tableros) posibles moviendo la Figura indicada. Válido para implementar un ajedrez que juegue
	   * automáticamente contra un jugador humano.
	   * @param tablero Tablero actual a partir del que se genera un movimiento de respuesta.
	   * @return Escenarios (Tableros) que se pueden generar.
	   */
	 public LinkedList<ITablero> escenarios(ITablero tablero) {

	   LinkedList<ITablero> escenarios = new LinkedList<ITablero>();
	   ITablero escenario;
			   
	   LinkedList<Posicion> movimientos = movimientos(tablero);	     
	   for (Posicion posicion: movimientos) {
		 escenario = tablero.clone();	 
		 escenario.setNull(new Posicion(this.getPosicion().getX(),this.getPosicion().getY())); //Elimina la Figura de su origen.
		 Figura f = this.clone();
		 f.setPosicion(posicion);      // Establece la Posicion de destino en la figura clonada
		 escenario.set(f);             // Añade la figura clonada
		 escenarios.add(escenario);
	   }	   
	   return escenarios;
	}

}
