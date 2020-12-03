package project.model;

import java.util.Collections;
import java.util.Vector;
public class Professor extends Colaborador{
    private Vector<Orientacao> orientacao;
    public Professor(String nome, String email)
    {
        super(nome, email);
        this.orientacao = new Vector<Orientacao>();
    }
    public Vector<Orientacao> getOrientacao() {
        return orientacao;
    }
    public void setOrientacao(Vector<Orientacao> orientacao) {
        this.orientacao = orientacao;
    }
    @Override
    public String toString() {
        return "Professor| "+super.toString();
    }
    @Override
    public String relatorioColaborador() {
        String res = super.relatorioColaborador();
        Vector<ProducaoAcademica> producoes = new Vector<ProducaoAcademica>();
        producoes.addAll(super.getPublicacao());
        producoes.addAll(getOrientacao());
        Collections.sort(producoes);
        Collections.reverse(producoes);
        res+="Produção Academica:\n";
        if(getPublicacao().size() == 0 && getOrientacao().size()==0) res+=" NENHUMA PUBLICAÇÃO, NENHUMA ORIENTAÇÃO\n";
        else if(getPublicacao().size() == 0) res+=", NENHUMA PUBLICAÇÃO\n";
        else if(getOrientacao().size() == 0) res+=", NENHUMA ORIENTAÇÃO\n"; 
        for (int i = 0; i < producoes.size(); i++) {
            if(producoes.elementAt(i) instanceof Publicacao) {
                res+= "PUBLICAÇÃO: ";
            }
            if(producoes.elementAt(i) instanceof Orientacao) {
                res+= "ORIENTAÇÃO: ";
            }
            res+= producoes.elementAt(i);
            res+="\n";
        }
        return res;
        }
}