package unico;

import java.io.File;

public class Principal {

	public static void main(String[] args) {
		String fichero = "ficheros\\ciudades.txt";
		File fch = new File(fichero);

		if (fch.exists()) {
			String fchNombreArchivo=fch.getName();
			String fchRutaAbsoluta=fch.getAbsolutePath();
			String fchCarpetaPadre=fch.getParent();
			long fchBytes=fch.length();
			
			boolean fchPuedeLeer=fch.canRead();
			boolean fchPuedeEscribir=fch.canWrite();
			boolean fchPuedeEjecutar=fch.canExecute();

			
			System.out.println("Nombre archivo: "+ fchNombreArchivo+
					"\nNombre Carpeta: "+fchCarpetaPadre+"\nSu ruta es "+fchRutaAbsoluta+
					"\nTamaño(Bytes)"+fchBytes);
			
			System.out.println("Se puede leer? "+SiNo(fch.canRead()));
			System.out.println("Se puede escribir? "+SiNo(fch.canWrite()));
			System.out.println("Se puede ejecutar? "+SiNo(fch.canExecute()));

			
		} else {
			System.out.println("No existe");
		}
	}

	private static String SiNo(boolean exp) {
		
		return exp ? "Sí":"No";
	}

}
