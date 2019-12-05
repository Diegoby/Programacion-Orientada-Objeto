package t5;

/**
 * Tipos de excepciones de Matricula.
 *
 */
enum Fallo {
    LONGITUD("Longitud incorrecta"),
    NUMERO_UNO("El primer caracter debería ser un número"),
    NUMERO_DOS("El segundo caracter debería ser un número"),
    NUMERO_TRES("El tercer caracter debería ser un número"),
    NUMERO_CUATRO("El cuarto caracter debería ser un número"),
    LETRA_UNO("El quinto caracter debería ser una letra"),
    LETRA_DOS("El sexto caracter debería ser una letra"),
    LETRA_TRES("El séptimo caracter debería ser una letra");

    private String mensaje;

    private Fallo(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }

    public String getTipo(){
        return name();
    }
}
