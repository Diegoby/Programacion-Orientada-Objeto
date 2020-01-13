package ajedrez;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

/**
 * Tablero de Ajedrez y Modelo de la aplicación.
 * @author POO
 *
 */
public class Tablero implements ITablero {
	
  private Figura[][] tablero, tableroAnterior;

  private PropertyChangeSupport support;

  public void addPropertyChangeListener(PropertyChangeListener pcl) {
	support.addPropertyChangeListener(pcl);
  }

  public void removePropertyChangeListener(PropertyChangeListener pcl) {
 	support.removePropertyChangeListener(pcl);
  }

  public Tablero() {
	tablero = new Figura[ITablero.SIZE][ITablero.SIZE];
    support = new PropertyChangeSupport(this);
  }
  
  public Tablero (Figura[][] tablero) {
	set(tablero);
	support = new PropertyChangeSupport(this);
  }
  
  public Tablero (ITablero tablero) {
	this.tablero = tablero.get();
	support = new PropertyChangeSupport(this);
  }

  public PropertyChangeSupport getSupport(){
  	return support;
  }

  public Figura[][] get() {
	return tablero;
  }
  

  public void set(Figura[][] tablero) {
     this.tablero = tablero;
  }
  
    
  public Figura get(Posicion posicion) {
	return tablero[posicion.getX()][posicion.getY()];
  }
	  

  public void set(Figura figura) {
	  System.out.println("Tablero.set()");

	  tableroAnterior = tablero.clone();
	  tablero[figura.getPosicion().getX()][figura.getPosicion().getY()] = figura;
	  support.firePropertyChange("tableroFiguras", tableroAnterior, tablero); // ******** Modelo Vista Controlador
  }
  
  public void setNull(Posicion posicion) {
	  System.out.println("Tablero.setNull()");

	  tableroAnterior = tablero.clone();
	  tablero[posicion.getX()][posicion.getY()] = null;
	  support.firePropertyChange("tableroFiguras", tableroAnterior, tablero); // ******** Modelo Vista Controlador
  }
	  

