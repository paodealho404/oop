package project.model;
import java.util.Vector;
public class LabPesquisa {
    private String nome;
    private Vector<Colaborador> colaboradores;
    private Vector<Projeto> projetos;
    private Administrador admin;
    public LabPesquisa(String nome, Administrador admin) {
        this.nome = nome;
        this.admin = admin;
        this.colaboradores = new Vector<Colaborador>();
        this.projetos = new Vector<Projeto>();
    }
    public Administrador getAdmin() {
        return admin;
    }
    public Vector<Colaborador> getColaboradores() {
        return colaboradores;
    }
    public String getNome() {
        return nome;
    }
    public Vector<Projeto> getProjetos() {
        return projetos;
    }
    public void addProjeto(Projeto p) {
        if(projetos!=null) {
            for (int i = 0; i < projetos.size(); i++) {
                if(projetos.elementAt(i).getTitulo().equals(p.getTitulo())){
                    System.out.println("Projeto com mesmo nome já existente");
                    return;
                }
            }
        }
        projetos.add(p);
        System.out.println("Projeto adicionado com sucesso ao laboratório!");
    }
    public void addColaborador(Colaborador c) {
        if(colaboradores!=null) {
            for (int i = 0; i < colaboradores.size(); i++) {
                if(colaboradores.elementAt(i).getNome().equals(c.getNome())){
                    System.out.println("Colaborador com mesmo nome já existente");
                    return;
                }
            }
        }
        colaboradores.add(c);
        System.out.println("Colaborador adicionado com sucesso ao laboratório!");
    }
    public Projeto getProjeto(String titulo) {
        for (int i = 0; i < projetos.size(); i++) {
            if(titulo.equals(projetos.elementAt(i).getTitulo())) return projetos.elementAt(i);
        }
        return null;
    }
    public Projeto getProjeto(int i) {
        if( i < projetos.size()) return projetos.elementAt(i);
        else return null;
    }
    public boolean hasProfessor() {
        System.out.println("Verificando professores... ");
        for (int i = 0; i < colaboradores.size(); i++) {
            if(colaboradores.elementAt(i) instanceof Professor) return true;
        }
        return false;
    }
    public Colaborador getColaborador(String nome) {
        for (int i = 0; i < colaboradores.size(); i++) {
            if(nome.equals(colaboradores.elementAt(i).getNome())) return colaboradores.elementAt(i);
        }
        return null;
    }
    public Colaborador getColaborador(int i) {
        if( i < colaboradores.size()) return colaboradores.elementAt(i);
        else return null;
    }
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    public void setColaboradores(Vector<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setProjetos(Vector<Projeto> projetos) {
        this.projetos = projetos;
    }
}
