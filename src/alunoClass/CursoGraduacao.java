package alunoClass;

import java.util.*;
import java.io.*;

public class CursoGraduacao extends Curso implements Serializable
{
    public void lerDados()
    {
       super.lerDados();   
    }    
    
    public static void writeFile(CursoGraduacao a){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cursograduacao.bin"));
            oos.writeObject(a);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static CursoGraduacao readFile(){
        CursoGraduacao a = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cursograduacao.bin"));
            a = (CursoGraduacao)ois.readObject();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException s){
            System.out.println(s.getMessage());
        }
            
        return a;
    }
    
   
    
    
    public void mostrarDados()
    {
       System.out.println ("\n-> Informacoes sobre o curso de Graduacao <-");
       super.mostrarDados();   
    }    
}