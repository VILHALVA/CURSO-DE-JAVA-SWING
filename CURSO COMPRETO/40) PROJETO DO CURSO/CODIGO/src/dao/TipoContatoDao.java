 package dao;

import java.sql.PreparedStatement;
import interfaces.InterfaceDao;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TipoContatoModelo;


public class TipoContatoDao implements InterfaceDao{
    
    String sql;
    PreparedStatement stm;
    ResultSet resultado;
    
    @Override
    public void salvarDao(Object... valor) {
        TipoContatoModelo tcm = (TipoContatoModelo)valor[0];
        
        //Descobrir se é inclusão ou alteração.
        if (tcm.getId() == 0){
           //incluir
            sql = "INSERT INTO tipo_contato (descricao) VALUES (?)";
        }else {
            //alterar
            sql = "UPDATE tipo_contato SET descricao=? WHERE id=?";
        }
        
        try {
            //Preparando e manipulando os dados
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);   
            
            stm.setString(1, tcm.getDescricao());
            if(tcm.getId() > 0)
                stm.setInt(2,tcm.getId());
            
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null,"Registro Gravado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro. " + e);
        }
    }

    @Override
    public void excluirDao(int id) {
          sql = "DELETE FROM tipo_contato WHERE id=?";
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);   
            
            stm.setInt(1, id);
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Registro Excluido Com Sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO Ao Excluir o Registro. " + e);
        }
    }

    @Override
    public void consultarDao(Object... valor) throws SQLException {
        
        DefaultTableModel tabela = (DefaultTableModel) valor[1];
        
        if("".equals((String)valor[0])){
            sql = "SELECT * FROM tipo_contato";
        }else{
            sql = "SELECT * FROM tipo_contato WHERE descricao LIKE '%" + valor[0] + "%'";
        }
       
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);   
        resultado = stm.executeQuery();
        
        while(resultado.next()){
           tabela.addRow(
                new Object[]{
                    resultado.getInt("Id"),
                    resultado.getString("Descricao")
                }
           );
        }
        stm.close();
    }
    
}
