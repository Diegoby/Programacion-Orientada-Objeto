package ajedrez;

import java.util.LinkedList;

/**
 * Figura de ajedrez: Alfil.
 * @author POO.
 *
 */
public class Alfil extends Figura {

	private final static int valor=3;
	
	private LinkedList<Posicion> movimientos = new LinkedList<Posicion>();
	
	public Alfil(Color color, Posicion posicion) {
	  super(color, posicion);
	}
	
	public int getValor() {
	  return valor;
	}
	
	public char getRepresentacion() {
	  return 'A';
	}
	
	public Figura clone() {
	  return new Alfil(getColor(),getPosicion());
	}
	
	
	public LinkedList<Posicion> movimientos(ITablero tablero) {
		
        Posicion posicion=null;
        boolean hayFigura;
		int x = getPosicion().getX();int y = getPosicion().getY();
		int i,j;
							
		  i=x+1;j=y+1; hayFigura=false;
		  while (i<ITablero.SIZE&&j<ITablero.SIZE&&!hayFigura) {	// diagonal arriba-derecha
		    posicion = new Posicion(i,j);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i=i+1;j=j+1;
		  }
		  
		  i=x-1;j=y+1; hayFigura=false;
		  while (i>=0&&j<ITablero.SIZE&&!hayFigura) {				// diagonal arriba-izquierda
		    posicion = new Posicion(i,j);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i=i-1;j=j+1;
		  }		
		  
		  i=x+1;j=y-1; hayFigura=false;
		  while (i<ITablero.SIZE&&j>=0&&!hayFigura) {				// diagonal abajo-derecha
		    posicion = new Posicion(i,j);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i=i+1;j=j-1;
		  }	
		  
		  i=x-1;j=y-1; hayFigura=false;
		  while (i>=0&&j>=0&&!hayFigura) {							// diagonal abajo-izquierda
		    posicion = new Posicion(i,j);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i=i-1;j=j-1;
		  }
		
		return movimientos;
	}	
	
	
	
}
