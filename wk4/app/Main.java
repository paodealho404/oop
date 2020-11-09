package wk4.app;
import java.util.Scanner;
import wk4.model.DoubleVector;
import wk4.model.IntVector;
public class Main {
    public static void clearprompt()
    {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
    public static void options(DoubleVector vec, Scanner n){
        System.out.println("Insira as coordenadas do vetor");
        for (int i = 0; i < vec.getSize(); i++) {
            System.out.print("Coordenada "+ (i+1) + ":");
            vec.insert(Double.parseDouble(n.nextLine()), i);
            System.out.println("");
        }
        
        int opt = -1;
        while(opt!=0)
        {
            System.out.println("Que operação deseja fazer?\n1) Adição vetorial\n2) Vetor oposto\n3) Multiplicação por escalar\n4) Produto escalar\n5) Módulo do vetor\n6) Ortogonalidade\n7) Paralelismo\n8) Imprimir vetor\n0) Sair");
            opt = Integer.parseInt(n.nextLine());
            switch(opt){
                case 1:
                    DoubleVector vecb = new DoubleVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecb.insert(Double.parseDouble(n.nextLine()), i);
                        System.out.println("");
                    }
                    vecb = vec.vectorAdition(vecb);
                    System.out.println(vecb);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 2:
                    DoubleVector vecopo = new DoubleVector(vec.getSize());
                    vecopo = vec.opositeVector();
                    System.out.println(vecopo);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 3:
                    System.out.println("Insira o escalar(Double)");
                    String a = n.nextLine();
                    DoubleVector scaleVector = new DoubleVector(vec.getSize());
                    scaleVector = vec.scalarMultiplication(a);
                    System.out.println(scaleVector);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 4:
                    DoubleVector vecprod = new DoubleVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecprod.insert(Double.parseDouble(n.nextLine()), i);
                        System.out.println("");
                    }
                    System.out.println("Resultado do produto escalar: "+ vec.scalarProduct(vecprod));
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 5:
                    System.out.println("Módulo do vetor: "+ vec.getModulus());
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 6:
                    DoubleVector vecortogonal = new DoubleVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecortogonal.insert(Double.parseDouble(n.nextLine()), i);
                        System.out.println("");
                    }
                    if(vec.areOrtogonal(vecortogonal)) System.out.println("São ortogonais");
                    else System.out.println("Não são ortogonais");
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 7:
                    DoubleVector vecparallel = new DoubleVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecparallel.insert(Double.parseDouble(n.nextLine()), i);
                        System.out.println("");
                    }
                    if(vec.areParallel(vecparallel)) System.out.println("São paralelos");
                    else System.out.println("Não são paralelos");
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;

                case 8:
                    System.out.println(vec);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
            }
            clearprompt();
        }
        

    }
    public static void options(IntVector vec, Scanner n){
        System.out.println("Insira as coordenadas do vetor");
        for (int i = 0; i < vec.getSize(); i++) {
            System.out.print("Coordenada "+ (i+1) + ":");
            vec.insert(Integer.parseInt(n.nextLine()), i);
            System.out.println("");
        }
        
        int opt = -1;
        while(opt!=0)
        {
            System.out.println("Que operação deseja fazer?\n1) Adição vetorial\n2) Vetor oposto\n3) Multiplicação por escalar\n4) Produto escalar\n5) Módulo do vetor\n6) Ortogonalidade\n7) Paralelismo\n8) Imprimir vetor\n0) Sair");
            opt = Integer.parseInt(n.nextLine());
            switch(opt){
                case 1:
                    IntVector vecb = new IntVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecb.insert(Integer.parseInt(n.nextLine()), i);
                        System.out.println("");
                    }
                    vecb = vec.vectorAdition(vecb);
                    System.out.println(vecb);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 2:
                    IntVector vecopo = new IntVector(vec.getSize());
                    vecopo = vec.opositeVector();
                    System.out.println(vecopo);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 3:
                    System.out.println("Insira o escalar(int)");
                    String a = n.nextLine();
                    IntVector scaleVector = new IntVector(vec.getSize());
                    scaleVector = vec.scalarMultiplication(a);
                    System.out.println(scaleVector);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 4:
                    IntVector vecprod = new IntVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecprod.insert(Integer.parseInt(n.nextLine()), i);
                        System.out.println("");
                    }
                    System.out.println("Resultado do produto escalar: "+ vec.scalarProduct(vecprod));
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 5:
                    System.out.println("Módulo do vetor: "+ vec.getModulus());
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 6:
                    IntVector vecortogonal = new IntVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecortogonal.insert(Integer.parseInt(n.nextLine()), i);
                        System.out.println("");
                    }
                    if(vec.areOrtogonal(vecortogonal)) System.out.println("São ortogonais");
                    else System.out.println("Não são ortogonais");
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 7:
                    IntVector vecparallel = new IntVector(vec.getSize());
                    System.out.println("Insira as coordenadas de um outro vetor");
                    for (int i = 0; i < vec.getSize(); i++) {
                        System.out.print("Coordenada "+ (i+1) + ":");
                        vecparallel.insert(Integer.parseInt(n.nextLine()), i);
                        System.out.println("");
                    }
                    if(vec.areParallel(vecparallel)) System.out.println("São paralelos");
                    else System.out.println("Não são paralelos");
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;

                case 8:
                    System.out.println(vec);
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
            }
            clearprompt();
        }
        

    }
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
       
        int opt = -1;
        while(opt!=0)
        {
            System.out.println("Que tipo de vetor deseja criar?\nDigite: \n1) Double\n2) Int\n0) Para sair do programa\n");
            opt = Integer.parseInt(n.nextLine());
            switch(opt)
            {
                case 1:
                    System.out.println("Insira o tamanho do vetor de Double");
                    int sizeA = Integer.parseInt(n.nextLine());
                    DoubleVector vecA = new DoubleVector(sizeA);
                    options(vecA,n);
                    break;
                case 2:
                    System.out.println("Insira o tamanho do vetor de int");
                    int sizeB = Integer.parseInt(n.nextLine());
                    IntVector vecB = new IntVector(sizeB);
                    options(vecB,n);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida\n");
                    System.out.println("Pressione qualquer tecla para continuar...");
                    n.nextLine();
                    clearprompt();
                    break;
            }  
            clearprompt();
        }
        


    }
}
