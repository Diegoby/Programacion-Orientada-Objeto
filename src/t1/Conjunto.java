package t1;

public class Conjunto implements IConjunto {

    private int[] conjunto;

    public Conjunto(){ conjunto = new int[SIZE]; }

    @Override
    public void set(int posicion, boolean valor) {

    }

    @Override
    public IConjunto get() {
        return null;
    }

    @Override
    public boolean get(int posicion) {
        return false;
    }

    @Override
    public IConjunto union(IConjunto c) {
        return null;
    }

    @Override
    public IConjunto intersection(IConjunto c) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}