package t8;

public class PruebaMatrimonios {

	public static void main(String[] args) {
	  Hombre luis = new Hombre("55555555L","Luis");
	  Hombre juan = new Hombre("55555555M","Juan");	
	  Hombre antonio = new Hombre("55555555O","Antonio");
	  Mujer ana = new Mujer("22222222A","Ana");	
	  Mujer mar = new Mujer("22222222B","Mar");	
	  Mujer raquel = new Mujer("22222222C","Raquel");	
	  Otros zoe = new Otros("77777777A","Zoe");	
	  Otros luigi = new Otros("77777777B","Luigi");	
	  Otros luca = new Otros("77777777C","Luca");	
	  
	  Matrimonio<Hombre,Hombre> homo = new Matrimonio<Hombre,Hombre>(juan,antonio);
	  Matrimonio<Mujer,Mujer> lesv = new Matrimonio<Mujer,Mujer>(ana,mar);
	  Matrimonio<Otros,Otros> trans1 = new Matrimonio<Otros,Otros>(luigi,luca);
	  Matrimonio<Otros,Mujer> trans2 = new Matrimonio<Otros,Mujer>(zoe,raquel);
	  Matrimonio<Hombre,Otros> trans3 = new Matrimonio<Hombre,Otros>(luis,luigi);
	  
	  MatrimonioIglesia<Hombre,Mujer> hetero = new MatrimonioIglesia<Hombre,Mujer>(juan,mar);
//	  MatrimonioIglesia<Hombre,Hombre> homo2 = new MatrimonioIglesia<Hombre,Hombre>(juan,antonio);	  ** error de compilacion en el segundo "Hombre"
//	  MatrimonioIglesia<Otro,Mujer> trans5 = new MatrimonioIglesia<Otro,Mujer>(zoe,ana);	//  ** error de compilacion en "Otro"
//	  MatrimonioIglesia<String,Mujer> trans5 = new MatrimonioIglesia<"KKK",Mujer>(zoe,ana);	//  ** error de compilacion en "String"
	  
	  System.out.println(trans1);
	}

}
