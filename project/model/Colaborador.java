package project.model;
import java.util.Vector;
public class Colaborador extends Usuario{
   protected Vector<Publicacao> publicacao;
   protected Vector<Projeto> projetos;
   protected int andamento;
   protected String link_lattes;
   public Colaborador( String nome, String email)
   {
      super(nome, email);
      this.andamento = 0;
      this.projetos = new Vector<Projeto>();
   }
   public Colaborador( String nome, String email, String link)
   {
      super(nome, email);
      setLink_lattes(link);
      this.andamento = 0;
      this.projetos = new Vector<Projeto>();
   }
   public String getLink_lattes() {
      return link_lattes;
   }
   public Vector<Publicacao> getPublicacao() {
      return publicacao;
   }
   public void check_projetos() {
      int num = 0;
      for (int i = 0; i < projetos.size(); i++) {
         if(projetos.elementAt(i).getStatus().equals("Em andamento")) num++;
      }
      setAndamento(num);
   }
   public int getAndamento() {
      return andamento;
   }
   public void setAndamento(int andamento) {
      this.andamento = andamento;
   }
   public Vector<Projeto> getProjetos() {
      return projetos;
   }
   public void setProjetos(Vector<Projeto> projetos) {
      this.projetos = projetos;
   }
   public void setLink_lattes(String link_lattes) {
      this.link_lattes = link_lattes;
   }
   public void setPublicacao(Vector<Publicacao> publicacao) {
      this.publicacao = publicacao;
   }
   public void addPublicacao(Publicacao p)
   {
      this.publicacao.add(p);
   }
   @Override
   public String toString() {
      String res = "Nome: " + super.getNome() + ", Email: "+ super.getEmail();
      return res;
   }
   public String colaboradorInfo()
   {
      String res = "{ "+ toString()+", ";
      for (int i = 0; i < publicacao.size(); i++) {
         res+= publicacao.elementAt(i);
         if(i<publicacao.size()-1) res+=", ";
      }
      res+=" }";
      return res;
   }
}