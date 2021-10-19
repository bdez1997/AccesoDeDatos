package model;

public class Empleado {
	private String sNombre;
	private String sApellidos;
	private long lTelefono;
	private String sEmail;
	private int iEdad;
	private double doSueldo;
	
	
	
	public Empleado(String sNombre, String sApellidos, long lTelefono, String sEmail, int iEdad, double doSueldo) {
		
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setlTelefono(lTelefono);
		setsEmail(sEmail);
		setiEdad(iEdad);
		setdoSueldo(doSueldo);
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		if (sNombre.length() <= 10) {
			this.sNombre = sNombre;
		}
	}

	public String getsApellidos() {
		return sApellidos;
	}

	public void setsApellidos(String sApellidos) {
		if (sApellidos.length() <= 20) {
			this.sApellidos = sApellidos;
		}
	}

	public long getlTelefono() {
		return lTelefono;
	}

	public void setlTelefono(long lTelefono) {
		this.lTelefono = lTelefono;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		if(sEmail.length()<=25) {
			this.sEmail = sEmail;}
	}

	public int getiEdad() {
		return iEdad;
	}

	public void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}

	public double getdoSueldo() {
		return doSueldo;
	}

	public void setdoSueldo(double doSueldo) {
		this.doSueldo = doSueldo;
	}

	@Override
	public String toString() {
		return "Empleado [sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", lTelefono=" + lTelefono + ", sEmail="
				+ sEmail + ", iEdad=" + iEdad + ", doSueldo=" + doSueldo + "]";
	}
	
	

}
