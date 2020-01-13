package ajedrez;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * VIsta de la aplicación; dibuja el tablero y sus evoluciones.
 * @author jbobi
 *
 */
public class Vista extends Canvas implements PropertyChangeListener {

  public static int MARGEN=10;
  public static int CASILLA_SIZE=50; 
	
  private Graphics2D g2d;
  private TableroAprendizaje tablero;
  
  /**
   * Obtiene el tablero inicial.
   * @param tablero TableroAprendizaje inicial.
   */
  public Vista (TableroAprendizaje tablero) {
    this.tablero = tablero;  
  }
	
  /**
   * Método establecido en el modo gráfico 2D para dibujar en el Canvas.
   */
  public void paint(Graphics g) {	
	g2d = (Graphics2D) g;
	for (int x=0;x<ITablero.SIZE;x++)
	  for (int y=0;y<ITablero.SIZE;y++) {	
		  
	// Dibuja el fondo: WHITE o BLACK
		if (ITableroAprendizaje.getColor(new Posicion(x,y))==ITableroAprendizaje.Casilla.BLANCA)
          g2d.setColor(java.awt.Color.WHITE);
		else
	      g2d.setColor(java.awt.Color.BLACK);				
        g2d.fillRect(MARGEN+x*CASILLA_SIZE, MARGEN+y*CASILLA_SIZE, CASILLA_SIZE, CASILLA_SIZE);
        
   // Dibuja las figuras del Tablero
        Figura figura = tablero.get(new Posicion(x,y));
    	if (figura!=null) {
          if (figura.getColor()==Figura.Color.BLANCA)
        	g2d.setColor(java.awt.Color.blue);
          else
          	g2d.setColor(java.awt.Color.orange);
          
          g2d.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
          int xf = MARGEN+x*CASILLA_SIZE+12, yf = MARGEN+y*CASILLA_SIZE+40;
          g2d.drawString(figura.getRepresentacion()+"", xf, yf); 
    	}
    	
   // Dibuja los estados del TableroAprendizaje
    	switch (tablero.getEstado(new Posicion(x,y))) {
   	     case VACIO: break;
    	 case MOVIMIENTO_POSIBLE: 
    		           g2d.setColor(java.awt.Color.RED); 
    	               g2d.drawRect(MARGEN+x*CASILLA_SIZE+3, MARGEN+y*CASILLA_SIZE+3, CASILLA_SIZE-6, CASILLA_SIZE-6); 
    	               g2d.drawRect(MARGEN+x*CASILLA_SIZE+2, MARGEN+y*CASILLA_SIZE+2, CASILLA_SIZE-4, CASILLA_SIZE-4);break;
    	 case MOVIMIENTO_REAL:    
    		           g2d.setColor(java.awt.Color.GREEN); 
    	               g2d.drawRect(MARGEN+x*CASILLA_SIZE+3, MARGEN+y*CASILLA_SIZE+3, CASILLA_SIZE-6, CASILLA_SIZE-6); 
    	               g2d.drawRect(MARGEN+x*CASILLA_SIZE+2, MARGEN+y*CASILLA_SIZE+2, CASILLA_SIZE-4, CASILLA_SIZE-4);break;
       	 case MOVIMIENTO_ORIGEN:    
	                   g2d.setColor(java.awt.Color.RED); 
                       g2d.drawRect(MARGEN+x*CASILLA_SIZE+3, MARGEN+y*CASILLA_SIZE+3, CASILLA_SIZE-6, CASILLA_SIZE-6); 
                       g2d.drawRect(MARGEN+x*CASILLA_SIZE+2, MARGEN+y*CASILLA_SIZE+2, CASILLA_SIZE-4, CASILLA_SIZE-4);break;  
       	 case MOVIMIENTO_DESTINO:  
       		 		   g2d.setColor(java.awt.Color.RED); 
                       g2d.drawRect(MARGEN+x*CASILLA_SIZE+3, MARGEN+y*CASILLA_SIZE+3, CASILLA_SIZE-6, CASILLA_SIZE-6); 
                       g2d.drawRect(MARGEN+x*CASILLA_SIZE+2, MARGEN+y*CASILLA_SIZE+2, CASILLA_SIZE-4, CASILLA_SIZE-4);break;  
    	}
     
	  }  
  } 
  
  
  /**
   * Actualiza la Vista, invocando al método paint, mediante el método repaint.
   */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("tableroFiguras")){
			tablero.set((Figura[][]) evt.getNewValue());
		} else {
			tablero.setEstados((ITableroAprendizaje.Estado[][]) evt.getNewValue());
		}
		repaint();

	}
}
