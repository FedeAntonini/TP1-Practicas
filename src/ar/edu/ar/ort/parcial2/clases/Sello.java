package ar.edu.ar.ort.parcial2.clases;

public abstract class Sello implements Visualizable{
	
	private String pais; 
	private String pieImprenta; 
	private float valorFacial;
	private Formato tipoFormato;
	private Impresion tipoImpresion;
	
	private static final RangoNumeros RANGO_NROS = new RangoNumeros(0.50f, 0.90f);
	
	
	public Sello(String pais, String pieImprenta, float valorFacial,
				 Formato tipoFormato,
				 Impresion tipoImpresion) {
		
		this.pais = pais;
		this.setPieImprenta(pieImprenta);
		this.setValorFacial(valorFacial);
		this.tipoFormato = tipoFormato;
		this.tipoImpresion = tipoImpresion;
		
	}
	
	
	
	public String getPieImprenta() {
		return pieImprenta;
	}

	

	public void setPieImprenta(String pieImprenta) {
		if(pieImprenta==null) {
			throw new IllegalArgumentException(ERROR_PIE_NULO);
		}
		this.pieImprenta = pieImprenta;
	}



	public Impresion getTipoImpresion() {
		return tipoImpresion;
	}



	public Formato getTipoFormato() {
		return tipoFormato;
	}

	public void setValorFacial(float valorFacial) {
		if (!RANGO_NROS.incluye(valorFacial)) {
			throw new IllegalArgumentException(ERROR_VALOR_FACIAL);
		}
		
		this.valorFacial = valorFacial; 
	}

	public float getValorFacial() {
		return valorFacial;
	}


	abstract float calcularValorComercial();



	@Override
	public String toString() {
		return "--" + pais + "(" + pieImprenta +")" +"Facial=" + valorFacial
				+ "--"+ tipoFormato + "--" + tipoImpresion;
	}
	
	
}
