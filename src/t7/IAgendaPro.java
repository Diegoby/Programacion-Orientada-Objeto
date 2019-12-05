package t7;

public interface IAgendaPro {

    boolean full();

    boolean empty();

    int size();

    int maxSize();

    void add(Persona e)throws ExAgendaProPersonaExistente, ExAgendaProLlena;

    void delete(Persona e)throws ExAgendaProPersonaNoExistente;

    Persona getByDNI(java.lang.String dni)throws ExAgendaProPersonaNoExistente;

    Persona first()throws ExAgendaProVacia;

    Persona next();

    boolean hasNext();

    @Override
    java.lang.String toString();
}

