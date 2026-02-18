package ar.edu.ar.ort.parcial2.clases;


public class SemiPostal extends Sello {

	private final static float COSTO_CONVENCION_POSTAL = 0.08f;
	
	
	public SemiPostal(String pais, String pieImprenta, float valorFacial, Formato tipoFormato,
			Impresion tipoImpresion) {
		super(pais, pieImprenta, valorFacial, tipoFormato, tipoImpresion);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	float calcularValorComercial() {
		// TODO Auto-generated method stub
		return this.getValorFacial()+ COSTO_CONVENCION_POSTAL + this.getTipoFormato().obtenerValor();
	}

	@Override
	public void verDatos() {
		// TODO Auto-generated method stub
		//System.out.println("SEMIPOSTAL"+ super.toString());
		System.out.printf(INFO_SELLO, getClass().getSimpleName(),  super.toString(), calcularValorComercial());
		//+ "VALOR COMERCIAL: " + this.calcularValorComercial());
	}
	
	

}
