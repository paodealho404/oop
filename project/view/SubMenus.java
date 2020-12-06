package project.view;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

import project.model.*;

public class SubMenus {
    
    public static void menuLabPesquisaAddColaborador(Administrador admin, Scanner sc, LabPesquisa lab) {
        MenuUtil.limpa();
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
    }
    public static void menuLabPesquisaAddProjetos(Administrador admin, Scanner sc, LabPesquisa lab) {
        MenuUtil.limpa();
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
        MenuUtil.limpa();
        System.out.println("Para que o projeto seja validado é necessário a presença de um professor no mesmo");
        System.out.println("Digite uma opcao:\n1) Selecionar um professor existente \n2) Adicionar um novo professor ao laboratório e vincular à pesquisa");
        int opt = Integer.parseInt(sc.nextLine());
        Vector<Colaborador> participantes = new Vector<Colaborador>();
        Projeto proj;
        switch(opt) {
            case 1:
                if(!lab.hasProfessor()){
                    System.out.println("Não há professores como colaboradores do laboratório");
                    System.out.println("Digite uma opcao:\n1) Selecionar um professor existente \n2) Adicionar um novo professor ao laboratório e vincular à pesquisa");
                    opt = Integer.parseInt(sc.nextLine());
                    break;
                }
                
                Vector<Colaborador> colab = lab.getColaboradores();
                System.out.println("Professores: ");
                for (int i = 0; i < colab.size(); i++) {
                    if(colab.elementAt(i) instanceof Professor) System.out.println(colab.elementAt(i));
                }
                System.out.println("Insira o nome do professor desejado");
                String busca = sc.nextLine();
                Colaborador p = lab.getColaborador(busca);
                if(p==null) System.out.println("Professor não encontrado");
                else {
                    participantes.add(p);
                    proj = new Projeto(titulo, data_inicio, data_fim, agencia_financiadora, valor_financiado, objetivo, descricao, participantes);
                    admin.cadastroProjetoLab(proj, lab);
                    admin.addProjetoColaborador(proj, p);
                }
                break;
            case 2:
                System.out.println("Digite o nome do professor: ");
                String nome = sc.nextLine();
                System.out.println("Digite o email do professor: ");
                String email = sc.nextLine();
                Colaborador c = new Professor(nome, email);
                lab.addColaborador(c);
                participantes.add(c);
                proj = new Projeto(titulo, data_inicio, data_fim, agencia_financiadora, valor_financiado, objetivo, descricao, participantes);
                admin.addProjetoColaborador(proj, c);
                admin.cadastroProjetoLab(proj, lab);
                break;
            default:
                break;
        }
    }
    public static void menuProjetoAlteracao(Administrador admin, Scanner sc, LabPesquisa lab, Projeto p) {
        MenuUtil.limpa();
        System.out.println("Mudar estado do projeto para: ");
        System.out.println("1) Em andamento");
        System.out.println("2) Concluído");
        int opt = Integer.parseInt(sc.nextLine());
        switch(opt) {
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
    public static void menuExibicaoProjetos(Administrador admin, Scanner sc, LabPesquisa lab) {
        MenuUtil.limpa();
        Vector<Projeto> projs = lab.getProjetos();
        if(projs.size()==0) {
            System.out.println("Ainda não há projetos cadastrados");
            System.out.println("Pressione qualquer tecla para continuar...");
            sc.nextLine();
            return;
        }
        else {
            for (int i = 0; i < projs.size(); i++) {
                System.out.println(i + ") "+projs.elementAt(i));
            }
            System.out.println("Selecione um projeto para ser editado");
            int x = Integer.parseInt(sc.nextLine());
            if(x>=projs.size()) {
                System.out.println("Não existente");
                System.out.println("Pressione qualquer tecla para continuar...");
                sc.nextLine();
                return;
            }
            Projeto selecionado = projs.elementAt(x);
            int opt=-1;
            while(opt!=0) {
                MenuUtil.limpa();
                System.out.println("Alterando o projeto " + selecionado.getTitulo());
                System.out.println("Selecione uma funcionalidade");
                System.out.println("1) Alterar status do projeto");
                System.out.println("2) Adicionar colaborador (já vinculado ao laboratório) ao projeto");
                System.out.println("0) Sair");
                opt = Integer.parseInt(sc.nextLine());
                switch(opt) {
                    case 1:
                        SubMenus.menuProjetoAlteracao(admin, sc, lab, selecionado);
                        System.out.println("Pressione qualquer tecla para continuar...");
                        sc.nextLine();
                        break;
                    case 2:
                        System.out.println("Insira o índice do colaborador existente");
                        int colab = Integer.parseInt(sc.nextLine());
                        Colaborador colab_result = lab.getColaborador(colab);
                        if(colab_result!=null) {
                            admin.addProjetoColaborador(selecionado, colab_result);
                        }
                        else {
                            System.out.println("Colaborador não encontrado");
                        }
                        System.out.println("\n\nPressione qualquer tecla para continuar...");
                        sc.nextLine();
                    case 0:
                        MenuUtil.limpa();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        System.out.println("Pressione qualquer tecla para continuar...");
                        sc.nextLine();
                        break;
                }
            }
        }
    }
    public static void menuProducaoAcademica(Administrador admin, Scanner sc, LabPesquisa lab) {

    }

}