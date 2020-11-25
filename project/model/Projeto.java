package project.model;
import java.time.LocalDate;
import java.util.Vector;
public class Projeto{
    private String titulo;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String agencia_financiadora;
    private double valor_financiado;
    private String objetivo;
    private String descricao;
    private Vector<Colaborador> participantes;
    private Vector<Publicacao> publicacoes;
    private boolean valid;
    private String status;
    public Projeto(String titulo, LocalDate data_inicio, LocalDate data_fim, String agencia_financiadora, double valor_financiado, String objetivo, String descricao, Vector<Colaborador> participantes)
    {
        this.titulo = titulo;
        this.data_fim = data_fim;
        this.data_inicio = data_inicio;
        this.agencia_financiadora = agencia_financiadora;
        this.valor_financiado = valor_financiado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.publicacoes = new Vector<Publicacao>();
        this.valid = checkValid();
    }
    public boolean getValid() {
        return valid;
    }
    public String getAgencia_financiadora() {
        return agencia_financiadora;
    }
    public LocalDate getData_fim() {
        return data_fim;
    }
    public LocalDate getData_inicio() {
        return data_inicio;
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
    public double getValor_financiado() {
        return valor_financiado;
    }
    public void setAgencia_financiadora(String agencia_financiadora) {
        this.agencia_financiadora = agencia_financiadora;
    }
    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }
    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
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
    public void setValor_financiado(double valor_financiado) {
        this.valor_financiado = valor_financiado;
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
        String res = "Titulo: " + getTitulo() + ", Status: " + getStatus() + ", Objetivo: "+ getObjetivo() + ", Descricao: " +
        getDescricao() + ", Inicio: "+getData_inicio()+", Fim: " + getData_fim() + ", Participantes: "+ getParticipantes().size();
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

}