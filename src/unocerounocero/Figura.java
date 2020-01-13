package unocerounocero;
import java.awt.Color;

public class Figura {

  private boolean [][] forma;
  private Color color;
  
  public Figura (boolean[][] forma, Color color) {
	  this.forma=forma;
	  this.color=color;
  }
  
  public boolean[][] getForma() {return forma;}
  
  public Color getColor() {return color;}
  
  public Figura get() {return this;}
  
  public void set(Figura f) {
	 forma = f.getForma();
	 color = f.getColor();
  }

  public String toString() {
	String aux="";
	for (int y=0;y<5;y++) {
		  for (int x=0;x<5;x++) 
			  aux=aux+forma[x][y]+" \n";	
		  aux=aux+"\n";
		}	
	  aux=aux+"\n\n";
	return aux;
  }
  
}
