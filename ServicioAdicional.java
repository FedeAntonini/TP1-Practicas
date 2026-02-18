package ar.edu.ar.ort.parcial2;

import ar.edu.ar.ort.parcial2.clases.Cliente;
import ar.edu.ar.ort.parcial2.clases.Hotel;
import ar.edu.ar.ort.parcial2.clases.ServicioAdicional;

public class Principal {
    private static final String MSG_ERROR_RESERVA = "Error al procesar la reserva para el cliente DNI: %s - %s";
    
	private static Hotel hotel = new Hotel();

    public static void main(String[] args) {
        // Agregar clientes
        agregarClientes();

        // Procesar reservas
        procesarReserva(12345678, "Estándar", "01-01-2024", 3);
        procesarReserva(87654321, "Estándar", "01-08-2024", 1);
        procesarReserva(87654321, "Estándar", "08-06-2024", 1);
        procesarReserva(87654321, "Estándar", "20-06-2024", 1);
        procesarReserva(87654321, "Estándar", "15-12-2024", 1);
        
        procesarReserva(87654321, "Suite", "05-01-2024", 2);
        procesarReserva(11223344, "Suite Presidencial", "10-01-2024", 4);
        procesarReservaConAdicional(12345678, "Estándar", "15-01-2024", 2, ServicioAdicional.SPA);
        procesarReservaConAdicional(12345678, "Suite", "15-01-2024", 2, ServicioAdicional.SPA);
        procesarReservaConAdicional(87654321, "Suite Presidencial", "20-01-2024", 3, ServicioAdicional.WIFI);
        procesarReservaConAdicional(11223344, "Suite", "25-01-2024", 1, ServicioAdicional.DESAYUNO);

        // Intentar una reserva con habitación ocupada
        procesarReserva(12345678, "Estándar", "30-01-2024", 2);

        // Mostrar historial de reservas
        hotel.mostrarHistorialReservas();

        // Mostrar reservas por tipo de habitación
        hotel.mostrarReservasPorTipoHabitacion();
    }

    private static void agregarClientes() {
        agregarCliente(12345678, "Juan Pérez");
        agregarCliente(87654321, "María Gómez");
        agregarCliente(11223344, "Carlos Ruiz");
        agregarCliente(0, "Carlos Ruiz");
        agregarCliente(44556677, "Ana Martínez");
        agregarCliente(99887766, "Luis Fernández");
        agregarCliente(4556766, "");
    }
    
    private static void agregarCliente(int dni, String nombre) {
        Cliente cliente = new Cliente(dni, nombre);
        hotel.agregarCliente(cliente);
    }

    private static void procesarReserva(int clienteDni, String tipoHabitacion, String fechaInicio, int noches) { 
        hotel.procesarReserva(clienteDni, tipoHabitacion, fechaInicio, noches);
    }

    private static void procesarReservaConAdicional(int clienteDni, String tipoHabitacion, String fechaInicio, int noches, ServicioAdicional servicioAdicional) {     
        hotel.procesarReserva(clienteDni, tipoHabitacion, fechaInicio, noches, servicioAdicional);
    }
}
