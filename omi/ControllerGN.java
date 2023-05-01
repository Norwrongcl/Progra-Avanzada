package proyecto.GE;

import proyect.exception.NotIntExceptions;
import proyect.exception.ValidNota;

public class ControllerGN {	
	
	public void invalidNota(String nota) throws ValidNota{
		int not = Integer.parseInt(nota);
		if(not < 1 || 7 < not) {
			throw new ValidNota();
		}			
	}
	
	public void isInt(String x) throws NotIntExceptions{
		try {
			Integer.parseInt(x);
		}
		catch(Exception ex) {
			throw new NotIntExceptions();
		}
	}
}