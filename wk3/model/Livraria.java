package wk3.model;
public class Livraria {
    private String nome;
    private String endereco;
    private Livro livros[];
    private Pessoa cadastros[];
    private int lotacao_total_pessoas;
    private int lotacao_atual_pessoas;
    private int lotacao_atual_livros;
    private int lotacao_total_livros;
    public Livraria() {
        this("","", null, null, 0, 0, 0, 0);
    }
    public Livraria(String nome, String endereco, Livro livros[], Pessoa cadastros[], int l_total_cli, int l_atual_cli, int l_total_liv, int l_atual_liv)
    {
        this.nome=nome;
        this.endereco=endereco;
        this.livros = livros;
        this.cadastros = cadastros;
        this.lotacao_total_pessoas = l_total_cli;
        this.lotacao_atual_pessoas = l_atual_cli;
        this.lotacao_total_livros = l_total_liv;
        this.lotacao_atual_livros = l_atual_liv;
    }
    public void setLotacao_atual_livros(int lotacao_atual_livros) {
        this.lotacao_atual_livros = lotacao_atual_livros;
    }
    public void setLotacao_total_livros(int lotacao_total_livros) {
        this.lotacao_total_livros = lotacao_total_livros;
    }
    public void setLotacao_atual_pessoas(int lotacao_atual_pessoas) {
        this.lotacao_atual_pessoas = lotacao_atual_pessoas;
    }
    public void setLotacao_total_pessoas(int lotacao_total_pessoas) {
        this.lotacao_total_pessoas = lotacao_total_pessoas;
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
    public void setCadastros(int size) {
        this.cadastros = new Pessoa[size];
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
    public Pessoa[] getCadastros() {
        return cadastros;
    }
    public int getLotacao_atual_pessoas() {
        return lotacao_atual_pessoas;
    }
    public int getLotacao_total_pessoas() {
        return lotacao_total_pessoas;
    }
    public int getLotacao_atual_livros() {
        return lotacao_atual_livros;
    }
    public int getLotacao_total_livros() {
        return lotacao_total_livros;
    }
    public void cadastrarCliente(String cpf, int idade, double credito, double desconto)
    {
        if(lotacao_total_pessoas==lotacao_atual_pessoas) System.out.println("Impossível cadastrar clientes, capacidade máxima atingida");
        else{
            Pessoa novoCadastro =  new Cliente(cpf, idade, credito, desconto, null);
            cadastros[lotacao_atual_pessoas] = novoCadastro;
            lotacao_atual_pessoas+=1;
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
        boolean find = false;
        if(lotacao_atual_pessoas==0)
        {
            System.out.println("Não há clientes cadastrados");
            return;
        } 
        else {
            for (int i = 0; i < lotacao_total_pessoas; i++)
            {
                if(cadastros[i]==null || cadastros[i] instanceof Funcionario) continue;
                System.out.println(cadastros[i]);
                find = true;
            }
            if(!find)  System.out.println("Não há clientes cadastrados");
        } 
    }
    public void listarFuncionarios()
    {
        boolean find = false;
        if(lotacao_atual_pessoas ==0) 
        {
            System.out.println("Não há funcionários cadastrados");
            return;
        }
        else {
            for (int i = 0; i < lotacao_total_pessoas; i++) {
                if(cadastros[i]==null || cadastros[i] instanceof Cliente) continue;
                System.out.println(cadastros[i]);
                find = true;
            }
            if(!find) System.out.println("Não há funcionários cadastrados");
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
            if(livros[i]==null || livros[i].getVendido()) continue;
            System.out.println(livros[i]); 
        }
    }
    public void venderLivro(String cpf, String isbn)
    {
        boolean cliente=false, livro=false;
        for (int i = 0; i < lotacao_total_livros; i++) {
            if(livros[i]==null) continue;
            if(isbn.equalsIgnoreCase(livros[i].getIsbn()))
            {
                livro = true;
                if(livros[i].getVendido()) System.out.println("Livro já foi vendido");
                else {
                    for (int j = 0; j < lotacao_total_pessoas; j++) {
                        if(cadastros[j]==null) continue;
                        if(cpf.equalsIgnoreCase(cadastros[j].cpf))
                        {
                            cliente = true;
                            double carteira = cadastros[j].getCredito();
                            double valor = livros[i].getValor();
                            if( carteira >= valor)
                            {
                                double desc=0;
                                if(cadastros[j] instanceof Cliente) 
                                {
                                    Cliente x = (Cliente)cadastros[j];
                                    desc = x.getDesconto();
                                }
                                else if(cadastros[j] instanceof Funcionario)
                                {
                                    Funcionario x = (Funcionario)cadastros[j];
                                    desc = x.getDesconto();
                                }
                                cadastros[j].pagar(valor*(1-desc));
                                livros[i].setVendido(true);
                                cadastros[j].setCompra(livros[i]);
                                livros[i].setComprador(cadastros[j]);
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
    public void cadastrarFuncionario(String cpf, String matricula, int idade,  int armario, double credito, double desconto)
    {
        if(lotacao_total_pessoas==lotacao_atual_pessoas) System.out.println("Impossível cadastrar funcionários, capacidade máxima atingida");
        else{
            Pessoa novoCadastro =  new Funcionario(cpf, matricula, idade, armario, credito, desconto);
            cadastros[lotacao_atual_pessoas] = novoCadastro;
            lotacao_atual_pessoas+=1;
        }
    }
}