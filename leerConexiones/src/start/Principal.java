package start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import model.Conexion;

public class Principal {

	public static void main(String[] args) {
		File fchFichero= new File("conexion.cfg");
		File fchFichero1=new File("PrimerFichero.txt");
		File fchFichero2=new File("SegundoFichero.txt");
		File fchFichero3=new File("TercerFichero.txt");
		diffFch(fchFichero1,fchFichero2,fchFichero3);
		//Conexion cPropiedades=leerConexion(fchFichero);
		//System.out.println(cPropiedades);
	}
	
	private static void diffFch(File fch1,File fch2,File fchD) {
		try {
			int iContador=0;
			FileReader reader1= new FileReader(fch1);
			FileReader reader2= new FileReader(fch2);
			BufferedReader br1= new BufferedReader(reader1);
			BufferedReader br2= new BufferedReader(reader2);
			FileWriter writer1= new FileWriter(fchD);
			
			String sLinea=br1.readLine();
			ArrayList<String> sTexto=new ArrayList<String>();
			String sLinea2=br2.readLine();		
			sTexto.add(sLinea);
			while (sLinea != null&&sLinea2 != null) {
				if(sTexto.get(iContador).contentEquals(sLinea2)) {
					writer1.write(sTexto.get(iContador));
				}
				iContador++;
				
			}
			br1.close();
			br2.close();
			reader1.close();
			reader2.close();
			writer1.close();			
		}catch(FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		}catch(IOException e) {
			System.err.println("Error al acceder al fichero");
		}
		
		
	}
	private static Conexion leerConexion(File fch) {
		Conexion cPropiedades=new Conexion();
		final String sSeparador=":";
		String[] sCampo;
		HashMap<String,String> mapa = new HashMap<String,String>();

		try {						
			FileReader reader= new FileReader(fch);
			BufferedReader br= new BufferedReader(reader);							
			String sLinea=br.readLine();
			
			while(sLinea != null) {
				
				sCampo=sLinea.split(sSeparador);
				mapa.put(sCampo[0].toUpperCase().trim(),sCampo[1].toUpperCase().trim());
				sLinea=br.readLine();
			}
				
				/*cPropiedades.setsHost(br.readLine().split(sSeparador)[1]);
				cPropiedades.setsPort(br.readLine().split(sSeparador)[1]);
				cPropiedades.setsDbname(br.readLine().split(sSeparador)[1]);
				cPropiedades.setsUserName(br.readLine().split(sSeparador)[1]);
				cPropiedades.setsUserPass(br.readLine().split(sSeparador)[1]);*/
			
			
				/*String[] campos = sLinea.split(":");
				
				while(sLinea!=null) {
					switch (sLinea) {
					case "HOST":
						cPropiedades.setsHost(campos[1]);
						
						break;

					case "PORT":
						cPropiedades.setsPort(campos[1]);
						break;
					case "USER":
						cPropiedades.setsDbname(campos[1]);
						break;
					case "USERNAME":
						cPropiedades.setsUserName(campos[1]);
						break;
					case "USERPASS":
						cPropiedades.setsUserPass(campos[1]);
					}
				}*/
			br.close();			
			reader.close();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		cPropiedades.setsHost(mapa.get("HOST"));
		cPropiedades.setsPort(mapa.get("PORT"));
		cPropiedades.setsDbname(mapa.get("DBNAME"));
		cPropiedades.setsUserName(mapa.get("USERNAME"));
		cPropiedades.setsUserPass(mapa.get("USERPASS"));
		
		return cPropiedades;	
	}

}
