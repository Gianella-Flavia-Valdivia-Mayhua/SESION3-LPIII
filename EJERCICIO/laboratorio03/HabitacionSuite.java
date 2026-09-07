package laboratorio03;

public class HabitacionSuite extends Habitacion
        implements ServicioLimpieza, ServicioComida, ServicioLavanderia {

    private static final double RECARGO = 1.50; // 50% adicional

    public HabitacionSuite(int numero, double precioBase) {
        super(numero, "Suite", precioBase);
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

    @Override
    public void solicitarLavanderia() {
        System.out.println(
            "Habitacion " + getNumero() + ": servicio de lavanderia solicitado."
        );
    }
}
