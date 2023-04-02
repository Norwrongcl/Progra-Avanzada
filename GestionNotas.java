package proyecto.GE;
import java.io.*;

public class GestionNotas {
	
	public static void main(String[] args) throws IOException {
		MenuGC menug = new MenuGC();
		String a = "mate";
		Asignatura b = new Asignatura();
		b.setprueba(1);
		menug.addAsignatura(a,b);
		
	}
		
}
	

