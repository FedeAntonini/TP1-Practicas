package ar.edu.ar.ort.parcial2.clases;

public enum Disenio {
	ART_DECO (0.20f),
	MONARCA (0.40f),
	FIGURA_ALEGORICA (0.30f);
	
	private float valorDisenio;
	
	private Disenio(float valorDisenio) {
		this.valorDisenio = valorDisenio;
	}
	
	public float getValorDisenio() {
		return valorDisenio;
	}
}
