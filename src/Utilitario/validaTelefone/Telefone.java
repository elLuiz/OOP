package Utilitario.validaTelefone;
import java.util.*;

public class Telefone 
{
     public static boolean vTele(String telefone){
         return telefone.matches("^\\([1-9]{2}\\) [2-9][0-9]{3,4}\\-[0-9]{4}$");
    }         
    
             
}
