package ajedrez;

import java.util.LinkedList;

public class Peon extends Figura {

	private final static int valor=1;
	
	/**
	 * Figura de ajedrez: Peon.
	 * @author POO.
	 * @param color Color de la Figura.
	 * @param posicion Posición inicial de la Figura.
	 */
	public Peon(Color color, Posicion posicion) {
	  super(color, posicion);
	}
	
	public int getValor() {
	  return valor;
	}
	
	public char getRepresentacion() {
	  return 'P';
	}
	
	public Figura clone() {
	  return new Peon(getColor(),getPosicion());
	}
	
	
	// Blancas comienzas en posiciones bajas de y (y=1 e y=2). Negras en posiciones altas de y (Y=8 e y=7).
	public LinkedList<Posicion> movimientos(ITablero tablero) {
		LinkedList<Posicion> movimientos = new LinkedList<Posicion>();
		
        int xDestino,yDestino;
        Posicion posicion;
        boolean hayFigura;
		int x = getPosicion().getX();int y = getPosicion().getY();
		
		if (getColor() == Figura.Color.NEGRA) {
			
			xDestino=x-1; yDestino=y-1; 				// diagonal izquierda	(visión negras)
			if (xDestino>=0&&yDestino>=0) {	
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (hayFigura&&tablero.get(posicion).getColor()!=getColor()) // Hay una figura del otro jugador
				movimientos.add(posicion);					  
			}

			xDestino=x+1; yDestino=y-1; 				// diagonal derecha		(visión negras)
			if (xDestino<ITablero.SIZE&&yDestino>=0) {	
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (hayFigura&&tablero.get(posicion).getColor()!=getColor()) // Hay una figura del otro jugador
				movimientos.add(posicion);					  
			}
			
			xDestino=x; yDestino=y-1; 					// arriba una posición
			if (yDestino>=0) {	
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (!hayFigura) 
				movimientos.add(posicion);					  
			}
			
			xDestino=x; yDestino=y-2; 					// arriba dos posiciones
			if (y==6) {	// fila inicial de los peones NEGROS
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (!hayFigura&&tablero.get(new Posicion(x,y-1))==null) // No hay figuras delante
				movimientos.add(posicion);					  
			}

		} else {  // BLANCA
			
			xDestino=x-1; yDestino=y+1; 				// diagonal derecha (visión blancas)
			if (xDestino>=0&&yDestino<ITablero.SIZE) {	
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (hayFigura&&tablero.get(posicion).getColor()!=getColor()) // Hay una figura del otro jugador
				movimientos.add(posicion);					  
			}

			xDestino=x+1; yDestino=y+1; 				// diagonal izquierda	(visión blancas)
			if (xDestino<ITablero.SIZE&&yDestino<ITablero.SIZE) {	
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (hayFigura&&tablero.get(posicion).getColor()!=getColor()) // Hay una figura del otro jugador
				movimientos.add(posicion);					  
			}
			
			xDestino=x; yDestino=y+1; 					// arriba una posición
			if (yDestino>=0) {	
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (!hayFigura) 
				movimientos.add(posicion);					  
			}
			
			xDestino=x; yDestino=y+2; 					// arriba dos posiciones
			if (y==1) {	 // fila inicial de los peones BLANCOS
			  posicion = new Posicion(xDestino,yDestino);
			  hayFigura = tablero.get(posicion)!=null;
			  if (!hayFigura&&tablero.get(new Posicion(x,y+1))==null) // No hay figuras delante
				movimientos.add(posicion);					  
			}			
		}
		
		return movimientos;
	}
	
}

