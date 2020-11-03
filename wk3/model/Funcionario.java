package wk3.model;
public class Funcionario extends Pessoa{
    private int armario;
    private String matricula;
    private Double desconto;
    public Funcionario()
    {
        this("","", 0, -1, 0.0, 15.0);
    }
    public Funcionario(String cpf, String matricula, int idade, int armario, double credito, Double desconto)
    {
        super(cpf, idade, credito, null);
        this.armario = armario;
        this.matricula = matricula;
        this.desconto = desconto;
    }
    public int getArmario() {
        return armario;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setArmario(int armario) {
        this.armario = armario;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        result+= ", MATRÍCULA: ";
        result+= getMatricula();
        result+= ", ARMÁRIO: ";
        result+= getArmario();
        result += ", DESCONTO: ";
        result += getDesconto();
        result+= " }";
        return result;
    }

}