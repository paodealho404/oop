package project.app;

import project.model.*;

import java.time.LocalDate;
import java.util.Vector;
public class Test {
    public static void main(String[] args) {
        Administrador admin = new Administrador("Fulano Beltrano", "fulanhinho@gmail.com", "beltraninho", "senha");
        LabPesquisa lab = new LabPesquisa("LabTeste", admin);


        Colaborador colab1 = new Professor("Jose", "jose@gmail.com");
        Colaborador colab2 = new Aluno("Paulo", "paulo@gmail.com", "Graduação");
        Colaborador colab3 = new Aluno("Fabiana", "fabiana@gmail.com", "Mestrado");
        Colaborador colab4 = new Aluno("Marcos", "marcos@gmail.com", "DOUTORADO");
        Colaborador colab5 = new Aluno("Vitor", "vitor@gmail.com", "Graduação");
        Colaborador colab6 = new Professor("Leonardo", "leo@gmail.com");
        Colaborador colab7 = new Aluno("Rosa", "rosa@gmail.com", "Graduação");
        Colaborador colab8 = new Aluno("Marta", "marta@uol.com.br", "Mestrado");
        Colaborador colab9 = new Aluno("Ruan", "ruan@ig.com.br", "Graduação");

        Vector<Colaborador> colaboradores = lab.getColaboradores();
        colaboradores.add(colab1);
        colaboradores.add(colab2);
        colaboradores.add(colab3);
        colaboradores.add(colab4);
        colaboradores.add(colab5);
        colaboradores.add(colab6);
        colaboradores.add(colab7);
        colaboradores.add(colab8);
        colaboradores.add(colab9);
        lab.setColaboradores(colaboradores);

        Vector<Colaborador> grupo1 = new Vector<Colaborador>();
        Vector<Colaborador> grupo2 = new Vector<Colaborador>();
        Vector<Colaborador> grupo3 = new Vector<Colaborador>();
        
        grupo1.add(colab1);
        grupo1.add(colab2);
        grupo1.add(colab3);

        grupo2.add(colab4);
        grupo2.add(colab1);
        grupo2.add(colab5);
        

        grupo3.add(colab6);
        grupo3.add(colab7);
        grupo3.add(colab8);
        grupo3.add(colab9);

        LocalDate dataIni1 =  LocalDate.of(2000,02,10), dataFim1 = LocalDate.of(2000,03,10);
        LocalDate dataIni2 = LocalDate.of(2001,03,11), dataFim2 = LocalDate.of(2001,04,11);

        LocalDate dataIni3 = LocalDate.of(2002,12,04), dataFim3 = LocalDate.of(2002,05,13);
        Projeto proj1 = new Projeto("BIOTECNOLOGIA", dataIni1, dataFim1, "CNPQ", 4800, "", "", grupo1);
        Projeto proj2 = new Projeto("TECNOBIOLOGIA", dataIni2, dataFim2, "CNPQ", 4800, "", "", grupo2);
        Projeto proj3 = new Projeto("USO DE PLANTAS", dataIni3, dataFim3, "CNPQ", 4800, "", "", grupo3);


        System.out.println("\n\nExecutando procedimentos...\n\n");
        System.out.println("Adicionando os projetos ao laboratório");
        admin.cadastroProjetoLab(proj1, lab);
        admin.cadastroProjetoLab(proj2, lab);
        admin.cadastroProjetoLab(proj3, lab);


        System.out.println("Tentando adicionar o projeto aos colaboradores");
        admin.addProjetoColaboradores(proj1, proj1.getParticipantes());
        admin.addProjetoColaboradores(proj2, proj2.getParticipantes());
        admin.addProjetoColaboradores(proj3, proj3.getParticipantes());

        
        

        Vector<Aluno> grupoOrientandos1 = new Vector<Aluno>();
        Vector<Aluno> grupoOrientandos2 = new Vector<Aluno>();

        grupoOrientandos1.add((Aluno)colab2);
        grupoOrientandos1.add((Aluno)colab3);
        grupoOrientandos2.add((Aluno)colab8);
        grupoOrientandos2.add((Aluno)colab9);
        
        Vector<Colaborador> autores1 = new Vector<Colaborador>();
        autores1.addAll(grupoOrientandos1);
        autores1.add(colab1);

        Vector<Colaborador> autores2 = new Vector<Colaborador>();
        autores2.addAll(grupoOrientandos2);
        autores2.add(colab6);


        //É pra dar certo
        Publicacao p1 = new Publicacao("PLANTINHAS1","CONFERENCIA 1", 2000, lab.getProjeto("BIOTECNOLOGIA"), autores1);
        Publicacao p2 = new Publicacao("PLANTINHAS2","CONFERENCIA 2", 2001, lab.getProjeto("TECNOBIOLOGIA"), autores2);
        Publicacao p3 = new Publicacao("FALHO", "CONFERENCIA 3", 2010, lab.getProjeto("USO DE PLANTAS"), autores2);

        Orientacao o1 = new Orientacao("DISSERTAÇÃO", 2000, (Professor)lab.getColaborador("Jose"), grupoOrientandos1);
        Orientacao o2 = new Orientacao("DISSERTAÇÃO", 2001, (Professor)lab.getColaborador("Leonardo"), grupoOrientandos2);
        Orientacao o3 = new Orientacao("ANÁLISE", 2002, (Professor)lab.getColaborador("Jose"), grupoOrientandos2);
        
        System.out.println("Mudando estados dos projetos");
        admin.mudarStatusProjeto("Em andamento", lab.getProjeto("BIOTECNOLOGIA"));
        admin.mudarStatusProjeto("Em andamento", lab.getProjeto("TECNOBIOLOGIA"));
        
        //É pra dar certo
        System.out.println("Tentando adicionar publicação 1 e 2");
        admin.addPublicacaoLabPesquisa(lab, p1);
        admin.addPublicacaoLabPesquisa(lab, p2);

        //É pra dar errado, pois p3 tem um projeto em elaboração
        System.out.println("Tentando adicionar publicação 3");
        admin.addPublicacaoLabPesquisa(lab, p3);
        
        admin.addOrientacaoProfessor(o1, o1.getProfessor());
        admin.addOrientacaoProfessor(o2, o2.getProfessor());
        admin.addOrientacaoProfessor(o3, o3.getProfessor());
        //Concluindo os projetos
        System.out.println("\n\nConcluindo projetos...\n");
        admin.mudarStatusProjeto("Concluído", proj1);
        admin.mudarStatusProjeto("Concluído", proj2);

        //Testando os projetos inseridos
        System.out.println("Testando os projetos inseridos\n\n");
        System.out.println(lab.getProjeto("BIOTECNOLOGIA")); 
        System.out.println(lab.getProjeto("TECNOBIOLOGIA")); 
        System.out.println(lab.getProjeto("USO DE PLANTAS")); 

        //Testando os colaboradores inseridos
        System.out.println("\n\nTestando os colaboradores inseridos\n\n");
        lab.getColaboradores().forEach(colaborador->{
            System.out.println(colaborador);
        });

        //Testando as publicacões inseridas
        System.out.println("\n\nTestando as publicacões inseridas\n\n");
        lab.getPublicacoes().forEach(publicacao->{
            System.out.println(publicacao);
        });

        System.out.println("TOTAL DE PUBLICACOES NO FINAL: "+ lab.getPublicacoes().size());

        //Relatório laboratório
        System.out.println("\n\nRelatório de Produtividade do laboratório\n\n"+lab.relatorioProdutividade());

        //Relatório colaboradores
       lab.getColaboradores().forEach(colab->{
        System.out.println("\n\nRelatório de Produtividade do Colaborador\n"+ colab.relatorioColaborador());
       });
    }
}