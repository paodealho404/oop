package wk3.model;
public class Livro {
    private String isbn;
    private String title;
    private String author;
    private int pages;
    private double valor;
    private boolean vendido;
    Pessoa comprador;

    public Livro() {
        this( "","", "", 0.0, 0, false, null);
    }
    public Livro(String isbn, String title, String author, Double valor, int pages, boolean vendido, Pessoa comprador) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.valor = valor;
        this.pages = pages;
        this.vendido = vendido;
        this.comprador = comprador;
    }
    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
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
    public Pessoa getComprador() {
        return comprador;
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
    public String toString()
    {
        String res = "{ ISBN: " + getIsbn() + ", AUTHOR: "+ getAuthor() + ", TITLE: " + getTitle() + ", PAGES: " +getPages() + ", VALOR: "+ getValor() + ", VENDIDO: ";
        res+= getVendido() ? ("SIM"):("NÃO");
        Pessoa comp = getComprador();
        if(getVendido())
        {
            res+=", COMPRADOR: ";
            res+= (comp != null) ? (comp.parseText()) : "AINDA NÃO FOI COMPRADO";
        }
        res+= " }";
        return res;
    }
}
