package ar.edu.ar.ort.parcial2.clases;

public class RangoNumeros {
	private float limiteSup; 
	private float limiteInf;
	
	public RangoNumeros(float limiteInf, float limiteSup) {
		if (limiteInf>limiteSup) {
			float aux = limiteInf; 
			limiteInf = limiteSup; 
			limiteSup = aux; 
		}
		
		this.setLimiteInf(limiteInf);
		this.setLimiteSup(limiteSup);
	}

	
	public float getLimiteSup() {
		return limiteSup;
	}


	public float getLimiteInf() {
		return limiteInf;
	}


	private void setLimiteSup(float limiteSup) {
		this.limiteSup = limiteSup;
	}

	private void setLimiteInf(float limiteInf) {
		this.limiteInf = limiteInf;
	}
	
	public boolean incluye(float valor) {
		return (valor>=getLimiteInf() && valor<=getLimiteSup());
	}
	
}
