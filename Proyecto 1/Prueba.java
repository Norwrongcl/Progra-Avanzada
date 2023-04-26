package proyecto.GE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Prueba {
	
	private int nota;
	private int cantP;
	ArrayList<String> preguntasE;
	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
	
	public Prueba() {
		this.nota = 0;
		this.cantP = 0;
		this.preguntasE = new ArrayList<String>();
	}
	
	public Prueba(int nota,int cantP) throws IOException{
		this.nota = nota;
		for (int i = 0 ; i < cantP ; i++) {
			System.out.println("ingrese su pregunta  numero"+ i+1);
			String pregunta = lector.readLine();
			preguntasE.add(cantP,pregunta);
			cantP++;
		}		
	}
	
	public void getprueba(int nump) {
		getnota();
		getpregunta(nump);
	}
	
	public int getnota(){
		return nota;
	}
	
	public void setnota(int nota) {
		this.nota = nota;
	}
	
	public void setnota(double nota) {
		this.nota = (int)nota;
	}
	
	public String getpregunta(int numP) {
		String pregunta = preguntasE.get(numP);
		return pregunta;
	}
	
	public void setpregunta(String pregunta) {
		preguntasE.add(cantP,pregunta);
		cantP++;	
	}
	
	 
	
	

}