package interfaces;

import java.sql.SQLException;


public interface InterfaceDao {
  
    public void salvarDao(Object...valor);
    public void excluirDao(int id);
    public void consultarDao(Object...valor) throws SQLException;
    
}

