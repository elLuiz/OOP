package alunoClass;

import Utilitario.validaExpressao.EntradadeDados;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tecnico extends Funcionario
{

    public String getDepartamento() {
        return departamento;
    }

    public double getValorhoraExtra() {
        return valorhoraExtra;
    }

    public double getQtdeHoraExtra() {
        return qtdeHoraExtra;
    }

    public double getSalariobase() {
        return salariobase;
    }

    public String getCargo() {
        return cargo;
    }
    private String cargo;
    private String departamento;
    private static double valorhoraExtra;
    private double qtdeHoraExtra;
    private double salariobase;
    
public boolean setCargo(String cargo)
{    
   if(cargo.length() > 0)
   {
      this.cargo = cargo;    
      return true; 
   }   
   else
   {
      JOptionPane.showMessageDialog(null,"Cargo Invalido ");    
      return false;
   }   
}    

    
public boolean setDepartamento(String departamento)
{    
   if(departamento.length() > 0)
   {
      this.departamento = departamento;    
      return true; 
   }   
   else
   {
      JOptionPane.showMessageDialog(null,"Departamento Invalido ");    
      return false;
   }   
}    


public boolean setHorasExtras(double valorhoraExtra)
{
   if(valorhoraExtra > 0.0)
   {
      this.valorhoraExtra = valorhoraExtra;
      return true;
   }
   else
   {
      JOptionPane.showMessageDialog(null,"Horas Invalidas ");
      return false;
   }    
}


public boolean setQtdeHorasExtras(double qtdeHoraExtra)
{
   if(qtdeHoraExtra > 0.0)
   {
      this.qtdeHoraExtra = qtdeHoraExtra;
      return true;
   }
   else
   {
      JOptionPane.showMessageDialog(null,"Quantidade de horas Invalidas ");
      return false;
   }    
}

public boolean setSalarioBase(double salariobase)
{    
    if(salariobase > 0.0)
    {
        this.salariobase = salariobase;
        return true;
    }
    else
    { 
       JOptionPane.showMessageDialog(null,"Salario Invalido");
        return false;
    }    
}  


public void lerDados()
{
   Scanner s = new Scanner(System.in);
   
   super.lerDados();  
   
   System.out.println("Digite o cargo do técnico: ");
   while(!setCargo(s.nextLine()));
    
   System.out.println("Digite o departamento do técnico: ");
   while(!setDepartamento(s.nextLine()));    

   System.out.println("Digite a quantidade de horas: ");
   this.qtdeHoraExtra = EntradadeDados.lerDouble();
   
   System.out.println("Digite o valor das horas: ");
   this.valorhoraExtra = EntradadeDados.lerDouble();
   
   System.out.println("Digite o salario base: ");
   this.salariobase = EntradadeDados.lerDouble();
   
}    

public double calcSalario()
{
   return this.getSalariobase() + (this.getQtdeHoraExtra() * this.getValorhoraExtra());
}  

public double calcSalario(double quantHoras, double
valorHora)
{
   this.qtdeHoraExtra = quantHoras;
   this.valorhoraExtra = valorHora;
   return this.getSalariobase() + (this.getQtdeHoraExtra() * this.getValorhoraExtra());
}


public void mostrarDados()
{
    super.mostrarDados();
    System.out.println("Cargo " +this.getCargo());
    System.out.println("Departamento: " +this.getDepartamento());
    System.out.println("Salario: " +"R$" +calcSalario());
    
}

}
