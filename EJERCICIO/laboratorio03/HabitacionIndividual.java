package laboratorio03;

public class HabitacionIndividual extends Habitacion
        implements ServicioLimpieza {

    public HabitacionIndividual(int numero, double precioBase) {
        super(numero, "Individual", precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecio();
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println(
            "Habitacion " + getNumero() + ": limpieza solicitada."
        );
    }
}
