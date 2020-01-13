package unocerounocero;
import java.awt.Color;
import java.util.Random;

public class Figuras1010 {

  private Figura[] formas = new Figura[4];
  private Figura[] figuras = new Figura[19];
  
  public final static Figura figuraVacia = new Figura(new boolean[5][5],Color.LIGHT_GRAY);
  
  private Random aleatorio = new Random();
  
  public Figuras1010() {
   boolean[][] forma0 = new boolean[5][5];
   forma0[0][0]=true;
   figuras[0]=new Figura(forma0,Color.BLUE);
 
   boolean[][] forma1 = new boolean[5][5];forma1 = copiar(forma0);
   forma1[0][1]=true;
   figuras[1]=new Figura(forma1,Color.CYAN);  
 
   boolean[][] forma2 = new boolean[5][5];forma2 = copiar(forma1);
   forma2[0][2]=true;
   figuras[2]=new Figura(forma2,Color.GREEN);    
 
   boolean[][] forma3 = new boolean[5][5];forma3 = copiar(forma2);
   forma3[0][3]=true;
   figuras[3]=new Figura(forma3,Color.MAGENTA); 

   boolean[][] forma4 = new boolean[5][5];forma4 = copiar(forma3);
   forma4[0][4]=true;
   figuras[4]=new Figura(forma4,Color.ORANGE); 
   
   boolean[][] forma5 = new boolean[5][5];  
   forma5[0][0]=true;forma5[1][0]=true;
   figuras[5]=new Figura(forma5,Color.CYAN); 
 
   boolean[][] forma6 = new boolean[5][5];forma6 = copiar(forma5);
   forma6[2][0]=true;
   figuras[6]=new Figura(forma6,Color.GREEN); 

   boolean[][] forma7 = new boolean[5][5];forma7 = copiar(forma6);
   forma7[3][0]=true;
   figuras[7]=new Figura(forma7,Color.MAGENTA); 

   boolean[][] forma8 = new boolean[5][5];forma8 = copiar(forma7);
   forma8[4][0]=true;
   figuras[8]=new Figura(forma8,Color.ORANGE); 
   

   boolean[][] forma9 = new boolean[5][5]; 
   forma9[0][0]=true;forma9[0][1]=true;forma9[1][0]=true;
   figuras[9]=new Figura(forma9,Color.PINK); 

   boolean[][] forma10 = new boolean[5][5];forma10 = copiar(forma9);
   forma10[0][2]=true;forma10[2][0]=true;
   figuras[10]=new Figura(forma10,Color.RED); 
   
   boolean[][] forma11 = new boolean[5][5]; 
   forma11[0][0]=true;forma11[1][1]=true;forma11[1][0]=true;
   figuras[11]=new Figura(forma11,Color.PINK); 
   
   boolean[][] forma12 = new boolean[5][5];
   forma12[0][0]=true;forma12[1][0]=true;forma12[2][0]=true;forma12[0][1]=true;forma12[0][2]=true;
   figuras[12]=new Figura(forma12,Color.RED);    
 
   boolean[][] forma13 = new boolean[5][5]; 
   forma13[0][0]=true;forma13[1][0]=true;forma13[1][1]=true;
   figuras[13]=new Figura(forma13,Color.PINK);  
   
   boolean[][] forma14 = new boolean[5][5];  
   forma14[0][0]=true;forma14[1][0]=true;forma14[2][0]=true;forma14[2][1]=true;forma14[2][2]=true;
   figuras[14]=new Figura(forma14,Color.RED);  
   
   boolean[][] forma15 = new boolean[5][5];  
   forma15[0][1]=true;forma15[1][1]=true;forma15[1][0]=true;
   figuras[15]=new Figura(forma15,Color.PINK);  
   
   boolean[][] forma16 = new boolean[5][5]; 
   forma16[2][0]=true;forma16[2][1]=true;forma16[2][2]=true;forma16[0][2]=true;forma16[1][2]=true;
   figuras[16]=new Figura(forma16,Color.RED); 
   
   boolean[][] forma17 = new boolean[5][5]; 
   forma17[0][0]=true;forma17[0][1]=true;forma17[1][0]=true;forma17[1][1]=true;
   figuras[17]=new Figura(forma17,Color.WHITE); 

   boolean[][] forma18 = new boolean[5][5];forma18 = copiar(forma17);
   forma18[2][0]=true;forma18[2][1]=true;forma18[2][2]=true;forma18[1][2]=true;forma18[0][2]=true;
   figuras[18]=new Figura(forma18,Color.YELLOW); 
      
  }
  
  
  private boolean[][] copiar(boolean[][] forma) {
	 boolean[][] aux = new boolean[5][5];
	 for (int x=0;x<5;x++)
	   for (int y=0;y<5;y++)
		  aux[x][y]=forma[x][y];	
	 return aux;
  }
  
  
  public Figura getAleatorioFigura() {
	 return figuras[aleatorio.nextInt(19)];
  }
  
  
  public Figura[] cambiaFigurasAElegir() {
	 for (int i=0;i<4;i++) 
	   formas[i]=getAleatorioFigura();
	 return formas;
  }
  
  public String toString() {
	  String aux="";
	  for (int i=0;i<19;i++) {
		for (int y=0;y<5;y++) {
			  for (int x=0;x<5;x++) 
				  aux=aux+figuras[i].getForma()[x][y]+" ";	
			  aux=aux+"\n";
		}
	    aux=aux+"\n\n";
	  }
	  return aux;
   }	  

  
}


