package t3;

public class SemaforoDcha  extends Semaforo implements ISemaforoDcha {

    private int colorDcha;

    public SemaforoDcha(){
        super();
        colorDcha = APAGADO;
    }

    public SemaforoDcha(int colorDcha){
        super();
        this.colorDcha = colorDcha;
    }

    public SemaforoDcha(int colorDcha, int colorCentral){
        super(colorCentral);
        this.colorDcha = colorDcha;
    }

    @Override
    public int getColorDcha() {
        return colorDcha;
    }

    @Override
    public void setColorDcha(int colorDcha) { this.colorDcha = colorDcha; }

    @Override
    public boolean equals(ISemaforoDcha s) {
        if (getColorDcha() == s.getColorDcha() && getColorCentral() == s.getColorCentral())
            return true;
        else
            return false;
    }

    @Override
    public ISemaforoDcha clone(){
        ISemaforoDcha copia = new SemaforoDcha(colorDcha, getColorCentral());
        return copia;
    }
}
