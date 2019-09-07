package alunoClass;

import Utilitario.validaTelefone.Telefone;
import java.util.Scanner;
import javax.swing.JOptionPane;

public abstract class Funcionario extends Pessoa
{

    public String getCtps() {
        return ctps;
    }

    public static double getPisoSalarial() {
        return pisoSalarial;
    }
    private String ctps;
    private static double pisoSalarial;

    
       
public boolean setCtps(String ctps)
{    
    if(ctps.length() > 0)
    {
        this.ctps = ctps;
        return true;
    }
    else
    { 
       JOptionPane.showMessageDialog(null,"Ctps Invalida");
        return false;
    }    
}  

public static void setPiso(double piso)
{
    pisoSalarial = piso;
}        

public static double getPiso()
{
    return getPisoSalarial();
}

 public void lerDados()
 {
   Scanner s = new Scanner(System.in);
   
   super.lerDados();
   
   System.out.println("Digite a CTPS do funcionário: ");
   while(!setCtps(s.nextLine()));
   

}

public void mostrarDados()
{
   super.mostrarDados(); 
   System.out.println("CTPS do funcionário: " +this.getCtps());
   

}   

public abstract double calcSalario();


}


