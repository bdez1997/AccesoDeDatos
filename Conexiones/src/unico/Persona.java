package unico;

import java.util.StringTokenizer;

public class Persona {
	private byte bEdad;
	private String sNombre;
	private String sApellidos;
	
	public Persona(String sNombre,String sApellidos,byte bEdad) {		
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setbEdad(bEdad);
	}

	public byte getbEdad() {
		return bEdad;
	}

	public void setbEdad(byte bEdad) {
		this.bEdad = bEdad;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsApellidos() {
		return sApellidos;
	}

	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}
	
	
}
