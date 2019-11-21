package t2;

public interface ITablero {

    int[][] getTablero();

    void setTablero(int[][] tablero);

    int getTamanio();

    int getPosicion(int x, int y);

    void setPosicion(int x, int y, int valor);

    void borra();

    int ocupacion();

    String toString();

}
