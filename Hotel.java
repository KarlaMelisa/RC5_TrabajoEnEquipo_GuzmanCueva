import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;


    public Hotel(int numHabitaciones){
        habitaciones=new ArrayList<>();
        reservas=new ArrayList<>();
        for (int i=1; i<=numHabitaciones; i++){
            habitaciones.add(new Habitacion(i));
        }
    }

    public void mostrarReservas(){
        if (reservas.isEmpty()){
            System.out.println("\nNo hay reservas registradas.");
        }else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }


    public void mostrarHabitaciones(){
        for (Habitacion habitacion:habitaciones){
            System.out.println(habitacion);
        }
    }

    public void crearReserva(String cliente, int numHabitacion, String inicio, String fin){
        for (Habitacion habitacion : habitaciones){
            if (habitacion.getNumero()==numHabitacion && habitacion.estaDisponible()){
                Reserva nuevaReserva=new Reserva(habitacion, cliente, inicio, fin);
                reservas.add(nuevaReserva);
                habitacion.ocupar();
                System.out.println("\nReserva creada con exito.");
                return;
            }
        }
        System.out.println("\nReserva fallida. Habitacion ocupada");
    }

    public void liberarReserva(int numHabitacion){
        for (Reserva reserva:reservas){
            if (reserva.getHabitacion().getNumero()==numHabitacion){
                reservas.remove(reserva);
                reserva.getHabitacion().liberar();
                System.out.println("\nHabitacion numero "+numHabitacion+" liberada con exito.");
                return;
            }
        }
        System.out.println("\nError liberando la reserva. Habitacion no reservada");
    }

    public void consultarDisponibilidad(int numHabitacion){
        boolean flag=false;
        for (Habitacion habitacion:habitaciones){
            if (habitacion.getNumero() == numHabitacion) {
                String estado = habitacion.estaDisponible() ? "está disponible" : "no está disponible";
                System.out.println("\nHabitación número " + numHabitacion + " " + estado + ".");
            }
        }
    }
}
