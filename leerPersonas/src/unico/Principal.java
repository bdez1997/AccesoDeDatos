package unico;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Principal {

	public static void main(String[] args) {
		File fch = new File("ejemplo.txt");
		File fch2=new File("Ejemplo2.txt");
		ArrayList<String> sTexto = new ArrayList<String>();
		ArrayList<String>frases=leerFichero(fch);
		ArrayList<Persona>listaPersona=leerPersona(fch);
		
		sTexto.add("Manuel#Rodriguez#37");
		sTexto.add("Jesus#Bermúdez#29");
		sTexto.add("Antonio#López#19");
		
		
		//frases.forEach(s->System.out.println(s));
		
		listaPersona.forEach(s->System.out.println(s));
		
		
	}
	
	private static void escribirTextoPlano(ArrayList<Persona>listaPersona,File fch ) {
		try {
			FileWriter fw = new FileWriter(fch);
			BufferedWriter bucleEscritura = new BufferedWriter(fw);
			
			String sTexto;
			String sSeparador="#";
			
			
			
			if (listaPersona.size()!=-1) {
				for (int i = 0; i < listaPersona.size(); i++) {
					sTexto = listaPersona.get(i).getsNombre()+sSeparador+
							listaPersona.get(i).getsApellidos()+sSeparador+
							listaPersona.get(i).getbEdad();
					
					if(i<listaPersona.size()-1) {
						bucleEscritura.newLine();
					}
				}
			} else {

			}
			bucleEscritura.flush();
			fw.close();
			bucleEscritura.close();			
		} catch (IOException e) {
			// TODO: handle exception
		}
	
		
	}
	private static ArrayList<Persona> leerPersona(File fch){
		ArrayList<Persona>grupoPersonas=new ArrayList<Persona>(); 		
		String sNombre;
		String sApellidos;
		String sEdad;
		try {
			
			FileReader reader = new FileReader(fch);
			BufferedReader teclado = new BufferedReader(reader);
			String sLinea;
			
			sLinea=teclado.readLine();
			while (sLinea!=null) {
				
				StringTokenizer st = new StringTokenizer(sLinea,"#");
				
					sNombre=st.nextToken();
					sApellidos=st.nextToken();
					sEdad=st.nextToken();
					
					grupoPersonas.add(new Persona(sNombre,sApellidos,Byte.parseByte(sEdad)));
	
								
				
			}
			reader.close();
			teclado.close();
			
			return grupoPersonas;
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		return grupoPersonas;
	}
	private static ArrayList<String> leerFichero(File fch) {
		
		ArrayList<String> sContenido = new ArrayList<String>();
		
		try {
			FileReader fichero = new FileReader(fch);
			BufferedReader bufLectura= new BufferedReader(fichero);
			String sLinea;
			
			sLinea = bufLectura.readLine();
			while(sLinea!=null) {
				//Proceso la líinea leída de
				sContenido.add(sLinea);
				//Realizamos una nueva lectura
				sLinea= bufLectura.readLine();

			}		
			bufLectura.close();
			fichero.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		return sContenido;
		
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
