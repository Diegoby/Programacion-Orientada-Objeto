package unocerounocero;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Canvas;
import java.util.Observer;
import java.util.Observable;

public class Vista extends Canvas implements Observer{   // ******** Modelo Vista Controlador

	  private boolean comienzo=true;
	  private Graphics2D g2d;
	  private Modelo modelo;
	  public static final int COMIENZO_X=40;
	  public static final int COMIENZO_Y=40;
	  public static final int LADO=30;
	  public static final int CANVAS_X=COMIENZO_X*2+LADO*Tablero.TAMANIO;
	  public static final int CANVAS_Y=COMIENZO_Y*2+LADO*Tablero.TAMANIO+LADO*11+10;  
	  
	  public Vista(Modelo modelo){
		  this.modelo = modelo;
	  }
		
	  public void paint(Graphics g) {	
		g2d = (Graphics2D) g;
		  
		if (comienzo) {
		  modelo.getFigurasMesa().set(modelo.getFigurasMesa().nuevasFiguras(new Figuras1010()));
		  comienzo=false;
	    } 
		g2d.drawString("Puntos: "+modelo.getPuntuacion().get(), COMIENZO_X, COMIENZO_Y-10);
		dibujaTablero();
		dibujaFigurasFueraDelTablero();
	  } 
	  	  
	  public void update(Observable o, Object arg) {    // ******** Modelo Vista Controlador	
		modelo = (Modelo) o;                   
		repaint();
	  }
	  
	  
	  public void dibujaTablero() {
	    for (int x=0;x<Tablero.TAMANIO;x++) 
		  for (int y=0;y<Tablero.TAMANIO;y++) {			
			g2d.setColor(Colores.color[modelo.getTableroJuego().getTablero()[x][y]]);
		    g2d.fillRect(COMIENZO_X+LADO*x, COMIENZO_Y+LADO*y, LADO, LADO);      		   
		    g2d.setColor(java.awt.Color.DARK_GRAY);      
			g2d.drawRect(COMIENZO_Y+LADO*x, COMIENZO_Y+LADO*y, LADO, LADO); 
		}
	  }
	  
	  private void dibujaFigurasMesa (boolean[][] forma, int comienzoX, int comienzoY, int indiceColor) {
	      for (int x=0;x<5;x++)
	          for (int y=0;y<5;y++)
	            if (forma[x][y]) {
	         	   // Dibujar el recuadro x,y
	         	       g2d.setColor(Colores.color[indiceColor]);
	         		   g2d.fillRect(comienzoX+LADO*x, comienzoY+LADO*y, LADO, LADO);      		   
	         		   g2d.setColor(java.awt.Color.BLACK);      
	         		   g2d.drawRect(comienzoX+LADO*x, comienzoY+LADO*y, LADO, LADO);   
	            }  
	  }  
	  
	  public void dibujaFigurasFueraDelTablero() {
		  Figura[] fig = modelo.getFigurasMesa().get();
		  dibujaFigurasMesa (fig[0].getForma(), COMIENZO_X, COMIENZO_Y+LADO+LADO*Tablero.TAMANIO, Colores.indice(fig[0].getColor()));
		  dibujaFigurasMesa (fig[1].getForma(), COMIENZO_X+LADO*Tablero.TAMANIO/2, COMIENZO_Y+LADO+LADO*Tablero.TAMANIO, Colores.indice(fig[1].getColor())); 
		  dibujaFigurasMesa (fig[2].getForma(), COMIENZO_X, COMIENZO_Y+LADO*2+LADO*Tablero.TAMANIO+LADO*5, Colores.indice(fig[2].getColor()));
		  dibujaFigurasMesa (fig[3].getForma(), COMIENZO_X+LADO*Tablero.TAMANIO/2, COMIENZO_Y+LADO*2+LADO*Tablero.TAMANIO+LADO*5, Colores.indice(fig[3].getColor())); 
	  }
	  
}
