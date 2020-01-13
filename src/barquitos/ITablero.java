package barquitos;
/**
 * Definición del Tablero del juego de los barquitos.
 * @author POO.
 *
 */
public interface ITablero {
    
	/**
	 * Devuelve el Tablero como una matriz.
	 * @return matriz de int conteniendo los valores de las casillas del Tablero.
	 */
    int[][] getTablero(); 
	
    /**
     * Modifica el contenido del Tablero completo.
     * @param tablero Matriz de enteros conteniendo el valor de cada casilla.
     */
	void setTablero(int[][] tablero);
	
	/**
	 * Indica el tamaño que tiene el tablero: la dimensión de la matriz de casillas. 
	 * @return Tamaño de del Tablero; por ejemplo: 8 en un Tablero de 8x8.
	 */
	int getTamanio();
	
	/**
	 * Devuelve el valor de la casilla indicada.
	 * @param x posición x de la casilla.
	 * @param y posición y de la casilla.
	 * @return valor de la casilla.
	 */
	int getPosicion(int x, int y); 
	
	/**
	 * Modifica el valor de la casilla indicada.
	 * @param x posición x de la casilla.
	 * @param y posición y de la casilla.
	 * @param valor Valor que se asigna a la casilla.
	 */
	void setPosicion(int x, int y, int valor); 
	
	/**
	 * Inicializa los valores de todas las casillas del Tablero a su estado inicial ("agua").
	 */
	void borra(); 
	
	/**
	 * Indica el número de casillas que no contienen "agua".
	 * @return Número de casillas ocupadas por un Barco (tocado, hundido o sin tocar).
	 */
	int ocupacion(); 
	
}