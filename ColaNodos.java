package ar.edu.ar.ort.parcial2.clases;

public class HabitacionEstandar extends Habitacion {
	private static final String FORMATO_ESTANDAR = "Tipo: Estándar";
	
    private static final float COSTO_BASE = 50.0f;
    private static final int CAPACIDAD = 2;

    public HabitacionEstandar(int id, EstadoHabitacion estado) {
        super(id, estado, CAPACIDAD, COSTO_BASE);
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println(FORMATO_ESTANDAR);
    }
}
