package t6;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Tablero extends java.util.Observable{

    public static final int VACIO=0;
    public static final int VIVO=1;
    public static final int MUERTO=2;

    private int[][] tablero;
    private int size;
    private PropertyChangeSupport support;

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public Tablero(int size) {
        support = new PropertyChangeSupport(this);
        tablero = new int[size][size];
        this.size = size;
    }

    public void setCasilla (int x, int y, int estado) {
        tablero[x][y] = estado;
    }

    public int getCasilla (int x, int y) {
        return tablero[x][y];
    }

    public int size() {
        return size;
    }

    public int size(int estado) {
        int cont=0;
        for (int x=0;x<size;x++)
            for (int y=0;y<size;y++)
                if (tablero[x][y]==estado)
                    cont++;
        return cont;
    }

    public void initRandom(int numCasillas, int estado) {
        Random rx = new Random();
        Random ry = new Random();
        int i=0;
        do {
            int x = rx.nextInt(size);
            int y = ry.nextInt(size);
            if (tablero[x][y]==VACIO) {
                tablero[x][y] = estado;
                i++;
            }
        } while(i<numCasillas);
    }

    public soluciont6.Tablero clone() {
        soluciont6.Tablero t = new soluciont6.Tablero(size);
        for (int x=0;x<size;x++)
            for (int y=0;y<size;y++)
                t.setCasilla(x,y,tablero[x][y]);
        return t;
    }

    public void set(Tablero tablero) {
        System.out.println("Tablero.set()");

        support.firePropertyChange("tablero", this.tablero, tablero); // ******** Modelo Vista Controlador
        for (int x=0;x<size;x++)
            for (int y=0;y<size;y++)
                this.tablero[x][y] = tablero.getCasilla(x,y);
    }

    public String toString() {
        String aux="";
        for (int x=0;x<size;x++) {
            for (int y=0;y<size;y++)
                aux=aux+tablero[x][y];
            aux=aux+"\n";
        }
        return aux;
    }
}
