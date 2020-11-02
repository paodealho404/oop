#include<stdio.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
#include<math.h>
#define DBG if(0)
typedef long long int lli;
typedef unsigned long long int ulli;
typedef long int li;
typedef struct emprestimo emp;
struct emprestimo
{
    double capital_inicial;
    double juros;
    double parcela;
    int parcelas;
    int parcela_atual;

};
double prox_parcela(emp *emprestimo)
{
    double parc_atual = emprestimo->parcela;
    if(emprestimo->parcela_atual < emprestimo->parcelas)
    {
        emprestimo->parcela = emprestimo->parcela + (emprestimo->parcela * (emprestimo->juros)/100);
    }   
    else emprestimo->parcela = 0;
    (emprestimo->parcela_atual)++;
    return parc_atual;
}
void imprimirEmprestimo(emp *emprestimo)
{
    printf("------------------\n");
    double a = prox_parcela(emprestimo);
    while(a>0)
    {
        printf("Parcela %d: $%.3lf\n", emprestimo->parcela_atual-1, a);
        a = prox_parcela(emprestimo);
    }
    printf("------------------\n");
}
int main()
{
    int n;
    printf("Insira o numero de emprestimos a serem feitos\n");
    scanf("%d", &n);
    emp emprestimos[n];
    for(int i=0;i<n;i++)
    {
        printf("Insira o capital inicial do emprestimo %d\n", i+1);
        scanf("%lf", &emprestimos[i].capital_inicial);
        printf("Insira o numero de parcelas do emprestimo\n", i+1);
        scanf("%d", &emprestimos[i].parcelas);
        printf("Insira o valor do juros em porcentagem\n");
        scanf("%lf", &emprestimos[i].juros);
        emprestimos[i].parcela = emprestimos[i].capital_inicial;
        emprestimos[i].parcela_atual = 1;
    }
    for(int i=0;i<n;i++)
    {
        printf("\n------------------\n");
        printf("Emprestimo %d\n", i+1);
        imprimirEmprestimo(&emprestimos[i]);
    }
}