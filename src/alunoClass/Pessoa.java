package alunoClass;

import java.util.Scanner;
import java.lang.String;
import javax.swing.*;
import java.io.*;
import Utilitario.*;
import Utilitario.validaTelefone.Telefone;

public abstract class Pessoa implements Serializable
{
   private String nome;
   private String endereco;
   private String cpf;
   private String telefone;
   
   public boolean setNome(String nome)
   {
      if(nome.length() > 0)
      {
         this.nome = nome;
         return true;
      }    
      else     
      {
         JOptionPane.showMessageDialog(null, "Nome invalido ");    
         return false; 
      }   
   }
    
   public boolean setEndereco(String endereco)
   {
      if(endereco.length() > 0)
      {
         this.endereco = endereco;
         return true;
      }    
      else     
      {
         JOptionPane.showMessageDialog(null, "Endereco invalido ");    
         return false; 
      }   
   }
    
   public boolean setCPF(String cpf)
   {     
       
      if((Cpf.isCPF(cpf)))
      {
          this.cpf = cpf;
          return true;
      }
      else
      { 
         JOptionPane.showMessageDialog(null, "CPF Invalido ");   
         return false;
      }      
   }
   
   public String getNome()
   {        
       return this.nome;
   }    
   
   public static void writeFile(Pessoa a)
   {
       try{
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pessoa.bin"));
          oos.writeObject(a);
       }catch(IOException e){
          System.out.println(e.getMessage());
        }
   }       
   
   public static Pessoa readFile(){
        Pessoa s = null;
        
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pessoa.bin"));
            s = (Pessoa)ois.readObject();
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException x){
            System.out.println(x.getMessage());
        }
        
        
        return s;
   }
   
    public boolean setTelefone(String telefone) {
        
      if(Telefone.vTele(telefone)){
          this.telefone = telefone;
          return true;  
      }    
      else
      {
          JOptionPane.showMessageDialog(null, "Telefone Invalido: ");
          return false;
      }
        
     
    }
    
    public String getTelefone() {
        return telefone;
    }


 
   public void lerDados()
   {
      Scanner s = new Scanner(System.in);
   
      System.out.println("Digite o nome: ");
      while(!setNome(s.nextLine()));
   
      System.out.println("Digite o endereço: ");
      while(!setEndereco(s.nextLine()));
   
      System.out.println("Digite o CPF: ");
      while(!setCPF(s.nextLine()));
       
      System.out.println("Digite o telefone (XX) XXXX-XXXX: ");
        System.out.println("Nao se esqueca do espaco apos o DDD: ");
      while(!setTelefone(s.nextLine()));
           
   }    
   
   public void mostrarDados()
   {      
      System.out.println("Nome: " +this.nome);   
      System.out.println("Endereço : " +this.endereco);
      System.out.println("CPF :" +this.cpf);
      System.out.println("Telefone: " +this.telefone);
   }   

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }
    
 }