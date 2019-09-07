package alunoClass;

import Utilitario.validaExpressao.EntradadeDados;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class Disciplina implements Serializable
{
    private int codigo;    
    private String nome;
    private int carga_horaria;
    private CursoPosGraduacao cursoP;
    private CursoGraduacao cursoG;
    private int escolha; 
//Construtor1    
Disciplina(CursoGraduacao c)
{    
    this.cursoG = c;
}

//Construtor2    
Disciplina(CursoPosGraduacao a)
{    
    this.cursoP = a;
}
//Construtor default
public Disciplina()
{    
    
}

public static void writeFile(Disciplina d)
{
    try{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("disciplina.bin"));
        oos.writeObject(d);
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}    

public static Disciplina readFile()
{
    Disciplina d = null;
    try{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("disciplinas.bin"));
        d = (Disciplina)ois.readObject();
    }catch(IOException e){
        System.out.println(e.getMessage());
    }catch(ClassNotFoundException s){
        System.out.println(s.getMessage());
    } 
    
    return d;
}


public boolean setCodigo(int codigo)
{
    if(codigo > 0)   
    {
       this.codigo = codigo;   
       return true; 
    } 
    else
    {
       JOptionPane.showMessageDialog(null,"Codigo Invalido ");
       return false;
    }   
}

public boolean setNome(String nome)
{
    if(nome.length() > 0)   
    {
       this.nome = nome;   
       return true; 
    } 
    else
    {
       JOptionPane.showMessageDialog(null,"Nome Invalido ");
       return false;
    }   
}    

public boolean setCarga_Horaria(int carga_horaria)
{
    if(carga_horaria > 0)   
    {
       this.carga_horaria = carga_horaria;   
       return true; 
    } 
    else
    {
       JOptionPane.showMessageDialog(null,"Formato Invalido ");
       return false;
    }   
}    

public String getNome()
{
    return this.nome;
}        
/*   
public void lerDados()
{
   Scanner s = new Scanner(System.in); 
    
   System.out.println ("Leitura de dados da Disciplina\n");   
   
   System.out.println("Digite o nome da disciplina: ");
   while(!setNome(s.nextLine()));
    
   System.out.println("Digite o codigo da disciplina: ");
   this.codigo = EntradadeDados.lerInt();
   
   System.out.println("Digite a carga horaria da disciplina: ");
   this.carga_horaria = EntradadeDados.lerInt();
}
*/


public void mostrarDados()
{
    System.out.println("\n-> Informacoes da Disciplina: " +this.nome + (" <-"));
    
    System.out.println("Nome da disciplina: " +this.nome);   
    System.out.println("Codigo da disciplina: " +this.getCodigo());
    System.out.println("Carga horaria da disciplina " +this.getCarga_horaria());  
}

    public int getCodigo() {
        return codigo;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

}