package ajedrez;

import java.util.LinkedList;

/**
 * Figura de ajedrez: Torre.
 * @author POO.
 *
 */
public class Torre extends Figura {

	private final static int valor=5;
	
	public Torre(Color color, Posicion posicion) {
	  super(color, posicion);
	}
	
	public int getValor() {
	  return valor;
	}
	
	public char getRepresentacion() {
	  return 'T';
	}
	
	public Figura clone() {
	  return new Torre(getColor(),getPosicion());
	}
	
	
	public LinkedList<Posicion> movimientos(ITablero tablero) {
		LinkedList<Posicion> movimientos = new LinkedList<Posicion>();

        Posicion posicion=null;
        boolean hayFigura;
		int x = getPosicion().getX();int y = getPosicion().getY();
		int i;
							
		  i=x-1; hayFigura=false;
		  while (i>=0&&!hayFigura) {						// izquierda
		    posicion = new Posicion(i,y);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i=i-1;
		  }
		  
		  i=x+1; hayFigura=false;
		  while (i<ITablero.SIZE&&!hayFigura) {		// derecha
		    posicion = new Posicion(i,y);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i++;
		  }		
		  
		  i=y+1; hayFigura=false;
		  while (i<ITablero.SIZE&&!hayFigura) {		// arriba
		    posicion = new Posicion(x,i);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i++;
		  }	
		  
		  i=y-1; hayFigura=false;
		  while (i>=0&&!hayFigura) {						// abajo
		    posicion = new Posicion(x,i);
		    hayFigura = tablero.get(posicion)!=null;	
		    if ((!hayFigura)||(hayFigura&&tablero.get(posicion).getColor()!=getColor())) // No hay figura o hay una figura del jugador contrario		  
			  movimientos.add(posicion);
		    i=i-1;
		  }
			  			
		return movimientos;
	}
	
	
}
