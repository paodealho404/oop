package project.model;

import java.util.Collections;
import java.util.Vector;
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
    public String relatorioProdutividade() {
        String res = super.relatorioProdutividade();
        res+= "Produção Academica associada: ";    
        Vector<ProducaoAcademica> producoes = new Vector<ProducaoAcademica>(super.getPublicacao());   
        if(producoes.size()==0) res+="Nenhuma";
        else {
            res+="\n";
            Collections.sort(producoes, Collections.reverseOrder());
            for (int i = 0; i < producoes.size(); i++) {
                res+=producoes.elementAt(i)+"\n";
            }
        }
           
        //    
        //    System.out.println("Ordenando aluno");
        //    Collections.sort(producoes);
        //    Collections.reverse(producoes);

        //    for (int i = 0; i < publicacao.size(); i++) {
        //       res+= "Publicação: ";
        //       res+= publicacao.elementAt(i);
        //       if(i<publicacao.size()-1) res+=", \n";
        //    }
        return res;
    }
    
}