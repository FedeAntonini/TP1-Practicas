package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaSellosPorValor extends ListaOrdenadaNodos<Float, Sello>{

	@Override
	public int compare(Sello dato1, Sello dato2) {
		// TODO Auto-generated method stub
		return this.compareByKey(dato1.calcularValorComercial(), dato2);
	}

	@Override
	public int compareByKey(Float clave, Sello elemento) {
		// TODO Auto-generated method stub
		return Float.compare(clave, elemento.calcularValorComercial());
	}

}
