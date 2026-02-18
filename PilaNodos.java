package ar.edu.ort.tp1.examen.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Fecha {

	private LocalDate date;

	/**
	 * Constructor de una fecha - si el día indicado no es válido para el mes
	 * indicado, arrojará un error. (por ejemplo un 30 de febrero)
	 * 
	 * @param dia  número de día de la fecha, de 1 a la cantidad de días del mes
	 *             (28, 29, 30 o 31)
	 * @param mes  número de mes de la fecha, de 1 a 12
	 * @param anio número de año
	 */
	public Fecha(int dia, int mes, int anio) {
		date = LocalDate.of(anio, mes, dia);
	}

	private Fecha(LocalDate date) {
		this.date = date;
	}

	/**
	 * Indica la diferencia, en días, desde la fecha actual y la pasada por
	 * parámetro
	 * 
	 * @param otraFecha la otra fecha
	 * @return La diferencia en días
	 */
	public long diasDesde(Fecha otraFecha) {
		return ChronoUnit.DAYS.between(this.date, otraFecha.date);
	}

	public static Fecha hoy() {
		return new Fecha(LocalDate.now());
	}
	
	@Override
	public String toString() {
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
