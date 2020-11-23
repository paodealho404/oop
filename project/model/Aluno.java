package project.model;
public class Aluno extends Colaborador{
    String tipo;
    public Aluno( String nome, String email, String tipo)
    {
        super(nome, email);
        setTipo(tipo);
    }
    public Aluno( String nome, String email, String link, String tipo)
    {
        super(nome, email, link);
        setTipo(tipo);
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}