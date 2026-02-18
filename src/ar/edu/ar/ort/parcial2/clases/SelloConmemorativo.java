package ar.edu.ar.ort.parcial2.clases;

public class SelloConmemorativo extends Sello {

	private Tematica tematica; 
	
	public SelloConmemorativo(String pais, String pieImprenta, float valorFacial, Formato tipoFormato,
			Impresion tipoImpresion, Tematica tema) {
		super(pais, pieImprenta, valorFacial, tipoFormato, tipoImpresion);
		this.tematica= tema;
	}

	public Tematica getTematica() {
		return tematica;
	}
	@Override
	float calcularValorComercial() {
		// TODO Auto-generated method stub
		return this.getTipoFormato() == Formato.REDONDO && this.getTematica() == Tematica.CEREMONIAL? 
			   (this.getValorFacial()+ this.getTipoFormato().obtenerValor()): this.getValorFacial();
	}

	@Override
	public void verDatos() {
		// TODO Auto-generated method stub
		//System.out.println("CONMEMORATIVO" +" "+ this.tematica + super.toString());
		System.out.printf(INFO_SELLO,getClass().getSimpleName(), super.toString(), calcularValorComercial());
	}
	

}
