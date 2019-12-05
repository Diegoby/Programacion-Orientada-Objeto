package t6;

public class Tradicional extends JuegoDeVida{

    public Tablero evolucion(Tablero tablero) {
        Tablero tableroSiguiente = new Tablero(tablero.size());
        for (int x=0;x<tablero.size();x++)
            for (int y=0;y<tablero.size();y++) {
                tableroSiguiente.setCasilla(x, y, evolucionCasilla(x,y,tablero));
            }
        return tableroSiguiente;
    }

    private int evolucionCasilla(int x, int y, Tablero tablero) {
        int contVIVO=0;
        int contMUERTO=0;
        int izq, dcha, arr, abj;
        if (x>0) {									// Izquierda
            izq = tablero.getCasilla(x-1, y);
            if (izq==Tablero.VIVO) contVIVO++;
            else
            if (izq==Tablero.MUERTO) contMUERTO++;
        }
        if (x<tablero.size()-1) {						// Derecha
            dcha = tablero.getCasilla(x+1, y);
            if (dcha==Tablero.VIVO) contVIVO++;
            else
            if (dcha==Tablero.MUERTO) contMUERTO++;
        }												// Arriba
        if (y>0) {
            arr = tablero.getCasilla(x, y-1);
            if (arr==Tablero.VIVO) contVIVO++;
            else
            if (arr==Tablero.MUERTO) contMUERTO++;
        }
        if (y<tablero.size()-1) {						// Abajo
            abj = tablero.getCasilla(x, y+1);
            if (abj==Tablero.VIVO) contVIVO++;
            else
            if (abj==Tablero.MUERTO) contMUERTO++;
        }


        if (contMUERTO>contVIVO)
            return (Tablero.VIVO);
        else
        if (contMUERTO<contVIVO)
            return(Tablero.MUERTO);
        else
            return(Tablero.VACIO);
    }
}
