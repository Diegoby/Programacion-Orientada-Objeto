package ajedrez;

import java.util.LinkedList;

/**
 * Tablero de Ajedrez.
 * @author jbobi
 *
 */
public interface ITablero {
  /**
   * Tamaño del Tablero de ajedrez.
   */
  int SIZE = 8;
  
  /**
   * Devuelve el Tablero completo.
   * @return Tablero.
   */
  Figura[][] get();
  
  /**
   * Actualiza el Tablero.
   * @param tablero Tablero que sustituye al actual.
   */
  void set(Figura[][] tablero);
  
  /**
   * Devuelve la Figura situada en la posición del tablero proporcionada; 
   * Si Figura es null, significa que la posición no contiene ninguna Figura.
   * @param posicion Posicion del tablero.
   * @return Figura situada en "posicion"; Null indica que esa Posicion no tiene Figura.
   */
  Figura get(Posicion posicion);
  
  /**
   * Asigna Figura al Tablero; Las Figuras ya incluyen su posición; También se actualizan los valores del Tablero;
   * Si Figura es null, la posición queda vacía.
   * @param figura Figura que se asignara a la "posicion"; Null indica que esa Posicion no contendrá Figura.
   */
  void set(Figura figura);
  
  /**
   * Elimina una Figura del tablero.
   * @param posicion Posicion de la Figura a eliminar.
   */
  public void setNull(Posicion posicion);
  
  /**
   * Valor del Tablero para el jugador de blancas (o del jugador de negras): 
   * Válido para implementar estrategias de juego que compitan con los jugadores humanos.
   * @param color Color de las figuras.
   * @return Valor del Tablero para el jugador del color especificado.
   */
  int valor(Figura.Color color);
  
  /**
   *  Coloca las Figuras para iniciar una partida de ajedrez.
   */
  void initTablero();
  
  /**
   * Número de figuras en total (blancas y negras) en el tablero.
   * @return Número de Figuras en el tablero.
   */
  int size();
  
  /**
   * Número de figuras blancas o negras en el tablero.
   * @param color Color de las figuras que se desea contabilizar.
   * @return  Número de Figuras.
   */
  int size(Figura.Color color);
  
  /**
   * Número de peones en el tablero con el color seleccionado.
   * @param color Color de los peones que se desean contabilizar.
   * @return Número de peones.
   */
  int sizePeones(Figura.Color color);
  
  /**
   * Número de alfiles en el tablero con el color seleccionado.
   * @param color Color de los alfiles que se desean contabilizar.
   * @return Número de alfiles.
   */
  int sizeAlfiles(Figura.Color color);
  
  /**
   * Número de torres en el tablero con el color seleccionado.
   * @param color Color de las torres que se desean contabilizar.
   * @return Número de torres.
   */
  int sizeTorres(Figura.Color color);
  
  /**
   * Número de caballos en el tablero con el color seleccionado.
   * @param color Color de los caballos que se desean contabilizar.
   * @return Número de caballos.
   */
  int sizeCaballos(Figura.Color color);
  
  /**
   * Indica si la Reina dell color seleccionado se encuentra en el Tablero.
   * @param color Color de la Reina.
   * @return Existe la Reina en el Tablero.
   */
  boolean Reina(Figura.Color color);
  
  /**
   * Posiciones de los peones, con el color seleccionado, en el Tablero.
   * @param color Color de los peones que se desean contabilizar.
   * @return Posiciones de los peones.
   */
  LinkedList<Posicion> peones(Figura.Color color);
  
  /**
   * Posiciones de los alfiles, con el color seleccionado, en el Tablero.
   * @param color Color de los alfiles que se desean contabilizar.
   * @return Posiciones de los alfiles.
   */
  LinkedList<Posicion> alfiles(Figura.Color color);
  
  /**
   * Posiciones de las torres, con el color seleccionado, en el Tablero.
   * @param color Color de las torres que se desean contabilizar.
   * @return Posiciones de las torres.
   */
  LinkedList<Posicion> torres(Figura.Color color);
  
  /**
   * Posiciones de los caballos, con el color seleccionado, en el Tablero.
   * @param color Color de los caballos que se desean contabilizar.
   * @return Posiciones de los caballos.
   */
  LinkedList<Posicion> caballos(Figura.Color color);
  
  /**
   * Posición de la Reina, con el color seleccionado, en el Tablero.
   * @param color Color de la reina.
   * @return Posición de la Reina.
   */
  Posicion reina(Figura.Color color);
  
  /**
   * Posición del Rey, con el color seleccionado, en el Tablero.
   * @param color Color del rey.
   * @return Posición del Rey.
   */
  Posicion rey(Figura.Color color);
  
  /**
   * Devuelve las posiciones del conjunto de figuras, del color seleccionado, en el Tablero.
   * @param color Color de las figuras elegidas (blancas o negras).
   * @return Posiciones de todas las figuras del color elegido.
   */
  LinkedList<Posicion> allFiguras(Figura.Color color);
  
  /**
   * Genera todos los escenarios (Tableros) posibles, moviendo las figuras del color elegido, a
   * partir del tablero existente.
   * @param color Color de las figuras con las que el programa responde al jugador humano.
   * @return Lista de escenarios (movimientos) posibles.
   */
  LinkedList<ITablero> escenarios(Figura.Color color);
  
  /**
   * Implementa la estrategia de juego: de un conjunto de escenarios (movimientos) posibles,
   * devuelve el movimiento que se considera que es más acertado para ganar al jugador humano;
   * Se pueden implementar soluciones heurísticas, de IA clásica (minimax, etc) o de Machine Learning,
   * cuando se pueden recopilar decenas o cientos de miles de jugadas;
   * Nuestro enfoque de diseño es sencillo: la estrategia se basa únicamente en el estado actual del tablero;
   * se podría mejorar guardando y teniendo en cuenta la historia de las jugadas realizadas por ambos jugadores; En
   * este caso añadiríamos un objeto "Estrategia" a nuestro diseño.
   * 
   * @param escenarios Listado de movimientos posibles, normalmente obtenidos con el método "escenarios".
   * @param color Color de las figuras con las que el programa responde al jugador humano.
   * @return Escenario (movimiento) más prometedor.
   */
  ITablero estrategia (LinkedList<ITablero> escenarios, Figura.Color color);
  
  
  /**
   * Muestra el movimiento realizado entre un Tablero actual y el Tablero destino proporcionado.
   * @param tableroDestino Tablero en el que finaliza el movimiento.
   * @return Posicion[0]devuelve la posición de origen del movimiento; Posicion[1]devuelve la posición de destino del movimiento.
   */
  public Posicion[] movimiento(ITablero tableroDestino);
  
  
  ITablero clone();
  
  String toString();
  
}
