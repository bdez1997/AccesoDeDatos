package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class GestionFch {
	private RandomAccessFile fch;
	private final int longReg=22;
	
	public void cerrarRegisto() {
		try {
			fch.close();
		} catch (IOException e) {
			System.err.println("Fichero imposible de cerrar");
		}
	}
}
