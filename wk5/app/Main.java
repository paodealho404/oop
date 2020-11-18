package wk5.app;

import java.util.Scanner;
import java.util.Vector;
import wk5.model.Pessoa;

public class Main{
	static void printvect(Vector<Pessoa> P, Vector<Boolean> choose)
    {
        System.out.print("{ ");
        boolean x = false;
        for (int i = 0; i < choose.size(); i++) {
            if(choose.get(i)==true) 
            {
                System.out.print(P.get(i)+" "); 
                x = true;
            }
        }
        if(!x) System.out.print("vazio ");
        System.out.println("}");
    }
    static void subset(int n, int i, Vector<Pessoa> P, Vector<Boolean> choose)
    {
        if(i<=n)
        {
            choose.add(true);
            subset(n, i+1, P, choose);
            choose.remove(choose.size()-1);
            choose.add(false);
            subset(n, i+1, P, choose);
            choose.remove(choose.size()-1);
        }
        else printvect(P, choose);
    }
    static void printpessoas(Vector<Pessoa> pessoas)
    {
        System.out.print("{ ");
        for (int i = 0; i < pessoas.size(); i++) {
           System.out.print(pessoas.get(i)+" ");
        }
        System.out.println("}");
    }
    static void permutation(int n, Vector<Pessoa> P, boolean[] choose, Vector<Pessoa> k)
    {
        if(k.size()==n) printpessoas(k);
        else {
            for (int i = 0; i < n; i++) {
                if(choose[i]==true) continue;
                choose[i]=true;
                k.add(P.get(i));
                permutation(n, P, choose, k);
                choose[i]=false;
                k.remove(k.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Vector<Boolean> vec = new Vector<Boolean>();
        Vector<Pessoa> pessoas = new Vector<Pessoa>();
        Vector<Pessoa> perm = new Vector<Pessoa>();
        Scanner n = new Scanner(System.in);
        System.out.println("Insira o número de pessoas a serem inseridas: ");
        int a = Integer.parseInt(n.nextLine()) ;
        for (int i = 0; i < a; i++) {
            System.out.println("Digite o nome da " + (i+1) +" pessoa:");
            Pessoa x = new Pessoa(n.nextLine());
            pessoas.add(x);
        }
        n.close();
        System.out.println("Esses são todos os subconjuntos das pessoas informadas:");
        subset(a, 1, pessoas,vec);
        System.out.println("\nEssas são todas as permutações das pessoas informadas:");
        boolean[] choose = new boolean[a];
        permutation(a, pessoas, choose, perm);
    }
}