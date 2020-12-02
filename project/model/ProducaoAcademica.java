package project.model;

public class ProducaoAcademica implements Comparable<ProducaoAcademica>{
    private int anoPublicacao;
    private String titulo;
    public ProducaoAcademica(String titulo, int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        String res = "Titulo: " + getTitulo() + ", Data de Publicação: " + getAnoPublicacao();
        return res;
    }
    @Override
    public int compareTo(ProducaoAcademica x) {
        return Integer.valueOf(this.anoPublicacao).compareTo(x.getAnoPublicacao());
    }
}
