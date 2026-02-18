package ar.edu.ar.ort.parcial2.clases;

public class Suite extends Habitacion {
	private static final String FORMATO_SUITE = "Tipo: Suite | Servicio Adicional: %s";

    private static final float COSTO_BASE = 150.0f;
    private static final int CAPACIDAD = 4;
    private ServicioAdicional servicioAdicional;

    public Suite(int id, EstadoHabitacion estado, ServicioAdicional servicioAdicional) {
        super(id, estado, CAPACIDAD, COSTO_BASE);
        this.servicioAdicional = servicioAdicional;
    }

    public ServicioAdicional getServicioAdicional() {
        return servicioAdicional;
    }

    public void setServicioAdicional(ServicioAdicional servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }
    
    @Override
    public float calcularTarifa() {
        return super.calcularTarifa() + (servicioAdicional != null ? servicioAdicional.getCostoExtra() : 0);
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.printf(FORMATO_SUITE, servicioAdicional);
    }
}
