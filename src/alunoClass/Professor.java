package alunoClass;

import Utilitario.validaExpressao.EntradadeDados;
import java.util.Scanner;
import java.util.Locale; 
import javax.swing.*;
import java.text.*;

public class Professor extends Funcionario implements Pesquisador
{
    private String area_atuacao;
    private String titulacao;
    private double horasAula;
    private double valorHoraAula;


    
public boolean setArea(String area_atuacao)
{    
   if(area_atuacao.length() > 0)
   {
      this.area_atuacao = area_atuacao;
      return true;
   }
   else
   { 
      JOptionPane.showMessageDialog(null, "Area de Atuacao Invalida ");
      return false;
   }    
}    

public boolean setTitulacao(String titulacao)
{    
   if(titulacao.length() > 0)
   {
      this.titulacao = titulacao;
      return true;
   }
   else
   { 
     JOptionPane.showMessageDialog(null, "Titulacao Invalida ");
      return false;
   }    
}    

public boolean setHorasAulas(double horasAula)
{
    if(horasAula > 0.0)
    {
       this.horasAula = horasAula;
       return true;
    }    
    else
    {
        JOptionPane.showMessageDialog(null, "Horas Invalidas ");
        return false;
    }
}    
    

public boolean setValorHoraAula(double valorHoraAula)
{
    if(valorHoraAula > 0.0)
    {
       this.valorHoraAula = valorHoraAula;
       return true;
    }    
    else
    {
        JOptionPane.showMessageDialog(null, "Valor Invalido ");
        return false;
    }
}    

public String getTipo()
{
    return getClass().getName();
}        
    

public void lerDados()
{
    Scanner s = new Scanner(System.in);
    
    System.out.println ("Leitura de dados do Professor\n");
    
    super.lerDados();
    
    System.out.println("Digite a área de atuação: ");
    while(!setArea(s.nextLine()));
    
    System.out.println("Digite a titulção :");
    while(!setTitulacao(s.nextLine()));
    
    System.out.println("Digite as horas aulas: ");
    this.horasAula = EntradadeDados.lerDouble();

    System.out.println("Digite o valor das horas aulas: ");
    this.valorHoraAula = EntradadeDados.lerDouble();

    
}

public double calcSalario()
{
    return this.getHorasAula() * this.getValorHoraAula();
}    

public double calcSalario(double h, double vh){
    return this.getHorasAula() * this.getValorHoraAula();
}

public void mostrarDados()
{
    System.out.println ("\n-> Informacoes sobre o Professor <-\n");
    super.mostrarDados();
    System.out.println("Área de atuação: " +this.getArea_atuacao());
    System.out.println("Titulação: " +this.getTitulacao());
    System.out.println("Salario final: " +calcSalario());
}

    public String getArea_atuacao() {
        return area_atuacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public double getHorasAula() {
        return horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

}