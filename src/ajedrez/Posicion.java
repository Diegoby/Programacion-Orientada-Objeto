package ajedrez;

/**
 * Abstracción de una casilla del tablero; se define por sus coordenadas x, y.
 * @author POO
 *
 */
public class Posicion {
	
	private int x, y;
	
	public Posicion(int x, int y) {
	  setX(x); setY(y);
	}
	
	public void setX(int x) {this.x=x;}
	
	public void setY(int y) {this.y=y;}
	
	public Posicion get() {return this;}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public String toString() {
	  return "x:"+x+", y:"+y;
	}
	
	public boolean equals(Posicion p) {
	  return x==p.getX() && y==p.getY();
	}
	
}
