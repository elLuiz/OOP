package Utilitario.Persist;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;



public class Persist 
{
     public static boolean gravar(Object a, String fname)
     {
         try{
            FileOutputStream arqGrav = new FileOutputStream(fname);
            ObjectOutputStream objArq = new ObjectOutputStream(arqGrav);
            //Faz a escrita no arquivo passado pelo usuário
            objArq.writeObject(a);
            //Limpa o buffer
            objArq.flush();
            objArq.close();
            //Fecha o arquivo
            arqGrav.flush();
            arqGrav.close();
         
            return true;               
         }catch(IOException e){
            System.out.println("Nao foi possivel gravar o arquivo!!!");
            return false;
         }
     }    
     
     public static Object recuperar(String filename)
     {
         Object obj = null;
         FileInputStream leitura = null;
         ObjectInputStream leituraObj = null;
         
         try{
             leitura = new FileInputStream(filename);
             leituraObj = new ObjectInputStream(leitura);
             //Lê os dados do arquivo
             //Os armazena em obj
             obj = leituraObj.readObject();
             //Fecha o arquivo
             leitura.close();
             leituraObj.close();
                           
            }catch(IOException e){
                  return null;
             }catch(ClassNotFoundException s){
                 System.out.println(s.getMessage());
                 return null; 
            } 
         
           return obj;
     }    
     
     
     public static void excluirLinha(String arquivo, ArrayList item, Object a){
         
         try{
             int i = 0;
             //Cria um buffer de leitura
             FileInputStream fw = new FileInputStream(arquivo);
             ObjectInputStream fr = new ObjectInputStream(fw);
             File s = new File(arquivo);
            
             ArrayList<Object> novo = new ArrayList();
             // Adiciona os dados no arrayList
             
             for(i = 0; i < item.size(); i++){
                 novo.add(item.get(i));
             }
             
             
             for(i = 0; i < novo.size(); i++) 
             {
                 if(novo.get(i).equals(a)){
                     novo.remove(i);
                
                }     
             } 
             //Deleta o arquivo, para criar um novo
             s.delete();
                  
             // Cria um novo arquivo, para sobreescrever o anterior
             FileOutputStream fw1 = new FileOutputStream(arquivo);
             ObjectOutputStream objArq = new ObjectOutputStream(fw1);
             
             
             objArq.writeObject(novo);
                 
             
             objArq.close();
             objArq.flush();
             fw1.close();
             fw1.flush();
   
         }catch(IOException e){
             JOptionPane.showMessageDialog(null, "Arquivo nao encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
         }
         
     }
}
