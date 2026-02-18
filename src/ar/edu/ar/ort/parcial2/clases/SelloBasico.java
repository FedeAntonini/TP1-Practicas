package ar.edu.ar.ort.parcial2.clases;

public class SelloBasico extends Sello {

	private Disenio tipoDisenio;
	
	public SelloBasico(String pais, String pieImprenta, float valorFacial, 
			      Formato tipoFormato,
			      Impresion tipoImpresion,
			      Disenio disenio) {
		super(pais, pieImprenta, valorFacial, tipoFormato, tipoImpresion);
		this.tipoDisenio = disenio;
	}

	public Disenio getTipoDisenio() {
		return tipoDisenio;
	}

	@Override
	float calcularValorComercial() {
		// TODO Auto-generated method stub
		return this.tipoDisenio == Disenio.MONARCA ? 
		(this.getValorFacial()+tipoDisenio.getValorDisenio()) 
		: this.getValorFacial()+this.getTipoFormato().obtenerValor();
	}

	@Override
	public void verDatos() {
		
		//System.out.println("BÁSICO" + super.toString());
		System.out.printf(INFO_SELLO, getClass().getSimpleName(),  super.toString(), calcularValorComercial());
		//System.out.printf();
	}
	
	
	
}
