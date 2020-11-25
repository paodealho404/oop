package project.view;

import project.model.Administrador;
import project.model.LabPesquisa;
import project.model.Pesquisador;
import project.model.Professor;
import project.model.Projeto;
import project.model.Colaborador;
import project.model.Aluno;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.namespace.QName;

public class Menus {
    public static void limpa() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
    public static void menu_criar_lab(Administrador admin, Scanner sc) {
        limpa();
        System.out.println("Crie um laboratório de pesquisa");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        LabPesquisa lab = new LabPesquisa(nome, admin);
        menu_lab_pesquisa(admin, sc, lab);
    }
    public static void menu_lab_pesquisa(Administrador admin, Scanner sc, LabPesquisa lab) { 
        limpa();
        System.out.println("Laboratório "+ lab.getNome());
        int opt = -1;
        while(opt!=0) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1) Adicionar colaboradores ao laboratório");
            System.out.println("2) Adicionar projetos ao laboratório");
            System.out.println("3) Menu de seleção e edição de colaboradores");
            System.out.println("4) Menu de seleçao e edição de projetos");
            System.out.println("0) Sair");
            opt = Integer.parseInt(sc.nextLine());
            switch(opt) {
                case 1:
                    menu_lab_pesquisa_add_colaborador(admin, sc, lab);
                    break;
                case 2:
                    menu_lab_pesquisa_add_projetos(admin, sc, lab);
                    break;
                case 3:
                    menu_colaborador(admin, sc,lab);
                    break;
                case 4:
                    menu_projeto(admin, sc, lab);
                    break;
                default:
                    break;
            }
        }
    }
    public static void menu_projeto_alteracao(Administrador admin, Scanner sc, LabPesquisa lab, Projeto p) {
        limpa();
        System.out.println("Menu aqui de alteracao");
    }
    public static void menu_projeto(Administrador admin, Scanner sc, LabPesquisa lab) {
        limpa();
        Vector<Projeto> projs = lab.getProjetos();
        if(projs.size()==0) {
            System.out.println("Ainda não há projetos cadastrados");
            System.out.println("Pressione qualquer tecla para continuar...");
            sc.nextLine();
            return;
        }
        else {
            System.out.println("Selecione um projeto para ser editado");
        
            for (int i = 0; i < projs.size(); i++) {
                System.out.println(i + " ) "+projs.elementAt(i));
            }
            int x = Integer.parseInt(sc.nextLine());
            Projeto selecionado = projs.elementAt(x);
            int opt=-1;
            while(opt!=0) {
                System.out.println("Selecione uma funcionalidade");
                System.out.println("1) Alterar status do projeto");
                System.out.println("0) Sair");
                opt = Integer.parseInt(sc.nextLine());
                switch(opt) {
                    case 1:
                    menu_projeto_alteracao(admin, sc, lab, selecionado);
                    break;
                    case 0:
                    break;
                }
            }
        }
    }
    public static void menu_lab_pesquisa_add_colaborador(Administrador admin, Scanner sc, LabPesquisa lab) {
        limpa();
        System.out.println("Laboratório "+ lab.getNome());
        System.out.println("->Adicionar colaborador ao laboratório");
        String nome, email;
        System.out.println("Digite o nome do colaborador: ");
        nome = sc.nextLine();
        System.out.println("Digite o email do colaborador: ");
        email = sc.nextLine();
        System.out.println("Qual o tipo de colaborador que deseja inserir?");
        System.out.println("1) Professor");
        System.out.println("2) Aluno");
        System.out.println("3) Pesquisador");
        int opt = Integer.parseInt(sc.nextLine());
        switch(opt) {
            case 1:
                Colaborador c = new Professor(nome, email);
                lab.addColaborador(c);
                break;
            case 2:
                System.out.println("Qual o tipo de aluno?");
                System.out.println("1) Graduação");
                System.out.println("2) Mestrado");
                System.out.println("3) Doutorado");
                int optaux = Integer.parseInt(sc.nextLine());
                Aluno a = new Aluno(nome, email);
                if(optaux==1)a.setTipo("Graduação");
                if(optaux==2)a.setTipo("Mestrado");
                if(optaux==3)a.setTipo("Doutorado");
                Colaborador x = (Colaborador) a;
                lab.addColaborador(x);
                break;
            case 3:
                System.out.println("Qual o vínculo do pesquisador?");
                String vinculo = sc.nextLine();
                Pesquisador k = new Pesquisador(nome, email);
                k.setVinculo(vinculo);
                Colaborador y = (Colaborador) k;
                lab.addColaborador(y);
                break;
            default: 
                System.out.println("Tipo de colaborador inválido");
                break;
        }
        System.out.println("Pressione qualquer tecla para continuar..");
        sc.nextLine();
        limpa();
    }
    public static void menu_colaborador(Administrador admin, Scanner sc, LabPesquisa lab) {
        Vector<Colaborador> colab = lab.getColaboradores();
        for (int i = 0; i < colab.size(); i++) {
            System.out.println(colab.elementAt(i));
        }
    }
    public static void menu_lab_pesquisa_add_projetos(Administrador admin, Scanner sc, LabPesquisa lab) {
        limpa();
        System.out.println("Laboratório "+ lab.getNome());
        System.out.println("->Adicionar projeto ao laboratório");
        
        
        String titulo, objetivo, descricao, agencia_financiadora;
        LocalDate data_inicio, data_fim;
        Double valor_financiado;

        System.out.println("Insira um título para o projeto");
        titulo = sc.nextLine();
        System.out.println("Insira o objetivo do projeto");
        objetivo = sc.nextLine();
        System.out.println("Insira a descricao do projeto");
        descricao = sc.nextLine();
        System.out.println("Insira a agencia financiadora");
        agencia_financiadora = sc.nextLine();
        System.out.println("Insira o valor financiado");
        valor_financiado = Double.parseDouble(sc.nextLine());
        System.out.println("Insira uma data de inicio: ");
        System.out.println("Dia(dd): ");
        int dia = Integer.parseInt(sc.nextLine());
        System.out.println("Mes(mm): ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.println("Ano(aaaa): ");
        int ano = Integer.parseInt(sc.nextLine());
        data_inicio = LocalDate.of(ano, mes, dia);
        System.out.println("Insira uma data de fim: DD MM AAAA");
        System.out.println("Dia(dd): ");
        dia = Integer.parseInt(sc.nextLine());
        System.out.println("Mes(mm): ");
        mes = Integer.parseInt(sc.nextLine());
        System.out.println("Ano(aaaa): ");
        ano = Integer.parseInt(sc.nextLine());
        data_fim = LocalDate.of(ano, mes, dia);
        limpa();
        System.out.println("Para que o projeto seja validado é necessário a presença de um professor no mesmo");
        System.out.println("Digite uma opcao:\n1) Selecionar um professor existente \n2) Adicionar um novo professor ao laboratório e vincular à pesquisa");
        int opt = Integer.parseInt(sc.nextLine());
        Vector<Colaborador> participantes = new Vector<Colaborador>();
        switch(opt) {
            case 1:
                if(!lab.hasProfessor()){
                    System.out.println("Não há professores colaboradores no laboratório");
                    System.out.println("Digite uma opcao:\n1) Selecionar um professor existente \n2) Adicionar um novo professor ao laboratório e vincular à pesquisa");
                    opt = Integer.parseInt(sc.nextLine());
                    break;
                }
                
                Vector<Colaborador> colab = lab.getColaboradores();
                System.out.println("Professores: ");
                for (int i = 0; i < colab.size(); i++) {
                    if(colab.elementAt(i)instanceof Professor) System.out.println(colab.elementAt(i));
                }
                System.out.println("Insira o nome do professor desejado");
                String busca = sc.nextLine();
                Colaborador p = lab.getColaborador(busca);
                if(p==null) System.out.println("Professor não encontrado");
                else {
                    participantes.add(p);
                }
                break;
            case 2:
                System.out.println("Digite o nome do colaborador: ");
                String nome = sc.nextLine();
                System.out.println("Digite o email do colaborador: ");
                String email = sc.nextLine();
                Colaborador c = new Professor(nome, email);
                if(lab.getColaborador(c.getNome())==null) {
                    lab.addColaborador(c);
                    participantes.add(c);
                }
                break;
            default:
                break;
        }
        Projeto p = new Projeto(titulo, data_inicio, data_fim, agencia_financiadora, valor_financiado, objetivo, descricao, participantes);
        admin.cadastroProjetoLab(lab, p);
    }

}
