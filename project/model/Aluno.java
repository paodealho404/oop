package project.model;
import java.util.Vector;
import java.util.Collections;
public class Aluno extends Colaborador{
    String tipo;
    public Aluno( String nome, String email) {
        super(nome,email);
    }
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
    @Override
    public String toString() {
        String res = "Aluno| " + super.toString();
        res+= ", Tipo de Aluno: " + getTipo();
        return res;
    }
    @Override
    public String relatorioColaborador() {
        String res = "Aluno| " + super.relatorioColaborador();
        res+= ", PUBLICACOES: ";
        if(publicacao.size()==0) res += "NENHUMA";
        else {
           Vector<ProducaoAcademica> producoes = new Vector<ProducaoAcademica>();
           producoes.addAll(super.getPublicacao());
           Collections.sort(producoes);
           Collections.reverse(producoes);
           for (int i = 0; i < publicacao.size(); i++) {
              res+= "PUBLICAÇÃO: ";
              res+= publicacao.elementAt(i);
              if(i<publicacao.size()-1) res+=", ";
           }
        }
        return res;
    }
    
}