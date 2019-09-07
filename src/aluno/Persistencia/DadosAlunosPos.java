package aluno.Persistencia;

import alunoClass.AlunoPosGraduacao;
import alunoClass.Aluno;
import Utilitario.Persist.Persist;
import java.util.*;
import java.util.ArrayList.*;
import javax.swing.*;

public class DadosAlunosPos 
{
     private static ArrayList<AlunoPosGraduacao>aluno;
     
     static{
         aluno = (ArrayList<AlunoPosGraduacao>)Persist.recuperar("alunoP.dat");
         if(aluno == null)
             aluno = new ArrayList<AlunoPosGraduacao>();
      
     }
     
     
     public static ArrayList<AlunoPosGraduacao> getAluno()
     {
         return aluno;
     }        
     
     
     public static void excluirAG(int i)
    {
        Persist.excluirLinha("alunoP.dat", aluno, aluno.get(i));
        JOptionPane.showMessageDialog(null, "Dado excluído");
        aluno.remove(i);
        
    }      
    
     public static void adcionarAlunoP(AlunoPosGraduacao a)
     {
          aluno.add(a);
          if(aluno != null)
          {    
     //        System.out.println("Alunos inseridos com sucesso: " +aluno.size());
             Persist.gravar(aluno, "alunoP.dat");
          }  
     }   

     public static void listarAlunoP()
     {
         //aluno = (ArrayList<AlunoPosGraduacao>)Persist.recuperar("alunoP.dat");
         
         for(AlunoPosGraduacao a: aluno)
             a.mostrarDados();
     }       
     
     public static AlunoPosGraduacao buscarAlunoP(String matricula)
     {
         for(AlunoPosGraduacao a: aluno)
             if(a.getMatricula().equals(matricula))
                 return a;
         
         return null;
     }   

    public static boolean excluirAlunoP(String matricula)
    {
        Aluno a = null;
        a = buscarAlunoP(matricula);
        
        if(a != null)
        {
            aluno.remove(a);
            Persist.gravar(aluno, "alunoP.dat");
            return true;
        }
        else
            return false;
    }        
    
     public static void alterarAL(int i, AlunoPosGraduacao p)
    {
        excluirAG(i);
        aluno.get(i).setNome(p.getNome());
        aluno.get(i).setEndereco(p.getEndereco());
        aluno.get(i).setTelefone(p.getTelefone());
        aluno.get(i).setCPF(p.getCpf());
        aluno.get(i).setCurso1(p.getCurso1());
        //alunoG.get(i).setSituacao(p.getStrsit());
        aluno.get(i).setInstituicao(p.getInstituicao());
        aluno.get(i).setCurso1(p.getCurso1());
       
        
        Persist.gravar(p, "alunosG.dat");
        
    }        
    
}
