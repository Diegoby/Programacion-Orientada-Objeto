package soluciont6;

/**
 * Búsquese "Juego de la vida autómata celular";
 * Si en las casillas adyacentes (izq, der, arr, abj) hay más organismos muertos que vivos,
 * entonces la casilla actual vive (hábitat positivo); en caso contrario muere (superpoblación). 
 * Se puede implementar cualquier otro conjunto de reglas extendiendo esta clase abstracta e
 * implementando el método evolución con esas reglas.
 * 
 * @author POO.
 *
 */
public class Tradicional extends JuegoVida {
	
	/**
	 * Implementa el método abstracto evolución de su superclase JuegoVida.
	 */
    public Tablero evolucion(Tablero tablero) {
      Tablero tableroSiguiente = new Tablero(tablero.size());
      for (int x=0;x<tablero.size();x++)
    	for (int y=0;y<tablero.size();y++) {	
    	  tableroSiguiente.setCasilla(x, y, evolucionCasilla(x,y,tablero));
    	}
      return tableroSiguiente;
    }
    
    private int evolucionCasilla(int x, int y, Tablero tablero) {
      int contVIVO=0;
      int contMUERTO=0;
      int izq, dcha, arr, abj;
      if (x>0) {									// Izquierda
    	izq = tablero.getCasilla(x-1, y);
    	if (izq==Tablero.VIVO) contVIVO++;    	  
      	else 
      	  if (izq==Tablero.MUERTO) contMUERTO++;     	   
      }
      if (x<tablero.size()-1) {						// Derecha
    	dcha = tablero.getCasilla(x+1, y);
    	if (dcha==Tablero.VIVO) contVIVO++;    	  
      	else 
      	  if (dcha==Tablero.MUERTO) contMUERTO++;     	   
      }												// Arriba
      if (y>0) {
    	arr = tablero.getCasilla(x, y-1);
    	if (arr==Tablero.VIVO) contVIVO++;    	  
      	else 
      	  if (arr==Tablero.MUERTO) contMUERTO++;     	   
      }
      if (y<tablero.size()-1) {						// Abajo
    	abj = tablero.getCasilla(x, y+1);
    	if (abj==Tablero.VIVO) contVIVO++;    	  
      	else 
      	  if (abj==Tablero.MUERTO) contMUERTO++;     	   
      }
      

  	  if (contMUERTO>contVIVO)
  		return (Tablero.VIVO);
  	  else
  		if (contMUERTO<contVIVO)
  	  	  return(Tablero.MUERTO);  
  		else
    	  return(Tablero.VACIO);   			
    }
}
