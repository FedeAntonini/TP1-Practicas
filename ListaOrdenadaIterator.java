package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

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
    
    private Habitacion[][] habitaciones;
    private ListaClientesOrdenadaPorId clientes; // Lista ordenada de clientes
    private PilaNodos<Reserva> historialReservas; // Pila para el historial de reservas
    private int[] reservasPorTipoHabitacion; // Array para almacenar el conteo de reservas por tipo de habitación

    public Hotel() {
        this.habitaciones = new Habitacion[PISOS][HABITACIONES_POR_PISO];
        this.clientes = new ListaClientesOrdenadaPorId();
        this.historialReservas = new PilaNodos<>();
        this.reservasPorTipoHabitacion = new int[3]; // Tres tipos de habitaciones: Estándar, Suite y Suite Presidencial

        // Inicializar las habitaciones del hotel
        inicializarHabitaciones();
    }

    private void inicializarHabitaciones() {
        int id = 1;

        // Asignar habitaciones Estándar
        int pisoEstandar = determinarPisoPorTipoHabitacion("Estándar");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
            habitaciones[pisoEstandar][i] = new HabitacionEstandar(id++, EstadoHabitacion.LIBRE);
        }

        // Asignar habitaciones Suite
        int pisoSuite = determinarPisoPorTipoHabitacion("Suite");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
            habitaciones[pisoSuite][i] = new Suite(id++, EstadoHabitacion.LIBRE, ServicioAdicional.DESAYUNO); // Asumiendo desayuno incluido como default
        }

        // Asignar habitaciones Suite Presidencial
        int pisoSuitePresidencial = determinarPisoPorTipoHabitacion("Suite Presidencial");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
            habitaciones[pisoSuitePresidencial][i] = new SuitePresidencial(id++, EstadoHabitacion.LIBRE, ServicioAdicional.SPA, 2); // Asumiendo 2 habitaciones como default
        }
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void procesarReserva(int clienteDni, String tipoHabitacion, String fechaInicio, int noches) throws IllegalArgumentException {   
        procesarReserva(clienteDni, tipoHabitacion, fechaInicio, noches, null);
    }

    public void procesarReserva(int clienteDni, String tipoHabitacion, String fechaInicio, int noches, ServicioAdicional servicioAdicional) throws IllegalArgumentException {
    	if (!tipoHabitacion.equals("Suite") && !tipoHabitacion.equals("Suite Presidencial") && servicioAdicional != null) {
            throw new IllegalArgumentException(MSG_RESERVA_ADICIONAL);
        }
    	
    	
    	Cliente cliente = buscarClientePorDni(clienteDni);
        Habitacion habitacion = buscarHabitacionDisponible(tipoHabitacion, servicioAdicional);
        
        if (cliente == null) {
            throw new IllegalArgumentException(MSG_CLIENTE_NO_ENCONTRADO);
        }

        if (habitacion == null) {
            throw new IllegalArgumentException(MSG_SIN_HABITACION_DISPONIBLE);
        }

        Reserva reserva = new Reserva(cliente, habitacion, fechaInicio, noches);
        historialReservas.push(reserva); // Agregar la reserva a la pila de historial
        habitacion.setEstado(EstadoHabitacion.RESERVADA);
        actualizarReservasPorTipoHabitacion(habitacion);
        System.out.println("Reserva realizada con éxito para el cliente DNI: " + clienteDni + " con servicio adicional: " + servicioAdicional);
    }

    private void actualizarReservasPorTipoHabitacion(Habitacion habitacion) {
        if (habitacion instanceof HabitacionEstandar) {
            reservasPorTipoHabitacion[PISO_ESTANDAR]++;
        } else if (habitacion instanceof Suite && !(habitacion instanceof SuitePresidencial)) {
            reservasPorTipoHabitacion[PISO_SUITE]++;
        } else if (habitacion instanceof SuitePresidencial) {
            reservasPorTipoHabitacion[PISO_PRESIDENCIAL]++;
        }
    }

    private Cliente buscarClientePorDni(int dni) {
        return clientes.search(dni);
    }

    private Habitacion buscarHabitacionDisponible(String tipoHabitacion, ServicioAdicional servicioAdicional) {
        int piso = determinarPisoPorTipoHabitacion(tipoHabitacion);
        if (piso == -1) {
            return null; // Tipo de habitación inválido
        }

        // Buscar habitación libre en el piso determinado
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
            Habitacion habitacion = habitaciones[piso][i];
            if (habitacion.getEstado().equals(EstadoHabitacion.LIBRE)) {
                if (habitacion instanceof Suite) {
                    ((Suite) habitacion).setServicioAdicional(servicioAdicional);
                } else if (habitacion instanceof SuitePresidencial) {
                    ((SuitePresidencial) habitacion).setServicioAdicional(servicioAdicional);
                }
                return habitacion;
            }
        }

        return null; // No se encontró habitación libre del tipo solicitado
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
        System.out.println("Historial de Reservas:");
        while (!historialReservas.isEmpty()) {
            Reserva reserva = historialReservas.pop();
            reserva.mostrar();
        }
    }

    public void mostrarReservasPorTipoHabitacion() {
        System.out.printf(FORMATO_SALIDA,
                reservasPorTipoHabitacion[0], reservasPorTipoHabitacion[1], reservasPorTipoHabitacion[2]);
    }
}
