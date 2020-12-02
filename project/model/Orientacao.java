package project.model;
import java.util.Vector;
public class Orientacao extends ProducaoAcademica{
    private Professor professor;
    private Vector<Aluno> alunos;
    public Orientacao(String titulo, int anoPublicacao, Professor professor, Vector<Aluno> alunos)
    {
        super(titulo, anoPublicacao);
        this.professor = professor;
        this.alunos = alunos;
    }
    public void addAluno(Aluno a)
    {
        this.alunos.add(a);
    }
    @Override
    public String toString() {
        String res = super.toString() + "PROFESSOR: "+ professor.getNome()+ ", ALUNO(A)(OS)(AS): ";
        for (int i = 0; i < alunos.size(); i++) {
            res+= alunos.elementAt(i);
            if(i<alunos.size()-1) res+=", ";
        }
        return res;
    }
}