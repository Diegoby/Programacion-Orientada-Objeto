package unocerounocero;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MilDiez extends Frame{
	
	private Modelo modelo;
	private Vista vista;
    private EstadoDelJuego estadoDelJuego;
    
	public MilDiez() {
	  super("Ejemplo Modelo/Vista/Controlador");
	
	  // crea el objeto que representa al modelo
	  modelo = new Modelo();
	  // crea la vista 
	  vista = new Vista(modelo);
	  
	  // crea un objeto que guarde el estado del juego 
	  estadoDelJuego = new EstadoDelJuego(modelo);
	  
	  // indica que objetos son vistas de que modelo		
	  modelo.addObserver(vista);        // ******** Modelo Vista Controlador
	  
	  this.add(vista);
	  
	  addWindowListener(new WindowAdapter() 
	      {public void windowClosing(WindowEvent e) 
	         {dispose(); System.exit(0);}  
	      }
	  );
		
	  vista.addMouseListener(new Controlador(modelo)); 
	  
	  vista.addKeyListener(new KeyAdapter()
	       {public void keyTyped(KeyEvent e)
		     { FicheroTexto f = new FicheroTexto("MilDiez.txt");
		       try {
	    	   if (e.getKeyChar()=='s') {
	    	     f.escribeEnFichero(estadoDelJuego.toStream());
	    	   }
		       if (e.getKeyChar()=='l') {
	    	     estadoDelJuego.fromStream(f.leeDeFichero());
	    	     vista.repaint(); }
		       } catch (IOException IOe) {System.out.println("Error en el almacenamiento del estado");}
		     }
		       
	       }
	  );
	  	  
	  setSize(Vista.CANVAS_X, Vista.CANVAS_Y); 
	  setVisible(true); 
	}
	
	public static void main(String[] args) {
      new MilDiez();
	}

}
