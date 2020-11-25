package project.model;

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
    public void mudarStatusProjeto(String novo, Projeto p) {
        if(novo.equals("Em andamento")) {
            if(p.getValid() && p.getStatus().equals("Em elaboração") && p.getTitulo()!=null && p.getData_fim()!=null && p.getData_inicio()!=null
        &&p.getValor_financiado()>=0 &&p.getAgencia_financiadora()!=null && p.getObjetivo()!=null && p.getDescricao()!=null && p.getParticipantes().size()>0) 
        p.setStatus(novo);
        }
        else if(novo.equals("Concluído")) {
            if(p.getPublicacoes().size()>0) p.setStatus(novo);
            else System.out.println("Ainda não há publicações vinculadas a esse projeto");
        }
    }
    public void cadastroProjetoLab(LabPesquisa lab, Projeto p) {
        if(p.getValid() && p.getStatus().equals("Em elaboração") && p.getTitulo()!=null && p.getData_fim()!=null && p.getData_inicio()!=null
        &&p.getValor_financiado()>=0 &&p.getAgencia_financiadora()!=null && p.getObjetivo()!=null && p.getDescricao()!=null && p.getParticipantes().size()>0) lab.addProjeto(p);
        else System.out.println("Projeto inválido");
    }
}
