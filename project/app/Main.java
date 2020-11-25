package project.app;
import project.model.Administrador;
import java.util.Scanner;
import project.view.Menus;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, email, login, senha;
        System.out.println("Crie um administrador para o sistema");
        System.out.println("Nome: ");
        nome = sc.nextLine();
        System.out.println("Email: ");
        email = sc.nextLine();
        System.out.println("Login: ");
        login = sc.nextLine();
        System.out.println("Senha: ");
        senha = sc.nextLine();
        Administrador admin = new Administrador(nome, email, login, senha);
        System.out.println("Pressione qualquer tecla para continuar");
        sc.nextLine();
        Menus.limpa();
        System.out.println("Efetue login: "+ admin.getLogin());
        System.out.println("Senha:");
        senha = sc.nextLine();
        boolean flag = false;
        while(!flag)
        {
            if(admin.logar(senha)) {
                flag=true;
                Menus.limpa();
                Menus.menu_criar_lab(admin, sc);
            }
            else {
                System.out.println("Pressione qualquer tecla para continuar...");
                sc.nextLine();
                Menus.limpa();
                System.out.println("Efetue login: "+ admin.getLogin());
                System.out.println("Senha:");
                senha = sc.nextLine();
            }
        }
    }
}