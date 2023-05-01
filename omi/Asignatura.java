package proyecto.GE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import proyect.exception.ValidNota;



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
	
    public Asignatura(String nombA,int cantP,String nota,int cantp,ArrayList<String> preguntasE)throws 	ValidNota{
    	ControllerGN ctr = new ControllerGN();
    	setnombA(nombA);
    	for (int i = 0 ; i < cantP ; i++) {
    		ctr.invalidNota(nota);
			Prueba newPrueba = new Prueba(Integer.parseInt(nota),cantp,preguntasE);
			pruebas.add(i,newPrueba);
			this.setCantPruebas(this.getCantPruebas() + 1);
		}
    }
    
	public void setPrueba(int cantPruebas)throws IOException, ValidNota {
		ControllerGN ctr = new ControllerGN();
		for (int i = 0 ; i < cantPruebas ; i++) {
			System.out.println("que nota tendra su prueba?");
			String nota = lectorr.readLine();
			ctr.invalidNota(nota);
			System.out.println("cuantas preguntas tiene la prueba?");
			int cantp = Integer.parseInt(lectorr.readLine());
			Prueba newPrueba = new Prueba();
			newPrueba.setnota(Integer.parseInt(nota));
			newPrueba.getpreguntas(cantp);
			pruebas.add(i,newPrueba);
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
	
	public ArrayList<Prueba> getPrueba(){
		return pruebas;
	}
	public void setCantPruebas(int cantPruebas) {
		this.cantPruebas = cantPruebas;
	}
	
	public void setCantPruebas(double cantPruebas) {
		this.cantPruebas = (int)cantPruebas;
	}

}
