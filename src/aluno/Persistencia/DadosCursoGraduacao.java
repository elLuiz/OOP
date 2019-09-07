package aluno.Persistencia;

import alunoClass.CursoGraduacao;
import Utilitario.Persist.Persist;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class DadosCursoGraduacao 
{
    private static ArrayList<CursoGraduacao>cg;
    
    static
    {
        cg = (ArrayList<CursoGraduacao>)Persist.recuperar("cursoG.dat");
        if(cg == null)
            cg = new ArrayList<CursoGraduacao>();
   
    }
    
    
    public static void listarCursoG()
    {
        cg = (ArrayList<CursoGraduacao>)Persist.recuperar("cursoG.dat");
        
        for(CursoGraduacao c: cg)
            c.mostrarDados();
    }        
    
    public static void cadastrarCursoCG(CursoGraduacao c)
    {  
         cg.add(c);
         Persist.gravar(cg, "cursoG.dat");
    }        
    
    public static CursoGraduacao buscarCurso(String nomeC)
    {
         CursoGraduacao a = null;   
         for(CursoGraduacao c: cg)
           if(c.getNome().equals(nomeC))
           {
               a = c;
               break;
           }
         
         return a;
    }       
    
    public static boolean excluirCursoG(String nome)
    {
        CursoGraduacao a = buscarCurso(nome);
        
        if(a != null)
        {
            cg.remove(a);
            Persist.gravar(cg, "cursoG.dat");
            return true;
        }
        
        return false;
    }        
     public static ArrayList<CursoGraduacao> getCursoG() {
        return cg;
    }
    
    public static CursoGraduacao getCursoG(int i) {
        return cg.get(i);
    }
    
    
    public static void excluir(int i)
    {
        Persist.excluirLinha("cursoG.dat", cg, cg.get(i));
        JOptionPane.showMessageDialog(null, "Dado(s) Excluído(s)");
        cg.remove(i);
   //     Persist.gravar(cg, "cursoG.dat");
    } 
}