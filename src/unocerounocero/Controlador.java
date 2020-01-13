package unocerounocero;
import java.awt.event.*;

public class Controlador extends MouseAdapter {

  private Modelo modelo;   // ******** Modelo Vista Controlador
  
  private int xPressed=0,yPressed=0;
  private int numFigura=0;
  private int numFiguras=0;
  
  public Controlador(Modelo modelo) {
	 this.modelo = modelo;   // ******** Modelo Vista Controlador
  }
	
  public void mousePressed(MouseEvent e) {
	  int tt = Tablero.TAMANIO;
	  int tt2 = tt/2;
	  xPressed = (e.getX()-Vista.COMIENZO_X);
	  if (xPressed>=0) 
		  xPressed = xPressed/Vista.LADO;
	  else
		  xPressed=-1;
	  yPressed = (e.getY()-Vista.COMIENZO_Y)/Vista.LADO;
	  if (xPressed>=0&&yPressed>tt&&xPressed<tt/2&&yPressed<=tt+tt2) {  // Figura exterior superior izquierda
		  yPressed = yPressed-(tt+1); 
		  numFigura=0;
	  } else
	    if (xPressed>=tt/2&&yPressed>tt&&xPressed<tt&&yPressed<tt+tt2) {  // Figura exterior superior derecha
		    xPressed = xPressed-tt2;yPressed = yPressed-(tt+1);
		    numFigura=1;
	    } else
	        if (xPressed>=0&&yPressed>16&&xPressed<5&&yPressed<tt*2+2) {   // Figura exterior inferior izquierda
		      yPressed = yPressed-(tt+tt2+2);
		      numFigura=2;
	        } else
	          if (xPressed>=tt/2&&yPressed>16&&xPressed<tt&&yPressed<tt*2+2) {  // Figura exterior inferior derecha
		          xPressed = xPressed-tt2;yPressed = yPressed-(tt+tt2+2);
		          numFigura=3;
	          }
  }
  
  public void mouseReleased(MouseEvent e) {
	  int xReleased = (e.getX()-Vista.COMIENZO_X)/Vista.LADO;
	  int yReleased = (e.getY()-Vista.COMIENZO_Y)/Vista.LADO;
	  int x=xReleased-xPressed;
	  int y=yReleased-yPressed;	 
	  if (x>=0&&y>=0&&x<Tablero.TAMANIO&&y<Tablero.TAMANIO) {	
		boolean dibujada = modelo.colocaEnPosTablero(modelo.getFigurasMesa().get()[numFigura].getForma(), 
				                                                  x, y, Colores.indice(modelo.getFigurasMesa().get()[numFigura].getColor()));
		if (dibujada) {
			modelo.getFigurasMesa().borrar(numFigura);
		  numFiguras=(numFiguras+1)%4;
		  if (numFiguras==0)
			  modelo.getFigurasMesa().set(modelo.getFigurasMesa().nuevasFiguras(new Figuras1010()));  
		}
		modelo.borrarProgresosTablero(modelo.getPuntuacion());
	    //modelo.estadoTablero();  
	  }
  }

}

