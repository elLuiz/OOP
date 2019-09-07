package aluno.Persistencia;

import alunoClass.AlunoGraduacao;
import alunoClass.Aluno;
import alunoClass.*;
import Utilitario.Persist.*;
import java.util.*;
import javax.swing.JOptionPane;

public class DadosAlunoGraduacao
{
    private static ArrayList<AlunoGraduacao>alunoG;
   
   
   static{
       alunoG = (ArrayList<AlunoGraduacao>)Persist.recuperar("alunosG.dat");
       if(alunoG == null)
           alunoG = new ArrayList<AlunoGraduacao>();
         
    }
   
    public static int qtde(){
        return alunoG.size();
    }
    
   
    
    public static void cadastrarAlunoGrad(AlunoGraduacao a)
    {
         alunoG.add(a);
         if(alunoG.size() > 0 )
         {
            // System.out.println("Alunos Inseridos com sucesso ");
            // System.out.println("Quantidade de alunos inseridos" +alunoG.size());
             Persist.gravar(alunoG, "alunosG.dat");
         }    
         
         
    }        
    
    public static void listarAlunoG()
    {       
        alunoG = (ArrayList<AlunoGraduacao>)Persist.recuperar("alunosG.dat");
        
        for(AlunoGraduacao o: alunoG)
            o.mostrarDados();
    }         
    
    public static AlunoGraduacao buscarAlunoG(String matricula)
    {
        
         for(AlunoGraduacao a : alunoG)
             if(a.getMatricula().equals(matricula))
                  return a;
         
         return null;        
    }        
    
    
    public static boolean excluirAlunoG(String matricula)
    {
        Aluno a = null;
        a = buscarAlunoG(matricula);
        
        if(a != null)
        {
            alunoG.remove(a);
            Persist.gravar(alunoG, "alunosG.dat");
            return true;
        }
        else
            return false;
 
    }        
    
    public static AlunoGraduacao getAP(int i)
    {
         return alunoG.get(i);
    }        
    
    public static ArrayList<AlunoGraduacao> getAluno()
    {
        return alunoG;
    }        
    
    public static void excluirAG(int i)
    {
        
        Persist.excluirLinha("alunosG.dat", alunoG, alunoG.get(i));
        JOptionPane.showMessageDialog(null, "Dado(s) excluído(s)");
        alunoG.remove(i);
    }      
    
    
    
    
    public static void alterarAL(int i, AlunoGraduacao p)
    {
        
        excluirAG(i);
        alunoG.get(i).setNome(p.getNome());
        alunoG.get(i).setEndereco(p.getEndereco());
        alunoG.get(i).setTelefone(p.getTelefone());
        alunoG.get(i).setCPF(p.getCpf());
        alunoG.get(i).setCurso1(p.getCurso1());
        //alunoG.get(i).setSituacao(p.getStrsit());
        alunoG.get(i).setInstituicao(p.getInstituicao());
        
       Persist.gravar(p, "alunosG.dat");
        
    }        
    
}
