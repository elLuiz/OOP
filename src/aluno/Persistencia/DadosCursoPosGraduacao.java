package aluno.Persistencia;

import alunoClass.CursoPosGraduacao;
import java.util.*;
import Utilitario.Persist.Persist;
import java.io.*;
import javax.swing.JOptionPane;

public class DadosCursoPosGraduacao 
{
    private static ArrayList<CursoPosGraduacao>cpg;
    
    static
    {
        cpg = (ArrayList)Persist.recuperar("cursoPG.dat");
        if(cpg == null)
            cpg = new ArrayList<CursoPosGraduacao>();
   
    }
    
    public static void cadastrarCursoCG(CursoPosGraduacao c)
    {  
         cpg.add(c);
         Persist.gravar(cpg, "cursoPG.dat");
    }      
    
    public static void listarCursoG()
    {
        cpg = (ArrayList<CursoPosGraduacao>)Persist.recuperar("cursoPG.dat");
        
        for(CursoPosGraduacao c: cpg)
            c.mostrarDados();
    }        
    
    public static CursoPosGraduacao buscarCurso(String nomeC)
    {
         CursoPosGraduacao a = null;   
         for(CursoPosGraduacao c: cpg)
           if(c.getNome().equals(nomeC))
           {
               a = c;
               break;
           }
         
         return a;
    }       
    
    public static boolean excluirCursoPG(String nome)
    {
        CursoPosGraduacao a = buscarCurso(nome);
        
        if(a != null)
        {
            cpg.remove(a);
            Persist.gravar(cpg, "cursoPG.dat");
            return true;
        }
        
        return false;
    }       
    
      public static ArrayList<CursoPosGraduacao> getCursoCPG() {
        return cpg;
    }
    
    public static CursoPosGraduacao getCursoCPG(int i) {
        return cpg.get(i);
    }
     public static void excluir(int i)
    {
        Persist.excluirLinha("cursoPG.dat", cpg, cpg.get(i));
        JOptionPane.showMessageDialog(null, "Dado(s) Excluído(s)");
        cpg.remove(i);
    
    } 
}    

