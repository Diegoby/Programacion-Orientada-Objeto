package barquitos;
import java.awt.*;

public enum Colores {

    CUBIERTO(Color.LIGHT_GRAY),
    AGUA(Color.CYAN),
    TOCADO(Color.ORANGE),
    HUNDIDO(Color.RED),
    BORDE(Color.DARK_GRAY);

    private Color color;

    Colores(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getValor() {
        return ordinal();
    }

    public static Color getColor(int valor){
        return Colores.values()[valor].getColor();
    }

}
