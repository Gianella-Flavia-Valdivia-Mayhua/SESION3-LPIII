package laboratorio03;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return reserva.getHorasAntesCheckIn() >= 24;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0;
    }
}
