package t3;

public interface ISemaforo {

    int AMBAR = 1;
    int APAGADO = 3;
    int ROJO = 0;
    int VERDE = 2;

    int getColorCentral();

    void setColorCentral(int colorCentral);

    boolean equals(ISemaforo s);

    ISemaforo clone();

}
