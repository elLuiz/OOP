package aluno.Persistencia;

import alunoClass.Tecnico;
import Utilitario.Persist.Persist;
import java.util.*;
import javax.swing.JOptionPane;

public class DadosTecnicos 
{
    private static ArrayList<Tecnico>tecnico;
    
   
   static
   {
       tecnico = (ArrayList<Tecnico>)Persist.recuperar("tecnico.dat");
       if(tecnico == null)
         tecnico = new ArrayList<Tecnico>();
       
   }        
        
    public static void cadastrarTecnico(Tecnico a)
    {
        tecnico.add(a);
        if(tecnico != null)
        {
       //     System.out.println("Dados inseridos com sucesso ");
      //      System.out.println("Quantida de itens: " +tecnico.size());
            Persist.gravar(tecnico, "tecnico.dat");
       
        }    
        
       
    }        
    
    public static void listarTecnico()
    {
        tecnico = (ArrayList<Tecnico>)Persist.recuperar("tecnico.dat");
        
        for(Tecnico t: tecnico)
            t.mostrarDados();
        
    }        
    
    public static Tecnico buscarTecnico(String nome)
    {
         Tecnico c = null;
         
         for(Tecnico x: tecnico)
         {
             if(x.getNome().equals(x))
             {
                 c = x;
                 break;
             }    
             else
                 return null;
         }    
         return c;
    }        
    
    public static boolean excluirTecnico(String nome)
    {
        Tecnico c = null;
        c = buscarTecnico(nome);
        
        if(c!=null)
        {
            tecnico.remove(c);
            Persist.gravar(tecnico, "tecnico.dat");
       
            return true;
        }
        else
            return false;
    }

    
    public static void excluir(int i){
         
         Persist.excluirLinha("tecnico.dat", tecnico, tecnico.get(i));
         JOptionPane.showMessageDialog(null, "Dado(s) excluído(s)");
         tecnico.remove(i);
    }
    
    public static ArrayList<Tecnico> getTecnico() {
        return tecnico;
    }
 
    public static Tecnico getTecnico(int i) {
        return tecnico.get(i);
    }
 
    
}