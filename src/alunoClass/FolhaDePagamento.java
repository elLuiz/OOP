package alunoClass;

import java.util.*;

public class FolhaDePagamento 
{
    private double totalFolha = 0;
    
    public void  somarFolha(ArrayList <? extends Funcionario>funcionarios)
    {
        this.totalFolha = 0;
        
        for(Funcionario f : funcionarios)
            this.totalFolha += f.calcSalario();
            
                    
    }        

    public double getFolha()
    {
        return this.totalFolha;
    }        
    
    public double totalEncargos()
    {
        return (this.totalFolha * 0.3378);
    }        
    
    public double calcularIRRF(Funcionario f)
    {
        if(f.calcSalario() > 3000)
            return f.calcSalario() * 0.275;      
        else if(f.calcSalario() > 1500)
            return f.calcSalario() * 0.15;
        else
            return 0.0;
    }        
    
    public double calcularINSS(Funcionario f)
    {
        return f.calcSalario() * 0.11;
    }        
    
    public void gerarRelatorio(ArrayList<? extends Funcionario> func)
    {
        double salarioLiquido;
        
        for(Funcionario f : func)
        {
            System.out.printf("Nome: %s \nCategoria: %s \n", f.getNome(), f.getClass().getName());
            System.out.printf("Salario Bruto: %1.2f", +f.calcSalario());
            
            System.out.printf("\n === Descontos === \n");
            System.out.printf("IRRF ser pago: %1.2f \n",  +calcularIRRF(f));
            System.out.printf("INSS descontado: %1.2f \n", +calcularINSS(f));
            
            System.out.printf("\n=== Salario Liquido === \n");
            salarioLiquido = f.calcSalario() -  calcularIRRF(f) - calcularINSS(f);
            System.out.println(+salarioLiquido);
        }    
    }        
    
    
    
}
