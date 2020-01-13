package unocerounocero;
/**************************************
 * 
 * @author jbobi
 *
 */
public class EstadoDelJuego {
	
  private int[][] tableroJuego;
  private int puntuacion;   
  
  private Modelo modelo;

  public EstadoDelJuego(Modelo modelo) {
	this.modelo = modelo;
	tableroJuego = new int[Tablero.TAMANIO][Tablero.TAMANIO];
  }
  
  public String toStream() {
	load();
	String aux="";
	
	aux=aux+puntuacion+" ";						// puntuacion
	
	for (int y=0;y<Tablero.TAMANIO;y++)			// tablero
	  for (int x=0;x<Tablero.TAMANIO;x++) 
		aux=aux+tableroJuego[x][y]+" "; 
			  
	return aux;
  }
  
 
  
  public void fromStream(String s) {
	String aux[] = s.split(" ");
	int pos=0;
	
	puntuacion = Integer.parseInt(aux[pos]);		// puntuacion
	
	for (int y=0;y<Tablero.TAMANIO;y++)			// tablero
	  for (int x=0;x<Tablero.TAMANIO;x++) {
		pos++;
		tableroJuego[x][y] = Integer.parseInt(aux[pos]); 
	  }
	  
	save();
  }
  
  private void load() {
	tableroJuego = modelo.getTableroJuego().getTablero();
	puntuacion = modelo.getPuntuacion().get();
  }
  
  private void save() {
	modelo.getTableroJuego().setTablero(tableroJuego);
	modelo.getPuntuacion().set(puntuacion);
  }
  

	
}
