package laboratorio03;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return false;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return reserva.getImporte();
    }
}
