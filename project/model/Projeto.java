package project.model;
import java.util.Date;
import java.util.Vector;
public class Projeto{
    private String titulo;
    private Date data_inicio;
    private Date data_fim;
    private String agencia_financiadora;
    private double valor_financiado;
    private String objetivo;
    private String descricao;
    private Vector<Colaborador> participantes;
    private boolean valid;
    private String status;
    public Projeto(String titulo, Date data_inicio, Date data_fim, String agencia_financiadora, double valor_financiado, String objetivo, String descricao, Vector<Colaborador> participantes)
    {
        this.titulo = titulo;
        this.data_fim = data_fim;
        this.data_inicio = data_inicio;
        this.agencia_financiadora = agencia_financiadora;
        this.valor_financiado = valor_financiado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.valid = checkValid();
    }
    public boolean getValid() {
        return valid;
    }
    public String getAgencia_financiadora() {
        return agencia_financiadora;
    }
    public Date getData_fim() {
        return data_fim;
    }
    public Date getData_inicio() {
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
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
    public void setData_inicio(Date data_inicio) {
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
    public void changeStatus(){
        if(this.titulo!=null && this.data_inicio!=null && this.data_fim==null && this.valid && this.agencia_financiadora!=null && this.valor_financiado!=-1 && this.descricao!=null && this.participantes!=null)
        setStatus("Em andamento");
        else if(this.titulo!=null && this.data_inicio!=null && this.data_fim!=null && this.valid && this.agencia_financiadora!=null && this.valor_financiado!=-1 && this.descricao!=null && this.participantes!=null)
        setStatus("Concluíddo");
    }
    public boolean checkValid(){
        for (int i = 0; i < participantes.size(); i++) {
            if(participantes.elementAt(i) instanceof Professor)
            {
                setStatus("Em elaboração");
                return true;
            } 
        }
        return false;
    }

}