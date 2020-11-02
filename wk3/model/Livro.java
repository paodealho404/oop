package wk3.model;
public class Livro {
    String isbn;
    String title;
    String author;
    int pages;
    double valor;
    boolean vendido;
    Pessoa locador;

    public Livro() {
        this.isbn = "";
        this.title = "";
        this.valor = 0;
        this.author = "";
        this.pages = 0;
        this.vendido = false;
        this.locador = null;
        this.vendido = false;
    }
    void setLocador(Pessoa locador) {
        this.locador = locador;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    public Pessoa getLocador() {
        return locador;
    }
    public double getValor() {
        return valor;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public boolean getVendido() {
        return vendido;
    }
}
