package t6;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class JuegoDeVida extends Frame {
    private final int SIZE=100;
    private Tablero tablero, tableroSiguiente;
    private Vista vista;

    public JuegoDeVida() {
        tablero = new Tablero (SIZE);
        tablero.initRandom(100, Tablero.VIVO);
        tablero.initRandom(100, Tablero.MUERTO);
        vista = new Vista();

        this.add(vista);

        tablero.addPropertyChangeListener(vista);
        tablero.set(tablero);

        addWindowListener(new WindowAdapter()
                          {public void windowClosing(WindowEvent e)
                          {dispose(); System.exit(0);}
                          }
        );

        setSize(SIZE*10+20, SIZE*10+40);
        setVisible(true);

    }

    public void start() {
        do {
            try {
                Thread.sleep(700);
            } catch(Exception e) {}
            tableroSiguiente = evolucion(tablero);
            tablero.set(tableroSiguiente);
        } while (true);
    }

    public abstract Tablero evolucion(Tablero tablero);

}
