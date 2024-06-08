package dao;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class ConexaoBanco {

    private static final String driveClass = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/bancoAgendaContatos";
    private static final String user = "root";
    private static final String senha = "fafa123qwe..";

    public static Connection abreConexao() {
        Connection con = null;

        try {
            Class.forName(driveClass);
            con = DriverManager.getConnection(url, user, senha);
//            JOptionPane.showMessageDialog(null, "Conectado!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar: " + erro);
        }
        return con;
    }
}
