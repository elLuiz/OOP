package alunoClass;

import java.util.*;
import java.io.*;

public class CursoPosGraduacao extends Curso implements Serializable
{
    public void lerDados()
    {       
       super.lerDados();   
    }    
    
    public void mostrarDados()
    {
       System.out.println ("\n-> Informacoes sobre o curso Pos Graduacao <-");
       super.mostrarDados();   
    }    
}