  public int valor(Figura.Color color) {
	int acumulador = 0;
	for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)
	    if (tablero[x][y]!=null&&tablero[x][y].getColor()==color)  // Si hay figura y es del color adecuado
	    	acumulador = acumulador+tablero[x][y].getValor();
	return acumulador;
  }
	  

  public int size() {
	int contador = 0;
	for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)
		if (tablero[x][y]!=null)  
		  contador++;
	return contador;
  }
	  

  public int size(Figura.Color color) {
	int contador = 0;
	for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)
	    if (tablero[x][y]!=null&&tablero[x][y].getColor()==color)  
		  contador++;
	return contador;	  
  }
  
  
  private enum TipoFigura {PEON, ALFIL, CABALLO, TORRE, REY, REINA};
  
  private int sizeFigura(Figura.Color color, TipoFigura tipoFigura) {
	int contador = 0;
	for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)
		switch (tipoFigura) {
		  case PEON: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Peon) contador++; break;
		  case ALFIL: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Alfil) contador++; break;
		  case CABALLO: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Caballo) contador++; break;
		  case TORRE: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Torre) contador++; break;
		  case REY: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Rey) contador++; break;
		  case REINA: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Reina) contador++; break;
		}
    return contador;		  
  }
  
  private LinkedList<Posicion> listaFigura(Figura.Color color, TipoFigura tipoFigura) {
	LinkedList<Posicion> figuras = new LinkedList<Posicion>();
	for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)
		switch (tipoFigura) {
		  case PEON: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Peon) figuras.add(new Posicion(x,y)); break;
		  case ALFIL: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Alfil) figuras.add(new Posicion(x,y)); break;
		  case CABALLO: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Caballo) figuras.add(new Posicion(x,y)); break;
		  case TORRE: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Torre) figuras.add(new Posicion(x,y)); break;
		  case REY: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Rey) figuras.add(new Posicion(x,y)); break;
		  case REINA: if (tablero[x][y]!=null&&tablero[x][y].getColor()==color&&tablero[x][y] instanceof Reina) figuras.add(new Posicion(x,y)); break;
		}
    return figuras;		  
  }
	  

  public int sizePeones(Figura.Color color)  {
	return sizeFigura(color, TipoFigura.PEON);	
  }
	  

  public int sizeAlfiles(Figura.Color color) {
	return sizeFigura(color, TipoFigura.ALFIL);	
  }
	  

  public int sizeTorres(Figura.Color color) {
	return sizeFigura(color, TipoFigura.TORRE);	
  }
	  

  public int sizeCaballos(Figura.Color color) {
	return sizeFigura(color, TipoFigura.CABALLO);	
  }
	  

  public boolean Reina(Figura.Color color) {
	return sizeFigura(color, TipoFigura.REINA)==1;	
  }
	  

  public LinkedList<Posicion> peones(Figura.Color color) {
	return listaFigura(color, TipoFigura.PEON);
  }  

  public LinkedList<Posicion> alfiles(Figura.Color color) {
	return listaFigura(color, TipoFigura.ALFIL);
  }  

  public LinkedList<Posicion> torres(Figura.Color color) {
	return listaFigura(color, TipoFigura.TORRE);
  }  

  public LinkedList<Posicion> caballos(Figura.Color color) {
	return listaFigura(color, TipoFigura.CABALLO);
  }  

  public Posicion reina(Figura.Color color) {
	LinkedList<Posicion> lista = listaFigura(color, TipoFigura.REINA);  
	if (lista.size()==0)
	  return null;
	else
	  return lista.getFirst();	
  }  

  
  public Posicion rey(Figura.Color color) {
	LinkedList<Posicion> lista = listaFigura(color, TipoFigura.REY);  
	if (lista.size()==0)
	  return null;
	else
	  return lista.getFirst();	
  }   

  
  public LinkedList<Posicion> allFiguras(Figura.Color color) {
	LinkedList<Posicion> posicionesFiguras = new LinkedList<Posicion>();
	for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)
		if (tablero[x][y]!=null&&tablero[x][y].getColor()==color)
		 posicionesFiguras.add(new Posicion(x,y));	
	return posicionesFiguras;
  }
  
  
  public LinkedList<ITablero> escenarios(Figura.Color color) {

	LinkedList<ITablero> escenariosFigura = new LinkedList<ITablero>(); 
	LinkedList<ITablero> escenariosTotal  = new LinkedList<ITablero>();

	LinkedList<Posicion> posicionesFiguras = allFiguras(color);
	for (Posicion posicion: posicionesFiguras) {
	  Figura figura = get(posicion);
	  escenariosFigura = figura.escenarios(this);
	  escenariosTotal.addAll(escenariosFigura);	  
	}	 	
	return escenariosTotal;
  }
  
  
  public ITablero estrategia(LinkedList<ITablero> escenarios, Figura.Color color) {
	ITablero mejorEscenario=null;
	int mejorValorEscenario=Integer.MIN_VALUE;
	
	int valorEscenario;
	
	for (ITablero escenario: escenarios) {    // Buscamos el escenario más favorable, en base a los valores de las figuras.
	  if (color == Figura.Color.BLANCA)
		valorEscenario = escenario.valor(Figura.Color.BLANCA)-escenario.valor(Figura.Color.NEGRA);
	  else
		valorEscenario = escenario.valor(Figura.Color.NEGRA)-escenario.valor(Figura.Color.BLANCA); 
	  if (valorEscenario>mejorValorEscenario) {
		  mejorValorEscenario = valorEscenario;
		  mejorEscenario = escenario;
	  }
	}
	return mejorEscenario;
  }
  
  
  public Posicion[] movimiento(ITablero tableroDestino) {
	  
	 System.out.println(this);
	 System.out.println(tableroDestino);	
	 
	 Posicion[] resultado = new Posicion[2];
	 for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)	{
		if (tablero[x][y]!=null && tableroDestino.get(new Posicion(x,y))==null)		   
		  resultado[0]=new Posicion(x,y);

		if ((tablero[x][y]==null && tableroDestino.get(new Posicion(x,y))!=null)||
		     (tablero[x][y]!=null && tableroDestino.get(new Posicion(x,y))!=null&&
		      tablero[x][y].getColor()!=tableroDestino.get(new Posicion(x,y)).getColor())
		   )  
		  resultado[1]=new Posicion(x,y);
	  }
	 return resultado;
  }
	  
  
  public ITablero clone() {
	Figura[][] tablero = new Figura[ITablero.SIZE][ITablero.SIZE];
	for (int y=0;y<ITablero.SIZE;y++)
	  for (int x=0;x<ITablero.SIZE;x++)
		tablero[x][y] = this.tablero[x][y];
	return new Tablero(tablero);
  }
  
	public void initTablero() {	
		Figura[] figuras = new Figura [32];
		
		Figura TorreBlanco1 = new Torre(Figura.Color.BLANCA, new Posicion(0,0)); 
		Figura CaballoBlanco1 = new Caballo(Figura.Color.BLANCA, new Posicion(1,0));
		Figura AlfilBlanco1 = new Alfil(Figura.Color.BLANCA, new Posicion(2,0));
		Figura ReinaBlanco = new Reina(Figura.Color.BLANCA, new Posicion(3,0));
		Figura ReyBlanco = new Rey(Figura.Color.BLANCA, new Posicion(4,0));
		Figura AlfilBlanco2 = new Alfil(Figura.Color.BLANCA, new Posicion(5,0));
		Figura CaballoBlanco2 = new Caballo(Figura.Color.BLANCA, new Posicion(6,0));
		Figura TorreBlanco2 = new Torre(Figura.Color.BLANCA, new Posicion(7,0));
		Figura PeonBlanco1 = new Peon(Figura.Color.BLANCA, new Posicion(0,1));
		Figura PeonBlanco2 = new Peon(Figura.Color.BLANCA, new Posicion(1,1));		
		Figura PeonBlanco3 = new Peon(Figura.Color.BLANCA, new Posicion(2,1));
		Figura PeonBlanco4 = new Peon(Figura.Color.BLANCA, new Posicion(3,1));	
		Figura PeonBlanco5 = new Peon(Figura.Color.BLANCA, new Posicion(4,1));
		Figura PeonBlanco6 = new Peon(Figura.Color.BLANCA, new Posicion(5,1));		
		Figura PeonBlanco7 = new Peon(Figura.Color.BLANCA, new Posicion(6,1));	
		Figura PeonBlanco8 = new Peon(Figura.Color.BLANCA, new Posicion(7,1));
		
		Figura TorreNegro1 = new Torre(Figura.Color.NEGRA, new Posicion(0,7)); 
		Figura CaballoNegro1 = new Caballo(Figura.Color.NEGRA, new Posicion(1,7));
		Figura AlfilNegro1 = new Alfil(Figura.Color.NEGRA, new Posicion(2,7));
		Figura ReinaNegro = new Reina(Figura.Color.NEGRA, new Posicion(3,7));
		Figura ReyNegro = new Rey(Figura.Color.NEGRA, new Posicion(4,7));
		Figura AlfilNegro2 = new Alfil(Figura.Color.NEGRA, new Posicion(5,7));
		Figura CaballoNegro2 = new Caballo(Figura.Color.NEGRA, new Posicion(6,7));
		Figura TorreNegro2 = new Torre(Figura.Color.NEGRA, new Posicion(7,7));
		Figura PeonNegro1 = new Peon(Figura.Color.NEGRA, new Posicion(0,6));
		Figura PeonNegro2 = new Peon(Figura.Color.NEGRA, new Posicion(1,6));		
		Figura PeonNegro3 = new Peon(Figura.Color.NEGRA, new Posicion(2,6));
		Figura PeonNegro4 = new Peon(Figura.Color.NEGRA, new Posicion(3,6));	
		Figura PeonNegro5 = new Peon(Figura.Color.NEGRA, new Posicion(4,6));
		Figura PeonNegro6 = new Peon(Figura.Color.NEGRA, new Posicion(5,6));		
		Figura PeonNegro7 = new Peon(Figura.Color.NEGRA, new Posicion(6,6));	
		Figura PeonNegro8 = new Peon(Figura.Color.NEGRA, new Posicion(7,6));
	
	  	
	    figuras[0] = TorreBlanco1;		figuras[8] =  PeonBlanco1;
	    figuras[1] = CaballoBlanco1;	figuras[9] =  PeonBlanco2;
	    figuras[2] = AlfilBlanco1;		figuras[10] = PeonBlanco3;
	    figuras[3] = ReinaBlanco;		figuras[11] = PeonBlanco4;
	    figuras[4] = ReyBlanco;			figuras[12] = PeonBlanco5;      
	    figuras[5] = AlfilBlanco2;		figuras[13] = PeonBlanco6;
	    figuras[6] = CaballoBlanco2;	figuras[14] = PeonBlanco7;
	    figuras[7] = TorreBlanco2;		figuras[15] = PeonBlanco8;
	    
	    figuras[16] = TorreNegro1;		figuras[24] = PeonNegro1;
	    figuras[17] = CaballoNegro1;	figuras[25] = PeonNegro2;
	    figuras[18] = AlfilNegro1;		figuras[26] = PeonNegro3;
	    figuras[19] = ReinaNegro;		figuras[27] = PeonNegro4;
	    figuras[20] = ReyNegro;			figuras[28] = PeonNegro5;      
	    figuras[21] = AlfilNegro2;		figuras[29] = PeonNegro6;
	    figuras[22] = CaballoNegro2;	figuras[30] = PeonNegro7;
	    figuras[23] = TorreNegro2;		figuras[31] = PeonNegro8;
	      
	    for (int i=0;i<figuras.length;i++) {
	      set(figuras[i]);
	    }		
	}
  
  public String toString() {
	String res="";
	for (int y=0;y<ITablero.SIZE;y++) {
	  for (int x=0;x<ITablero.SIZE;x++)	 
		if (tablero[x][y]==null)
		  res = res + "  ";
		else 
		  res = res + tablero[x][y].getRepresentacion()+" ";		
	  res = res + "\n";
	}	
	return res+"-------------------\n";
  }

}
