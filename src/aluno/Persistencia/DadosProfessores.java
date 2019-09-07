package aluno.Persistencia;

import alunoClass.Professor;
import java.util.*;
import Utilitario.Persist.*;
import javax.swing.JOptionPane;
    
public class DadosProfessores
{
   private static ArrayList<Professor>professor;

   static
   {
       professor = (ArrayList<Professor>)Persist.recuperar("professor.dat");
       if(getProfessor() == null)
          professor = new ArrayList<Professor>();
        
          
   }        
    
   public static void cadastrarProfessor(Professor a)
   {
        getProfessor().add(a);
       if(getProfessor() != null)
       {
          // System.out.println("Quantidade de professores inseridos ");
           Persist.gravar(getProfessor(), "professor.dat");
          // System.out.println(getProfessor().size());
       }    
           
   } 
   
   public static void listarProfessores()
   {
       professor = (ArrayList<Professor>)Persist.recuperar("professor.dat");
       for(Professor o: professor)
           o.mostrarDados();
   }        
   
   public static Professor buscarProfessor(String nome)
   {
        Professor p = null;
        for(Professor x : getProfessor())
            if(x.getNome().equals(nome))
            {
                p = x;
                break;
            }     
                
        return p;
   }        
    
   public static boolean excluirProfessor(String nome)
   {
       Professor p = buscarProfessor(nome);
       if(p != null)
         getProfessor().remove(p);
         Persist.gravar(getProfessor(), "professor.dat");
       return true;       
   }

    public static ArrayList<Professor> getProfessor() {
        return professor;
    }
    
    public static void excluir(int i)
    {
       
        Persist.excluirLinha("professor.dat" ,professor, professor.get(i));
        JOptionPane.showMessageDialog(null, "Dado(s) excluído(s)");
        professor.remove(i);
    }       
    
    
   
}