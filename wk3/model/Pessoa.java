package wk3.model;
public class Pessoa{
    int idade;
    String cpf;
    double credito;
    Livro compra;
    public Pessoa()
    {
        this("",0,0.0, null);
    }
    public Pessoa(String cpf, int idade, double credito, Livro compra)
    {
        this.idade = idade;
        this.cpf = cpf;
        this.credito = credito;
        this.compra = compra;
    }
    public double getCredito() {
        return credito;
    }
    public String getCpf() {
        return cpf;
    }
    public int getIdade() {
        return idade;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setCredito(double credito) {
        this.credito = credito;
    }
    public Livro getCompra() {
        return compra;
    }
    public void setCompra(Livro compra) {
        this.compra = compra;
    }
    public void pagar(double value)
    {
        credito -= value;
    }
    public String parseText()
    {
        String result = "{ CPF: ";
        result+= getCpf();
        result+= ", IDADE: ";
        result+= getIdade();
        return result;
    }
    public String toString()
    {
        String result = "{ CPF: ";
        result+= getCpf();
        result+= ", IDADE: ";
        result+= getIdade();
        result+= ", CREDITO: ";
        result+= ", LIVRO COMPRADO: ";
        Livro a = getCompra();
        result+= (a!=null) ? (a): ("AINDA NÃO EFETUOU COMPRAS");
        result+=", SALDO: ";
        result+= getCredito();
        return result;
    }
}
