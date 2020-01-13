package unocerounocero;
public class Puntuacion {
  private static int[] puntos;
  
  private int puntuacion;
  
  public Puntuacion() {
	puntuacion=0;
	puntos = new int[11];
	puntos[0]=0; // no se usa
	puntos[1]=5;
	puntos[2]=9;
	puntos[3]=3;
	puntos[4]=5;
	puntos[5]=0; // no se usa
	puntos[6]=3;
	puntos[7]=4;
	puntos[8]=2;
	puntos[9]=0; // no se usa
	puntos[10]=1; 
  }
  
  
  /************************************************
   * 
   * @return puntuacion lograda hasta el momento.
   */
  public int get() {return puntuacion;}
  
  
  
  /***********************************************
   * 
   * @param puntuacion puntuacion que se va a asignar
   */
  public void set(int puntuacion) {this.puntuacion=puntuacion;}
  
  
  
  /*************************************************
   * 
   * @param casillas 11 posiciones (una por cada color) en las que se indica el número de Casillas de cada color
   *                 que se han liberado.
   * @return puntuacion de las casillas liberadas.
   */
  public static int puntosJugada(int[] casillas) {
	int puntosJugada=0;
	for (int i=0;i<casillas.length;i++)  // colores
		puntosJugada=puntosJugada+casillas[i]*puntos[i];
	return puntosJugada; 
  }
  
  
}
