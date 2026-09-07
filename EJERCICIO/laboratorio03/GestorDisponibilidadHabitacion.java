package laboratorio03;

import java.util.ArrayList;

public class GestorDisponibilidadHabitacion {

    private ArrayList<Reserva> reservas;

    public GestorDisponibilidadHabitacion() {
        reservas = new ArrayList<>();
    }

    public boolean estaDisponible(int fechaInicio, int fechaFin) {

        for (Reserva reserva : reservas) {

            if (fechaInicio < reserva.getFechaFin()
                    && fechaFin > reserva.getFechaInicio()) {

                return false;
            }
        }

        return true;
    }

    public boolean reservar(Reserva reserva) {

        if (estaDisponible(
                reserva.getFechaInicio(),
                reserva.getFechaFin())) {

            reservas.add(reserva);
            return true;
        }

        return false;
    }

    public void liberarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }
}
