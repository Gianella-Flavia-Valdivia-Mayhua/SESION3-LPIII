package laboratorio03;

public class PoliticaCancelacionModerada implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return reserva.getHorasAntesCheckIn() >= 72;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return reserva.getImporte() * 0.50;
    }
}
