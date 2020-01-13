package barquitos;
/**
 * Funcionalidad del juego de los Barquitos.
 * @author POO
 *
 */
public interface IBarquitos {
  
  /**
   * Coloca aleatoriamente los barcos en el Tablero.
   */
  void colocarBarcos();
  
  /**
   * Actualiza el Tablero en función de su estado actual y del disparo realizado en la casilla (x,y).
   * @param x coordenada x del disparo.
   * @param y coordenada y del disparo.
   */
  void disparo(int x, int y);
  
  /**
   * Indica si se ha llegado al final de la partida (todos los barcos hundidos).
   * @return true: todos los barcos han sido hundidos.
   */
  boolean finPartida();
  
  /**
   * Muestra todo el Tablero (agua, barcos tocados y barcos hundidos).
   */
  void mostrarFinPartida();

}

