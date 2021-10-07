package unico;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		// String ruta = "ficheros\\ciudades.txt";
		String ruta = "C:\\Users\\Usuario\\Desktop\\Prueba acceso a datos";

		File fch = new File(ruta);

		System.out.println(contarItems(fch));

		/*
		 * contarElementos(fch);
		 * 
		 * if (fch.exists()) { diffTipoContenido(fch); } else {
		 * System.out.println("No existe"); }
		 */
	}
	private static int contarItems(File fch) {
		File[] fContenido =fch.listFiles();
		int c=0;
		
		for (int i = 0; i < fContenido.length; i++) {
			if(fContenido[i].isDirectory()) {
				c++;
				c+=contarItems(fContenido[i]);
			}	
		}
		return c;
	}
	private static void NombrarItems(File fch) {

		File[] dirContenido = fch.listFiles();
		File[] carpetaHijo;
		int iContadorCarpetas = 0;
		int iContadorFicheros = 0;

		for (int i = 0; i < dirContenido.length; i++) {
			if (dirContenido[i].isDirectory()) {
				System.out.println(dirContenido[i].getAbsolutePath());
				carpetaHijo = dirContenido[i].listFiles();
				for (int j = 0; j < carpetaHijo.length; j++) {
					if (carpetaHijo[j].isDirectory()) {
						System.out.println(carpetaHijo[j].getAbsolutePath());
						contarItems(carpetaHijo[j]);
					}

				}
			}
		}
	}
	
	//Contar Ficheros 
	//cuantas hay que contenga una palabra

	private static void diffTipoContenido(File fch) {

		String infoprevio;

		File[] dirContenido = fch.listFiles();
		ArrayList<String> nombres = new ArrayList<String>();

		for (File f : dirContenido) {
			infoprevio = f.isDirectory() ? "DIR" : "FCH";
			nombres.add(infoprevio + " " + f.getName());
		}
		Collections.sort(nombres);
		System.out.println(nombres);

	}

	private static void contarElementos(File fch) {
		File[] dirContenido = fch.listFiles();
		int contadorCarpeta = 0;
		int contadorFichero = 0;
		for (File f : dirContenido) {
			if (f.isDirectory()) {
				contadorCarpeta++;
			} else {
				contadorFichero++;
			}
		}
		System.out.println("El número de carpetas es " + contadorCarpeta);
		System.out.println("El número de ficheros es " + contadorFichero);
	}

	private static void infoDir(File fch) {

		System.out.println("Es un directorio!!!");

		long dirEspacioLibreBytes = fch.getFreeSpace();
		long dirEspacioLibreMB = fch.getFreeSpace() / 1024 / 1024;
		long dirEspacioLibreGB = fch.getFreeSpace() / 1024 / 1024 / 1024;

		/*
		 * System.out.println("Espacio libre = "+dirEspacioLibreBytes);
		 * System.out.println("Espacio libre en MB: "+dirEspacioLibreMB);
		 * System.out.println("Espacio libre en GB: "+dirEspacioLibreGB); }
		 */
	}

	private static void infoFile(File fch) {
		String fchNombreArchivo = fch.getName();
		String fchRutaAbsoluta = fch.getAbsolutePath();
		String fchCarpetaPadre = fch.getParent();
		long fchBytes = fch.length();

		boolean fchPuedeLeer = fch.canRead();
		boolean fchPuedeEscribir = fch.canWrite();
		boolean fchPuedeEjecutar = fch.canExecute();

		System.out.println("Nombre archivo: " + fchNombreArchivo + "\nNombre Carpeta: " + fchCarpetaPadre
				+ "\nSu ruta es " + fchRutaAbsoluta + "\nTamaño(Bytes)" + fchBytes);

		System.out.println("Se puede leer? " + SiNo(fch.canRead()));
		System.out.println("Se puede escribir? " + SiNo(fch.canWrite()));
		System.out.println("Se puede ejecutar? " + SiNo(fch.canExecute()));
	}

	private static String SiNo(boolean exp) {

		return exp ? "Sí" : "No";
	}

}
