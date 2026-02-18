package ar.edu.ar.ort.parcial2.clases;

public enum Formato {
	CUADRADO (2.30f),
	ALARGADO (2.50f),
	REDONDO (2.60f),
	HEXAGONAL (1.80f);
	
	private float precioBase;
	
	private Formato (float precioBase) {
		this.precioBase = precioBase;
	}
	
	public float obtenerValor() {
		return precioBase;
	}
}
