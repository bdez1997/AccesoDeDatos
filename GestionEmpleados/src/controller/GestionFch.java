package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import model.Empleado;

public class GestionFch {
	private RandomAccessFile fch;
	private final int longReg = 130;
	
	public int maxLista() {
		int maxLista = 0;
		try {
			maxLista = (int) (fch.length()/longReg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return maxLista;
	}
	public GestionFch(String fileName) {
	abrirFichero(fileName);
	}
	
	
	public void cerrarFichero() {

		try {
			fch.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.err.println("Error al acceder al fichero");
		}

	}

	public void abrirFichero(String fileName) {

		try {
			fch = new RandomAccessFile(fileName, "rw");// r es solo lectura w es solo escritura rw-lectura y escritura
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.err.println("Error al acceder al fichero");
		}

	}

	public void escribirRegistro(int numReg, Empleado emp) {
		try {
			fch.seek(getPosition(numReg));
			// sNombre
			String sNombre = emp.getsNombre();
			char cNombre;
			for (int i = 0; i < 10; i++) {
				cNombre = (i < sNombre.length()) ? sNombre.charAt(i) : ' ';
				fch.writeChar(cNombre);
			}
			// Apellidos
			String sApellidos = emp.getsApellidos();
			char cApellidos;
			for (int i = 0; i < 20; i++) {
				cApellidos = (i < sApellidos.length()) ? sApellidos.charAt(i) : ' ';
				fch.writeChar(cApellidos);
			}
			// telefono
			fch.writeLong(emp.getlTelefono());
			// email
			String sEmail = emp.getsEmail();
			char cEmail;
			for (int i = 0; i < 25; i++) {
				cEmail = (i < sEmail.length()) ? sEmail.charAt(i) : ' ';
				fch.writeChar(cEmail);
			}
			// edad
			fch.writeInt(emp.getiEdad());
			// sueldo
			fch.writeDouble(emp.getdoSueldo());

		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.err.println("Error al acceder al fichero");
		}
	}

	public Empleado leerRegistro(int iNumReg) {
		String sNombre = "", sApellidos = "", sEmail = "";
		long lTelefono=0;
		int iEdad = 0;
		double doSueldo = 0;

		try {
			fch.seek(getPosition(iNumReg));

			// sNombre
			for (int i = 0; i < 10; i++) {
				sNombre+=fch.readChar();
			}
			//sApellidos
			for (int i = 0; i < 20; i++) {
				sApellidos+=fch.readChar();				
			}
			//sEmail
			for (int i = 0; i < 25; i++) {
				sEmail+=fch.readChar();
			}
			//Edad
			iEdad=fch.readInt();
			//Telefono
			lTelefono+=fch.readLong();
			//sueldo
			doSueldo=fch.readDouble();
			

		} catch (IOException e) {
			System.err.println("Error al accerder al fichero");
		}
		return new Empleado(sNombre,sApellidos,lTelefono,sEmail,iEdad,doSueldo);
	}
	public void listarPosicion() {
		Scanner sScanner = new Scanner();
		Empleado 
		}
	public void listarTodo() {
		try {
			for (int i = 1; i <=maxLista() ; i++) {
				Empleado persona=leerRegistro(i);
				System.out.println(persona);			
			}
			
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
	}

	private long getPosition(int iNumReg) {
		int iPosition=(iNumReg - 1) * longReg;
		if (iPosition<0) {
			iPosition=iPosition*-1;
		} 
		
		return iPosition;

	}

}
