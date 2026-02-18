package ar.edu.ar.ort.parcial2;

import ar.edu.ar.ort.parcial2.clases.CentroDeCompilacion;
import ar.edu.ar.ort.parcial2.clases.Disenio;
import ar.edu.ar.ort.parcial2.clases.Formato;
import ar.edu.ar.ort.parcial2.clases.Impresion;
import ar.edu.ar.ort.parcial2.clases.SelloBasico;
import ar.edu.ar.ort.parcial2.clases.SelloConmemorativo;
import ar.edu.ar.ort.parcial2.clases.SemiPostal;
import ar.edu.ar.ort.parcial2.clases.Tematica;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CentroDeCompilacion comp = new CentroDeCompilacion();

		System.out.println("Iniciando carga Asociación Filatelia...");
		System.out.println("Vista de errores...");
		System.out.println("----------------------------------------");
		ingresarSelloBasico(comp, "RU", "1428-Ku-AR", 0.56f, Formato.CUADRADO, Impresion.HUECOGRABADO, Disenio.MONARCA);
		ingresarSelloBasico(comp, "UK", "1028-Po-BR", 0.76f, Formato.ALARGADO, Impresion.FOTOGRABADO, Disenio.MONARCA);
		ingresarSelloBasico(comp, "GR", "1029-Ku-GR", 0.72f, Formato.CUADRADO, Impresion.HUECOGRABADO,
				Disenio.FIGURA_ALEGORICA);
		ingresarSelloBasico(comp, "GR", "1036-Ku-GR", 0.72f, Formato.ALARGADO, Impresion.TIPOGRAFÍA,
				Disenio.FIGURA_ALEGORICA);
		ingresarSelloBasico(comp, "GR", "1129-Ky-GR", 0.72f, Formato.CUADRADO, Impresion.TIPOGRAFÍA,
				Disenio.FIGURA_ALEGORICA);
		ingresarSelloBasico(comp, "UK", "1999-Ks-UK", 0.70f, Formato.HEXAGONAL, Impresion.TROQUELADO,
				Disenio.FIGURA_ALEGORICA);

		ingresarSemiPostal(comp, "AR", "1235-Ku-AR", 0.55f, Formato.HEXAGONAL, Impresion.LITOGRAFÍA);
		ingresarSemiPostal(comp, "AR", "1265-Co-AR", 0.48f, Formato.CUADRADO, Impresion.TROQUELADO);
		ingresarSemiPostal(comp, "FR", "1658-Fo-AR", 0.65f, Formato.REDONDO, Impresion.TIPOGRAFÍA);
		ingresarSemiPostal(comp, "FR", "1344-Co-AR", 1.05f, Formato.CUADRADO, Impresion.TIPOGRAFÍA);
		ingresarSemiPostal(comp, "ME", "3047-Me-Fr", 0.90f, Formato.CUADRADO, Impresion.TIPOGRAFÍA);
		ingresarSemiPostal(comp, "AR", "0047-Ag-AR", 0.55f, Formato.HEXAGONAL, Impresion.FOTOGRABADO);
		ingresarSemiPostal(comp, "AR", null, 0.55f, Formato.HEXAGONAL, Impresion.LITOGRAFÍA);
		ingresarSemiPostal(comp, "CH", "1935-Lu-AR", 0.52f, Formato.CUADRADO, Impresion.LITOGRAFÍA);
		ingresarSemiPostal(comp, "UR", "1765-Ur-AR", 0.52f, Formato.REDONDO, Impresion.FOTOGRABADO);
		ingresarSemiPostal(comp, "VE", "1244-Vu-Ve", 0.52f, Formato.REDONDO, Impresion.LITOGRAFÍA);
		ingresarSemiPostal(comp, "PR", "1340-Pr-Ar", 0.63f, Formato.CUADRADO, Impresion.TROQUELADO);

		ingresarConmemorativo(comp, "SU", "0087-Su-AR", 0.88f, Formato.ALARGADO, Impresion.TROQUELADO,
				Tematica.CEREMONIAL);
		ingresarConmemorativo(comp, "ES", "0078-Es-AR", 0.75f, Formato.REDONDO, Impresion.HUECOGRABADO,
				Tematica.CEREMONIAL);
		ingresarConmemorativo(comp, "ES", "0076-Es-AR", 0.72f, Formato.ALARGADO, Impresion.HUECOGRABADO,
				Tematica.HISTOGRAFICA);
		ingresarConmemorativo(comp, "PE", "0080-Es-AR", 0.50f, Formato.CUADRADO, Impresion.HUECOGRABADO,
				Tematica.PATRIA);
		ingresarConmemorativo(comp, "SU", "0017-Su-IR", 0.80f, Formato.REDONDO, Impresion.TROQUELADO,
				Tematica.CEREMONIAL);

		realizarVentaSello(comp, "0087-Su-AR", 6, "11-2345-6789");
		realizarVentaSello(comp, "1344-Co-AR", 32, "11-1355-6673");
		realizarVentaSello(comp, "1658-Fo-AR", 1, "3765-456788");
		realizarVentaSello(comp, "1344-Co-AR", 3, "3764-908765");
		realizarVentaSello(comp, "3047-Mex-AR", 45, "11-0987-3456");
		realizarVentaSello(comp, "0047-Ag-AR", 12, "Sin Nro");
		realizarVentaSello(comp, "1235-Ku-AR", 45, "11-0987-3456");
		realizarVentaSello(comp, "1244-Vu-Ve", 12, "Sin Nro");
		realizarVentaSello(comp, "1028-Po-BR", 32, "11-2345-6789");
		realizarVentaSello(comp, "1129-Ky-GR", 3, "3764-908765");
		realizarVentaSello(comp, "1029-Ku-GR", 3, "3764-908765");
		realizarVentaSello(comp, "0076-Es-AR", 4, "3765-920063");
		realizarVentaSello(comp, "1935-Lu-AR", 7, "11-4567-0864");
		realizarVentaSello(comp, "1340-Pr-Ar", 31, "Sin Nro");
		realizarVentaSello(comp, "1999-Ks-UK", 32, "11-2345-6789");
		realizarVentaSello(comp, "1428-Ku-AR", 35, "3764-891122");
		System.out.println("----------------------------------------");
		comp.verDatos();

	}

	private static void ingresarSelloBasico(CentroDeCompilacion comp, String pais, String pie, float valorFacial,
			Formato formato, Impresion impre, Disenio disenio) {

		comp.agregarSellos(new SelloBasico(pais, pie, valorFacial, formato, impre, disenio));

	}

	private static void ingresarSemiPostal(CentroDeCompilacion comp, String pais, String pie, float valorFacial,
			Formato formato, Impresion impre) {
		comp.agregarSellos(new SemiPostal(pais, pie, valorFacial, formato, impre));
	}

	private static void ingresarConmemorativo(CentroDeCompilacion comp, String pais, String pie, float valorFacial,
			Formato formato, Impresion impre, Tematica tema) {

		comp.agregarSellos(new SelloConmemorativo(pais, pie, valorFacial, formato, impre, tema));
	}

	private static void realizarVentaSello(CentroDeCompilacion comp, String s, int credencial, String Contacto) {
		comp.realizarVentaSello(s, credencial, Contacto);
	}

}
