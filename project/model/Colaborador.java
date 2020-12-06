package project.model;
import java.util.Collections;
import java.util.Vector;
public class Colaborador extends Usuario{
   protected Vector<Publicacao> publicacao;
   protected Vector<Projeto> projetos;
   protected int andamento;
   public Colaborador( String nome, String email)
   {
      super(nome, email);
      this.andamento = 0;
      this.projetos = new Vector<Projeto>();
      this.publicacao = new Vector<Publicacao>();
   }
   public Vector<Publicacao> getPublicacao() {
      return publicacao;
   }
   public void checkProjetos() {
      int num = 0;
      for (int i = 0; i < projetos.size(); i++) {
         if(projetos.elementAt(i).getStatus().equals("Em andamento")) num++;
      }
      setAndamento(num);
   }
   public int getAndamento() {
      checkProjetos();
      return andamento;
   }
   public Vector<Projeto> getProjetosParticipados(){
      Vector<Projeto> projs = new Vector<Projeto>();
      for (int i = 0; i < projetos.size(); i++) {
         if(!projetos.elementAt(i).getStatus().equals("Em elaboração")) projs.add(projetos.elementAt(i));
      }
      return projs;
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
   public void setPublicacao(Vector<Publicacao> publicacao) {
      this.publicacao = publicacao;
   }
   @Override
   public String toString() {
      String res = "Nome: " + super.getNome() + ", Email: "+ super.getEmail();
      return res;
   }
   public String relatorioProdutividade()
   {
      String res = toString() + "\nProjetos Participados: ";
      Vector<Projeto> projetosValidos = new Vector<Projeto>(getProjetosParticipados());
      if(projetosValidos.size()==0) res+="Nenhum\n";
      else {
         res+="\n";
         Collections.sort(projetosValidos);
         Collections.reverse(projetosValidos);
         for (int i = 0; i < projetosValidos.size(); i++) {
            res += projetosValidos.elementAt(i);
            res +=",\n";
         }
      }
      return res;
   }
}