package beansclass;
/**
 * @author mateus.zlcarmo
 */
public class ger_residuos {
    private int id;
    private String cidade;
    private String comunidade;
    private int n_decaixas;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getcidade(){
        return cidade;
    }
    
    public void setcidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getcomunidade(){
        return comunidade;
    }
    
    public void setcomunidade(String comunidade) {
        this.comunidade = comunidade;
    }
    
        public int getn_decaixas(){
        return n_decaixas;
    }
    
    public void setn_decaixas(int n_decaixas) {
        this.n_decaixas = n_decaixas;
    }
    
}
