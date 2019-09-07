package alunoClass;

import aluno.Persistencia.DadosDisciplina;
import java.util.*;
import java.io.*;

public class AlunoGraduacao extends Aluno implements Serializable
{
    private CursoGraduacao cg;
    
    
    AlunoGraduacao(CursoGraduacao c)
    {
        cg = c;   
    }
     
    public AlunoGraduacao()
    {
       super();
    }    
       
   public static void writeFile(AlunoGraduacao a) 
   {
      try
      {
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alunoGraduacao.bin"));
          oos.writeObject(a);
      }catch(IOException e){
          System.out.println(e.getMessage());
      }    
   }        

   public static AlunoGraduacao readFile()
   {
       AlunoGraduacao a = null;
       try{
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alunoGraduacao.bin"));
           a = (AlunoGraduacao)ois.readObject();
       }catch(NotSerializableException e){
           System.out.println(e.getMessage());
         }
        catch(IOException x){
           System.out.println(x.getMessage());
        }
        catch(ClassNotFoundException s){
          System.out.println(s.getMessage());
    }
   
    return a; 
}  
    
    
    public boolean setCurso(CursoGraduacao c)
    {
        this.cg = c;
        return true;    
    }
    
    public CursoGraduacao getCurso()
    {
       return this.cg;   
    }  
    
    
    public void inserirDisciplinaCG()
    {
       Scanner s = new Scanner(System.in); 
       int opcao = 0; 
         
    
       do 
       {
         Disciplina d = new Disciplina(this.cg);  
    //     d.lerDados(); 
         
         this.cg.adicionarDisciplina(d);
         
         System.out.println("Deseja Inserir Mais Disciplinas: 1 - SIM / 0 - NAO ");
         opcao = s.nextInt();
         
         DadosDisciplina.cadastrarDisciplina(d);
         
       }while(opcao != 0);     
    }   
    
    public void lerDados()
    {
        super.lerDados();
        inserirDisciplinaCG();
    }    
    
     
    
    public void mostrarDados()
    {
        super.mostrarDados();
        this.cg.mostrarDados();
        System.out.printf("\n");
        System.out.println("Disciplinas feitas pelo aluno: " +this.getNome());
        this.cg.mostrarDisciplinas(); 
        
    }
 
}
