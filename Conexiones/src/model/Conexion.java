package model;

public class Conexion {
	String sHost
	,sPort
	,sDbname
	,sUserName
	,sUserPass;
	
	
	public Conexion(String sHost,String sPort,String sDbname,String sUserName,String sUserPass){
		this.sHost = sHost;
		this.sPort = sPort;
		this.sDbname = sDbname;
		this.sUserName = sUserName;
		this.sUserPass = sUserPass;
	}

}
