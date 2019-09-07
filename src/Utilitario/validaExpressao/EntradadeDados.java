package Utilitario.validaExpressao;
import java.util.*;
import javax.swing.JOptionPane;
import java.text.ParseException;

public class EntradadeDados {
     
   
    
    public static int lerInt(int i, String s)
    {
        
        
        while(true)
        {    
           try
           {
               i = Integer.parseInt(s);            
               break;      
             
           }catch(NumberFormatException e)
           {
               JOptionPane.showMessageDialog(null, "Número Invalido - NAN ");  
               return 0; 
           }
               
        
        }
        
        return i;
    }
   
    public static double lerDouble()
    {
        
        Scanner s = new Scanner(System.in);
        double pf2;
        while(true)
        {    
           try
           {
              pf2 = s.nextDouble();         
              break; 
             
           }catch(InputMismatchException e)
           {
              System.out.println("Erro: "+e.toString());
              s.reset();
              System.out.println("Digite novamente: "); 
              s.next();
           }
        }   
        
        return pf2;
    }
    /*
    public static double lerFloat(double a, String w) throws ParseException{
      
         
        a = Double.parseDouble(w);           
        return a;
    } 
    */
    
    public static int lerInt(){
         int i = 0;
         Scanner s = new Scanner(System.in);
         while(true){
         try{
             i = s.nextInt();
             break;
         }catch(InputMismatchException e){
             e.printStackTrace();
             s.reset();
             s.next();
         }   
    }
         
    return i;     
    
}
    
    public static double lerDouble(double i, String s)
    {
        
        
        while(true)
        {    
           try
           {
               i = Double.parseDouble(s);            
               break;      
             
           }catch(NumberFormatException e)
           {
               JOptionPane.showMessageDialog(null, "Número Inválido - NAN ");  
               return 0; 
           }
               
        
        }
        
        return i;
    } 
    
}
