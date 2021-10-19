package model;

public class Trabajadores {
	private String sNombre;
	private String sApellidos;
	private int iTlfno;
	private String email;
	private double doSueldo;
	
	
	public Trabajadores( String ssNombre, String sApellidos, int iTlfno,String email,double doSueldo) {
		setsNombre(sNombre);
		
	}
	
	
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String setsNombre) {
		this.sNombre = setsNombre;
	}
	public String getsApellidos() {
		return sApellidos;
	}
	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}
	public int getiTlfno() {
		return iTlfno;
	}
	public void setiTlfno(int iTlfno) {
		this.iTlfno = iTlfno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getDoSueldo() {
		return doSueldo;
	}
	public void setDoSueldo(double doSueldo) {
		this.doSueldo = doSueldo;
	}
	
	
	@Override
	public String toString() {
		return "Trabajadores [setsNombre=" + sNombre + ", sApellidos=" + sApellidos + ", iTlfno=" + iTlfno
				+ ", email=" + email + ", doSueldo=" + doSueldo + "]";
	}
	
	
	
}
