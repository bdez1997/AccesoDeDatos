package controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class copiaInversaCtrl {
	public static void main(String[] args) {
		File fch1=new File("Fichero1.txt");
		File fch2=new File("Fichero2.txt");

		//CopiarInverso(fch1,fch2);
		contarLineas(fch1);
		
	}
	public static byte contarLineas(File fch1) {
		String sLinea;
		
		byte bContador=0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fch1));
			sLinea=br.readLine();
			while(sLinea!=null) {				
				bContador++;
				sLinea=br.readLine();		
			}
			
			br.close();
			
		} catch (IOException e) {
			System.out.println("Error al acceder al fichero");
		}
		
		return bContador;

		
	}
	public static void CopiarInverso(File fch1, File fch2) {
		String sLinea;
		byte bLineas=contarLineas(fch1);
		
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fch1));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fch2,true));
			sLinea=br.readLine();
				for (int i = bLineas; i <= 0; i--) {
					for (int j = i; j <=0; j++) {
						
						sLinea=br.readLine();	
					}
					bw.append(sLinea);
					bw.newLine();
				}
				
			
			
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch (IOException e) {
			System.out.println("Error al acceder al fichero");
		}
		
		

	}

}
