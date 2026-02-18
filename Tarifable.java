package ar.edu.ar.ort.parcial2.clases;

public abstract class Habitacion implements Tarifable {
	
	private static final String MSG_TARIFA_INVALIDO = "La tarifa por noche debe ser mayor a 0.";


	private static final String MSG_CAPACIDAD_INVALIDO = "La capacidad debe ser mayor a 0.";


	private static final String MSG_ESTADO_INVALIDO = "Estado inválido.";


	private static final String MSG_ID_INVALIDO = "El ID no puede ser negativo.";


	private static final String FORMATO_HABITACION = "Habitación -- ID: %d | Estado: %s | Capacidad: %d | Tarifa por Noche: %.2f";

	
    private int id;
    private EstadoHabitacion estado; // LIBRE, MANTENIMIENTO, RESERVADA
    private int capacidad;
    private float tarifaPorNoche;

    public Habitacion(int id, EstadoHabitacion estado, int capacidad, float tarifaPorNoche) {
        setId(id);
        setEstado(estado);
        setCapacidad(capacidad);
        setTarifaPorNoche(tarifaPorNoche);
    }

    private void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException(MSG_ID_INVALIDO);
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEstado(EstadoHabitacion estado) {
        if (estado == null) {
            throw new IllegalArgumentException(MSG_ESTADO_INVALIDO);
        }
        this.estado = estado;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    private void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException(MSG_CAPACIDAD_INVALIDO);
        }
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    private void setTarifaPorNoche(float tarifaPorNoche) {
        if (tarifaPorNoche <= 0) {
            throw new IllegalArgumentException(MSG_TARIFA_INVALIDO);
        }
        this.tarifaPorNoche = tarifaPorNoche;
    }

    public float getTarifaPorNoche() {
        return tarifaPorNoche;
    }

    @Override
    public float calcularTarifa() {
        return getTarifaPorNoche();
    }

    public void mostrar() {
        System.out.printf(FORMATO_HABITACION, id, estado, capacidad, tarifaPorNoche);
    }
}
