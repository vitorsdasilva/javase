
package br.com.cursojavaseudemy.desenvolvimentoemcamadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author e333832
 */
public class AutorDAO {
    
    public void adicionar(AutorModel objAutorModel){
        /* Carregar dados JDBC*/
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            JOptionPane.showMessageDialog(null, "Driver JDBC carregado");
            
        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
        
        /* Criando conexao com o banco de dados */
        Connection con = null;
        try{
            /*Obtendo conexao com banco de dados*/
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/bdautor", "vitor", "123456");
            JOptionPane.showMessageDialog(null, "Conexao com o banco de dados foi estabelecida");
            
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro na conexao com o banco de dados" 
                                                + sqle.getMessage());
        }
        
        /* Objeto para executar comando sql */
        PreparedStatement ps = null;
        String sql = "insert into Autor values (?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, objAutorModel.getCodigo());
            ps.setString(2, objAutorModel.getNome());
            ps.setString(3,objAutorModel.getEstado());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pronto para execucao de comando sql");
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Erro no acesso ao banco de dados" 
                                                + sqle.getMessage());
        }
        
        /* Fechando a conexao */
        try{
            con.close();
            JOptionPane.showMessageDialog(null, "Conexao com o banco foi fechada com sucesso");
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com o banco de dados" 
                                                + sqle.getMessage());
        }
     
    }
    
    public AutorModel consultar(AutorModel objAutorModel){
      
        AutorModel obj = new AutorModel();
        /* Carregar dados JDBC*/
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            JOptionPane.showMessageDialog(null, "Driver JDBC carregado");
            
        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
        
        /* Criando conexao com o banco de dados */
        Connection con = null;
        try{
            /*Obtendo conexao com banco de dados*/
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/bdautor", "vitor", "123456");
            JOptionPane.showMessageDialog(null, "Conexao com o banco de dados foi estabelecida");
            
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro na conexao com o banco de dados" 
                                                + sqle.getMessage());
        }
        
        /* Objeto para executar comando sql */
        PreparedStatement ps = null;
        String sql = "select codigo, nome, estado from Autor";
        
        try{
            
            ps = con.prepareStatement(sql);
            
            //ps.setString(1, "%" + objAutorModel.getNome()+ "%");
            
            
            ResultSet rs = ps.executeQuery();
            
            // while (rs.next()){
                // System.out.println("Ob: " + rs.next());
                rs.next();
                System.out.println("Codigo adquirido no bd: " + String.valueOf(rs.getString("codigo")));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("estado"));
                obj.setCodigo(Integer.valueOf(rs.getString("codigo")));
                obj.setNome(rs.getString("nome"));
                obj.setEstado(rs.getString("estado"));
            // }
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Pronto para execucao de comando sql");
            
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Erro no acesso ao banco de dados" 
                                                + sqle.getMessage());
            
        }
        
        /* Fechando a conexao */
        try{
            con.close();
            JOptionPane.showMessageDialog(null, "Conexao com o banco foi fechada com sucesso");
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com o banco de dados" 
                                                + sqle.getMessage());
        }
       
        JOptionPane.showMessageDialog(null, "codigo: "+ obj.getCodigo()+ "nome: " + obj.getNome() +"estado: " + obj.getEstado());
        
        return obj;
     
    }
    
    
}
