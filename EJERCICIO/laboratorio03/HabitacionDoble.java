package laboratorio03;

public class HabitacionDoble extends Habitacion
        implements ServicioLimpieza, ServicioComida {

    private static final double RECARGO = 1.20; // 20% adicional

    public HabitacionDoble(int numero, double precioBase) {
        super(numero, "Doble", precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecio() * RECARGO;
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println(
            "Habitacion " + getNumero() + ": limpieza solicitada."
        );
    }

    @Override
    public void solicitarComida(String pedido) {
        System.out.println(
            "Habitacion " + getNumero() + ": pedido de comida - " + pedido
        );
    }
}
