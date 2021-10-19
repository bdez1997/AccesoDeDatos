package unico;

import java.io.*;
import java.util.*;

public class Principal {
	public static void main(String[] args) {
		String sRuta = "ascii.txt";
		
		File fch = new File(sRuta);
		ArrayList<Persona> pepa =leerPersonas(fch);
		pepa.forEach(e->{System.out.println(e);});
		//byte bValores[]=contarCarpetas(fch);
		// LeerBufer();
		// CopiarBufer();
		//System.out.println("Hay " + bValores[0] + " Carpetas y "+bValores[1]);
	}
	
	private static ArrayList<Persona> leerPersonas(File fch) {
		ArrayList<Persona> pepa = new ArrayList<Persona>();
		try {			
			BufferedReader br =new BufferedReader(new FileReader(fch));
			String sNombre;
			byte bEdad;
			String sSeparador="#";
			
			
			String sLinea=br.readLine();
			
			
			while(sLinea!=null) {
				StringTokenizer st = new StringTokenizer(sLinea,sSeparador);
				sNombre=st.nextToken();
				bEdad=Byte.parseByte(st.nextToken());				
				pepa.add(new Persona(sNombre,bEdad));
				sLinea=br.readLine();
			}
			br.close();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pepa;
		
	}
	
	private static byte[] contarCarpetas(File fch) {
		byte[] bValores= {0,0};
		byte[] bValoressubCarpetas={0,0};
		
		File[] CarpetasyFicheros;

		if (fch.exists()) {
			CarpetasyFicheros = fch.listFiles();
			for (int i = 0; i < CarpetasyFicheros.length; i++) {
				
				if (CarpetasyFicheros[i].isDirectory()) {
					bValores[0]++;
					bValoressubCarpetas=contarCarpetas(CarpetasyFicheros[i]);
					bValores[0]+=bValoressubCarpetas[0];
					bValores[1]+=bValoressubCarpetas[1];
					
				}else {
					bValores[1]++;					
				}
			}			
		}
		return bValores;		
	}

	private static void LeerBufer() {
		File fch = new File("ascii.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(fch));
			String buferLeido;

			buferLeido = br.readLine();
			while (buferLeido != null) {
				System.out.println(buferLeido);
				buferLeido = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
	}

	private static void CopiarBufer() {
		File fch = new File("ascii.txt");
		File fchCopia = new File("Copia.txt");
		try {

			BufferedReader br = new BufferedReader(new FileReader(fch));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fchCopia));
			String buferLeido;

			buferLeido = br.readLine();
			while (buferLeido != null) {
				bw.write(buferLeido);
				bw.newLine();
				buferLeido = br.readLine();

			}
			bw.flush();
			bw.close();
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
	}
}
