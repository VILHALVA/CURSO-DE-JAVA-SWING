package controle;

import dao.CidadeDao;
import interfaces.InterfaceControle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CidadeModelo;


public class CidadeControle implements InterfaceControle{
    
    CidadeModelo cim = new CidadeModelo();  
    CidadeDao cid = new CidadeDao();
    
    @Override
    public void salvarControle(Object... valor) {
        
        if ("".equals(valor[0])) {
            cim.setId(0);
        }else{
            cim.setId(Integer.parseInt(valor[0].toString()));
        }
        
        cim.setDescricao((String)valor[1]);
        cim.setUf((String)valor[2]);
        cim.setCep((Integer)valor[3]);
        
        //Enviar informações para o DAO
        
        cid.salvarDao(cim);
        
    }

    @Override
    public void excluirControle(int id) {
        cid.excluirDao(id);
    }

    @Override
    public void consultarControle(Object... valor) {
        try {
            cid.consultarDao(valor);
        } catch(SQLException ex) {
            Logger.getLogger(TipoContatoControle.class.getName()).log(Level.SEVERE, null, ex);        
        }
    }
    
}
