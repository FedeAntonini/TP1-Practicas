package ar.edu.ar.ort.parcial2.clases;

public interface Visualizable {
	
	public static final String INFO_SELLO = "%s %s - Valor COMERCIAL:%.2f\n";
	public static final String ERROR_PIE_NULO = "Pie de imprenta NULO";
	public static final String ERROR_SELLO = "EL SELLO NO EXISTE";
	public static final String INFO_VALOR_COMERCIAL = "\tValor COMERCIAL:%.2f\n";
	public static final String INFO_VALOR_POR_FORMATO = "%.2f\t";
	public static final String MSG_TIPO_IMPRESION = "Sellos vendidos según impresión: %d Hueco - %d Lito - %d Tipo - %d Foto - %d Troque\n";
	public static final String MSG_RECAUDACION_TOTAL = "Recaudación al cierre: $%.2f\n";
	public static final String MSG_VENTAS_CRITICAS = "Ventas en franja Crítica. Cierre de ventas";
	
	public void verDatos();
}
