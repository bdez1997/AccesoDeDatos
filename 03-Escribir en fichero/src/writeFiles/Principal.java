package writeFiles;

import java.io.*;

public class Principal {

	public static void main(String[] args) {
		
		final int clave=3;
		File fFileSource = new File("Notas.txt");
		File fFileTarget = new File("Notas_v2.txt");
		File fNombreFichero= new File("Notas_enc.txt");
		File fNombreDeencriptado = new File("Notas_desencrriptadas");
		
		//EscribirFchEncriptado(fFileSource,fNombreFichero,clave);
		desencriptarFch(fNombreFichero,fNombreDeencriptado,clave);
		
		//pedirContenido(fFileSource);
		//copiarContenido(fFileSource, fFileTarget);
		
	
	}
	
	private static void EscribirFchEncriptado(File nombreFichero,File nombreFicheroEncriptado,int clave) {
		
		char chLetra;
		int iAscii,iClave;
		
		try {
			
			FileWriter fch = new FileWriter(nombreFicheroEncriptado );
			FileReader fchSource = new FileReader(nombreFichero);
			
			for (int i = 0; i < nombreFichero.length(); i++) {
				iAscii= fchSource.read();
				if (iAscii!=-1) {		
				fch.write(iAscii+clave);
				}
			}
			fch.close();
			fchSource.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static void desencriptarFch(File fchEncriptado,File fchTarget,int clave) {
		
		try {
			FileReader fchSource = new FileReader(fchEncriptado);
			FileWriter fch = new FileWriter(fchTarget);
			int iAscii;
			
			for (int i = 0; i < fchEncriptado.length(); i++) {
				iAscii = fchSource.read();
				if(iAscii!=-1) {
					fch.write(iAscii-clave);
				}
			}
			fchSource.close();
			fch.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			
		}
		
	}

	private static void pedirContenido(File fch) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		try {
			FileWriter fichero = new FileWriter(fch);
			String sTexto = null;
			do {
				//System.out.print("Dame la palabra: ");
				sTexto = teclado.readLine();
				fichero.write(sTexto + "\n");

			} while (sTexto.length() != 0);
			fichero.close();
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException i) {
			System.err.println("Error con el fichero");
		}
	}

	private static void copiarContenido(File fFileSource, File fFileTarget) {
		try {
			FileReader fchSource = new FileReader(fFileSource);
			FileWriter fchTarget = new FileWriter(fFileTarget);

			char chCaracter;
			int iAscii;
			int iContadorTotal = 0;
			int iContadorVocales = 0;
			int iContadorConsonantes = 0;

			iAscii = fchSource.read();

			while (iAscii != -1) {
				iContadorTotal++;
				fchTarget.write(iAscii);
				iAscii = fchSource.read();
				chCaracter = (char) iAscii;
				if (iAscii == 97 || iAscii == 101 || iAscii == 105 || iAscii == 111 || iAscii == 117) {
					iContadorVocales++;

				} else  {
					if (Character.isLetter(chCaracter)){
						iContadorConsonantes++;
					}
					
				}
			}
			System.out.println("Hay " + iContadorTotal + " Caracteres");
			System.out.println("Hay " + iContadorVocales + " vocales y " + (iContadorConsonantes+1) + " consonantes");
			fchSource.close();
			fchTarget.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error al leer el fichero");
		}

	}
}
