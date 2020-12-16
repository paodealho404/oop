package wk9.app;

import java.util.Scanner;


import java.util.ArrayList;

import wk9.model.Pessoa;

public class Main{
        public static void limpa() {
            for (int i = 0; i < 50; i++) {
                System.out.println("");
            }
        }
        public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        Scanner n = new Scanner(System.in);
        boolean flag1 = true;
        while(flag1) {
            System.out.println("Digite o número de pessoas a serem inseridas: ");
            try {
                int x = Integer.parseInt(n.nextLine());
                flag1 = false;
                boolean flag2 = true;
                while(flag2) {
                    try {
                    
                        for (int i = 0; i < x; i++) {
                            System.out.println("Insira o nome da pessoa "+ (i+1));
                            String nome = n.nextLine();
                            System.out.println("Insira a idade da pessoa "+ (i+1));
                            int idade = Integer.parseInt(n.nextLine());
                            System.out.println("Insira o salário da pessoa "+ (i+1));
                            double salario = Double.parseDouble(n.nextLine());
                            Pessoa p = new Pessoa(nome, idade, salario);
                            pessoas.add(p);
                            limpa();
                        }
                        flag2 = false;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Entrada incorreta");
                    }
                    finally {
                        if(!flag2) System.out.println("Todas as pessoas foram inseridas");
                        System.out.println("Pressione qualquer tecla para continuar");
                        n.nextLine();
                        limpa();   
                    }
                }
                
            }
            catch (NumberFormatException e) {
                System.out.println("Entrada incorreta");
            }
            finally {
                if(!flag1) {
                    System.out.println("Imprimindo todas as pessoas");
                    pessoas.forEach(pessoa->{
                    System.out.println("Nome: "+pessoa.getNome() + " Idade: "+ pessoa.getIdade());
                });
                }
           }            
        }
        n.close();
    }
}