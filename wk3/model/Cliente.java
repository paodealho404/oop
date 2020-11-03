package wk3.model;
public class Cliente extends Pessoa {
    private Double desconto;
    public Cliente()
    {
        this("",0, 0.0, 0.0, null);
    }
    public Cliente(String cpf, int idade, double credito, Double desconto, Livro compra)
    {
        super(cpf, idade, credito, null);
        this.desconto = desconto;
        
    }
    public Double getDesconto() {
        return desconto;
    }
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    public String toString()
    {
        String result = super.toString();
        result+= ", DESCONTO: ";
        result+= getDesconto();
        result+= " }";
        return result;
    }
}