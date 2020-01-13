package ajedrez;

/**
 * Tablero de aprendizaje.
 * @author POO
 *
 */
public class TableroAprendizaje extends Tablero implements ITableroAprendizaje {

  private Estado[][] tableroVisual, tableroVisualAnterior;
  
  /**
   * Crea un tablero de aprendizaje e inicializa sus casillas.
   */
  public TableroAprendizaje() {
	tableroVisual = new Estado [ITablero.SIZE][ITablero.SIZE];
    initEstados();
  }

  public void setEstados(Estado[][] tableroVisual){
      this.tableroVisual = tableroVisual;
  }

  public  void setEstado(Posicion posicion, Estado estado) {
      System.out.println("TableroAprendizaje.setEstado()");

      tableroVisualAnterior = tableroVisual.clone();
      tableroVisual[posicion.getX()][posicion.getY()] = estado;
      getSupport().firePropertyChange("tableroEstados", tableroVisualAnterior, tableroVisual); // ******** Modelo Vista Controlador
  }
  
  public void initEstados() {
      System.out.println("TableroAprendizaje.initEstados()");

      tableroVisualAnterior = tableroVisual.clone();
      for (int x=0;x<ITablero.SIZE;x++)
	    for (int y=0;y<ITablero.SIZE;y++)
	        tableroVisual[x][y] = ITableroAprendizaje.Estado.VACIO;
      getSupport().firePropertyChange("tableroEstados", tableroVisualAnterior, tableroVisual); // ******** Modelo Vista Controlador
  }
	  

  public Estado getEstado(Posicion posicion) {
	return tableroVisual[posicion.getX()][posicion.getY()];
  }

}
