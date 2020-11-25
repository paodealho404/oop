package project.model;
import java.util.Vector;
public class Colaborador extends Usuario{
   protected Vector<Publicacao> publicacao;
   protected Vector<Projeto> projetos;
   protected int num_projetos;
   protected String link_lattes;
   public Colaborador( String nome, String email)
   {
      super(nome, email);
      this.num_projetos = 0;
      this.projetos = null;
   }
   public Colaborador( String nome, String email, String link)
   {
      super(nome, email);
      setLink_lattes(link);
      this.num_projetos =0;
      this.projetos = null;
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
      setNum_projetos(num);
   }
   public void addProjeto(Projeto p) {
      if(p.getValid()) {
         check_projetos();
         if(getNum_projetos()>=2) System.out.println("Numero máximo de projetos"+" 'Em andamento' "+ "atingido");
         else {
            if(p.getStatus().equals("Em elaboração")){
               System.out.println("Projeto adicionado com sucesso ao colaborador+"+ super.getNome());
               projetos.add(p);
            }
            else System.out.println("Alocação não permitida. Projeto não está mais em fase de elaboração");
         }
      }
      else System.out.println("Projeto inválido ( Faltam informações ou um professor responsável )");  
   }
   public int getNum_projetos() {
      return num_projetos;
   }
   public void setNum_projetos(int num_projetos) {
      this.num_projetos = num_projetos;
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