package t1;

public interface IConjunto {
    int SIZE = 20;

    void set(int posicion, boolean valor);

    IConjunto get();

    boolean get(int posicion);

    IConjunto union(IConjunto c);

    IConjunto intersection(IConjunto c);

    int size();

}