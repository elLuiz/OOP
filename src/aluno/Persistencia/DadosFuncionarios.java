package aluno.Persistencia;

import alunoClass.Funcionario;
import Utilitario.Persist.Persist;
import java.util.*;
import java.io.*;


public class DadosFuncionarios 
{
   private static ArrayList<Funcionario>fun; 
    
   static{
       fun = (ArrayList)Persist.recuperar("funcionario.dat");
       if(fun == null)
          fun = new ArrayList<Funcionario>();          
   }   
   
  //Usar polimorfismo...










}
