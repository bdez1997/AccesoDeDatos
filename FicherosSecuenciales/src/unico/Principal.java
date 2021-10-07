package unico;

import java.io.*;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		File fch = new File("ejemplo.txt");
		ArrayList<String> sTexto = new ArrayList<String>();
		sTexto.add("hola");
		sTexto.add("Jesus");
		sTexto.add("Antonio");

		escribirFch(fch, sTexto);
	}

	private static void escribirFch(File fch, ArrayList<String> sTexto) {
		try {

			// Creamos el Buffer en el que se va a escribir
			BufferedWriter fichero = new BufferedWriter(new FileWriter(fch));
			// Volcamos el texrto sobre el buffer
			// Este buffer lo escribe en el fichero
			for (int i = 0; i < sTexto.size(); i++) {
				if (i == sTexto.size() - 1) {
					fichero.write(sTexto.get(i));
				} else {
					fichero.write(sTexto.get(i) + "\n");
				}
			}
			// Vaciamos el buffer con los datos que queden por escribir
			fichero.flush();
			
			fichero.close();
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
			// TODO: handle exception
		}
	}
}
