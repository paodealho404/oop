package project.view;
import java.util.Scanner;
import project.model.Administrador;
import project.model.LabPesquisa;
import project.model.Projeto;
import project.model.Colaborador;

public class SubMenusProjeto {
    public static void menuProjetoAlteracao(Administrador admin, Scanner sc, LabPesquisa lab, Projeto p) {
        MenuUtil.limpa();
        System.out.println("Mudar estado do projeto para: ");
        System.out.println("1) Em andamento");
        System.out.println("2) Concluído");
        int opt = Integer.parseInt(sc.nextLine());
        switch (opt) {
            case 1:
                admin.mudarStatusProjeto("Em andamento", p);
                break;
            case 2:
                admin.mudarStatusProjeto("Concluído", p);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
    public static void menuAdicionarColaboradorProjeto(Administrador admin, Scanner sc, LabPesquisa lab, Projeto projeto) {
        MenuUtil.limpa();
        for (int i = 0; i < lab.getColaboradores().size(); i++) {
            System.out.println(i+") "+lab.getColaborador(i));    
        }
        System.out.println("Insira o índice do colaborador a ser adicionado no projeto");
        int colab = Integer.parseInt(sc.nextLine());
        Colaborador colab_result = lab.getColaborador(colab);
        if (colab_result != null) {
            admin.addProjetoColaborador(projeto, colab_result);
        } else {
            System.out.println("Colaborador não encontrado");
        }
    }
}
