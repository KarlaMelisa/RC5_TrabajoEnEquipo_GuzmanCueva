public class Reserva {
    private Habitacion habitacion;
    private String nombreCliente;
    private String fechaInicio;
    private String fechaFin;

    public Reserva(Habitacion habitacion, String nombreCliente, String fechaInicio, String fechaFin) {
        this.habitacion = habitacion;
        this.nombreCliente = nombreCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Habitacion getHabitacion(){
        return habitacion;
    }

    @Override
    public String toString() {
        return "\nReserva: " + habitacion +
                ", a nombre del cliente '" + nombreCliente + "'" +
                ", con fecha de inicio " + fechaInicio +
                " y fecha de fin " + fechaFin +
                ".";
    }
}