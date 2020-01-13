package unocerounocero;
import java.io.*;

public class FicheroTexto {
  BufferedReader in;
  BufferedWriter out;
  String nombreFichero;
  
  public FicheroTexto(String nombreFichero) {
	  this.nombreFichero = nombreFichero;
  }
  
  public void escribeEnFichero(String estado) throws IOException {
	 out = new BufferedWriter(new FileWriter(nombreFichero));
	 out.write(estado);
	 out.close();	 
  }
  
  public String leeDeFichero() throws IOException {
	 in = new BufferedReader(new FileReader(nombreFichero));
	 String s = in.readLine();
	 in.close();
	 return s;
  }
  
}
