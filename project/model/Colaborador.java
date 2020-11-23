package project.model;
import java.util.Vector;
public class Colaborador extends Usuario{
   protected Vector<Publicacao> publicacao;
   protected String link_lattes;
   public Colaborador( String nome, String email)
   {
      super(nome, email);
   }
   public Colaborador( String nome, String email, String link)
   {
      super(nome, email);
      setLink_lattes(link);
   }
   public String getLink_lattes() {
      return link_lattes;
   }
   public Vector<Publicacao> getPublicacao() {
      return publicacao;
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
      String res = "{" + super.getEmail() + ", "+ super.getNome()+ "}";
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