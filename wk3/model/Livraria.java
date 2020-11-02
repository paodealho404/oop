package wk3.model;
public class Livraria {
    String nome;
    String endereco;
    Livro livros[];
    Pessoa clientes[];
    int lotacao_total_clientes;
    int lotacao_atual_clientes;
    int lotacao_atual_livros;
    int lotacao_total_livros;
    public Livraria() {
        this.nome="";
        this.endereco="";
        this.livros = null;
        this.clientes = null;
        this.lotacao_total_clientes = 0;
        this.lotacao_atual_clientes = 0;
        this.lotacao_atual_livros = 0;
        this.lotacao_total_livros = 0;
    }
    public void setLotacao_atual_livros(int lotacao_atual_livros) {
        this.lotacao_atual_livros = lotacao_atual_livros;
    }
    public void setLotacao_total_livros(int lotacao_total_livros) {
        this.lotacao_total_livros = lotacao_total_livros;
    }
    public void setLotacao_atual_clientes(int lotacao_atual_clientes) {
        this.lotacao_atual_clientes = lotacao_atual_clientes;
    }
    public void setLotacao_total_clientes(int lotacao_total_clientes) {
        this.lotacao_total_clientes = lotacao_total_clientes;
    }
    public void setLivros(int size) {
        this.livros = new Livro[size];
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setClientes(int size) {
        this.clientes = new Pessoa[size];
    }
    public String getEndereco() {
        return endereco;
    }
    public Livro[] getLivros() {
        return livros;
    }
    public String getNome() {
        return nome;
    }
    public Pessoa[] getClientes() {
        return clientes;
    }
    public int getLotacao_atual_clientes() {
        return lotacao_atual_clientes;
    }
    public int getLotacao_total_clientes() {
        return lotacao_total_clientes;
    }
    public int getLotacao_atual_livros() {
        return lotacao_atual_livros;
    }
    public int getLotacao_total_livros() {
        return lotacao_total_livros;
    }
    public void cadastrarCliente(String cpf, int idade, double carteira)
    {
        if(lotacao_total_clientes==lotacao_atual_clientes) System.out.println("Impossível cadastrar clientes, capacidade máxima atingida");
        else{
            Pessoa novaPessoa = new Pessoa();
            novaPessoa.setCpf(cpf);
            novaPessoa.setCarteira(carteira);
            novaPessoa.setIdade(idade);
            clientes[lotacao_atual_clientes] = novaPessoa;
            lotacao_atual_clientes+=1;
        }
    }
    public void cadastrarLivro(String isbn, String title, String author, int pages, double valor, boolean vendido)
    {   
        if(lotacao_atual_livros == lotacao_total_livros) System.out.println("Impossível cadastrar livros, capacidade máxima atingida");
        else {
            Livro novoLivro = new Livro();
            novoLivro.setAuthor(author);
            novoLivro.setIsbn(isbn);
            novoLivro.setPages(pages);
            novoLivro.setVendido(vendido);
            novoLivro.setTitle(title);
            novoLivro.setValor(valor);
            livros[lotacao_atual_livros] = novoLivro;
            lotacao_atual_livros+=1;
        }
    }
    public void listarClientes()
    {   
        if(lotacao_atual_clientes==0)
        {
            System.out.println("Não há clientes cadastrados");
            return;
        } 
        else for (int i = 0; i < lotacao_total_clientes; i++)
        {
            if(clientes[i]==null) continue;
            System.out.println("CPF> "+ clientes[i].getCpf() + "\nIDADE> "+ clientes[i].getIdade() + "\nSALDO> R$"+clientes[i].getCarteira()+"\n");
        }   
    }
    public void listarLivros()
    {
        if(lotacao_atual_livros==0)
        {
            System.out.println("Não há livros disponíveis para venda");
            return;
        } 
        for (int i = 0; i < lotacao_atual_livros; i++) {
            if(livros[i]==null) continue;
            if(!livros[i].vendido) System.out.println("ISBN> "+ livros[i].isbn + "\nTitulo> "+ livros[i].title + "\nAutor> " + livros[i].author +"\nValor> "+ livros[i].valor+"\n\n");
        }
    }
    public void venderLivro(String cpf, String isbn)
    {
        boolean cliente=false, livro=false;
        for (int i = 0; i < lotacao_total_livros; i++) {
            if(livros[i]==null) continue;
            if(isbn.equalsIgnoreCase(livros[i].isbn))
            {
                livro = true;
                if(livros[i].vendido) System.out.println("Livro já foi vendido");
                else {
                    for (int j = 0; j < lotacao_total_clientes; j++) {
                        if(clientes[j]==null) continue;
                        if(cpf.equalsIgnoreCase(clientes[j].cpf))
                        {
                            cliente = true;
                            double carteira = clientes[j].getCarteira();
                            double valor = livros[i].getValor();
                            if( carteira >= valor)
                            {
                                clientes[j].setCarteira(carteira - valor);
                                livros[i].setVendido(true);
                                clientes[j].setAluguel(livros[i]);
                                livros[i].setLocador(clientes[j]);
                                System.out.println("Venda realizada com sucesso");
                                lotacao_atual_livros--;
                                break;
                            }
                            else System.out.println("Saldo insuficiente");
                        }
                    } 
                }
            }
        }
        if(!cliente) System.out.println("Cliente não encontrado");
        if(!livro) System.out.println("Livro não encontrado");
    }
}