package ar.edu.ar.ort.parcial2.clases;

public class Venta implements Visualizable{
	
	private Sello sello;
	private int credencial;
	private String contacto;
	
	public Venta(Sello s, int cred, String c) {
		this.sello = s;
		this.credencial = cred; 
		this.contacto = c;
	}

	
	
	@Override
	public void verDatos() {
		// TODO Auto-generated method stub
		System.out.println("Sello: " + this.sello +" Comprador: " + this.credencial +" Contacto: " + this.contacto);
	} 
	
	
	
	
	
	
	
}
