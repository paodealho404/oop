package project.model;
import java.util.Date;
public abstract class Usuario {
    private String nome;
    private String email;
    Date data_associacao;
    public Usuario( String nome, String email){
        setEmail(email);
        setNome(nome);
    }
    public Date getData_associacao() {
        return data_associacao;
    }
    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public void setData_associacao(Date data_associacao) {
        this.data_associacao = data_associacao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public abstract String toString();
}
