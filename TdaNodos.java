package ar.edu.ort.tp1.examen.clases;

import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;
//TODO
public class Gestor {

	private ColaTareas[][] matriz;

	public Gestor() {
		inicializarMatriz();
	}

	private void inicializarMatriz() {
		matriz = new ColaTareas[Tipo.values().length][Prioridad.values().length];
		for (int iFila = 0; iFila < matriz.length; iFila++) {
			ColaTareas[] colaTareas = matriz[iFila];
			for (int iCol = 0; iCol < colaTareas.length; iCol++) {
				matriz[iFila][iCol] = new ColaTareas();
			}
		}
	}

	public void registrarTarea(Tarea tarea) {
		if (tarea == null) {
			throw new IllegalArgumentException("Tarea nula");
		}
		matriz[tarea.getTipo().ordinal()][tarea.getPrioridad().ordinal()].add(tarea);
		System.out.println("Tarea registrada " + tarea.getTipo() + " - " + tarea.estaVencido());
	}

	public void listarTareasPorDescripcion(Prioridad p) {
		ListaOrdenada<String, Tarea> lista = generarListaTareasPorDescripcion(p);
		for (Tarea tarea : lista) {
			tarea.mostrar();
		}
	}

	private ListaOrdenada<String, Tarea> generarListaTareasPorDescripcion(Prioridad p) {
		ListaOrdenada<String, Tarea> lista = new ListaTareasPorDescripcion();
		for (int j = 0; j < matriz.length; j++) {
			ColaTareas colaTareas = matriz[j][p.ordinal()];
			agregarElementos(colaTareas, lista);
		}
		return lista;
	}

	private void agregarElementos(ColaTareas colaTareas, ListaOrdenada<String, Tarea> lista) {
		colaTareas.add(null);
		Tarea t = colaTareas.remove();
		while (t != null) {
			lista.add(t);
			colaTareas.add(t);
			t = colaTareas.remove();
		}
	}

}
