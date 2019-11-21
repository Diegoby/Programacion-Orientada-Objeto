package t3;

public interface ISemaforoDcha extends ISemaforo{

    int getColorDcha();

    void setColorDcha(int colorCentral);

    boolean equals(ISemaforoDcha s);

    ISemaforoDcha clone();

}
