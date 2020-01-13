package unocerounocero;
public class FigurasMesa {
	  private Figura[] figura;
	  
	  public Figura[] get() {
		return figura;
	  }
	  
	  public void set(Figura[] figuras) {
		this.figura=figuras;
	  }	 
	  	  
	  public Figura[] nuevasFiguras(Figuras1010 figuras) {
		  Figura[] figura = figuras.cambiaFigurasAElegir();	  
		  return figura;
	  }
	  
	  public void borrar(int i) {
		  figura[i]=Figuras1010.figuraVacia;
	  }
}
