package ar.edu.ort.tp1.examen.clases;
//TODO
public abstract class TareaVencible extends Tarea {

	private static final String MSG_FECHA_VTO_INVALIDA = "Fecha de vencimiento inválida";
	private Fecha fechaVto;
	
	public TareaVencible(String descripcion, int diaInicio, int mesInicio, int anioInicio, Prioridad prioridad,
			int diaVto, int mesVto, int anioVto) {
		super(descripcion, diaInicio, mesInicio, anioInicio, prioridad);
		setFechaVto(diaVto, mesVto, anioVto);
	}

	private void setFechaVto(int diaVto, int mesVto, int anioVto) {
		try {
			this.fechaVto = new Fecha(diaVto, mesVto, anioVto);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(MSG_FECHA_VTO_INVALIDA);
		}
	}

	public boolean estaVencido() {
		
		return fechaVto.diasDesde(Fecha.hoy()) > 0;
	}

	protected long diasDesdeVto() {

		return fechaVto.diasDesde(Fecha.hoy());
	}
}
