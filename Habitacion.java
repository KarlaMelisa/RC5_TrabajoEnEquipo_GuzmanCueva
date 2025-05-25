public class Habitacion {
    private int numero;
    private boolean disponible;

    public Habitacion(int numero){
        this.numero=numero;
        this.disponible=true;
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void ocupar() {
        this.disponible=false;
    }

    public void liberar(){
        this.disponible=true;
    }

    @Override
    public String toString() {
        return "Habitacion " +
                "numero " + numero +
                (disponible ?  " (disponible).":" (ocupada)");
    }
}
