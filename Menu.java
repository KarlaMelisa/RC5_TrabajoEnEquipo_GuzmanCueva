import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Hotel hotel;

    public Menu() {
        scanner = new Scanner(System.in);
        inicializarHotel();
    }

    private void inicializarHotel() {
        System.out.print("Ingrese el número de habitaciones que tiene el hotel en total: ");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();
        hotel = new Hotel(numHabitaciones);
    }

    public void mostrar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar todas las habitaciones y su disponibilidad.");
            System.out.println("2. Crear una nueva reserva.");
            System.out.println("3. Liberar una habitación reservada.");
            System.out.println("4. Revisar la disponibilidad de una habitación.");
            System.out.println("5. Mostrar todas las reservas.");
            System.out.println("6. Salir.");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> hotel.mostrarHabitaciones();
                case 2 -> crearReserva();
                case 3 -> liberarHabitacion();
                case 4 -> revisarDisponibilidad();
                case 5 -> hotel.mostrarReservas();
                case 6 -> salir = true;
                default -> System.out.println("\nOpción no válida. Intente de nuevo.");
            }
        }

        System.out.println("\nGracias por usar el sistema de reservas.");
    }

    private void crearReserva() {
        System.out.print("Ingrese el nombre del anfitrión de la reserva: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el número de habitación: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la fecha de inicio (mm/dd/aaaa): ");
        String fechaInicio = scanner.nextLine();

        System.out.print("Ingrese la fecha de fin (mm/dd/aaaa): ");
        String fechaFin = scanner.nextLine();

        hotel.crearReserva(nombre, numero, fechaInicio, fechaFin);
    }

    private void liberarHabitacion() {
        System.out.print("Ingrese el número de la habitación que desea liberar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        hotel.liberarReserva(numero);
    }

    private void revisarDisponibilidad() {
        System.out.print("Ingrese el número de la habitación a revisar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        hotel.consultarDisponibilidad(numero);
    }
}
