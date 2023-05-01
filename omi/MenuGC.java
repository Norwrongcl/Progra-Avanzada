package proyecto.GE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import proyect.exception.NotIntExceptions;
import proyect.exception.ValidNota;



//CLase que utilizamos para el menu
public class MenuGC {
	Hashtable<String,Asignatura> listA;// aca se crea un mapa donde se guardan las asignaturas
    BufferedReader reader;//este se utiliza para poder leeer lo que la persona pone en la consola
    private int resp;//este se utiliza para poder controlar el switch
   
	
	public MenuGC() {// se inicializan los datos
		this.listA = new Hashtable<String,Asignatura>();
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		resp=0;
	}
	
	public void menuon() throws IOException, NumberFormatException, ValidNota,NotIntExceptions{
		// aca se muestran las opciones q tiene la persona para poder iniciar
		System.out.println("Director");
		System.out.println("1) crear asignatura");
		System.out.println("2) mostrar asignaturas");
		System.out.println("3) mostrar pruebas de una asignatura");
		
		//csv.readText(listaA);
	
		resp = Integer.parseInt(reader.readLine());
		// aca es el switch donde inicializa todo
		switch (resp){
		case 1: //aca se agregan las asignaturas
			   ControllerGN ctr = new ControllerGN();
			   System.out.println("ingrese su asignatura");
			   String nombreA = reader.readLine();
			   Asignatura Asign = new Asignatura();
			   System.out.println("ingrese cuantas pruebas tendra");
			   String canP = reader.readLine();
			   ctr.isInt(canP);
			   Asign.setPrueba(Integer.parseInt(canP));
			   Asign.setnombA(nombreA);
			   addAsignatura(nombreA,Asign);
			   break;
		case 2:// aca se muestran las asignaturas
			   mostrarAsignaturas(listA);
			   break;
		case 3://aca se muestran preguntas de una asignatura
			  System.out.println("las pruebas de que asignatura busca?");
			  String asignatura = reader.readLine();
			  mostrarPruebas(asignatura,listA);
		default: System.out.println("Saliendo...\n"); break;
		}
		menuon();
	}//End menuCliente
	
	
	//metodo para añadir asignatura
	public void addAsignatura(String nomA,Asignatura AA) {
		this.listA.put(nomA, AA);
		 
	}
	//metodo para mostrar asignatura
	public void mostrarAsignaturas(Hashtable<String,Asignatura> listA) {
		Set<String> asign= listA.keySet();
		System.out.println(asign.toString());		
	}
	//metodo para mostrar las preguntas
	public void mostrarPruebas(String asignatura,Hashtable<String,Asignatura> listA) {
		 Asignatura asign =listA.get(asignatura);
		 ArrayList<Prueba> pruebas = asign.getPrueba();
		 for (int i = 0 ; i < pruebas.size() ; i++) {
			 System.out.println("pregunta numero " + (i+1));
			 Prueba prueb =pruebas.get(i);
			 for (int j = 0 ; j < prueb.getCantP() ; j++) {
				 System.out.println(prueb.getpregunta(j));
				 	 
			 }	 
		 }
	}


	
	

	
}
