package aluno.Persistencia;

import alunoClass.Aluno;
import java.util.*;
import Utilitario.Persist.*;

public class DadosAlunos
{
   private static ArrayList<Aluno>alunos;
   
    static{
       alunos = (ArrayList)Persist.recuperar("alunos.txt");
       if(alunos == null)
       {
           alunos = new ArrayList<Aluno>();
       
       }    
       
    }
   
   
   public static void cadastrarAluno(Aluno a)
   {        
        alunos.add(a);
        if(alunos != null)
        {
       //     System.out.println("Todos os alunos foram inseridos");
      //      System.out.println(alunos.size());
            Persist.gravar(alunos, "alunos.txt");
        }    
   }

   public static void listarDados()
   {        
       for(Aluno o: alunos)
            o.mostrarDados();
   }
   
   public static Aluno buscarAluno(String aluno)
   {        
       Aluno a = null;
       for(Aluno o: alunos)
           if(o.getNome().equals(aluno))
           {
               a = o;
               break;
           }           
       return a;
   }
   
   public static boolean removerAluno(String aluno)
   {
       Aluno a = buscarAluno(aluno);
       if(a != null)
       {
           alunos.remove(aluno);
           Persist.gravar(alunos, "alunos.txt");
           return true;
       }
       else
           return false;
   }  
}