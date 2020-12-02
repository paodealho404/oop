package project.model;

import java.util.Collections;
import java.util.Vector;
public class Professor extends Colaborador{
    private Vector<Orientacao> orientacao;
    public Professor(String nome, String email)
    {
        super(nome, email);
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
    public void addOrientacao(Orientacao orientacao)
    {
        this.orientacao.add(orientacao);
    }
    public String professorInfo() {
        String res = "Professor| "+ super.relatorioColaborador();
        Vector<ProducaoAcademica> producoes = new Vector<ProducaoAcademica>();
        producoes.addAll(super.getPublicacao());
        producoes.addAll(getOrientacao());
        Collections.sort(producoes);
        Collections.reverse(producoes);
        if(getPublicacao().size() == 0||getOrientacao().size()==0) {
            if(getPublicacao().size() == 0 && getOrientacao().size()==0){
                res+="NENHUMA PUBLICAÇÃO, NENHUMA ORIENTAÇÃO";
            }
            else if(getPublicacao().size() == 0) {
                res+="NENHUMA PUBLICAÇÃO";
            }
            else if(getOrientacao().size() == 0) {
                res+="NENHUMA ORIENTAÇÃO";
            }
        } 
        else {
           for (int i = 0; i < producoes.size(); i++) {
              if(producoes.elementAt(i) instanceof Publicacao) {
                  res+= "PUBLICAÇÃO: ";
              }
              else if(producoes.elementAt(i) instanceof Orientacao) {
                  res+= "ORIENTAÇÃO: ";
              }
              res+= producoes.elementAt(i);
              if(i<producoes.size()-1) res+="\n ";
           }
        }
        return res;
    }
}