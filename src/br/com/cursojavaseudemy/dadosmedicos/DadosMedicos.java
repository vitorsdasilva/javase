/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojavaseudemy.dadosmedicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor Silva
 */
public class DadosMedicos extends javax.swing.JFrame {

    /**
     * Creates new form DadosMedicos
     */
    public DadosMedicos() {
        super("Dados Medicos");
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

        jLbCRM = new javax.swing.JLabel();
        jLbNome = new javax.swing.JLabel();
        jLbEspecialidade = new javax.swing.JLabel();
        jCBxSelecionaEspecialidade = new javax.swing.JComboBox<>();
        jTFCRM = new javax.swing.JTextField();
        jTFNome = new javax.swing.JTextField();
        jBCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLbCRM.setText("CRM:");

        jLbNome.setText("Nome:");

        jLbEspecialidade.setText("Especialidade:");

        jCBxSelecionaEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARDIOLOGISTA", "CLINICO GERAL", "ORTOPEDISTA", "PEDIATRA" }));

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbCRM)
                    .addComponent(jLbNome)
                    .addComponent(jLbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCadastrar)
                    .addComponent(jCBxSelecionaEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbCRM)
                    .addComponent(jTFCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbNome)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbEspecialidade)
                    .addComponent(jCBxSelecionaEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jBCadastrar)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        // TODO add your handling code here:
        
        /** Evento para cadastro de Médicos **/
        
        
        /* Iniciar carregamento do driver JDBC */
        try {
            
            Class.forName( "org.apache.derby.jdbc.ClientDriver" );
            System.out.println( "Driver JDBC carregado");
              
        }catch (ClassNotFoundException cnfe){
            System.out.println("Erro ao carregar o driver JDBC: "
                                    + cnfe.getMessage() );
        }
        
        /* Iniciar a conexão com o banco de dados */
        
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/dadosmedicos","bdadmin","123456");
            System.out.println( "Conexão com o banco de dados estabelecida" );
            
        }catch (SQLException sqle){
            System.out.println("Erro na conexao com o banco de dados: "
                                    + sqle.getMessage() );
        }
        
        
        /* Iniciar Objeto de preparação para executar comandos SQL */
       
        PreparedStatement ps = null;
        String sql = "insert into medico values (?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            
            int crm = Integer.valueOf(jTFCRM.getText());
            String nome = jTFNome.getText();
            String especialidade = jCBxSelecionaEspecialidade.getSelectedItem().toString();
                         
            ps.setInt(1,crm);
            ps.setString(2, nome);
            ps.setString(3,especialidade);
                
            ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Medico " + nome + " foi Cadastrado com sucesso!");
            
        }catch (SQLException sqle){
            System.out.println("Erro no acesso ao banco de dados: "
                                    + sqle.getMessage() );
        }
        
        
        /* Fechar conexão com o banco de dados */
        try {
            con.close();
            System.out.println("Conexao com o banco de dados foi fechada com sucesso! ");           
            
        }catch (SQLException sqle){
            System.out.println("Erro ao fechar conexão com o banco de dados: "
                                    + sqle.getMessage() );
        }                       
        
        
    }//GEN-LAST:event_jBCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(DadosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DadosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DadosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DadosMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DadosMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JComboBox<String> jCBxSelecionaEspecialidade;
    private javax.swing.JLabel jLbCRM;
    private javax.swing.JLabel jLbEspecialidade;
    private javax.swing.JLabel jLbNome;
    private javax.swing.JTextField jTFCRM;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
