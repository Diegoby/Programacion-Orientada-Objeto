package t7;

public interface IPersona {

    java.lang.String getDNI();

    java.lang.String getNombre();

    IPersona get();

    @Override
    java.lang.String toString();

    boolean equals(IPersona p);

}
