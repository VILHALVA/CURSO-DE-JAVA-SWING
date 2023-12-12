package dao;

import interfaces.InterfaceDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.BairroModelo;

public class BairroDao implements InterfaceDao {

    String sql;
    PreparedStatement stm;
    ResultSet resultado;

    @Override
    public void salvarDao(Object... valor) {

        BairroModelo bm = (BairroModelo) valor[0];

        if (bm.getId() == 0) {
            sql = "INSERT INTO bairro (descricao,cidade) VALUES (?,?)";
        } else {
            sql = "UPDATE bairro SET descricao=?,cidade=? WHERE id = ?";
        }

        try {

            //Preparando e Manipulando os dados
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);

            stm.setString(1, bm.getDescricao());
            stm.setString(2, bm.getCidade());

            if (bm.getId() > 0) {
                stm.setInt(3, bm.getId());
            }

            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Registro Gravado!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro. " + e);
        }

    }

    @Override
    public void excluirDao(int id) {
        sql = "DELETE FROM bairro WHERE id=?";
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);

            stm.setInt(1, id);
            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Registro Excluido Com Sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Excluir o Registro. " + e);
        }
    }

    @Override
    public void consultarDao(Object... valor) throws SQLException {
        DefaultTableModel tabela = (DefaultTableModel) valor[1];

        if ("".equals((String) valor[0])) {
            sql = "SELECT * FROM bairro";
        } else {
            sql = "SELECT * FROM bairro WHERE descricao LIKE '%" + valor[0] + "%'";
        }

        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        resultado = stm.executeQuery();

        while (resultado.next()) {
            tabela.addRow(
                    new Object[]{
                        resultado.getInt("Id"),
                        resultado.getString("Descricao"),
                        resultado.getString("Cidade")
                    }
            );
        }
        stm.close();
    }

}
