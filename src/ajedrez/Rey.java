package ajedrez;

import java.util.LinkedList;

/**
 * Figura de ajedrez: Rey.
 * @author POO.
 *
 */
public class Rey extends Figura {

	private final static int valor=9;
	
	private LinkedList<Posicion> movimientos = new LinkedList<Posicion>(); //Movimientos posibles
	
	public Rey(Color color, Posicion posicion) {
	  super(color, posicion);
	}
	
	public int getValor() {
	  return valor;
	}
	
	public char getRepresentacion() {
	  return 'R';
	}
	
	public Figura clone() {
	  return new Rey(getColor(),getPosicion());
	}
	
	
	public LinkedList<Posicion> movimientos(ITablero tablero) {
		
        int xDestino,yDestino;
		int x = getPosicion().getX();int y = getPosicion().getY();
		
		xDestino=x-1; yDestino=y; // Izquierda
		if (xDestino>=0) 	
		  movimiento(xDestino,yDestino,tablero);
				
		xDestino=x+1; yDestino=y; // Derecha
		if (xDestino<ITablero.SIZE) 	
		  movimiento(xDestino,yDestino,tablero);
		
		yDestino=y-1; xDestino=x;  // Arriba
		if (yDestino>=0) 	
		  movimiento(xDestino,yDestino,tablero);
		
		yDestino=y+1; xDestino=x;  // Abajo
		if (yDestino<ITablero.SIZE) 	
		  movimiento(xDestino,yDestino,tablero);
		
		xDestino=x-1; yDestino=y-1;	// Arriba-Izquierda
		if (xDestino>=0&&yDestino>=0) 	
		  movimiento(xDestino,yDestino,tablero);
				
		xDestino=x+1; yDestino=y-1;	 // Arriba-Derecha
		if (xDestino<ITablero.SIZE&&yDestino>=0) 	
		  movimiento(xDestino,yDestino,tablero);
		
		xDestino=x-1; yDestino=y+1;	// Abajo-Izquierda
		if (xDestino>=0&&yDestino<ITablero.SIZE) 	
		  movimiento(xDestino,yDestino,tablero);
		
		xDestino=x+1; yDestino=y+1;	// Abajo-Derecha
		if (xDestino<ITablero.SIZE&&yDestino<ITablero.SIZE) 	
		  movimiento(xDestino,yDestino,tablero);				  
		
		return movimientos;
	}
	
	private void movimiento(int xDestino, int yDestino, ITablero tablero) {
	  Posicion posicion = new Posicion(xDestino,yDestino);
	  boolean hayFigura = tablero.get(posicion)!=null;
	  if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario
		movimientos.add(posicion);			
	}
	
}
