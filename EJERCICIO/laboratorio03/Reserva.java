package laboratorio03;

public class Reserva {

    private Habitacion habitacion;
    private int fechaInicio;
    private int fechaFin;
    private int horasAntesCheckIn;
    private double importe;

    private PoliticaCancelacion politicaCancelacion;

    public Reserva(Habitacion habitacion,
                    int fechaInicio,
                    int fechaFin,
                    int horasAntesCheckIn,
                    double importe,
                    PoliticaCancelacion politicaCancelacion) {

        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasAntesCheckIn = horasAntesCheckIn;
        this.importe = importe;
        this.politicaCancelacion = politicaCancelacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public int getHorasAntesCheckIn() {
        return horasAntesCheckIn;
    }

    public double getImporte() {
        return importe;
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public void cancelar() {

        if (politicaCancelacion.puedeCancelar(this)) {

            double penalizacion =
                    politicaCancelacion.calcularPenalizacion(this);

            habitacion.liberarReserva(this);

            System.out.println("Reserva cancelada.");
            System.out.println("Penalizacion: S/. " + penalizacion);

        } else {

            System.out.println("La reserva no se puede cancelar.");
        }
    }
}
