package project.model;

public class Pesquisador extends Colaborador {
    private String vinculo;
    public Pesquisador(String nome, String email) {
        super(nome, email);
    }
    public String getVinculo() {
        return vinculo;
    }
    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }
    @Override
    public String toString() {
        String res = "Pesquisador| ";
        res+= super.toString();
        return res;
    }
    public String relatorioProdutividade() {
        return super.relatorioProdutividade();
    }
}
