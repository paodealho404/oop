package wk3.model;
public class Pessoa{
    int idade;
    String cpf;
    double carteira;
    Livro aluguel;
    public Pessoa()
    {
        this.idade = 0;
        this.cpf = "";
        this.carteira = 0;
        this.aluguel = null;
    }
    public String getCpf() {
        return cpf;
    }
    public int getIdade() {
        return idade;
    }
    public Livro getAluguel() {
        return aluguel;
    }
    public double getCarteira() {
        return carteira;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setAluguel(Livro aluguel) {
        this.aluguel = aluguel;
    } 
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setCarteira(double carteira) {
        this.carteira = carteira;
    }
    void pagar(double value) {
        carteira-=value;
    }
}
