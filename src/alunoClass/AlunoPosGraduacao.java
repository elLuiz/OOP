package alunoClass;

import aluno.Persistencia.DadosDisciplina;
import java.util.Scanner;
import java.lang.String;
import javax.swing.JOptionPane;

public class AlunoPosGraduacao extends Aluno
{

    public String getGraduacao() {
        return graduacao;
    }
    private String graduacao;
    private CursoPosGraduacao cp;
    
    AlunoPosGraduacao(CursoPosGraduacao c)
    {
        cp = c;   
    }
     
    public AlunoPosGraduacao()
    {
       super();
    }    
        
    
    
    
    public boolean setCurso(CursoPosGraduacao c)
    { 
        this.cp = c;
        return true;    
    }
    
    public CursoPosGraduacao getCurso()
    {
       return this.cp;   
    } 
    
    public boolean setGraduacao(String graduacao)
    {
        if(graduacao.length() > 0)
        {   
           this.graduacao = graduacao;
           return true; 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Graduacao invalida ");     
            return false;
        }   
    }
      
      
    
        
    public void inserirDisciplinaCPG()
    {
       Scanner s = new Scanner(System.in); 
        
         
       int opcao = 0; 
        
       do 
       {
         Disciplina d = new Disciplina(this.cp);  
   //      d.lerDados();    
    //     this.cp.adicionarDisciplina(d);
         
         DadosDisciplina.cadastrarDisciplina(d);
         
         System.out.println("Deseja Inserir Mais Disciplinas: 1 - SIM / 0 - NAO ");
         opcao = s.nextInt();
         
       }while(opcao != 0);
              
    }    
    
    public void lerDados()
    {
        Scanner s = new Scanner(System.in);
        
        super.lerDados();
        
        System.out.println("Digite sua graduação ");
        while(!setGraduacao(s.nextLine()));
               
        inserirDisciplinaCPG();
        
    }   
    
    public void mostrarDados()
    {
       super.mostrarDados();
       
       System.out.println("Graduação em: " +this.getGraduacao()); 
       this.cp.mostrarDados();
       
       System.out.println("Materias feitas pelo aluno:" +this.getNome());
       this.cp.mostrarDisciplinas();
    }    
}
