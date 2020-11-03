package wk3.app;
import wk3.model.*;
import java.util.Scanner;
public class Main{
    public static void limpaTela()
    {
        for (int i = 0; i < 70; i++) {
            System.out.println("");
        }
    }
    public static void cadastrarLivro(Livraria lib, Scanner n)
    {
        String isbn , title, author;
        int pages;
        double valor;
        System.out.print("Insira o ISBN> ");
        isbn = n.nextLine();
        System.out.print("\nInsira o título> ");
        title = n.nextLine();
        System.out.print("\nInsira o autor> ");
        author = n.nextLine();
        System.out.print("\nInsira o número de páginas> ");
        pages = Integer.parseInt(n.nextLine());
        System.out.print("\nInsira o valor do livro> ");
        valor = Double.parseDouble(n.nextLine());
        lib.cadastrarLivro(isbn, title, author, pages, valor, false);
    }
    public static void cadastrarFuncionario(Livraria lib, Scanner n)
    {
        String cpf, matricula;
        double saldo, desconto;
        int idade, armario;
        System.out.println("Insira o CPF do funcionário> ");
        cpf = n.nextLine();
        System.out.println("\nInsira a idade do funcionário> ");
        idade = Integer.parseInt(n.nextLine());
        System.out.println("\nInsira a matricula do funcionário> ");
        matricula = n.nextLine();
        System.out.println("\nInsira o saldo do funcionário> ");
        saldo = Double.parseDouble(n.nextLine());
        System.out.println("\nInsira o número do armário do funcionário> ");
        armario = Integer.parseInt(n.nextLine());
        System.out.println("\nInsira o desconto base do funcionário> ");
        desconto = Double.parseDouble(n.nextLine());
        lib.cadastrarFuncionario(cpf, matricula, idade, armario, saldo, desconto);
    }
    public static void cadastrarCliente(Livraria lib, Scanner n)
    {
        String cpf;
        int idade;
        double carteira;
        double desconto;
        System.out.println("Insira o CPF do cliente> ");
        cpf = n.nextLine();
        System.out.println("\nInsira a idade do cliente> ");
        idade = Integer.parseInt(n.nextLine());
        System.out.println("\nInsira o saldo do cliente> ");
        carteira = Double.parseDouble(n.nextLine());
        System.out.println("\nInsira o desconto base do cliente> ");
        desconto = Double.parseDouble(n.nextLine());
        lib.cadastrarCliente(cpf, idade, carteira, desconto);
    }
    public static void realizarVenda(Livraria lib, Scanner n) {
        String cpf, isbn;
        System.out.print("Insira o CPF do cliente> ");
        cpf = n.nextLine();
        System.out.print("\nInsira o ISBN do livro a ser vendido> ");
        isbn = n.nextLine();
        lib.venderLivro(cpf, isbn);
    }
    public static void main(String[] args) {
        int opt;
        Scanner n = new Scanner(System.in);
        do
        {
            System.out.println("Bem-vindo!\nInsira 1 para cadastrar a livraria\nInsira 0 para sair do sistema");
            opt= Integer.parseInt(n.nextLine());
            if(opt==1)
            {
                Livraria lib = new Livraria();
                System.out.print("Insira o nome da livraria: ");
                lib.setNome(n.nextLine());
                System.out.print("Insira o endereço: ");
                lib.setEndereco(n.nextLine());
                System.out.print("Insira a quantidade de usuários suportada pela livraria (usuários + funcionários): ");
                int size;
                size = Integer.parseInt(n.nextLine());
                lib.setCadastros(size);
                lib.setLotacao_total_pessoas(size);
                System.out.print("Insira a quantidade de livros suportada pela livraria: ");
                size = Integer.parseInt(n.nextLine());
                lib.setLivros(size);;
                lib.setLotacao_total_livros(size);
                limpaTela();
                do
                {
                    System.out.println("Sistema da Livraria "+ lib.getNome() +"!  Bem-Vindo(a)!\n\n");
                    System.out.println("Insira 1 para cadastrar um livro");
                    System.out.println("Insira 2 para cadastrar um cliente");
                    System.out.println("Insira 3 para cadastrar um funcionário");
                    System.out.println("Insira 4 para efetuar a compra de um livro por um cliente");
                    System.out.println("Insira 5 para listar os livros disponíveis");
                    System.out.println("Insira 6 para listar os clientes cadastrados");
                    System.out.println("Insira 7 para listar os funcionários cadastrados");
                    System.out.println("Insira 0 para sair do sistema");    
                    opt = Integer.parseInt(n.nextLine());
                    if(opt==1) 
                    {
                        cadastrarLivro(lib, n);
                        System.out.println("Pressione enter para continuar...");
                        n.nextLine();
                        limpaTela();
                    }
                    if(opt==2) {
                        cadastrarCliente(lib, n);
                        System.out.println("Pressione enter para continuar...");
                        n.nextLine();
                        limpaTela();
                    }   
                    if(opt==3) {
                        cadastrarFuncionario(lib, n);
                        System.out.println("Pressione enter para continuar...");
                        n.nextLine();
                        limpaTela();
                    }
                    if(opt==4) {
                        realizarVenda(lib , n);
                        System.out.println("Pressione enter para continuar...");
                        n.nextLine();
                        limpaTela();
                    }
                    if(opt==5)
                    {
                        lib.listarLivros();
                        System.out.println("Pressione enter para continuar...");
                        n.nextLine();
                        limpaTela();
                    }  
                    if(opt==6)
                    {
                        lib.listarClientes();
                        System.out.println("Pressione enter para continuar...");
                        n.nextLine();
                        limpaTela();
                    }     
                    if(opt==7)
                    {
                        lib.listarFuncionarios();
                        System.out.println("Pressione enter para continuar...");
                        n.nextLine();
                        limpaTela();
                    }
                    limpaTela();  
                }
                while (opt!=0);
                
            }
        }
        while(opt!=0);
        n.close();
    }
}