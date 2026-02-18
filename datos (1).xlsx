package ar.edu.ort.tp1.examen.clases;
//TODO
public class TareaBug extends TareaVencible {

	private static final int DIAS_VTO_NO_CRITICO = 10;
	private boolean critico;

	public TareaBug(String descripcion, int diaInicio, int mesInicio, int anioInicio, Prioridad prioridad, int diaVto,
			int mesVto, int anioVto, boolean critico) {
		super(descripcion, diaInicio, mesInicio, anioInicio, prioridad, diaVto, mesVto, anioVto);
		this.critico = critico;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.BUG;
	}

	@Override
	public boolean estaVencido() {

		return critico ? super.estaVencido() : diasDesdeVto() > DIAS_VTO_NO_CRITICO;
	}

	@Override
	public void mostrar() {
		
		super.mostrar();
		System.out.println(" - El bug " + (critico ? "" : "no ") + "es crítico");
	}
}
