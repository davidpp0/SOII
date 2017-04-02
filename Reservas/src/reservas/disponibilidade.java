package reservas;

import java.util.Date;


public class disponibilidade implements java.io.Serializable {
    int hora;
    Date data;
    Espaço espaço;
    
    public disponibilidade(int hora, Date data, Espaço espaço){
        this.hora = hora;
        this.data = data;
        this.espaço = espaço;
    }
}
