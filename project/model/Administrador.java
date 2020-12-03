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
        publicacoes.add(pb);
        proj.setPublicacoes(publicacoes);
    }
    public void addPublicacaoLabPesquisa(LabPesquisa lab, Publicacao p) {
        Vector<Publicacao> publicacoes = lab.getPublicacoes();
        if(p.getProjeto().getStatus().equals("Em andamento")) {
            if(!publicacoes.contains(p)){
                publicacoes.add(p);
                lab.setPublicacoes(publicacoes);
                addPublicacaoProjeto(p, p.getProjeto());
                addPublicacaoColaboradores(p, p.getAutores());
            }
            else {
                System.out.println("Publicação já existente");
            }
            
        }
        else {
            System.out.println("Projeto não está em fase de andamento");
        }
    }
    public void addPublicacaoColaboradores(Publicacao p, Vector<Colaborador> colaboradores) {
        Vector<Colaborador> novosColaboradores = new Vector<Colaborador>(colaboradores);
        novosColaboradores.forEach(colaborador->{
            addPublicacaoColaborador(p, colaborador);
        });
        p.setAutores(novosColaboradores);
    }
    public void addPublicacaoColaborador(Publicacao p, Colaborador c) {
        Vector<Publicacao> colabPublicacao = c.getPublicacao();
        if(!colabPublicacao.contains(p)) {
            colabPublicacao.add(p);
            c.setPublicacao(colabPublicacao);
        }
    }
    public void addOrientacaoProfessor(Orientacao o, Professor p) {
        Vector<Orientacao> orientacoes = new Vector<Orientacao>(p.getOrientacao());
        if(!orientacoes.contains(o)) {
            System.out.println("Orientação adicionada");
            orientacoes.add(o);
            p.setOrientacao(orientacoes);
        }
    }
    public void addProjetoColaboradores(Projeto p, Vector<Colaborador> colaboradores) {
        Vector<Colaborador> novosColaboradores = new Vector<Colaborador>(colaboradores);
        novosColaboradores.forEach(colab->{
            addProjetoColaborador(p, colab);
        });
        p.setParticipantes(novosColaboradores);
    }
    public void addProjetoColaborador(Projeto p, Colaborador c) {
        if(!p.getStatus().equals("Em elaboração")) {
            System.out.println("Não foi possível inserir colaborador. Projeto não está mais em fase de elaboração");
            return;
        }
        Vector<Projeto> projetos = c.getProjetos();
        if(projetos.contains(p)) {
            // System.out.println("Colaborador já possui o projeto na sua lista");
            return;
        } 
        else {
            if(c instanceof Aluno){
                Aluno aux = (Aluno) c;
                if(aux.getTipo().equals("Graduação")) {
                    if(aux.getAndamento()>=2) System.out.println("Não é possível inserir o aluno "+ aux.getNome() + ". Capacidade máxima de projetos em andamento atingida");
                    else {
                        projetos.add(p);
                        c.setProjetos(projetos);
                        System.out.println("Projeto adicionado com sucesso ao colaborador");
                    }
                }
                else {
                    projetos.add(p);
                    c.setProjetos(projetos);
                    System.out.println("Projeto adicionado com sucesso ao colaborador");
                }
            }
            else {
                projetos.add(p);
                c.setProjetos(projetos);
                System.out.println("Projeto adicionado com sucesso ao colaborador");
            }
            
        }
        
    }
}
