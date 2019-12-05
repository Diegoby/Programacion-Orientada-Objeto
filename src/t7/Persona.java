package t7;

import java.lang.Object;

public class Persona extends Object implements IPersona{

    private String DNI;
    private String nombre;

    public Persona(String DNI, String nombre){
        this.DNI = DNI;
        this.nombre = nombre;
    }

    @Override
    public String getDNI() {
        return this.DNI;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public IPersona get(){
        return this;
    }

    @Override
    public boolean equals(IPersona p) {
        return p.getDNI() == this.DNI;
    }
}
