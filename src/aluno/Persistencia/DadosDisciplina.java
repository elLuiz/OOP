package aluno.Persistencia;

import alunoClass.Disciplina;
import Utilitario.Persist.Persist;
import java.util.*;
import javax.swing.*;

public class DadosDisciplina
{

    public static ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    
    private static ArrayList<Disciplina>disciplinas;
    
    static{
        disciplinas = (ArrayList<Disciplina>)Persist.recuperar("disciplina.dat");
        if(getDisciplinas() == null)
           disciplinas = new ArrayList<Disciplina>();
             
    }
    
    
    
    public static void cadastrarDisciplina(Disciplina a)
    {
        getDisciplinas().add(a);
        if(getDisciplinas() != null)
        {
      //      System.out.println("Disciplinas adicionadas com sucesso ");
        //    System.out.println("Quantidade de itens adicionados: " +getDisciplinas().size());
            Persist.gravar(getDisciplinas(), "disciplina.dat");
        }
    }   
    
    public static void listarDisciplinas()
    {
        disciplinas = (ArrayList<Disciplina>)Persist.recuperar("disciplina.dat");
        for(Disciplina d: getDisciplinas())
            d.mostrarDados();
    }        
    
    public static Disciplina buscarDisciplina(String dis)
    {
        Disciplina c = null;
        
        for(Disciplina d: getDisciplinas())
        {
            if(d.getNome().equals(dis))
            {
                c = d;
                break;
            }    
            else
                return null;
        }    
        
        return c;
    }        
    
    public static boolean excluirDisciplina(String dis)
    {
         Disciplina a = null;
         a = buscarDisciplina(dis);
         
         if(a != null)
         {
             getDisciplinas().remove(a);
             Persist.gravar(getDisciplinas(), "disciplina.dat");
             return true;
         }
         else
             return false;
    }
    
    
    public static void excluir(int i){
         Persist.excluirLinha("disciplina.dat", disciplinas, disciplinas.get(i));
         JOptionPane.showMessageDialog(null, "Dado(s) exclído(s)"); 
         disciplinas.remove(i);
    }
    
    public static void alterar(int i, Disciplina a){
        excluir(i);
        disciplinas.get(i).setNome(a.getNome());
        disciplinas.get(i).setCodigo(a.getCodigo());
        disciplinas.get(i).setCarga_Horaria(a.getCarga_horaria());
        Persist.gravar(disciplinas, "disciplina.dat");
    }
}