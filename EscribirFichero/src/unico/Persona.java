package unico;

public class Persona {
	private String sNombre;
	private byte bEdad;
	
	
	public Persona(String sNombre,byte bEdad) {
		setsNombre(sNombre);
		setbEdad(bEdad);
	}
	
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public byte getbEdad() {
		return bEdad;
	}
	public void setbEdad(byte bEdad) {
		this.bEdad = bEdad;
	}
	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", bEdad=" + bEdad + "]";
	}
	
	
	
}
