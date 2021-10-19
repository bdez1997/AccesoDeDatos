package model;

public class Persona {
	private String sNombre;
	private double fAltura;
	private byte bEdad;
	
	public Persona(String sNombre,byte bEdad,double fAltura) {
		setsNombre(sNombre);
		setbEdad(bEdad);
		setfAltura(fAltura);
	}
	public Persona() {
		setsNombre("");
		setbEdad((byte) -1);
		setfAltura(-1.0f);
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
	public double getfAltura() {
		return fAltura;
	}
	public void setfAltura(double fAltura) {
		this.fAltura = fAltura;
	}
	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", fAltura=" + fAltura + ", bEdad=" + bEdad + "]";
	}
	
	
	
	
}
