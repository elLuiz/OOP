package alunoClass;

import java.util.Scanner;
import java.io.*;
import java.lang.String;
import javax.swing.JOptionPane;

public abstract class Aluno extends Pessoa implements Pesquisador, Serializable
{        

    private String matricula;
    private byte situacao;
    private String data;
    private String instituicao;
    private String strsit;
    private String curso1;
    Curso curso;    
    
    
    public String getStrsit() {
        return strsit;
    }

    public byte getSituacao() {
        return this.situacao;
    }

    public String getInstituicao() {
        return instituicao;
    }
    
    public String getCurso1()
    {
        return this.curso1;
    }        
    
    public void setCurso1(String c)
    {
         if(c.length() > 0)
             this.curso1 = c;
         else
             JOptionPane.showMessageDialog(null, "Curso Invalido");
    }        
    
    public boolean setMatricula(String matricula)
    {
       if(matricula.length() > 0)
       {   
         this.matricula = matricula;
         return true;
       }
       else
       {
          JOptionPane.showMessageDialog(null, "Matricula invalida "); 
          return false; 
       }    
    }

    public boolean setData(String data)
    {
        if(data.length() > 0)
        {
           this.data = data;
           return true;
        }
        else
        {
           System.out.println("Data Invalida");
           return false; 
        }    
    } 
    

    public boolean setSituacao(String strsit)
    {
      char c;
    
      if(strsit.length() > 0)
      {
        c = strsit.charAt(0); 
         
        switch(c)
        {
          case 'M' : 
             this.situacao = 1;
             return true;
             
          case 'T' :
             this.situacao = 2;
             return true;   
             
          case 'D' :
             this.situacao = 3;
             return true;
          
         default:
             System.out.println("Invalido ");
             return false;
        }    
    }
    else
    {
       System.out.println("Dados invalidos ");   
       return false; 
    }    
    
}

public String getMatricula()
{
    return this.matricula;   
}

   public boolean setInstituicao(String instituicao)
   {
          if(instituicao.length() > 0)
      {    
         this.instituicao = instituicao;
         return true;
      }
      else
      {
         JOptionPane.showMessageDialog(null, "Instituicao invalida "); 
         return false; 
      }    
   }

   public void  setCurso(Curso c)
   {
      this.curso = c;
   }
 
   public Curso getCurso()
   {
    return this.curso;
   }   

   public String getTipo()
   {
     return this.getClass().getName();
   }   
      
 
   public void lerDados()
   { 
      Scanner s = new Scanner(System.in);   
   
      System.out.println ("Leitura de dados do Aluno\n");
   
      super.lerDados();
 
      System.out.println("Digite a instituicao do Aluno: ");
      while(!setInstituicao(s.nextLine()));  
   
      System.out.println("Digite a matricula do Aluno: ");
      while(!setMatricula(s.nextLine()));
  
   
      System.out.println("Digite a situacao do Aluno: ");
      while(!setSituacao(s.nextLine()));
   
      System.out.println("Digite a data de inicio e término ");
      while(!setData(s.nextLine()));
   
   
    
}    
/*
public void mostrarDados()
{
   
   System.out.println ("\n-> Informacoes sobre o Aluno <-\n");
   super.mostrarDados();
   
   System.out.println("Matricula do Aluno: " +this.matricula);
   System.out.println("Data Inicio - Data Termino: " +this.data);
   System.out.println("Instituicao do Aluno: " +this.getInstituicao());
 
   
   
   if(  this.getSituacao() == 1)
      System.out.println("Aluno Matriculado");
   else if(this.getSituacao() == 2)   
      System.out.println("Aluno Trancou");
   else
      System.out.println("Aluno Desligado" );
    
}    
*/
}   
