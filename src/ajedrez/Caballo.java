package ajedrez;

import java.util.LinkedList;

/**
 * Figura de ajedrez: Caballo.
 * @author POO.
 *
 */
public class Caballo extends Figura {

	private final static int valor=3;
	
	private LinkedList<Posicion> movimientos = new LinkedList<Posicion>();
	
	public Caballo(Color color, Posicion posicion) {
	  super(color, posicion);
	}
	
	public int getValor() {
	  return valor;
	}
	
	public char getRepresentacion() {
	  return 'C';
	}
	
	public Figura clone() {
	  return new Caballo(getColor(),getPosicion());
	}
	
	
	public LinkedList<Posicion> movimientos(ITablero tablero) {

		int x = getPosicion().getX();int y = getPosicion().getY();
        int xDestino,yDestino;
        
		// Derecha-Arriba
		xDestino=x+2; yDestino=y+1;
		if (xDestino<ITablero.SIZE&&yDestino<ITablero.SIZE) 
		  movimiento(xDestino,yDestino,tablero);	
		
		// Derecha-Abajo
		xDestino=x+2; yDestino=y-1;
		if (xDestino<ITablero.SIZE&&yDestino>=0) 		  
		  movimiento(xDestino,yDestino,tablero);	
		
		// Izquierda-Arriba
		xDestino=x-2;yDestino=y+1;
		if (xDestino>=0&&yDestino<ITablero.SIZE) 		  
		  movimiento(xDestino,yDestino,tablero);	
		
		// Izquierda-Abajo
		xDestino=x-2;yDestino=y-1;
		if (xDestino>=0&&yDestino>=0) 		 
		  movimiento(xDestino,yDestino,tablero);	
		
		// Arriba-Derecha
		xDestino=x+1; yDestino=y+2;
		if (xDestino<ITablero.SIZE&&yDestino<ITablero.SIZE) 
		  movimiento(xDestino,yDestino,tablero);	
		
		// Abajo-Derecha
		xDestino=x+1; yDestino=y-2;
		if (xDestino<ITablero.SIZE&&yDestino>=0) 
		  movimiento(xDestino,yDestino,tablero);	
		
		// Arriba-Izquierda
		xDestino=x-1;yDestino=y+2;
		if (xDestino>=0&&yDestino<ITablero.SIZE) 		  
		  movimiento(xDestino,yDestino,tablero);	
		
		// Abajo-Izquierda
		xDestino=x-1;yDestino=y-2;
		if (xDestino>=0&&yDestino>=0) 		  
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
