package project.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Vector;
public class Projeto implements Comparable<Projeto>{
    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String agenciaFinanciadora;
    private double valorFinanciado;
    private String objetivo;
    private String descricao;
    private Vector<Colaborador> participantes;
    private Vector<Publicacao> publicacoes;
    private boolean valid;
    private String status;
    public Projeto(String titulo, LocalDate dataInicio, LocalDate dataFim, String agenciaFinanciadora, double valorFinanciado, String objetivo, String descricao, Vector<Colaborador> participantes)
    {
        this.titulo = titulo;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.publicacoes = new Vector<Publicacao>();
        this.valid = checkValid();
    }
    public boolean getValid() {
        return valid;
    }
    public String getAgenciaFinanciadora() {
        return agenciaFinanciadora;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public Vector<Colaborador> getParticipantes() {
        return participantes;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getStatus() {
        return status;
    }
    public double getValorFinanciado() {
        return valorFinanciado;
    }
    public void setAgenciaFinanciadora(String agenciaFinanciadora) {
        this.agenciaFinanciadora = agenciaFinanciadora;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public void setParticipantes(Vector<Colaborador> participantes) {
        this.participantes = participantes;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setValorFinanciado(double valorFinanciado) {
        this.valorFinanciado = valorFinanciado;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Vector<Publicacao> getPublicacoes() {
        return publicacoes;
    }
    public void setPublicacoes(Vector<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
    @Override
    public String toString() {
        String res = "Projeto| Título: " + getTitulo() + ", Status: " + getStatus() + ", Objetivo: "+ getObjetivo() + ", Descricao: " +
        getDescricao() + ", Inicio: "+getDataInicio()+", Fim: " + getDataFim() + ", Participantes: "+ getParticipantes().size();
        return res;
    }
    public boolean checkValid(){
        setStatus("Em elaboração");
        boolean flag=false;
        for (int i = 0; i < participantes.size(); i++) {
            if(participantes.elementAt(i) instanceof Professor) flag = true;
        }
        if(!flag) System.out.println("Não há professor cadastrado para o projeto");
        return flag;
    }
    @Override
    public int compareTo(Projeto a) {
        return this.getDataFim().compareTo(a.getDataFim());
    }
    public String relatorioProdutividade() {
        String res = this.toString()+"\n"+"Nomes: ";
        Vector<ProducaoAcademica> producoes = new Vector<ProducaoAcademica>();
        producoes.addAll(this.getPublicacoes());
        Vector<Colaborador> participantes = getParticipantes();

        for (int i = 0; i < participantes.size(); i++) {
            res += participantes.elementAt(i).getNome();
            if(i!=participantes.size()-1) res+=",";
            else res+="\n";
        }
        res+="Publicações: ";
        if(publicacoes.size()==0) res+="Nenhuma";
        else {
            res+="\n";
            Collections.sort(producoes, Collections.reverseOrder());
            for (int i = 0; i < producoes.size(); i++) {
                res+=producoes.elementAt(i)+"\n";
             }
        }
        return res;
    }


}