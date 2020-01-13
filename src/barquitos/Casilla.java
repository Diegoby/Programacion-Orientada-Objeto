package barquitos;

public class Casilla {
    private int x, y, idBarco;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
        this.idBarco = -1;
    }

    public Casilla(int x, int y, int idBarco) {
        this(x, y);
        this.idBarco = idBarco;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIdBarco() {
        return idBarco;
    }

    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }

    @Override
    public String toString(){
        return x+""+y;
    }

    @Override
    public boolean equals(Object o)
    {
        return this.x == ((Casilla) o).getX() && this.y == ((Casilla) o).getY();
    }
}

