package start;

import controller.GestionFch;
import model.Empleado;

public class Init {

	public static void main(String[] args) {
		GestionFch gest=new GestionFch("datos.db");
		
		/*gest.escribirRegistro(1, new Empleado("Antonio","Berm�dez",665394504,"bdez_1997@live.com",24,1100.75));
		gest.escribirRegistro(2, new Empleado("Irene","Cejas",789456123,"Irene_CEjas@live.com",19,1700.75));
		gest.escribirRegistro(3, new Empleado("Luis","Cano",123456789,"Luis@live.com",38,1700.75));*/
		
		
		
		gest.listarTodo();
	}

}
