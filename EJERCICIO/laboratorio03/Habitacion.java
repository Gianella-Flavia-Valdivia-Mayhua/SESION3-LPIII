package laboratorio03;

public abstract class Habitacion {

    private int numero;
    private String tipo;
    private double precio;
    private boolean enMantenimiento;

    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.enMantenimiento = false;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();
    }

    public abstract double calcularPrecio();

    public boolean estaDisponible(int fechaInicio, int fechaFin) {
        if (enMantenimiento) {
            return false;
        }
        return gestorDisponibilidad.estaDisponible(fechaInicio, fechaFin);
    }

    public boolean reservar(Reserva reserva) {
        if (enMantenimiento) {
            return false;
        }
        return gestorDisponibilidad.reservar(reserva);
    }

    public void liberarReserva(Reserva reserva) {
        gestorDisponibilidad.liberarReserva(reserva);
    }

    public void ponerEnMantenimiento() {
        this.enMantenimiento = true;
    }

    public void quitarDeMantenimiento() {
        this.enMantenimiento = false;
    }

    public boolean isEnMantenimiento() {
        return enMantenimiento;
    }

    public void generarInforme() {
        System.out.println(
            "Habitacion " + numero +
            " - Tipo: " + tipo +
            " - Precio final: S/. " + calcularPrecio() +
            " - En mantenimiento: " + enMantenimiento
        );
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public GestorDisponibilidadHabitacion getGestorDisponibilidad() {
        return gestorDisponibilidad;
    }
}
