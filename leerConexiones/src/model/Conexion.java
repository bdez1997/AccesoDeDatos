package model;

public class Conexion {
	String sHost
	,sPort
	,sDbname
	,sUserName
	,sUserPass;
	
	
	public Conexion() {
		setsHost("");
		setsPort("");
		setsDbname("");
		setsUserName("");
		setsUserPass("");
	}
	public Conexion(String sHost,String sPort,String sDbname,String sUserName,String sUserPass){
		setsHost(sHost);
		setsPort(sPort);
		setsDbname(sDbname);
		setsUserName(sUserName);
		setsUserPass(sUserPass);
	}


	public String getsHost() {
		return sHost;
	}


	public void setsHost(String sHost) {
		this.sHost = sHost;
		System.out.println(this.sHost);
	}


	public String getsPort() {
		return sPort;
	}


	public void setsPort(String sPort) {
		this.sPort = sPort;
	}


	public String getsDbname() {
		return sDbname;
	}


	public void setsDbname(String sDbname) {
		this.sDbname = sDbname;
	}


	public String getsUserName() {
		return sUserName;
	}


	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}


	public String getsUserPass() {
		return sUserPass;
	}


	public void setsUserPass(String sUserPass) {
		this.sUserPass = sUserPass;
	}
	@Override
	public String toString() {
		return "Conexion [sHost=" + sHost + ", sPort=" + sPort + ", sDbname=" + sDbname + ", sUserName=" + sUserName
				+ ", sUserPass=" + sUserPass + "]";
	}
	
	
	
	
}
