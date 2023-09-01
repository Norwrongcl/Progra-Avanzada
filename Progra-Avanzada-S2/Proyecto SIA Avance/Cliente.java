import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private int rut;
	ArrayList<String> servicio;
	
	public Cliente(){
		this.nombre = null;
		this.rut = 0;
		this.servicio = new ArrayList<String>();	
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(double rut){
		this.rut = (int)rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	
	
	

}
