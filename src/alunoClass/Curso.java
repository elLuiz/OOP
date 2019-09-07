package alunoClass;

import java.util.*;
import java.io.*;
  import Utilitario.*;
  import Utilitario.validaExpressao.EntradadeDados;
import javax.swing.JOptionPane;


  public abstract class Curso implements Serializable
  {
   private String nome;
   private int codigo;
   private int duracao;
   private ArrayList<Disciplina>disciplinas = new ArrayList<Disciplina>(); 
    
   public boolean setNome(String nome)
   {
      if(nome.length() > 0)
      { 
         this.nome = nome;
         return true;
      } 
      else
      {
         JOptionPane.showMessageDialog(null,"Curso Invalido ");
         return false;
      }    
   }

   public static void writeFile(Curso a)
   {
      try{
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("curso.bin"));
          oos.writeObject(a);
        
      }catch(IOException e){
           System.out.println(e.getMessage());
       }
   }    

   public static Curso readFile()
   {
       Curso a = null;
       try{
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream("curso.bin"));
          a = (Curso)ois.readObject();
       }catch(IOException e){
          System.out.println(e.getMessage());
       }catch(ClassNotFoundException s){
           System.out.println(s.getMessage());
       }
    
       return a;
   }        


  public Class getTipo(){
       return getClass();
   }


  public boolean setCodigo(int codigo)
  {
      if(codigo > 0)
        this.codigo = codigo;   
    
    
      return true;  
  }

  public boolean setDuracao(int duracao)
  {
      if(duracao > 1)   
      {
         this.duracao = duracao;   
         return true; 
      } 
      else
      {
         JOptionPane.showMessageDialog(null,"Duracao Invalida ");
         return false;
      }   
  }

  public String getNome() 
  {
      return this.nome;
  }        

  public void adicionarDisciplina(Disciplina d)
  {
        disciplinas.add(d);
  }
     
  public void mostrarDisciplinas()
  {
      for(Disciplina d: disciplinas)
         d.mostrarDados();
  }    
    
  public void removerDisciplina(Disciplina d)
  {
     disciplinas.remove(d);   
  }    

  public int getCursoCod()
  {
      return this.getCodigo();
  }
        
  public void lerDados()
  {
     Scanner s = new Scanner(System.in); 
   
     System.out.println ("Leitura de dados do Curso\n");
   
     System.out.println("Digite o nome do curso: ");
     while(!setNome(s.nextLine()));
    
     System.out.println("Digite o codigo do curso: ");
    // this.codigo = EntradadeDados.lerInt();
   
     System.out.println("Digite a duracao do curso: ");
   ///  this.duracao = EntradadeDados.lerInt();
    
   }    

   public void mostrarDados()
   {
      System.out.println("Nome do curso: " +this.nome);   
      System.out.println("Código do curso: " +this.getCodigo());
      System.out.println("Duracao do curso: " +this.getDuracao() +"(anos)");
   }

    public int getCodigo() {
        return codigo;
    }

    public int getDuracao() {
        return duracao;
    }

   }
