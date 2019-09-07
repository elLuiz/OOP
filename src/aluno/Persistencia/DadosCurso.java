package aluno.Persistencia;

import alunoClass.Curso;
import java.util.*;
import Utilitario.Persist.*;

public class DadosCurso
{
    private static ArrayList<Curso>curso;
   
    public static void armazenar(){
        curso = (ArrayList<Curso>)Persist.recuperar("curso.dat");
        if(curso == null)
           curso = new ArrayList<Curso>();
              
    }
    
    
    public static void cadastrarCurso(Curso b)
    {        
        curso.add(b);
        if(curso != null)
        {
      //      System.out.println("Curso inserido com sucesso");      
       //     System.out.println("Quantidade de curso: " +curso.size());
            Persist.gravar(curso, "curso.dat");
        }    
    }
    
    public static void listarCurso()
    {
         for(Curso c: curso)
             c.mostrarDados();
    }        
    
    public static Curso buscarCurso(String cursoN)
    {
        Curso b = null;
        
        for(Curso c: curso)
        {  
            if(c.getNome().equals(cursoN))
            {  
                b = c;
                break;
            }
            else
                return null;
        }
        
        return b;
    }        
    
    public static  boolean excluirCurso(String c)
    {
        Curso b = buscarCurso(c);
        
        if(b != null)
        {
            curso.remove(b);
            Persist.gravar(curso, "curso.dat");
            return true;
        }
        else
            return false;    
    }        

}
