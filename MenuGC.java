package proyecto.GE;

import java.util.Hashtable;


public class MenuGC {
	
	Hashtable<String,Asignatura> listA;
	
	public MenuGC() {
		this.listA = new Hashtable<String,Asignatura>();
	}
	
	public void addAsignatura(String nomA,Asignatura AA) {
		this.listA.put(nomA, AA);
	}

	
}
