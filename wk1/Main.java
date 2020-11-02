package wk1;
import java.util.Scanner;
import java.math.BigInteger;
public class Main{
    public static BigInteger factorial(BigInteger n)
    {
        if(n.compareTo(BigInteger.ZERO)==0) return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
    public static int fibonacci(int n)
    {
        if(n<=1) return 0;
        else if(n==2) return 1;
        else{
           int a = 0,b=1, x=0;
            while(n>2)
            {
                x = b;
                b = a+x;
                a = x;
                n--;
            }
            return b;
        }
    }
    public static void main(String[] args) {
        Scanner n_s = new Scanner(System.in);
        System.out.println("Escolha um procedimento:\n[1] Fibonacci\n[2] Fatorial\n[Qualquer outro caracter] Cancelar\n");
        while(n_s.hasNext())
        {
            int opt = n_s.nextInt();
            
            switch(opt){
                case 1:
                    System.out.println("Qual o termo da sequencia de Fibonacci?");
                    int a = n_s.nextInt();
                    System.out.println("O termo " + a+"-ésimo é "+fibonacci(a)+"\n\n\n");
                    break;
                case 2:
                    System.out.println("Qual o termo fatorial a ser calculado?");
                    int b = n_s.nextInt();
                    System.out.println("O termo " + b +" fatorial é " + factorial(BigInteger.valueOf(b))+"\n\n\n");
                    break;
                default:
                    break;
            }
            if(opt!=1 && opt!=2) break;
            System.out.println("Escolha um procedimento:\n[1] Fibonacci\n[2] Fatorial\n[Qualquer outro caracter] Cancelar\n");
        }
        n_s.close();
    }
    
    
}
