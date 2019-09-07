package alunoClass;

import java.util.*;
import java.io.*;
import Utilitario.Persist.*;
import Utilitario.validaExpressao.EntradadeDados;
import aluno.Persistencia.*;

public class Principal
{
   /*
    public  static void main(String [] args)
    {
        
       int escolha = 0; 
       int continua = 0;
       int gorpos;
      
       Scanner s = new Scanner(System.in);
    
       do
       {
       
          System.out.println("Escolha uma opcao: ");
          System.out.println("1  - Aluno Graduacao ");
          System.out.println("2  - Professor ");
          System.out.println("3  - Aluno Pos Graduacao ");
          System.out.println("4  - Tecnico ");
          System.out.println("5  - Iniciacao Cientifica ");
          System.out.println("6  - Cadastrar Curso Graduacao ");
          System.out.println("7  - Cadastrar Curso Pos Graduacao ");
          System.out.println("8  - Consultar Base de Dados Alunos ");
          System.out.println("9  - Consultar Base de Dados Funcionarios ");
          System.out.println("10 - Consultar Base de Dados de Cursos ");
          System.out.println("11 - Consultar Base de Dados de Projetos ");
          System.out.println("12 - Consultar Base de Disciplinas ");
          System.out.println("13 - Sair ");
          escolha = EntradadeDados.lerInt();
      
              
       switch(escolha)
       {
          case 1:   
             
             CursoGraduacao cg;
             cg = new CursoGraduacao();
           
             cg.lerDados();
            
             AlunoGraduacao a = new AlunoGraduacao(cg);
            
             a.lerDados();
             a.setCurso(cg);
             DadosCursoGraduacao.cadastrarCursoCG(cg);
             
           
             DadosAlunoGraduacao.cadastrarAlunoGrad(a);   
             a.mostrarDados();   
             break;
        
          case 2:
             Professor b = new Professor();
             b.lerDados();
            
             DadosProfessores.cadastrarProfessor(b);
             
             FolhaDePagamento x = new FolhaDePagamento();
             x.calcularINSS(b);
             x.somarFolha(DadosProfessores.getProfessor());
             b.mostrarDados();
             x.gerarRelatorio(DadosProfessores.getProfessor());
             
             DadosProfessores.cadastrarProfessor(b);
             break;
           
          case 3:
             CursoPosGraduacao cpg = new CursoPosGraduacao(); 
             AlunoPosGraduacao c = new AlunoPosGraduacao(cpg);
          
             c.lerDados();
             cpg.lerDados();
             c.setCurso(cpg);
             
             c.mostrarDados();
             
             DadosAlunosPos.adcionarAlunoP(c);
             DadosCursoPosGraduacao.cadastrarCursoCG(cpg);
             break; 
           
          case 4:
             Tecnico t = new Tecnico();
             t.lerDados();
             DadosTecnicos.cadastrarTecnico(t);           

             FolhaDePagamento p = new FolhaDePagamento();
             p.calcularINSS(t);
             p.somarFolha(DadosTecnicos.getTecnico());
             t.mostrarDados();
             p.gerarRelatorio(DadosTecnicos.getTecnico());
             break;
          case 5:
              ProjetoPesquisa IC = new ProjetoPesquisa();
              System.out.println("O aluno a ser inserido, faz graduacao ou pos?: ");
                 System.out.println("1 - Aluno Graduacao ");
                 System.out.println("2 - Aluno PosGraduacao ");
                 gorpos = EntradadeDados.lerInt();
                 switch(gorpos)
                 {
                   case 1:
                        Pesquisador pesA = new AlunoGraduacao();
                        System.out.println("Digite o nome do aluno: ");
                        String nome = s.nextLine();
                        pesA.setNome(nome);
                        IC.lerDados();
                        IC.cadastrarEquipe(pesA);
                        IC.listarEquipe();
                        
                        DadosProjetoPesquisa.cadastrarIC(IC);
                        break;
                   case 2:
                        Pesquisador pesB = new AlunoPosGraduacao();
                        System.out.println("Digite o nome do aluno: ");
                        nome = s.nextLine();
                        pesB.setNome(nome);
                        IC.lerDados();
                        IC.cadastrarEquipe(pesB);
                        IC.listarEquipe();
                        
                        DadosProjetoPesquisa.cadastrarIC(IC);
                        break;
                   default:
                        System.out.println("Invalido");
                        break;
               }      
               break;  
          case 6:      
               CursoGraduacao cG = new CursoGraduacao();
               cG.lerDados();
               cG.mostrarDados();
               DadosCursoGraduacao.cadastrarCursoCG(cG);
               break;
          case 7:
               CursoGraduacao cpG = new CursoGraduacao();
               cpG.lerDados();
               cpG.mostrarDados();
               DadosCursoGraduacao.cadastrarCursoCG(cpG);
               break;
          case 8:
               System.out.println("Aluno Graduacao ou Pos-Graduacao: ");
                  System.out.println("1 - Graduacao");
                  System.out.println("2-  Pos-Graduacao");
                  gorpos = EntradadeDados.lerInt();
                  switch(gorpos)
                  {
                      case 1: 
                        DadosAlunoGraduacao.listarAlunoG();
                        break;
                      case 2:
                        DadosAlunosPos.listarAlunoP();
                        break;
                      default:
                        System.out.println("Invalido ");
                        s.reset();
                        break;
                  }    
               break;
          case 9: 
               System.out.println("Professor ou Tecnico: ");
                  System.out.println("1 - Professor");
                  System.out.println("2-  Tecnico");
                  gorpos = EntradadeDados.lerInt();
               
               switch(gorpos)
               {
                   case 1:
                       DadosProfessores.listarProfessores();
                       break;
                   case 2:
                        DadosTecnicos.listarTecnico();
                        break;
                   default:
                        System.out.println("Invalido");
                        break;
               }    
               break;
               
          case 10:    
                System.out.println("Curso Graduacao ou Pos-Graduacao: ");
                  System.out.println("1 - Graduacao");
                  System.out.println("2-  Pos-Graduacao");
                  gorpos = EntradadeDados.lerInt();
                  switch(gorpos)
                  {
                      case 1:
                          DadosCursoGraduacao.listarCursoG();
                          break;
                      case 2:
                          DadosCursoPosGraduacao.listarCursoG();
                          break;
                      default:
                          System.out.println("Invalido");
                          break;
                  }
               break;   
                  
          case 11:
               DadosProjetoPesquisa.listarIC();
               break;
               
          case 12:
               DadosDisciplina.listarDisciplinas();
               break;
               
          case 13: 
               System.out.println("Saindo...");
               System.exit(1);
          default:
               System.out.println("Opcao errada ");
          
       } 
       
         System.out.println("Deseja inserir novos valores: ");
         System.out.println("1 - Sim / 0 - Nao ");
         continua = EntradadeDados.lerInt();
       
    }while(continua == 1);          
   }   */
}
    

