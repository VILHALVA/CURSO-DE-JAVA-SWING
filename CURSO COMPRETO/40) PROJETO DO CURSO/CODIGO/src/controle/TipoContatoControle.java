package controle;

import dao.TipoContatoDao;
import interfaces.InterfaceControle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TipoContatoModelo;


public class TipoContatoControle implements InterfaceControle {
    
    TipoContatoModelo tcm = new TipoContatoModelo();
    TipoContatoDao tcd = new TipoContatoDao();

    @Override
    public void salvarControle(Object... valor) {
        
        if("".equals(valor[0])){
            tcm.setId(0);
        }else{
            tcm.setId(Integer.parseInt(valor[0].toString()));
        }      
        
        tcm.setDescricao((String) valor[1]);
        
        //Enviar as informações para o DAO
        tcd.salvarDao(tcm);
    }

    @Override
    public void excluirControle(int id) {
        tcd.excluirDao(id);
    }

    @Override
    public void consultarControle(Object... valor) {
        try {
            tcd.consultarDao(valor);
        } catch (SQLException ex) {
            Logger.getLogger(TipoContatoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
