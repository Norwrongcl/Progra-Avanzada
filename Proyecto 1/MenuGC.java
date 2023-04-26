package proyecto.GE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;



public class MenuGC {
	
	Hashtable<String,Asignatura> listA;
    BufferedReader reader;
    private int resp;
	
	public MenuGC() {
		this.listA = new Hashtable<String,Asignatura>();
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		resp=0;
	}
	
	public void menuon() throws IOException{
		System.out.println("Director");
		System.out.println("1) crear asignatura");
		System.out.println("2) mostrar asignaturas");
	
		resp = Integer.parseInt(reader.readLine());
		
		switch (resp){
		case 1: 
			   System.out.println("ingrese su asignatura");
			   String a = reader.readLine();
			   Asignatura b = new Asignatura();
			   System.out.println("ingrese cuantas pruebas tendra");
			   b.setPrueba(Integer.parseInt(reader.readLine()));
			   b.setnombA(a);
			   addAsignatura(a,b);
			   System.out.println("cuantas pruebas tendra la asignatura?");
			   b.setPrueba(Integer.parseInt(reader.readLine()));
			   break;
		case 2:
			   break;
		
		default: System.out.println("Saliendo...\n"); break;
		}
	}//End menuCliente
	
	
	
	public void addAsignatura(String nomA,Asignatura AA) {
		this.listA.put(nomA, AA);
		 
	}


	
	

	
}
