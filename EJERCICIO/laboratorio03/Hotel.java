package laboratorio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new HabitacionIndividual(101, 120.0));
        habitaciones.add(new HabitacionDoble(102, 150.0));
        habitaciones.add(new HabitacionSuite(103, 200.0));

        habitaciones.get(2).ponerEnMantenimiento();

        System.out.println("=== INFORME DE HABITACIONES (polimorfismo) ===");
        for (Habitacion h : habitaciones) {
            h.generarInforme();
        }

        System.out.println("\n=== SERVICIOS DISPONIBLES POR HABITACION ===");
        for (Habitacion h : habitaciones) {

            System.out.println("Habitacion " + h.getNumero() + ":");

            if (h instanceof ServicioLimpieza) {
                ((ServicioLimpieza) h).solicitarLimpieza();
            }

            if (h instanceof ServicioComida) {
                ((ServicioComida) h).solicitarComida("Desayuno continental");
            } else {
                System.out.println(
                    "  (no ofrece servicio de comida a la habitacion)"
                );
            }

            if (h instanceof ServicioLavanderia) {
                ((ServicioLavanderia) h).solicitarLavanderia();
            } else {
                System.out.println(
                    "  (no ofrece servicio de lavanderia)"
                );
            }
        }

        System.out.println("\n=== RESERVA DE HABITACION ===");
        System.out.print("Elija el numero de habitacion (101, 102 o 103): ");
        int numeroElegido = teclado.nextInt();

        Habitacion habitacionElegida = null;
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroElegido) {
                habitacionElegida = h;
            }
        }

        if (habitacionElegida == null) {
            System.out.println("Habitacion no encontrada.");
            teclado.close();
            return;
        }

        System.out.println(
            "Habitacion " + habitacionElegida.getNumero() +
            " disponible: " + habitacionElegida.estaDisponible(1, 5)
        );

        if (!habitacionElegida.estaDisponible(1, 5)) {
            System.out.println(
                "No se puede continuar: la habitacion no esta disponible " +
                "(revise si esta en mantenimiento)."
            );
            teclado.close();
            return;
        }

        System.out.println("Seleccione una politica de cancelacion:");
        System.out.println("1. Flexible");
        System.out.println("2. Moderada");
        System.out.println("3. Estricta");
        System.out.print("Opcion: ");

        int opcion = teclado.nextInt();

        PoliticaCancelacion politica;

        if (opcion == 1) {
            politica = new PoliticaCancelacionFlexible();
        } else if (opcion == 2) {
            politica = new PoliticaCancelacionModerada();
        } else {
            politica = new PoliticaCancelacionEstricta();
        }

        System.out.print("Ingrese las horas antes del check-in: ");
        int horas = teclado.nextInt();

        System.out.print("Ingrese el importe de la reserva: ");
        double importe = teclado.nextDouble();

        Reserva reserva = new Reserva(
            habitacionElegida,
            1,
            5,
            horas,
            importe,
            politica
        );

        boolean reservada = habitacionElegida.reservar(reserva);

        if (reservada) {
            System.out.println("Habitacion reservada correctamente.");
        } else {
            System.out.println("No se pudo reservar la habitacion.");
        }

        System.out.println(
            "Habitacion " + habitacionElegida.getNumero() +
            " disponible: " + habitacionElegida.estaDisponible(1, 5)
        );

        System.out.println("\n=== CANCELACION ===");
        reserva.cancelar();

        System.out.println(
            "Habitacion " + habitacionElegida.getNumero() +
            " disponible: " + habitacionElegida.estaDisponible(1, 5)
        );

        teclado.close();
    }
}
