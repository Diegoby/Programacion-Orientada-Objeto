package barquitos;
import java.util.Collection;
import java.util.HashMap;

public class Barco {
    private int idBarco;
    private boolean hundido;
    private HashMap<Casilla, Boolean> casillas;

    public Barco(int idBarco) {
        this.idBarco = idBarco;
        this.hundido = false;
        this.casillas = new HashMap<>();
    }

    public int getIdBarco() {
        return idBarco;
    }

    public Collection<Casilla> getCasillas() {
        return casillas.keySet();
    }

    public boolean estaHundido(){
        return hundido;
    }

    public void aniadePosicion(int x, int y){
        casillas.put(new Casilla(x, y, idBarco), false);
    }

    public void actualizaPosicion(int x, int y){
        casillas.put(new Casilla(x, y), true);
        actualizaEstado();
    }

    private void actualizaEstado(){
        boolean estadoBarco = true;
        for(boolean estadoPieza: casillas.values()){
            estadoBarco = estadoBarco && estadoPieza;
        }
        this.hundido = estadoBarco;
    }
}
