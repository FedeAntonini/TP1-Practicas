package ar.edu.ort.tp1.examen.clases;
//TODO
public abstract class Tarea implements Vigencia, Mostrable {

	private static final String MSG_PRIORIDAD_INVALIDA = "Prioridad inválida";
	private static final String MSG_FECHA_INVALIDA = "Fecha de inicio inválida";
	private static final String MSG_DESCRIPCION_INVALIDA = "La descripcion no puede ser nula ni vacía";
	private String descripcion;
	private Fecha fechaInicio;
	private Prioridad prioridad;

	public Tarea(String descripcion, int diaInicio, int mesInicio, int anioInicio, Prioridad prioridad) {
		this.setDescripcion(descripcion);
		this.setFechaInicio(diaInicio, mesInicio, anioInicio);
		this.setPrioridad(prioridad);
	}

	private void setPrioridad(Prioridad prioridad) {
		if (prioridad == null) {
			throw new IllegalArgumentException(MSG_PRIORIDAD_INVALIDA);
		}
		this.prioridad = prioridad;
	}

	private void setDescripcion(String descripcion) {

		if (descripcion == null || descripcion.isBlank()) {
			throw new IllegalArgumentException(MSG_DESCRIPCION_INVALIDA);
		}
		this.descripcion = descripcion;
	}

	private void setFechaInicio(int diaInicio, int mesInicio, int anioInicio) {

		try {
			this.fechaInicio = new Fecha(diaInicio, mesInicio, anioInicio);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(MSG_FECHA_INVALIDA);
		}
	}

	@Override
	public boolean estaVigente() {
		return fechaInicio.diasDesde(Fecha.hoy()) > 0 && !estaVencido();
	}

	public Prioridad obtenerPrioridad() {
		return this.prioridad;
	}

	public boolean posteriorAInicio(Fecha fecha) {
		return this.diasDesdeInicio(fecha) < 0;
	}
	
	public long diasDesdeInicio(Fecha hasta) {
		return fechaInicio.diasDesde(hasta);
	}

	public Prioridad getPrioridad() {
		return this.prioridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public abstract Tipo getTipo();
	
	@Override
	public void mostrar() {
		System.out.print(getTipo() + " - Descripción: " + descripcion + " - Prioridad: " + prioridad
				+ " - Fecha de inicio: " + fechaInicio + " - " + vencidaONo());
	}

	private String vencidaONo() {
		return (!estaVencido() ? "No " : "") + "está vencida";
	}
}
