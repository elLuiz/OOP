/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualAluno;

import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Hebruque
 */
public class CadastrarCurso extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarCurso
     */
    public CadastrarCurso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        opcao = new javax.swing.JLabel();
        EscolhaCursoGraduacao = new javax.swing.JRadioButton();
        EscolhaCursoPosGraduacao = new javax.swing.JRadioButton();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cursos");

        opcao.setText("Esolha um curso: ");

        buttonGroup1.add(EscolhaCursoGraduacao);
        EscolhaCursoGraduacao.setText("Curso Graduação");
        EscolhaCursoGraduacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscolhaCursoGraduacaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(EscolhaCursoPosGraduacao);
        EscolhaCursoPosGraduacao.setText("Curso Pós Graduação");
        EscolhaCursoPosGraduacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscolhaCursoPosGraduacaoActionPerformed(evt);
            }
        });

        OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitario/Imagens/accept.png"))); // NOI18N
        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opcao)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(EscolhaCursoGraduacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(EscolhaCursoPosGraduacao)
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OK)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(opcao)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EscolhaCursoGraduacao)
                    .addComponent(EscolhaCursoPosGraduacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EscolhaCursoGraduacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscolhaCursoGraduacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EscolhaCursoGraduacaoActionPerformed

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
        if(EscolhaCursoGraduacao.isSelected())
        {
            CadastrarCursoGrad cg = new CadastrarCursoGrad();
            cg.setVisible(true);
            dispose();
        }    
        else if(EscolhaCursoPosGraduacao.isSelected())
        {
            CadastrarCursoPos cp = new CadastrarCursoPos();
            cp.setVisible(true);
            dispose();
        }    
        else{
         JOptionPane.showMessageDialog(this, "Escolha uma opcao");         
        } 
    }//GEN-LAST:event_OKActionPerformed

    private void EscolhaCursoPosGraduacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscolhaCursoPosGraduacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EscolhaCursoPosGraduacaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton EscolhaCursoGraduacao;
    private javax.swing.JRadioButton EscolhaCursoPosGraduacao;
    private javax.swing.JButton OK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel opcao;
    // End of variables declaration//GEN-END:variables
}
