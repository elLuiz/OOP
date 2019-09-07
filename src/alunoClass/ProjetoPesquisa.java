package alunoClass;

import aluno.Persistencia.DadosProfessores;
import Utilitario.validaExpressao.EntradadeDados;
import java.util.*;
import java.io.*;
import javax.swing.*;
import aluno.Persistencia.*;

public class ProjetoPesquisa implements Serializable 
{
    private int codigo;
    private String titulo;
    private String dataInicio;
    private String dataTermino;
    private String professorResposnsavel;
    private static ArrayList<Pesquisador>equipe = new ArrayList<Pesquisador>();
    
    //Getters e setters
    public int getCodigo() {
        return codigo;
    }

    public boolean setCodigo(int codigo) {
        this.codigo = codigo;
        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean setTitulo(String titulo) {
        this.titulo = titulo;
        return true;
    }

    public String getDataInicio() {
        return dataInicio;
    }


    public boolean setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
        return true;
    }

    public String getDataTermino() {
        return dataTermino;
    }
    public boolean setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
        return true;
    }

    public String getProfessorResposnsavel() {
        return professorResposnsavel;
    }


    public boolean setProfessorResponsavel(String professorResposnsavel) 
    {
       if(DadosProfessores.buscarProfessor(professorResposnsavel) != null)
       {
           this.professorResposnsavel = professorResposnsavel;
           return true;
       }
       else
       {
           int cont = 0;
           JOptionPane.showMessageDialog(null,"Professor nao encontrado ", "Atenção", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null,"Certifique-se que o professor esteja na base de dados");
           
           return false; 
       }    
       
    }
    
    public void cadastrarEquipe(Pesquisador p)
    {
            getEquipe().add(p);         
    }
    
    // Serializacao da classe
    public static void writeFile(ProjetoPesquisa a)
    {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IC.bin"));
            oos.writeObject(a);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }        
    
    public static ProjetoPesquisa readFile()
    {
        ProjetoPesquisa pp = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IC.bin"));
            pp = (ProjetoPesquisa)ois.readObject();
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException s){
            System.out.println(s.getMessage());
        }
        
        return pp;
    }        
    
    // Leitura de Dados
    public void lerDados()
    {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Digite o titulo da pesquisa: ");
        while(!setTitulo(s.nextLine()));
        
        System.out.println("Insira o professor responsavel: ");
        while(!setProfessorResponsavel(s.nextLine()));
                        
        System.out.println("Digite no formato DD/MM/AA a data de inicio: ");
        while(!setDataInicio(s.nextLine()));
        
        System.out.println("Digite no formato DD/MM/AA a data de termino: ");
        while(!setDataTermino(s.nextLine()));
        
        System.out.println("Digite o codigo da pesquisa: ");
      //  this.codigo = EntradadeDados.lerInt();
    }         
    
    public void mostrarDados()
    {
        listarEquipe();
        System.out.println("Codigo da Pesquisa: " +this.codigo);
        System.out.println("Titulo da Pesquisa: " +this.titulo);
        System.out.println("DD/MM/AA de Inicio: " +this.dataInicio);
        System.out.println("DD/MM/AA de Termino: " +this.dataTermino);  
        System.out.println("Professor Responsavel: " +this.professorResposnsavel);
        
    }
        
    public void listarEquipe()
    {
        int i = 0;
        for(i = 0; i < getEquipe().size(); i++)
        {
             System.out.printf("Nome Aluno: %s \n", this.getEquipe().get(i).getNome());
             System.out.printf("Funcao: %s \n", this.getEquipe().get(i).getTipo());
        }
    }    

    public static ArrayList<Pesquisador> getEquipe() {
        return equipe;
    }
        
            
}