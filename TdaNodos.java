package ar.edu.ar.ort.parcial2.clases;

public class SuitePresidencial extends Suite {
	private static final String FORMATO_SUITE_PRESIDENCIAL = "Tipo: Suite Presidencial | Servicio Adicional: %s | Número de Habitaciones: %d";

    private static final float COSTO_BASE = 320.0f;
    private static final int CAPACIDAD = 6;
    private int numeroHabitaciones;

    public SuitePresidencial(int id, EstadoHabitacion estado, ServicioAdicional servicioAdicional, int numeroHabitaciones) {
        super(id, estado, servicioAdicional);
        if (numeroHabitaciones <= 1) {
            throw new IllegalArgumentException("El número de habitaciones debe ser mayor a 1.");
        }
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    private void setNumeroHabitaciones(int numeroHabitaciones) {
        if (numeroHabitaciones <= 1) {
            throw new IllegalArgumentException("El número de habitaciones debe ser mayor a 1.");
        }
        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.printf(FORMATO_SUITE_PRESIDENCIAL, getServicioAdicional(), numeroHabitaciones);
    }
}
