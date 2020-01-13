package ajedrez;

import java.util.LinkedList;

/**
 * Figura de ajedrez: Reina.
 * @author POO.
 *
 */
public class Reina extends Figura {

	private final static int valor=10;
	
	public Reina(Color color, Posicion posicion) {
	  super(color, posicion);
	}
	
	public int getValor() {
	  return valor;
	}
	
	public char getRepresentacion() {
	  return 'r';
	}
	
	public Figura clone() {
	  return new Reina(getColor(),getPosicion());
	}
	
	public LinkedList<Posicion> movimientos(ITablero tablero) {
	  Torre torre = new Torre(getColor(),getPosicion());
	  Alfil alfil = new Alfil(getColor(),getPosicion());
	  LinkedList<Posicion> movimientosTorre = torre.movimientos(tablero);
	  LinkedList<Posicion> movimientosAlfil = alfil.movimientos(tablero);	
	  movimientosTorre.addAll(movimientosAlfil);
	  return movimientosTorre;
	}
	
}
