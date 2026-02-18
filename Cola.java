package ar.edu.ort.tp1.examen.clases;

//TODO
public class Mejora extends Tarea {

	private String sistema;
	
	public Mejora(String descripcion, int diaInicio, int mesInicio, int anioInicio, Prioridad prioridad, String sistema) {
		super(descripcion, diaInicio, mesInicio, anioInicio, prioridad);
		this.sistema = sistema;
	}

	@Override
	public boolean estaVencido() {
		return false;
	}

	@Override
	public Tipo getTipo() {

		return Tipo.MEJORA;
	}

	@Override
	public void mostrar() {
		super.mostrar();
		System.out.println(" - Se mejorará el sistema " + sistema);
	}
}
