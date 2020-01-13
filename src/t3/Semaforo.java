package t3;

import java.util.ArrayList;

public class Semaforo implements ISemaforo{

    private int colorCentral;

    public Semaforo(){
        colorCentral = APAGADO;
    }

    public Semaforo(int colorCentral){
        this.colorCentral = colorCentral;
    }

    @Override
    public int getColorCentral() { return colorCentral; }

    @Override
    public void setColorCentral(int colorCentral) { this.colorCentral = colorCentral; }

    @Override
    public boolean equals(ISemaforo s) {
        if(s.getColorCentral() == colorCentral)
            return true;
        else
            return false;
    }

    @Override
    public ISemaforo clone() {
        ISemaforo copia = new Semaforo(colorCentral);
        return copia;
    }
}
