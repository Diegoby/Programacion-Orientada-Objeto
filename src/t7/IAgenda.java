package t7;

public interface IAgenda {

    void add(Persona e);

    void pos(Persona e)throws ExAgendaPersonaNoExistente;

    java.lang.String getDNI();

    java.lang.String getNombre();

    int size();

    void delete();

    @Override
    java.lang.String toString();

}

