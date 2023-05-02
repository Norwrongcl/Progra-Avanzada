package proyecto.GE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import proyect.exception.NotIntExceptions;
import proyect.exception.ValidNota;




public class MenuGC {
	Hashtable<String,Asignatura> listA;
    BufferedReader reader;
    private int resp;
   
	
	public MenuGC() {// se inicializan los datos
		this.listA = new Hashtable<String,Asignatura>();
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		resp=0;
	}
	
	public void menuon() throws IOException, NumberFormatException, ValidNota,NotIntExceptions{
		
		System.out.println("Director");
		System.out.println("1) inicializar datos");
		System.out.println("2) agregar asignatura");
		System.out.println("3) mostrar asignaturas");
		System.out.println("4) mostrar pruebas de una asignatura");
		System.out.println("5) promedio notas de una asignatura");
		System.out.println("6) eliminar asignatura");
		System.out.println("7) agregar prueba");      
		System.out.println("Otherwise: Salir");
		
	
		resp = Integer.parseInt(reader.readLine());		
		
		switch (resp){
		case 1:
			  inicializarDatos();
			  break;
		case 2: 
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
		case 3:
			   mostrarAsignaturas(listA);
			   break;
		case 4:
			  System.out.println("las pruebas de que asignatura busca?");
			  String asignatura = reader.readLine();
			  mostrarPruebas(asignatura,listA);
			  break;
		case 5:
			  System.out.println("de que asignatura quiere sacar el primedio ?");
			  String asigna = reader.readLine();
			  mostrarPA(asigna,listA);
			  break;
		case 6:
			  System.out.println("de que asignatura desea eliminar ?");
			  String A = reader.readLine();
			  eliminarAsignatura(A,listA);
			  break;
		case 7:
			  System.out.println("en que asignatura quiere agregar prueba?");
			  String As = reader.readLine();
			  agregaPrueba(As,listA);
			  break;
			  	
		default: System.out.println("Saliendo...\n"); break;
		}
		menuon();
	}
	
	
	public void addAsignatura(String nomA,Asignatura AA) {
		this.listA.put(nomA, AA);
		 
	}
	
	public void mostrarAsignaturas(Hashtable<String,Asignatura> listA) {
		Set<String> asign= listA.keySet();
		System.out.println(asign.toString());		
	}
	
	public void mostrarPruebas(String asignatura,Hashtable<String,Asignatura> listA) {
		 Asignatura asign =listA.get(asignatura);
		 
		 ArrayList<Prueba> pruebas = asign.getPrueba();
		 for (int i = 0 ; i < pruebas.size() ; i++) {
			 System.out.println("prueba numero " + (i+1));
			 Prueba prueb = pruebas.get(i);
			 for (int j = 0 ; j < prueb.getCantP() ; j++) {
				 System.out.println("pregunta " + (i+1));
				 System.out.println(prueb.getpregunta(j));	 	 
			 }	 
		 }	 
	}
	
	public void mostrarPA(String asignatura,Hashtable<String,Asignatura> listA) {
		Asignatura asign =listA.get(asignatura);
		System.out.println(asign.getnombA());
		ArrayList<Prueba> pruebas = asign.getPrueba();
		double prom = 0;
		for (int i = 0 ; i < pruebas.size() ; i++) {
			Prueba prueb =pruebas.get(i);
			prom = prueb.getnota()+prom;	 
		}
		prom = prom/pruebas.size();
		System.out.println("el promedio de notas de esta asignatura es" + prom);	
	}
	
	public void eliminarAsignatura(String asignatura,Hashtable<String,Asignatura> listA) {
		Asignatura asign =listA.get(asignatura);
		if(asign == null){
			System.out.println("no existe asignatura");
		}
		else {
			this.listA.remove(asignatura,asign);
			System.out.println("se elimino con exito");
		}
	}
	
	public void agregaPrueba(String asignatura,Hashtable<String,Asignatura> listA) throws NumberFormatException, IOException, ValidNota {	
		Asignatura asign =listA.get(asignatura);
		System.out.println("cuantas pruebas quiere agregar?");
		int p = Integer.parseInt(reader.readLine());
		asign.setPrueba(p);	
	}
	
	public void inicializarDatos() {
		String nomb = "Matematicas";
		Asignatura asi = new Asignatura();
		asi.setnombA(nomb);
		asi.setCantPruebas(2);
		ArrayList<Prueba> pruebas = new ArrayList<Prueba>();
		Prueba newPrueba = new Prueba();
		ArrayList<String> preguntas = new ArrayList<String>();
		preguntas.add("59x689");
		preguntas.add("x=89x55-33");
		newPrueba.setCantP(2);
		for (int i = 0 ; i < 2 ; i++) {	
			newPrueba.setnota((4+i));
			newPrueba.setPreguntas(preguntas);
			pruebas.add(newPrueba);
			preguntas.clear();
			newPrueba = new Prueba();
			newPrueba.setCantP(3);
			preguntas.add("5734x1509");
			preguntas.add("x=1500+66-79x-16");
			preguntas.add("si axa=16 cuanto vale a?");	
		}
		asi.setPruebas(pruebas);
		listA.put(nomb,asi);
		
	}



	
}
