package model;

import java.io.*;

public class GestionFch {
	private RandomAccessFile fch;
	private final int longReg=22;//5 caracteres *2.4 int,8 double
	
	public GestionFch(String fch) {
		abrirFichero(fch);
	}
	public Persona leerRegistro(int iNumReg) {
		
		String sNombre="";
		byte bEdad = 0;
		double doAltura = 0;
		
		try {
			long posicion = getPosition(iNumReg);
			fch.seek(posicion);
			
			
			//nombre de
			for (int i = 0; i < 5; i++) {
				sNombre+=fch.readChar();
			}
			
			
			
			//edad de
			bEdad=fch.readByte();
			
			//altura de
			doAltura=fch.readDouble();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Persona(sNombre,bEdad,doAltura);
	}
	
	private void abrirFichero(String fch2) {
		try {
			fch=new RandomAccessFile(fch2,"rw");
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		}
		
	}
	private long getPosition(int iReg) {
		
		
		return (iReg-1)*longReg;
	}
	
	public  void cerrarFichero() {
		try {
			fch.close();
		} catch (IOException e) {
			System.err.println("Fichero imposible de cerrar");
		}
	}
	public void escribirRegistro(int iReg,Persona persona) {
		try {
			long posicion= getPosition(iReg);
			fch.seek(getPosition(iReg));
			
			//nombre de
			String nombre = persona.getsNombre();
			char letra;
			for (int i = 0; i < 5; i++) {
				letra= (i<nombre.length()) ?nombre.charAt(i) : ' ';
				fch.writeChar(letra);
			}
			
			//edad de
			fch.writeByte(persona.getbEdad());
			
			//altura de
			fch.writeDouble(persona.getfAltura());
		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}
		
	}
}
