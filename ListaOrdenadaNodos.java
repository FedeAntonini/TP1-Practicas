package ar.edu.ar.ort.parcial2.clases;

public abstract class Habitacion implements Tarifable {
	
	private static final String MSG_TARIFA_INVALIDO = "La tarifa por noche debe ser mayor a 0.";
	private static final String MSG_CAPACIDAD_INVALIDO = "La capacidad debe ser mayor a 0.";
	private static final String MSG_ESTADO_INVALIDO = "Estado inválido.";
	private static final String MSG_ID_INVALIDO = "El ID no puede ser negativo.";
	
	private static final String FORMATO_HABITACION = "Habitación -- ID: %d | Estado: %s | Capacidad: %d | Tarifa por Noche: %.2f";

    public Habitacion(int id, EstadoHabitacion estado, int capacidad, float tarifaPorNoche) {
   
    }


    public void mostrar() {
    	// COMPLETAR
    }


	public int getTarifaPorNoche() {
		// COMPLETAR
		return 0;
	}


	public int getId() {
		// COMPLETAR
		return 0;
	}
}
