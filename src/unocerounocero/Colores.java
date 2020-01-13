package unocerounocero;

import java.awt.Color;

public class Colores {
  
  public static Color[] color;
  
  public final static int ORANGE=1;	
  public final static int YELLOW=2;
  public final static int GREEN=3;
  public final static int RED=4;
  public final static int MAGENTA=5;
  public final static int PINK=6;
  public final static int WHITE=7;
  public final static int CYAN=8; 
  public final static int BLACK=9;
  public final static int BLUE=10;
  
  public Colores() {
	color = new Color[11];
	
	color[0]=Color.LIGHT_GRAY;
	color[1]=Color.ORANGE;
	color[2]=Color.YELLOW;
	color[3]=Color.GREEN;
	color[4]=Color.RED;
	color[5]=Color.MAGENTA;
	color[6]=Color.PINK;
	color[7]=Color.WHITE;
	color[8]=Color.CYAN;
	color[9]=Color.BLACK;
	color[10]=Color.BLUE; 
  }
  
  public static int indice (Color c) {
	for (int i=1;i<color.length;i++)
	  if (color[i].equals(c))
		return i; 
	return -1;
  }
  
 
}

