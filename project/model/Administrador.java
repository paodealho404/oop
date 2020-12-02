package project.model;

import java.util.Vector;

public class Administrador extends Usuario{
    private String login;
    private String senha;
    public Administrador( String nome, String email, String login, String senha)
    {
        super(nome,email);
        setLogin(login);
        setSenha(senha);
    }
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Override
    public String toString() {
        return "{" + super.getEmail() + ", "+ super.getNome() + "}";
    }
    public boolean logar(String senha)
    {
        if(this.senha.equals(senha)) return true;
        else{
            System.out.println("Senha incorreta");
            return false;
        }
    }
    public boolean isProjectValid(Projeto p) {
        if(p.getValid() && p.getTitulo()!=null && p.getDataFim()!=null && p.getDataInicio()!=null
        && p.getValorFinanciado()>=0 &&p.getAgenciaFinanciadora()!=null && p.getObjetivo()!=null && p.getDescricao()!=null && p.getParticipantes().size()>0) return true;
        return false;
    }
    public void mudarStatusProjeto(String novo, Projeto p) {
        if(novo.equals("Em andamento")) {
            if(isProjectValid(p) &&  p.getStatus().equals("Em elaboração")) {
            Vector<Colaborador> colab = p.getParticipantes();
            for (int i = 0; i < colab.size(); i++) {
                if(colab.elementAt(i) instanceof Aluno) {
                    Aluno aux = (Aluno)colab.elementAt(i);
                    if(aux.getTipo().equals("Graduação")){
                       aux.check_projetos();
                        if(aux.getAndamento()==2) { // removendo alunos de graduação com 2 projetos em andamento
                            colab.removeElementAt(i);
                            p.setParticipantes(colab);
                            Vector<Projeto> projs = aux.getProjetos();
                            projs.remove(p);
                            aux.setProjetos(projs);
                            System.out.println("Removendo alunos de graduação com 2 projetos em andamento");
                        }
                    }
                }
            }
            p.setStatus(novo);
            System.out.println("Mudança realizada com sucesso");
        }
        else {
            System.out.println("Não foi possível alterar o status do projeto. Ainda há informações em falta no projeto");
        }
        }
        else if(novo.equals("Concluído")) {
            if(p.getPublicacoes().size()>0) {
                p.setStatus(novo);
                System.out.println("Mudança realizada com sucesso");
            } 
            else System.out.println("Não foi possível alterar o status do projeto. Ainda não há publicações vinculadas a esse projeto");
        }
    }
    
    public void cadastroProjetoLab(Projeto p, LabPesquisa lab) {
        if( isProjectValid(p) && p.getStatus().equals("Em elaboração")) {
            if(!lab.getProjetos().contains(p)) lab.addProjeto(p);
        }
        else System.out.println("Projeto inválido");
    }
    public void addPublicacaoProjeto(Publicacao pb, Projeto proj) {
        Vector<Publicacao> publicacoes = proj.getPublicacoes();
        if(proj.getStatus().equals("Em andamento") && !publicacoes.contains(pb)) {
            publicacoes.add(pb);
            proj.setPublicacoes(publicacoes);
            proj.getParticipantes().forEach((colab)-> {
                addPublicacaoColaborador(pb, colab);
            });
        }
        else {
            System.out.println("Projeto não está em fase de andamento");
        }

    }
    public void addPublicacaoColaborador(Publicacao p, Colaborador c) {
        Vector<Publicacao> colabPublicacao = c.getPublicacao();
        if(!colabPublicacao.contains(p)) { 
            colabPublicacao.add(p);
            c.setPublicacao(colabPublicacao); 
        }
    }
    public void addProjetoColaborador(Projeto p, Colaborador c) {
        if(!p.getStatus().equals("Em elaboração")) {
            System.out.println("Não foi possível inserir colaborador. Projeto não está mais em fase de elaboração");
            return;
        }
        Vector<Projeto> projetos = c.getProjetos();
        Vector<Colaborador> colab = p.getParticipantes();
        if(c instanceof Aluno){
            Aluno aux = (Aluno) c;
            if(aux.getTipo().equals("Graduação")) {
                aux.check_projetos();
                if(aux.getAndamento()>=2) System.out.println("Não é possível inserir o aluno "+ aux.getNome() + ". Capacidade máxima de projetos em andamento atingida");
                else {
                    projetos.add(p);
                    c.setProjetos(projetos);
                    colab.add(c);
                    p.setParticipantes(colab);
                    System.out.println("Projeto adicionado com sucesso ao colaborador");
                }
            }
        }
        else {
            projetos.add(p);
            c.setProjetos(projetos);
            colab.add(c);
            p.setParticipantes(colab);
            System.out.println("Projeto adicionado com sucesso ao colaborador");
        }
    }
}
