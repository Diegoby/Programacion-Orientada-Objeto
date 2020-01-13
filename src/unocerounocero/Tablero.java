package unocerounocero;

public class Tablero {
	
	public static final int TAMANIO = 10;
	
	private int [][] tablero; 
	private boolean[][] tableroAux;
	
	public Tablero() {
	  tablero = new int[TAMANIO][TAMANIO]; 	
	  tableroAux = new boolean[TAMANIO][TAMANIO];
	}
	
	
	public int[][] getTablero() {
	  return tablero;
	}
	
	public void setTablero(int[][] tablero) {
		  this.tablero=tablero;
	}
			  
	public boolean colocaEnPos(boolean[][] forma, int posX, int posY, int indiceColor,Puntuacion puntuacion) {
	  if (figuraEntraEnTablero(forma, posX, posY)) {	
		 actualiza(forma, posX, posY,indiceColor);
		 
		 puntuacion.set(puntuacion.get()+numPosiciones(forma)); // actualiza puntos
		 return true;
	  } else 
		 return false;
	}
	
	private int numPosiciones(boolean[][] forma) {
	  int cont=0;
	  for (int x=0;x<5;x++)
		    for (int y=0;y<5;y++) 
			  if (forma[x][y]) 
				  cont++;
	  return cont;
	}
			  
			  
	private boolean figuraEntraEnTablero(boolean[][] forma, int posX, int posY) {
	  int posTableroX, posTableroY;
	  for (int x=0;x<5;x++)
	    for (int y=0;y<5;y++) {
		  if (forma[x][y]) {
			posTableroX=x+posX;
			posTableroY=y+posY;  
			if (posTableroX>=TAMANIO||posTableroY>=TAMANIO||tablero[posTableroX][posTableroY]!=0)
			  return false;
		   }       
	    }
		return true;  
	}
			  
			  
	private void actualiza(boolean[][] forma, int posX, int posY, int IndiceColor) {
	  for (int x=0;x<5;x++)
	    for (int y=0;y<5;y++) 
		  if (forma[x][y]) 
		    tablero[x+posX][y+posY]=IndiceColor;
	}
			  
	
	public boolean borrarProgresos(Puntuacion puntuacion) {
	   boolean progresos=false;
	   
	   // Tablero Aux que indica lo que hay que boorar
	   for (int y=0;y<TAMANIO;y++) 
		 for (int x=0;x<TAMANIO;x++) 
		   tableroAux[x][y]=false;	
	   
	   // Indicamos las filas que hay que borrar
	   for (int y=0;y<TAMANIO;y++) {
		 boolean horizontal=true;
		 for (int x=0;x<TAMANIO;x++) 	
		   if (tablero[x][y]==0) 
			 horizontal=false;
		 
		 if (horizontal) {
		   progresos=true;
		   for (int i=0;i<TAMANIO;i++) 
			 tableroAux[i][y]=true; // borramos la fila	 
		 }
	   }  // siguiente fila	
	   
	   // Indicamos las columnas que hay que borrar
	   for (int x=0;x<TAMANIO;x++) {
		 boolean vertical=true;
		 for (int y=0;y<TAMANIO;y++) 	
		   if (tablero[x][y]==0) 
			 vertical=false;
		 
		 if (vertical) {
		   progresos=true;
		   for (int i=0;i<TAMANIO;i++) 
			 tableroAux[x][i]=true; // borramos la fila	  
		 }
	   }  // siguiente columna	
	   
	   // borramos en tablero las filas y columnas que se han completado

		   
	    if (progresos) {
	       puntuacion.set(puntuacion.get()+Puntuacion.puntosJugada(setColoresPuntuacion())); // actualiza puntos
		   for (int y=0;y<TAMANIO;y++) 
			 for (int x=0;x<TAMANIO;x++) 
			   if (tableroAux[x][y]) 
				 tablero[x][y]=0;	              
		   return true;
	    } else
	       return false;
				   
	}  // borrarProgresos
	
	
	private int[] setColoresPuntuacion() {
	  int[] casillas = new int[11];
	  for (int y=0;y<TAMANIO;y++) 
		for (int x=0;x<TAMANIO;x++) 
		  if (tableroAux[x][y]) 
			casillas[tablero[x][y]]++;
	  return casillas;  
	}
				  
				  
	public String toString() {
		  String resultado="";
		  for (int y=0;y<TAMANIO;y++) {
			for (int x=0;x<TAMANIO;x++) 
			  resultado=resultado+tablero[x][y]+" ";	
			resultado=resultado+"\n";
		  }	
		  resultado=resultado+"\n\n";
		  return resultado;
		}
}
