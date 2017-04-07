package reservas;

public enum Espaco {
    espaço1("futsal",10),
    espaço2("tenis",8),
    espaço3("padel",6);
    
    private String nome;
    private int custo;
    
    Espaco(String nome, int custo) {
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
