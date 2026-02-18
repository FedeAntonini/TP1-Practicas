package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class CentroDeCompilacion implements Visualizable{
	
	private Pila<Venta> ventas;
	private int[] cantidadPorImpresion = new int [Impresion.values().length];
	private double [][] ventasPorImpresion = new double [Impresion.values().length][Formato.values().length];
	private ListaSellosPorValor sellosPorValor; 

	double recaudacion = 0.0;
	private static final RangoNumeros RANGO_NROS = new RangoNumeros(25, 35);
	
	
	public CentroDeCompilacion() {
		this.ventas = new PilaNodos<>();
		this.sellosPorValor = new ListaSellosPorValor();
	}
	
	
	public void agregarSellos(Sello unSello) {
		sellosPorValor.add(unSello);		
	}

	@Override
	public void verDatos() {
		this.verSellosPorValor();
		this.verDatosVenta();
		this.verCantidadPorTipoImpresion();
		this.verVentasPorImpresionyFormato();
	}
	
	
	public void realizarVentaSello(String pie, int cred, String contacto) {
		
		int i=0;
		boolean coincide=false; 
		
		while(i<this.sellosPorValor.size() && !coincide){
			if (encuentraPie(pie, i)) {
				cantidadPorImpresion[sellosPorValor.get(i).getTipoImpresion().ordinal()]++;
				ventasPorImpresion[sellosPorValor.get(i).getTipoImpresion().ordinal()][sellosPorValor.get(i).getTipoFormato().ordinal()] += sellosPorValor.get(i).calcularValorComercial();				
				ventas.push(new Venta(sellosPorValor.removeAt(i), cred, contacto));
				coincide = true;
				}
			i++;
		}
		
		if (coincide==false) {
			throw new IllegalArgumentException(ERROR_SELLO);
		}
			
	}
	
	private boolean encuentraPie (String pie, int index) {
		return this.sellosPorValor.get(index).getPieImprenta().equals(pie) ? true : false; 
	}
	
	private void verDatosVenta() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Ventas efectuadas con éxito");
		System.out.println("-----------------------------------------------------");
		Pila<Venta> aux = new PilaNodos<Venta>();
		
		while(!ventas.isEmpty()) {
			ventas.peek().verDatos();
			aux.push(ventas.pop());
		}
		while(!aux.isEmpty()) { ventas.push(aux.pop());}
	}
	
	private void verSellosPorValor() {
		System.out.println("Sellos sin vender");
		System.out.println("-----------------------------------------------------");
		for (Sello s: sellosPorValor) {
			s.verDatos();
		}
	}
	
	private void verCantidadPorTipoImpresion() {
		System.out.println("-----------------------------------------------------");
		System.out.printf(MSG_TIPO_IMPRESION,
				this.cantidadPorImpresion[Impresion.HUECOGRABADO.ordinal()],
				this.cantidadPorImpresion[Impresion.LITOGRAFÍA.ordinal()],
				this.cantidadPorImpresion[Impresion.TIPOGRAFÍA.ordinal()],
				this.cantidadPorImpresion[Impresion.FOTOGRABADO.ordinal()],
				this.cantidadPorImpresion[Impresion.TROQUELADO.ordinal()]);
		System.out.println("-----------------------------------------------------");
	}
	
	private void verVentasPorImpresionyFormato() {
		
		System.out.printf(MSG_RECAUDACION_TOTAL, calcularRecaudacion(ventasPorImpresion));
		System.out.println("-----------------------------------------------------");
		System.out.println(verificarRecaudacion(recaudacion));
	}
	
	private double calcularRecaudacion(double [][] ventas) {
		
		for (int f=0; f<Impresion.values().length; f++) {
			for(int c=0; c<Formato.values().length;c++) {
				recaudacion += ventas[f][c];
			}	
		}
		return recaudacion;
	}
	
	private String verificarRecaudacion(double recaudacion) {
		return RANGO_NROS.incluye((float)recaudacion) ? MSG_VENTAS_CRITICAS : "";
	}
}
	

