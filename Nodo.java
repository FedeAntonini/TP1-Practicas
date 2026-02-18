package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

public class Hotel {
    private static final String MSG_RESERVA_ADICIONAL = "La reserva sin servicio adicional solo está permitida para Suite y Suite Presidencial.";
	private static final String MSG_SIN_HABITACION_DISPONIBLE = "No hay habitaciones disponibles del tipo solicitado.";
	private static final String MSG_CLIENTE_NO_ENCONTRADO = "Cliente no encontrado.";
    
	private static final int PISO_PRESIDENCIAL = 2;
	private static final int PISO_SUITE = 1;
	private static final int PISO_ESTANDAR = 0;
	
	private static final String FORMATO_SALIDA = "Reservas por Tipo de Habitación:%nEstándar: %d%nSuite: %d%nSuite Presidencial: %d%n";
	
	private static final int PISOS = 3;
    private static final int HABITACIONES_POR_PISO = 5;
    

    public Hotel() {

        // Inicializar las habitaciones del hotel
        inicializarHabitaciones();
    }

    private void inicializarHabitaciones() {
        int id = 1;

        int pisoEstandar = determinarPisoPorTipoHabitacion("Estándar");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
        	// COMPLETAR
        }

        // Asignar habitaciones Suite
        int pisoSuite = determinarPisoPorTipoHabitacion("Suite");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
            // COMPLETAR: Asumiendo desayuno incluido por defecto
        }

        // Asignar habitaciones Suite Presidencial
        int pisoSuitePresidencial = determinarPisoPorTipoHabitacion("Suite Presidencial");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
        	// COMPLETAR: Asumiendo 2 habitaciones por defecto
        }
    }

    public void agregarCliente(Cliente cliente) {
    	// COMPLETAR 
    }

    public void procesarReserva(int clienteDni, String tipoHabitacion, String fechaInicio, int noches) throws IllegalArgumentException {   
    	// COMPLETAR
    }

    public void procesarReserva(int clienteDni, String tipoHabitacion, String fechaInicio, int noches, ServicioAdicional servicioAdicional) throws IllegalArgumentException {
    	// COMPLETAR
    	
        System.out.println("Reserva realizada con éxito para el cliente DNI: " + clienteDni + " con servicio adicional: " + servicioAdicional);
    }

    private void actualizarReservasPorTipoHabitacion(Habitacion habitacion) {
      
    }

    private Cliente buscarClientePorDni(int dni) {
        // COMPLETAR

		return null;
    }

    private Habitacion buscarHabitacionDisponible(String tipoHabitacion, ServicioAdicional servicioAdicional) {
    	// COMPLETAR

		return null;
    }

    private int determinarPisoPorTipoHabitacion(String tipoHabitacion) {
        switch (tipoHabitacion) {
            case "Estándar":
                return PISO_ESTANDAR;
            case "Suite":
                return PISO_SUITE;
            case "Suite Presidencial":
                return PISO_PRESIDENCIAL;
            default:
                return -1; // Tipo de habitación inválido
        }
    }

    public void mostrarHistorialReservas() {
    	// COMPLETAR
    }

    public void mostrarReservasPorTipoHabitacion() {
    	// COMPLETAR
    }
}
