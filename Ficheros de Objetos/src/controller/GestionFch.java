package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Coche;

public class GestionFch {
	
		

	public static Coche ReadData(String fileName) {
		Coche c=null;
		
		try {
			FileInputStream in = new FileInputStream(fileName);
			ObjectInputStream readBuff = new ObjectInputStream(in);
			
			c=(Coche)readBuff.readObject();			
			
		}catch (FileNotFoundException e) {			
			System.err.println("El fichero no existe");
		}catch (IOException e) {
			System.err.println("Error al acceder al fochero");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public static ArrayList<Coche> leerArrayObjeto(String fileName) {
		ArrayList<Coche> lst = new ArrayList<>();
		
		try {
			FileInputStream in = new FileInputStream(fileName);
			ObjectInputStream readBuff = new ObjectInputStream(in);
			
			/*
			Object obj =readBuff.readObject();
			while(obj != null) {
				if(obj instanceof Coche) {
					lst.add((Coche)obj);
				}
				obj =readBuff.readObject();
			}*/
			
			lst=(ArrayList<Coche>)readBuff.readObject();
			
						
			
		}catch (FileNotFoundException e) {			
			System.err.println("El fichero no existe");
		}catch (IOException e) {
			System.err.println("Error al acceder al fochero");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	public static void WriteData(String fileName) {
		try {
			FileOutputStream fch = new FileOutputStream(fileName);
			ObjectOutputStream buffOutput = new ObjectOutputStream(fch);
			
			for (Coche c: list) {
				buffOutput.writeObject(c);
			}
			
			
			buffOutput.close();
			fch.close();
		} catch (FileNotFoundException e) {			
			System.err.println("El fichero no existe");
		}catch (IOException e) {
			System.err.println("Error al acceder al fochero");
		}
	}
	public static void WriteDataObject(String fileName, ArrayList<Coche> list) {
		
		try {
			FileOutputStream fch = new FileOutputStream(fileName);
			ObjectOutputStream buffOutput = new ObjectOutputStream(fch);
			
			buffOutput.writeObject(list);

			buffOutput.close();
			fch.close();
		} catch (FileNotFoundException e) {			
			System.err.println("El fichero no existe");
		}catch (IOException e) {
			System.err.println("Error al acceder al fochero");
		}
		
		
		
	}
		
	
	
}
