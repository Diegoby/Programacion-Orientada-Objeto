package barquitos;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends Frame {
    public Ventana(int tamanio){
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                    System.exit(0);
                }
            }
        );
        setSize(IVista.COMIENZO_X*2+IVista.LADO*tamanio, IVista.COMIENZO_Y*2+IVista.LADO*tamanio+20);
    }

    public void insertarVista(Component comp) {
        super.add(comp);
        setVisible(true);
    }
}
