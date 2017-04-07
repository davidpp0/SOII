package reservas;


public class adicionarReserva implements java.io.Serializable {
    ReservasImpl reserva;
     
    public adicionarReserva(ReservasImpl reserva) {
       this.reserva=reserva;
    }
}
