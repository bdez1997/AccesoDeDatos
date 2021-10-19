package start;

import model.GestionFch;
import model.Persona;

public class init {

	public static void main(String[] args) {
		GestionFch gest = new GestionFch("datos.db");
		/*gest.escribirRegistro(1,new Persona("Pepe",(byte) 45,1.70));
		gest.escribirRegistro(2,new Persona("Juan",(byte)18,1.81));*/
		
		Persona p2 =gest.leerRegistro(2);
		System.out.println(p2);
		
		
		gest.cerrarFichero();
		System.out.println("Fin del programa");
		
		
	}
}
