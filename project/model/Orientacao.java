package project.model;
import java.util.Vector;
public class Orientacao{
    private Professor professor;
    private Vector<Aluno> alunos;
    public Orientacao(Professor professor, Vector<Aluno> alunos)
    {
        this.professor = professor;
        this.alunos = alunos;
    }
    public void addAluno(Aluno a)
    {
        this.alunos.add(a);
    }
    @Override
    public String toString() {
        String res = "{ PROFESSOR: "+ professor + " ALUNO(A)(OS)(AS): ";
        for (int i = 0; i < alunos.size(); i++) {
            res+= alunos.elementAt(i);
            if(i<alunos.size()-1) res+=", ";
        }
        res+=" }";
        return res;
    }
}