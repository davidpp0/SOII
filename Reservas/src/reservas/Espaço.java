package reservas;

public enum Espaço {
    espaço1("futsal",10),
    espaço2("tenis",8),
    espaço3("padel",6);
    
    private String nome;
    private int custo;
    
    Espaço(String nome, int custo) {
        this.nome=nome;
        this.custo = custo;
    }
        
        String getNome(){
            return this.nome;
        }
    
        int getCusto() {
            return this.custo;
    }
       
}
