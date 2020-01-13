package t7;

/**
 * Programa principal para Agenda.
 * @author POO.
 */
public class PruebaAgenda {

	public static void main(String[] args) {

       Agenda agenda = new Agenda();

       Persona p[] = new Persona[5];
       p[0] = new Persona("5556789","Ana Ruiz");
       p[1] = new Persona("3335677","Pedro Perez");
       p[2] = new Persona("2227894","Nuria Rodriguez");
       p[3] = new Persona("7778812","Juan Peire");
       p[4] = new Persona("4446790","Rosa Lopez");
       
       for (int i=0;i<5;i++)
    	 agenda.add(p[i]);
       
       System.out.println(agenda);
       
       try {
    	 agenda.pos(p[3]);
    	 agenda.delete();
    	 agenda.pos(p[1]);
    	 System.out.println(agenda.getNombre());
    	 System.out.println();   	 
       } catch (ExAgendaPersonaNoExistente e) {
    	 System.out.println("Persona no existente en la agenda");  
       }
       
       System.out.println(agenda);
       
	}

}

