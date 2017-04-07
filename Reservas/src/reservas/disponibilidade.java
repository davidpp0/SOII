package reservas;

import java.util.Date;


public class disponibilidade implements java.io.Serializable {
    int hora;
    Date data;
    String nomeEspaço;
    
    public disponibilidade(int hora, Date data,String nomeEspaço){
        this.hora = hora;
        this.data = data;
        this.nomeEspaço = nomeEspaço;
    }
}
