package unico;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	public static void main(String[] args) {

		File fNombreFichero = new File("Notas.txt");
		File fNombreCopia= new File("Notas02.txt");
		// escribirfch(fNombreFichero);
		//pedirContenido(fNombreFichero);
		pedirCaracter(fNombreFichero,fNombreCopia);

	}

	private static void leerFch(File fNombreFichero) {
		try {
			FileReader fch = new FileReader(fNombreFichero);
			int ascii;

			ascii = fch.read();
			while (ascii != -1) {
				System.out.println();
				System.out.println(ascii);

			}

			fch.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
		} catch (IOException e) {
			System.err.println("Error de fichero");

		}
	}

	private static void pedirCaracter(File fNombreFichero, File fNombreCopia) {
		try {
			FileReader fch = new FileReader(fNombreFichero);
			FileWriter fch2 = new FileWriter(fNombreCopia);
			
			//Proceso de fNombreCopia
			
			int iAscii;
			
			iAscii =fch.read();
			while (iAscii!=-1) {
				fch2.write(iAscii);
				iAscii=fch.read(); 
			}
			fch.close();
			fch2.close();		
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
		}
	}

	private static void pedirContenido(File fNombreFichero) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		String sMensaje = null;

		try {
			FileWriter fch = new FileWriter(fNombreFichero);

			do {

				System.out.println("Introduce los nuevos datos del fichero");
				sMensaje = teclado.readLine();
				if (sMensaje.length() != 0) {
					fch.write(sMensaje + "\n");
				}

			} while (sMensaje.length() != 0);
			fch.close();

		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
		} catch (IOException e) {
			System.err.println("Error de fichero");
		}

	}

	private static void escribirfch(File fNombreFichero) {

		try {
			FileWriter fch = new FileWriter(fNombreFichero);
			String sTexto = "Hola, este es mi pimer fichero escrito en java";

			fch.write(sTexto);
			fch.close();
			System.out.println("Se ha escrito el contenido recibido por teclado");

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
		}

	}

}
