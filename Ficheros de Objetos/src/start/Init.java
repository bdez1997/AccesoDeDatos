package start;

import java.util.ArrayList;

import model.Coche;

public class Init {

	public static void main(String[] args) {
		/* Ficheros dem objetos
		 * 
		 * ESCRITURA
		 * FileOutputStream-->Apunta al archivo pra escribir
		 * 
		 * 
		 * ObjectOutputStream-->Buufer de escritura que se usa sobre FileOutputStream
		 * 
		 * 
		 * LECTURA
		 * 
		 * FileInputStream-->Apunta al archivo para leer
		 * ObjectInputStream-->Buufer de lectura que se usa sobre FileInputStream
		 * readObject-->Lee un objeto del OIS
		 * 
		 * */
		
		
	String fileName = "archivos/coches.dat";
	
	//escritura(fileName);
	lectura(fileName);
		
	}

	private static void escritura(String fileName) {
		ArrayList<Coche> list = new ArrayList<Coche>();
		list.add(new Coche("Renault","Clio",1500));
		list.add(new Coche("Citroen","Picasso",2000));
		controller.GestionFch.WriteDataObject(fileName, list);
		System.out.println("Se ha escrito correctamente");
		
	}

	private static void lectura(String fileName) {
		/*Coche cocheLeido=controller.GestionFch.ReadData(fileName);
		System.out.println(cocheLeido);*/
		ArrayList<Coche>lst =controller.GestionFch.leerArrayObjeto(fileName);
		
		for(Coche c:lst) {
			System.out.println(lst);
		}
	}

}
