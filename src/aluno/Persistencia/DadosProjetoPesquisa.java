package aluno.Persistencia;

import alunoClass.ProjetoPesquisa;
import Utilitario.Persist.Persist;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class DadosProjetoPesquisa 
{
   private static ArrayList<ProjetoPesquisa> pp; 
    
   static{
       pp = (ArrayList<ProjetoPesquisa>)Persist.recuperar("IC.dat");
       if(pp == null)
           pp = new ArrayList<ProjetoPesquisa>();
       
   }
   
   public static void cadastrarIC(ProjetoPesquisa p)
   {
        pp.add(p);
        Persist.gravar(pp, "IC.dat");
   }           
   
   public static void listarIC()
   {
        pp = (ArrayList)Persist.recuperar("IC.dat");
        
        for(ProjetoPesquisa pes: pp)
            pes.mostrarDados();
   }        
   
   public static ProjetoPesquisa buscarIC(String titulo)
   {
       ProjetoPesquisa p = null;
       for(ProjetoPesquisa o: pp)
          if(o.getTitulo().equals(titulo))
          {
                p = o;
                break;
          }    
       
       return p; 
   }        
   
   public static boolean excluirIC(String titulo)
   {
       ProjetoPesquisa p = buscarIC(titulo);
       if(p != null)
       {
           pp.remove(p);
           Persist.gravar(pp, "IC.dat");
           return true;
       }    
       return false;
   }           
   
   
   public static ArrayList<ProjetoPesquisa> getProjetoPesquisa() {
        return pp;
    }
    
    public static ProjetoPesquisa getProjetoPesquisa(int i) {
        return pp.get(i);
    }
    
     
    public static void excluir(int i)
    {
        Persist.excluirLinha("IC.dat", pp, pp.get(i));
        JOptionPane.showMessageDialog(null, "Dado(s) Excluído(s)");
        pp.remove(i);
       
    } 
    
}
