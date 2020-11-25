package project.model;
import java.util.Vector;
public class Publicacao{
    private Vector<Colaborador> autores;
    private String titulo;
    private String conferencia;
    private int ano_publicacao;
    private Projeto projeto;
    public Publicacao(String titulo, String conferencia, int ano_publicacao, Projeto projeto, Vector<Colaborador> autores)
    {
        this.ano_publicacao = ano_publicacao;
        this.conferencia = conferencia;
        this.projeto = projeto;
        this.titulo = titulo;
        this.autores = autores;
    }
    public String getConferencia() {
        return conferencia;
    }
    public int getAno_publicacao() {
        return ano_publicacao;
    }
    public Vector<Colaborador> getAutores() {
        return autores;
    }
    public Projeto getProjeto() {
        return projeto;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }
    public void setAutores(Vector<Colaborador> autores) {
        this.autores = autores;
    }
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }
    public void addAutor(Colaborador autor)
    {
        autores.add(autor);
    }
    @Override
    public String toString() {
        String res = "{ Titulo: " + getTitulo() + ", Publicacao: " + getAno_publicacao() + ", Autores: ";
        for (int i = 0; i < autores.size(); i++) {
                res+=autores.elementAt(i);
                if(i<autores.size()-1) res+=", ";
        }
        res+=" }";
        return res;
    }
}