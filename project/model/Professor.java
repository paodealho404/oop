package project.model;
import java.util.Vector;
public class Professor extends Colaborador{
    private Vector<Orientacao> orientacao;
    public Professor(String nome, String email)
    {
        super(nome, email);
    }
    @Override
    public String toString() {
        return super.toString();
    }
    public void addOrientacao(Orientacao orientacao)
    {
        this.orientacao.add(orientacao);
    }
    public String professorInfo() {
        String res = super.toString();
        res+=", Orientacoes: ";
        if(orientacao.size()>0) res+="{";
        else res+= "Nenhuma";
        for (int i = 0; i < orientacao.size(); i++) {
            res+= orientacao.elementAt(i);
            if(i<orientacao.size()-1) res+=", ";
            else res+="}";
        }
        res+=" }";
        return res;
    }
}