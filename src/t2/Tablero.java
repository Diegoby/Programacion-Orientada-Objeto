package t2;

public class Tablero implements ITablero {

    private int[][] tablero;

    public Tablero(int tamaño){
        tablero = new int[tamaño][tamaño];
        borra();
    }

    @Override
    public int[][] getTablero() {
        return tablero;
    }

    @Override
    public void setTablero(int[][] tablero) {
        for (int i = 0; i < this.tablero.length-1; i++) {
            for (int j = 0; j < this.tablero.length-1; j++) {
                this.tablero[i][j] = tablero[i][j];
            }
        }
    }

    @Override
    public int getTamanio() {
        return tablero.length;
    }

    @Override
    public int getPosicion(int x, int y) {
        return tablero[x][y];
    }

    @Override
    public void setPosicion(int x, int y, int valor) {
        tablero[x][y] = valor;
    }

    @Override
    public void borra() {
        for (int i = 0; i < this.tablero.length-1; i++) {
            for (int j = 0; j < this.tablero.length-1; j++) {
                this.tablero[i][j] = 0;
            }
        }
    }

    @Override
    public int ocupacion() {
        int sol = 0;
        for (int i = 0; i < this.tablero.length-1; i++) {
            for (int j = 0; j < this.tablero.length-1; j++) {
                if(this.tablero[i][j] == 0)sol++;
            }
        }
        return sol;
    }

    @Override
    public String toString() {
        String aux = new String();
        for (int i = 0; i < this.tablero.length-1; i++) {
            for (int j = 0; j < this.tablero.length-1; j++) {
                aux += tablero[i][j] + ' ';
            }
            aux += '\n';
        }
        return aux;
    }
}
