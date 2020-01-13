package t7;

/**
 * Programa principal para AgendaPro.
 * @author POO.
 */
public class PruebaAgendaPro {
	
	public static void main(String[] args) {

	       AgendaPro agenda = new AgendaPro();

	       Persona p[] = new Persona[5];
	       p[0] = new Persona("5556789","Ana Ruiz");
	       p[1] = new Persona("3335677","Pedro Perez");
	       p[2] = new Persona("2227894","Nuria Rodriguez");
	       p[3] = new Persona("7778812","Juan Peire");
	       p[4] = new Persona("4446790","Rosa Lopez");
	       	       
	       try {
		    for (int i=0;i<5;i++) 
			  agenda.add(p[i]);
			       
			System.out.println(agenda);
	    	agenda.delete(p[3]);
	    	System.out.println();  
	    	
	    	
		    System.out.println(agenda.first());
		    while (agenda.hasNext())
			  System.out.println(agenda.next());	
		    
		    System.out.println(agenda.getByDNI("2227894"));
		    
		    System.out.println(agenda.maxSize()+", "+agenda.size()+", "+agenda.full()+", "+agenda.empty());
	    	
	       } catch (Exception e) {
	    	 System.out.println(e);  
	       }
	       
       System.out.println(agenda);
	       
		}
}
