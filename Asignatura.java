package proyecto.GE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Asignatura {
	
	private String nombA;
	private int cantPruebas;
	ArrayList<Prueba> pruebas;
	BufferedReader lectorr ;
	
	public Asignatura() {
		this.nombA = null;
		this.setCantPruebas(0);
		this.pruebas = new ArrayList<Prueba>();	
		this.lectorr = new BufferedReader(new InputStreamReader(System.in));
	}
    public Asignatura(String nombA,int cantP) throws IOException {
    	setnombA(nombA);
    	setPrueba(cantP);
    }
	public void setPrueba(int cantPruebas)throws IOException {
		for (int i = 0 ; i < cantPruebas ; i++) {
			int nota = Integer.parseInt(lectorr.readLine());
			int cantp = Integer.parseInt(lectorr.readLine());
			Prueba newPrueba = new Prueba(nota,cantp);
			pruebas.add(cantPruebas,newPrueba);
			this.setCantPruebas(this.getCantPruebas() + 1);
		}	
	}
	public void setnombA(String nomA) {
		this.nombA = nomA;
	}
	public String getnombA() {
		return nombA;
	}

	public int getCantPruebas() {
		return cantPruebas;
	}

	public void setCantPruebas(int cantPruebas) {
		this.cantPruebas = cantPruebas;
	}
	

}
